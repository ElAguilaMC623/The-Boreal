package net.elaguilamc623.the_boreal.worldgen.features.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class GlacialCrystalSpikeFeature extends Feature<GlacialCrystalSpikeFeature.Config> {

    private static final BlockState SPIKE = BorealBlocks.GLACIAL_CRYSTAL.get().defaultBlockState();

    public GlacialCrystalSpikeFeature(Codec<Config> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<Config> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        RandomSource random = world.getRandom();
        Config config = context.config();

        int startY = -1;
        for (int i = 0; i < 30; i++) {
            BlockPos check = origin.above(i);
            BlockPos below = check.below();

            if (world.getBlockState(below).is(BorealBlocks.PERMAFROST.get())
                    && world.isEmptyBlock(check)) {
                startY = i;
                break;
            }
        }

        if (startY == -1) return false;

        BlockPos basePos = origin.above(startY);

        int height = random.nextInt(config.maxHeight - config.minHeight + 1) + config.minHeight;
        int radius = random.nextInt(config.maxRadius - config.minRadius + 1) + config.minRadius;

        for (int y = 0; y < height; y++) {
            setBlock(world, basePos.above(y), SPIKE);
        }

        double slope = (double) height / (radius + 1.0);

        for (int r = 1; r <= radius; r++) {
            for (int x = -r; x <= r; x++) {
                for (int z = -r; z <= r; z++) {
                    if (Math.abs(x) + Math.abs(z) == r) {

                        int maxY = height - (int) (slope * r);
                        maxY = Math.max(1, maxY + random.nextInt(3) - 1);

                        for (int y = 0; y < maxY; y++) {
                            setBlock(world, basePos.offset(x, y, z), SPIKE);
                        }
                    }
                }
            }
        }

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (Math.abs(x) + Math.abs(z) <= radius + 1) {
                    for (int y = -2; y <= 0; y++) {
                        setBlock(world, basePos.offset(x, y, z), SPIKE);
                    }
                }
            }
        }

        return true;
    }

    private void setBlock(LevelAccessor world, BlockPos pos, BlockState state) {
        world.setBlock(pos, state, 2);
    }

    public static class Config implements FeatureConfiguration {

        public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.INT.fieldOf("min_height").forGetter(c -> c.minHeight),
                        Codec.INT.fieldOf("max_height").forGetter(c -> c.maxHeight),
                        Codec.INT.fieldOf("min_radius").forGetter(c -> c.minRadius),
                        Codec.INT.fieldOf("max_radius").forGetter(c -> c.maxRadius)
                ).apply(instance, Config::new)
        );

        public final int minHeight;
        public final int maxHeight;
        public final int minRadius;
        public final int maxRadius;

        public Config(int minHeight, int maxHeight, int minRadius, int maxRadius) {
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.minRadius = minRadius;
            this.maxRadius = maxRadius;
        }
    }
}
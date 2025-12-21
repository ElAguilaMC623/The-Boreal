package net.elaguilamc623.the_boreal.worldgen.level.trees.auroral;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.elaguilamc623.the_boreal.registries.worldgen.level.BorealFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class AuroralFoliagePlacer extends FoliagePlacer {
    public static final Codec<AuroralFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            foliagePlacerParts(instance)
                    .and(IntProvider.CODEC.fieldOf("height").forGetter(fp -> fp.height))
                    .apply(instance, AuroralFoliagePlacer::new)
    );

    private final IntProvider height;

    public AuroralFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return BorealFoliagePlacers.AURORAL_FOLIAGE_PLACER.get();
    }
    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter setter, RandomSource random,
                                 TreeConfiguration config, int trunkHeight, FoliageAttachment attachment,
                                 int foliageHeight, int radius, int offset) {

        BlockPos pos = attachment.pos();
        for (int y = 0; y < foliageHeight; y++) {
            double factor = (double)(foliageHeight - y) / foliageHeight;

            int layerRadius = Math.max(1, (int)(radius * factor * factor));

            if (random.nextFloat() < 0.2f) {
                layerRadius = Math.max(1, layerRadius - 1);
            }

            placeLeavesRow(level, setter, random, config, pos.above(-y), layerRadius, 0, attachment.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return this.height.sample(random);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int dy, int dz, int radius, boolean doubleTrunk) {
        return random.nextFloat() < 0.45f;
    }
}
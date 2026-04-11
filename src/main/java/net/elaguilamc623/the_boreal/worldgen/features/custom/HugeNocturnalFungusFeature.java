package net.elaguilamc623.the_boreal.worldgen.features.custom;

import com.mojang.serialization.Codec;
import net.elaguilamc623.complementary_core.world.features.custom.BranchingMushroomFeature;
import net.elaguilamc623.the_boreal.blocks.custom.NocturnalFungusCapBlock;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeNocturnalFungusFeature extends BranchingMushroomFeature {
    public HugeNocturnalFungusFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected boolean isValidPosition(LevelAccessor levelAccessor, BlockPos origin, int t, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
        int i = origin.getY();
        if (i >= levelAccessor.getMinBuildHeight() + 1 && i + t + 1 < levelAccessor.getMaxBuildHeight()) {
            BlockState blockstate = levelAccessor.getBlockState(origin.below());
            if (!isDirt(blockstate) && !blockstate.is(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)) {
                return false;
            } else {
                for(int j = 0; j <= t; ++j) {
                    int k = this.getTreeRadiusForHeight(-1, -1, config.foliageRadius, j);

                    for(int l = -k; l <= k; ++l) {
                        for(int i1 = -k; i1 <= k; ++i1) {
                            BlockState blockstate1 = levelAccessor.getBlockState(mutableBlockPos.setWithOffset(origin, l, j, i1));
                            if (!blockstate1.isAir() && !blockstate1.is(BlockTags.LEAVES)) {
                                return false;
                            }
                        }
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }
}

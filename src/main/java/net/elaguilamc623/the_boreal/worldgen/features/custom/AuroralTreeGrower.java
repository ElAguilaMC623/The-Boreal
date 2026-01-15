package net.elaguilamc623.the_boreal.worldgen.features.custom;

import net.elaguilamc623.the_boreal.worldgen.features.BorealConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class AuroralTreeGrower extends AbstractMegaTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        return BorealConfiguredFeatures.AURORAL_TREE_SMALL;
    }

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return BorealConfiguredFeatures.AURORAL_TREE_LARGE;
    }
}
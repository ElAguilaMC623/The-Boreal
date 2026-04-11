package net.elaguilamc623.the_boreal.worldgen.features.growers;

import net.elaguilamc623.the_boreal.worldgen.features.BorealConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class HugeNocturnalMushroomGrower extends AbstractTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return BorealConfiguredFeatures.HUGE_NOCTURNAL_FUNGUS;
    }
}

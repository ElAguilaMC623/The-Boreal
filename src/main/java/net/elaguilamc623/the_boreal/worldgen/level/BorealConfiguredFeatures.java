package net.elaguilamc623.the_boreal.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class BorealConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE_LARGE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_large"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE_SMALL =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_small"));
}
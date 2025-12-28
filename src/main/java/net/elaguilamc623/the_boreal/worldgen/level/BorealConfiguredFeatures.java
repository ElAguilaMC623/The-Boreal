package net.elaguilamc623.the_boreal.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BorealConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE_LARGE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_large"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE_SMALL =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_small"));
}
package net.elaguilamc623.the_boreal.worldgen.features;

import net.elaguilamc623.complementary_core.world.features.config.CCFeatureConfiguration;
import net.elaguilamc623.complementary_core.world.features.templates.CCPlacedFeaturesTemplates;
import net.elaguilamc623.complementary_core.world.features.templates.DeltaFeatures;
import net.elaguilamc623.complementary_core.world.features.templates.OreFeatures;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import java.util.List;

public class BorealPlacedFeatures {

    public static final ResourceKey<PlacedFeature> AURORAL_TREE_SMALL_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_small_placed"));

    public static final ResourceKey<PlacedFeature> AURORAL_TREE_LARGE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_large_placed"));

    public static final ResourceKey<PlacedFeature> AURORAL_BUSH_SPREAD_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_bush_spread"));

    public static final ResourceKey<PlacedFeature> AURORAL_BUSH_DENSE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_bush_dense"));

    public static final ResourceKey<PlacedFeature> AURORAL_FALLEN_LOG_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_fallen_log_placed"));

    public static final ResourceKey<PlacedFeature> GLACIAL_GRASS_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_grass_patch"));

    public static final ResourceKey<PlacedFeature> GLACIAL_TALL_GRASS_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_tall_grass_patch"));

    public static final ResourceKey<PlacedFeature> GLACIAL_BERRIES_COMMON_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_berries_bush_common_placed"));

    public static final ResourceKey<PlacedFeature> GLACIAL_BERRIES_UNCOMMON_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_berries_bush_uncommon_placed"));

    public static final ResourceKey<PlacedFeature> GLACIALIGHT_SHROOM_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacialight_shroom_patch"));

    public static final ResourceKey<PlacedFeature> BOREALIGHT_SHROOM_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "borealight_shroom_patch"));

    public static final ResourceKey<PlacedFeature> BOREAL_ROCK_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "boreal_rock_patch_placed"));

    public static final ResourceKey<PlacedFeature> CRYSTALIZED_DEAD_BUSH_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "crystalized_dead_bush_patch_placed"));

    public static final ResourceKey<PlacedFeature> CHRODIUM_ORE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "chrodium_ore_placed"));

    public static final ResourceKey<PlacedFeature> DIORIUM_ORE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "diorium_ore_placed"));

    public static final ResourceKey<PlacedFeature> TARNITE_ORE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "ore_tarnite"));

    public static final ResourceKey<PlacedFeature> VERNITE_ORE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "ore_vernite"));

    public static final ResourceKey<PlacedFeature> TALISMANDIUM_ORE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "talismandium_ore_placed"));

    public static final ResourceKey<PlacedFeature> GLACIAL_CRYSTAL_SPIKE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_crystal_spike_placed"));

    public static final ResourceKey<PlacedFeature> NOCTURNAL_DELTA =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnal_delta"));

    public static final ResourceKey<PlacedFeature> NOCTURNAL_TALL_GRASS_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnal_tall_grass_patch"));

    public static final ResourceKey<PlacedFeature> GLACIALWEED_PATCH_COMMON_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacialweed_patch_common_placed"));

    public static final ResourceKey<PlacedFeature> GLACIALWEED_PATCH_UNCOMMON_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacialweed_patch_uncommon_placed"));

    public static final ResourceKey<PlacedFeature> STARLIGHT_SHROOM_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "starlight_shroom_patch"));

    public static final ResourceKey<PlacedFeature> NOCTURNALIGHT_SHROOM_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnalight_shroom_patch"));

    public static final ResourceKey<PlacedFeature> NOCTURNALWEED_PATCH_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnalweed_patch"));

    public static final ResourceKey<PlacedFeature> HUGE_NOCTURNAL_FUNGUS_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "huge_nocturnal_fungus_placed"));


    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configured =
                context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                AURORAL_TREE_LARGE_PLACED,
                CCPlacedFeaturesTemplates.treePlacedFeature(
                        configured,
                        BorealConfiguredFeatures.AURORAL_TREE_LARGE,
                        10,
                        BorealBlocks.AURORA_SAPLING.get()
                )
        );

        context.register(
                AURORAL_TREE_SMALL_PLACED,
                CCPlacedFeaturesTemplates.treePlacedFeature(
                        configured,
                        BorealConfiguredFeatures.AURORAL_TREE_SMALL,
                        1,
                        BorealBlocks.AURORA_SAPLING.get()
                )
        );

        context.register(
                AURORAL_BUSH_SPREAD_PLACED,
                CCPlacedFeaturesTemplates.treePlacedFeature(
                        configured,
                        BorealConfiguredFeatures.AURORAL_BUSH,
                        1,
                        BorealBlocks.AURORA_SAPLING.get()
                )
        );

        context.register(
                AURORAL_BUSH_DENSE_PLACED,
                CCPlacedFeaturesTemplates.treePlacedFeature(
                        configured,
                        BorealConfiguredFeatures.AURORAL_BUSH,
                        10,
                        BorealBlocks.AURORA_SAPLING.get()
                )
        );

        context.register(
                AURORAL_FALLEN_LOG_PLACED,
                new PlacedFeature(
                        configured.getOrThrow(BorealConfiguredFeatures.AURORAL_FALLEN_LOG),
                        List.of(
                                RarityFilter.onAverageOnceEvery(6),
                                CountPlacement.of(1),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        context.register(
                GLACIAL_GRASS_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.GLACIAL_GRASS_PATCH, 3, 2)
        );

        context.register(
                GLACIAL_TALL_GRASS_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.GLACIAL_TALL_GRASS_PATCH, 7, 4)
        );

        context.register(
                GLACIAL_BERRIES_COMMON_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlaced(configured,
                        BorealConfiguredFeatures.GLACIAL_BERRIES, 8)
        );

        context.register(
                GLACIAL_BERRIES_UNCOMMON_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlaced(configured,
                        BorealConfiguredFeatures.GLACIAL_BERRIES, 13)
        );

        context.register(
                GLACIALIGHT_SHROOM_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.GLACIALIGHT_SHROOM_PATCH, 10, 2)
        );

        context.register(
                BOREALIGHT_SHROOM_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.BOREALIGHT_SHROOM_PATCH, 10, 2)
        );

        context.register(
                BOREAL_ROCK_PATCH,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.BOREAL_ROCK_PATCH, 10, 2)
        );

        context.register(
                CRYSTALIZED_DEAD_BUSH_PATCH,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.CRYSTALIZED_DEAD_BUSH_PATCH, 10, 2)
        );

        context.register(
                CHRODIUM_ORE_PLACED,
                OreFeatures.orePlacedFeature(configured,
                        BorealConfiguredFeatures.CHRODIUM_ORE, 6, -64, 34
                )
        );

        context.register(
                DIORIUM_ORE_PLACED,
                OreFeatures.orePlacedFeature(configured,
                        BorealConfiguredFeatures.DIORIUM_ORE, 1, -64, -10)
        );

        context.register(
                TARNITE_ORE_PLACED,
                OreFeatures.orePlacedFeature(configured,
                        BorealConfiguredFeatures.TARNITE_ORE, 5, -64, 128)
        );

        context.register(
                VERNITE_ORE_PLACED,
                OreFeatures.orePlacedFeature(configured,
                        BorealConfiguredFeatures.VERNITE_ORE, 5, -64, 128)
        );

        context.register(
                TALISMANDIUM_ORE_PLACED,
                OreFeatures.orePlacedFeature(configured,
                        BorealConfiguredFeatures.TALISMANDIUM_ORE, 13, -52, 40)
        );

        context.register(
                GLACIAL_CRYSTAL_SPIKE_PLACED,
                new PlacedFeature(configured.getOrThrow(BorealConfiguredFeatures.GLACIAL_CRYSTAL_SPIKE),
                        List.of(
                                CountPlacement.of(1),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        DeltaFeatures.registerPlaced(
                context, BorealPlacedFeatures.NOCTURNAL_DELTA,
                configured, BorealConfiguredFeatures.NOCTURNAL_DELTA,
                List.of(
                        CountPlacement.of(10),
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                        BiomeFilter.biome()
                )
        );

        CCFeatureConfiguration.registerPlaced(
                context,
                NOCTURNAL_TALL_GRASS_PATCH_PLACED,
                configured,
                BorealConfiguredFeatures.NOCTURNAL_TALL_GRASS_PATCH,
                List.of(
                        NoiseThresholdCountPlacement.of(-0.8, 30, 60),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )
        );

        context.register(
                GLACIALWEED_PATCH_COMMON_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.GLACIALWEED_PATCH_ON_MARSH, 10, 2)
        );

        context.register(
                GLACIALWEED_PATCH_UNCOMMON_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.GLACIALWEED_PATCH_ON_MARSH, 4, 2)
        );

        context.register(
                STARLIGHT_SHROOM_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.STARLIGHT_SHROOM_PATCH, 10, 2)
        );

        context.register(
                NOCTURNALIGHT_SHROOM_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.NOCTURNALIGHT_SHROOM_PATCH, 7, 2)
        );

        context.register(
                NOCTURNALWEED_PATCH_PLACED,
                CCPlacedFeaturesTemplates.patchFeaturePlacedWithCount(configured,
                        BorealConfiguredFeatures.NOCTURNALWEED_PATCH, 6, 2)
        );


        context.register(BorealPlacedFeatures.HUGE_NOCTURNAL_FUNGUS_PLACED, new PlacedFeature(
                configured.getOrThrow(BorealConfiguredFeatures.HUGE_NOCTURNAL_FUNGUS),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                )
        ));
    }
}
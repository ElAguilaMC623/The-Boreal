package net.elaguilamc623.the_boreal.worldgen.features;

import net.elaguilamc623.complementary_core.world.features.config.CCFeatureConfiguration;
import net.elaguilamc623.complementary_core.world.features.config.custom.FallenLogConfig;
import net.elaguilamc623.complementary_core.world.features.registry.CCFeatureRegistry;
import net.elaguilamc623.complementary_core.world.features.templates.DeltaFeatures;
import net.elaguilamc623.complementary_core.world.features.templates.OreFeatures;
import net.elaguilamc623.complementary_core.world.features.templates.PatchFeature;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.blocks.custom.plants.GlacialBerryBushBlock;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.elaguilamc623.the_boreal.registries.world.BorealFeatures;
import net.elaguilamc623.the_boreal.worldgen.features.custom.GlacialCrystalSpikeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

public class BorealConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE_LARGE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_large"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE_SMALL =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_small"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_BUSH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_bush"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIAL_GRASS_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_grass_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIAL_TALL_GRASS_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_tall_grass_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_FALLEN_LOG =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "aurora_fallen_log"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIAL_BERRIES =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_berries_bush"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIALIGHT_SHROOM_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacialight_shroom_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOREALIGHT_SHROOM_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "borealight_shroom_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOREAL_ROCK_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "boreal_rock_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTALIZED_DEAD_BUSH_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "crystalized_dead_bush_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHRODIUM_ORE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "chrodium_ore"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> DIORIUM_ORE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "diorium_ore"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> TARNITE_ORE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "tarnite_ore"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> VERNITE_ORE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "vernite_ore"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALISMANDIUM_ORE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "talismandium_ore"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIAL_CRYSTAL_SPIKE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_crystal_spike"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> NOCTURNAL_DELTA =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnal_delta"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> NOCTURNAL_TALL_GRASS_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnal_tall_grass_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> STARLIGHT_SHROOM_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "starlight_shroom_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> NOCTURNALIGHT_SHROOM_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnalight_shroom_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLACIALWEED_PATCH_ON_MARSH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacialweed_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> NOCTURNALWEED_PATCH =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "nocturnalweed_patch"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_NOCTURNAL_FUNGUS =
            ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "huge_nocturnal_fungus"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        context.register(AURORAL_TREE_LARGE,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(
                                SimpleStateProvider.simple(BorealBlocks.AURORA_LOG.get().defaultBlockState()),
                                new GiantTrunkPlacer(13, 2, 14),

                                SimpleStateProvider.simple(BorealBlocks.AURORA_LEAVES.get().defaultBlockState()),
                                new SpruceFoliagePlacer(
                                        ConstantInt.of(2),
                                        ConstantInt.of(1),
                                        ConstantInt.of(4)
                                ),

                                new TwoLayersFeatureSize(2, 1, 2)
                        )
                                .dirt(SimpleStateProvider.simple(BorealBlocks.GLACIAL_DIRT.get().defaultBlockState()))
                                .ignoreVines()
                                .build()
                )
        );

        context.register(AURORAL_TREE_SMALL,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(
                                SimpleStateProvider.simple(BorealBlocks.AURORA_LOG.get().defaultBlockState()),
                                new StraightTrunkPlacer(5, 2, 1),

                                SimpleStateProvider.simple(BorealBlocks.AURORA_LEAVES.get().defaultBlockState()),
                                new SpruceFoliagePlacer(
                                        ConstantInt.of(2),
                                        ConstantInt.of(1),
                                        ConstantInt.of(4)
                                ),

                                new TwoLayersFeatureSize(1, 0, 1)
                        )
                                .dirt(SimpleStateProvider.simple(BorealBlocks.GLACIAL_DIRT.get().defaultBlockState()))
                                .ignoreVines()
                                .build()
                )
        );

        context.register(
                AURORAL_BUSH,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(
                                SimpleStateProvider.simple(BorealBlocks.AURORA_LOG.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 0, 0),

                                SimpleStateProvider.simple(BorealBlocks.AURORA_LEAVES.get().defaultBlockState()),
                                new BushFoliagePlacer(
                                        ConstantInt.of(2),
                                        ConstantInt.of(1),
                                        2
                                ),

                                new TwoLayersFeatureSize(0, 0, 0))
                                .dirt(SimpleStateProvider.simple(BorealBlocks.GLACIAL_DIRT.get().defaultBlockState()))
                                .ignoreVines()
                                .build()
                )
        );


        CCFeatureConfiguration.register(
                context,
                AURORAL_FALLEN_LOG,
                CCFeatureRegistry.FALLEN_LOG.get(),
                new FallenLogConfig(
                        BlockStateProvider.simple(BorealBlocks.AURORA_LOG.get()),
                        BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON,
                        ConstantInt.of(4)
                )
        );

        PatchFeature.collectivePatch(context, GLACIAL_GRASS_PATCH)
                .state(BorealBlocks.GLACIAL_GRASS.get().defaultBlockState())
                .below(BorealBlocks.GLACIAL_GRASS_BLOCK.get())
                .tries(96)
                .spread(7, 3)
                .register();

        PatchFeature.individualPatch(context, GLACIAL_TALL_GRASS_PATCH)
                .state(BorealBlocks.GLACIAL_TALL_GRASS.get().defaultBlockState())
                .below(BorealBlocks.GLACIAL_GRASS_BLOCK.get())
                .register();

        PatchFeature.collectivePatch(context, GLACIAL_BERRIES)
                .state(BorealBlocks.GLACIAL_BERRY_BUSH.get().defaultBlockState().setValue(GlacialBerryBushBlock.AGE, 3))
                .below(BorealBlocks.GLACIAL_GRASS_BLOCK.get())
                .tries(96)
                .spread(7, 3)
                .register();

        PatchFeature.individualPatch(context, GLACIALIGHT_SHROOM_PATCH)
                .state(BorealBlocks.GLACIALIGHT_SHROOM.get().defaultBlockState())
                .below(BorealBlocks.GLACIAL_GRASS_BLOCK.get())
                .register();

        PatchFeature.individualPatch(context, BOREALIGHT_SHROOM_PATCH)
                .state(BorealBlocks.BOREALIGHT_SHROOM.get().defaultBlockState())
                .below(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)
                .register();

        PatchFeature.individualPatch(context, BOREAL_ROCK_PATCH)
                .state(BorealBlocks.BOREAL_ROCK.get().defaultBlockState())
                .below(BorealBlocks.PERMAFROST.get())
                .register();

        PatchFeature.individualPatch(context, CRYSTALIZED_DEAD_BUSH_PATCH)
                .state(BorealBlocks.CRYSTALIZED_DEAD_BUSH.get().defaultBlockState())
                .below(BorealBlocks.PERMAFROST.get())
                .register();

        context.register(
                CHRODIUM_ORE,
                OreFeatures.oreFeature(
                        List.of(
                                OreFeatures.blockTarget(BorealBlocks.BOREAL_STONE.get(), BorealBlocks.CHRODIUM_ORE.get().defaultBlockState()),
                                OreFeatures.blockTarget(BorealBlocks.BOREAL_DEEP_STONE.get(), BorealBlocks.DEEP_CHRODIUM_ORE.get().defaultBlockState())
                        ),
                        5,
                        0.0f
                )
        );

        context.register(
                DIORIUM_ORE,
                OreFeatures.oreFeature(
                        List.of(
                                OreFeatures.blockTarget(BorealBlocks.BOREAL_STONE.get(), BorealBlocks.DIORIUM_ORE.get().defaultBlockState()),
                                OreFeatures.blockTarget(BorealBlocks.BOREAL_DEEP_STONE.get(), BorealBlocks.DEEP_DIORIUM_ORE.get().defaultBlockState())
                        ),
                        6,
                        0.0f
                )
        );

        context.register(
                TARNITE_ORE,
                OreFeatures.oreFeature(
                        List.of(
                                OreFeatures.tagTarget(BlockTags.STONE_ORE_REPLACEABLES, BorealBlocks.TARNITE.get().defaultBlockState())
                        ),
                        33,
                        0.0f
                )
        );

        context.register(
                VERNITE_ORE,
                OreFeatures.oreFeature(
                        List.of(
                                OreFeatures.tagTarget(BlockTags.STONE_ORE_REPLACEABLES, BorealBlocks.VERNITE.get().defaultBlockState())
                        ),
                        33,
                        0.0f
                )
        );

        context.register(
                TALISMANDIUM_ORE,
                OreFeatures.oreFeature(
                        List.of(
                                OreFeatures.blockTarget(BorealBlocks.BOREAL_STONE.get(), BorealBlocks.TALISMANDIUM_ORE.get().defaultBlockState()),
                                OreFeatures.blockTarget(BorealBlocks.BOREAL_DEEP_STONE.get(), BorealBlocks.DEEP_TALISMANDIUM_ORE.get().defaultBlockState())
                        ),
                        6,
                        0.0f
                )
        );

        context.register(
                GLACIAL_CRYSTAL_SPIKE,
                new ConfiguredFeature<>(
                        BorealFeatures.GLACIAL_CRYSTAL_SPIKE.get(),
                        new GlacialCrystalSpikeFeature.Config(
                                5,
                                12,
                                1,
                                3
                        )
                )
        );

        DeltaFeatures.registerConfigured(
                context,
                BorealConfiguredFeatures.NOCTURNAL_DELTA,
                Feature.DELTA_FEATURE,
                new DeltaFeatureConfiguration(
                        Blocks.WATER.defaultBlockState(),
                        BorealBlocks.NOCTURNAL_MUD.get().defaultBlockState(),
                        UniformInt.of(3, 7),
                        UniformInt.of(0, 2)
                )
        );

        CCFeatureConfiguration.registerConfigured(
                context,
                NOCTURNAL_TALL_GRASS_PATCH,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(BorealBlocks.NOCTURNAL_TALL_GRASS.get())
                )
        );

        PatchFeature.individualPatch(context, STARLIGHT_SHROOM_PATCH)
                .state(BorealBlocks.STARLIGHT_SHROOM.get().defaultBlockState())
                .below(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)
                .register();

        PatchFeature.individualPatch(context, NOCTURNALIGHT_SHROOM_PATCH)
                .state(BorealBlocks.NOCTURNALIGHT_SHROOM.get().defaultBlockState())
                .below(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)
                .register();

        PatchFeature.individualPatch(context, NOCTURNALWEED_PATCH)
                .state(BorealBlocks.NOCTURNALWEED.get().defaultBlockState())
                .below(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)
                .register();

        PatchFeature.individualPatch(context, GLACIALWEED_PATCH_ON_MARSH)
                .state(BorealBlocks.GLACIALWEED.get().defaultBlockState())
                .below(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)
                .register();

        context.register(BorealConfiguredFeatures.HUGE_NOCTURNAL_FUNGUS, new ConfiguredFeature<>(
                (Feature<HugeMushroomFeatureConfiguration>)BorealFeatures.HUGE_NOCTURNAL_FUNGUS_FEATURE.get(),
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(BorealBlocks.NOCTURNAL_FUNGUS_CAP.get()),
                        BlockStateProvider.simple(BorealBlocks.NOCTURNAL_FUNGUS_STEM.get()),
                        2
                )
        ));
    }
}
package net.elaguilamc623.the_boreal.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.worldgen.level.BorealFeatures;
import net.elaguilamc623.the_boreal.worldgen.level.trees.auroral.AuroralTreeConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BorealConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> AURORAL_TREE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(AURORAL_TREE,
                new ConfiguredFeature<>(BorealFeatures.AURORAL_TREE.get(),
                        new AuroralTreeConfiguration(
                                BlockStateProvider.simple(BorealBlocks.AURORA_LOG.get()),
                                BlockStateProvider.simple(BorealBlocks.AURORA_LEAVES.get()),
                                BlockStateProvider.simple(BorealBlocks.AURORA_LOG.get()),
                                12, 8
                        )
                )
        );
    }
}
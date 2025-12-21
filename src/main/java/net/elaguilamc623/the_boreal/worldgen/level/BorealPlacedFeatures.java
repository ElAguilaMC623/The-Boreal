package net.elaguilamc623.the_boreal.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class BorealPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AURORAL_TREE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        context.register(AURORAL_TREE_PLACED,
                new PlacedFeature(
                        context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(BorealConfiguredFeatures.AURORAL_TREE),
                        List.of(
                                CountPlacement.of(1),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP,
                                BiomeFilter.biome()
                        )
                )
        );
    }
}
package net.elaguilamc623.the_boreal.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.elaguilamc623.the_boreal.worldgen.level.BorealConfiguredFeatures.*;

public class BorealPlacedFeatures {

    public static final ResourceKey<PlacedFeature> AURORAL_TREE_SMALL_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_small_placed"));

    public static final ResourceKey<PlacedFeature> AURORAL_TREE_LARGE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation(TheBoreal.MOD_ID, "auroral_tree_large_placed"));

}
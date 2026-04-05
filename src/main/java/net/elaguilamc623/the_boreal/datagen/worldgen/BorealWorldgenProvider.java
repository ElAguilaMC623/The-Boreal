package net.elaguilamc623.the_boreal.datagen.worldgen;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBiomes;
import net.elaguilamc623.the_boreal.worldgen.features.BorealConfiguredFeatures;
import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BorealWorldgenProvider extends DatapackBuiltinEntriesProvider {

    public BorealWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(
                output,
                registries,
                new RegistrySetBuilder()
                        .add(Registries.BIOME, BorealBiomes::bootstrap)
                        .add(Registries.CONFIGURED_FEATURE, BorealConfiguredFeatures::bootstrap)
                        .add(Registries.PLACED_FEATURE, BorealPlacedFeatures::bootstrap),
                Set.of(TheBoreal.MOD_ID)
        );
    }
}
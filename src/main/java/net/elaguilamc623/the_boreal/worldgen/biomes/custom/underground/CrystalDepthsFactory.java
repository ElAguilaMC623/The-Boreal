package net.elaguilamc623.the_boreal.worldgen.biomes.custom.underground;

import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CrystalDepthsFactory extends BorealCavesFactory {

    @Override
    public BiomeGenerationSettings.Builder defaultGenerationSettings(BootstapContext<Biome> context) {
        var builder = super.defaultGenerationSettings(context);

        builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BorealPlacedFeatures.CAVE_CRYSTAL_SPIKE_PLACED);

        return builder;
    }
}

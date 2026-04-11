package net.elaguilamc623.the_boreal.worldgen.biomes.util;

import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BorealBiomeDefaultFeatures {

    public static void addGlacialGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIAL_GRASS_PATCH_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIAL_TALL_GRASS_PATCH_PLACED);
    }

    public static void addNocturnalGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.NOCTURNAL_TALL_GRASS_PATCH_PLACED);
    }

    public static void addNocturnalPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.NOCTURNALIGHT_SHROOM_PATCH_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.NOCTURNALWEED_PATCH_PLACED);
    }

    public static void addGlacialPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIALIGHT_SHROOM_PATCH_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIALWEED_PATCH_COMMON_PLACED);
    }

    public static void addAuroralPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.BOREALIGHT_SHROOM_PATCH_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.STARLIGHT_SHROOM_PATCH_PLACED);
    }
}

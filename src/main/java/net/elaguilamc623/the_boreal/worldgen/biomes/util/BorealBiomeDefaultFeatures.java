package net.elaguilamc623.the_boreal.worldgen.biomes.util;

import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BorealBiomeDefaultFeatures {

    public static void addGlacialGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIAL_GRASS_PATCH_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIAL_TALL_GRASS_PATCH_PLACED);
    }

    public static void addNocturnalGrassDense(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.NOCTURNAL_GRASS_DENSE_PATCH_PLACED);
    }

    public static void addNocturnalGrassSpare(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.NOCTURNAL_GRASS_SPARE_PATCH_PLACED);
    }

    public static void addNocturnalMarshGrass(BiomeGenerationSettings.Builder builder) {
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

    public static void addAllCaveOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BorealPlacedFeatures.TALISMANDIUM_ORE_PLACED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BorealPlacedFeatures.CHRODIUM_ORE_PLACED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BorealPlacedFeatures.DIORIUM_ORE_PLACED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BorealPlacedFeatures.TARNITE_ORE_PLACED);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BorealPlacedFeatures.VERNITE_ORE_PLACED);
    }

    public static void addCrystalDepths(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BorealPlacedFeatures.CAVE_CRYSTAL_SPIKE_PLACED);
    }
}

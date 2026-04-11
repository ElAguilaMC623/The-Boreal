package net.elaguilamc623.the_boreal.worldgen.biomes.custom;

import net.elaguilamc623.the_boreal.worldgen.biomes.AbstractBorealBiomeFactory;
import net.elaguilamc623.the_boreal.worldgen.biomes.util.BorealBiomeDefaultFeatures;
import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class NocturnalMarshFactory extends AbstractBorealBiomeFactory {

    @Override
    public float temperature(BootstapContext<Biome> context) {
        return 0.2F;
    }

    @Override
    public float downfall(BootstapContext<Biome> context) {
        return 0.5F;
    }

    @Override
    public BiomeSpecialEffects.Builder specialEffects(BootstapContext<Biome> context) {
        return super.specialEffects(context)
                .grassColorOverride(4876142)
                .foliageColorOverride(4876142)
                .fogColor(2507703)
                .waterColor(5718385)
                .waterFogColor(2561575);
    }

    @Override
    public MobSpawnSettings.Builder mobSpawnSettings(BootstapContext<Biome> context) {
        return super.mobSpawnSettings(context);
    }

    @Override
    public BiomeGenerationSettings.Builder defaultGenerationSettings(BootstapContext<Biome> context) {
        var builder = super.defaultGenerationSettings(context);

        builder.addFeature(GenerationStep.Decoration.LAKES, BorealPlacedFeatures.NOCTURNAL_DELTA);
        BorealBiomeDefaultFeatures.addNocturnalGrass(builder);

        BorealBiomeDefaultFeatures.addNocturnalPlants(builder);
        BorealBiomeDefaultFeatures.addAuroralPlants(builder);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.HUGE_NOCTURNAL_FUNGUS_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIALWEED_PATCH_UNCOMMON_PLACED);

        return builder;
    }
}
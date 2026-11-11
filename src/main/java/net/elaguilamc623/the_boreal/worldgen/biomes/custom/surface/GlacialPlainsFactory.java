package net.elaguilamc623.the_boreal.worldgen.biomes.custom.surface;

import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.elaguilamc623.the_boreal.worldgen.biomes.custom.AbstractBorealBiomeFactory;
import net.elaguilamc623.the_boreal.worldgen.biomes.util.BorealBiomeDefaultFeatures;
import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class GlacialPlainsFactory extends AbstractBorealBiomeFactory {

    @Override
    public float temperature(BootstapContext<Biome> context) {
        return 0.5F;
    }

    @Override
    public float downfall(BootstapContext<Biome> context) {
        return 0.5F;
    }

    @Override
    public BiomeSpecialEffects.Builder specialEffects(BootstapContext<Biome> context) {
        return super.specialEffects(context)
                .grassColorOverride(6734565)
                .foliageColorOverride(4876142)
                .fogColor(2507703)
                .waterColor(5718385)
                .waterFogColor(2561575);
    }

    @Override
    public MobSpawnSettings.Builder mobSpawnSettings(BootstapContext<Biome> context) {
        return super.mobSpawnSettings(context)
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(BorealEntities.GLACIAL_WOLF.get(), 10, 1, 3));
    }

    @Override
    public BiomeGenerationSettings.Builder defaultGenerationSettings(BootstapContext<Biome> context) {
        var builder = super.defaultGenerationSettings(context);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.AURORAL_BUSH_SPREAD_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIAL_GRASS_PATCH_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.GLACIAL_TALL_GRASS_PATCH_PLACED);
        BorealBiomeDefaultFeatures.addGlacialGrass(builder);
        BorealBiomeDefaultFeatures.addAuroralPlants(builder);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.BOREAL_COBBLESTONE_PILE_RARE_PLACED);

        return builder;
    }
}


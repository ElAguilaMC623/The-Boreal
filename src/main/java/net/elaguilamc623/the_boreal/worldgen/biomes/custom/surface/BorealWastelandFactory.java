package net.elaguilamc623.the_boreal.worldgen.biomes.custom.surface;

import net.elaguilamc623.the_boreal.worldgen.biomes.custom.AbstractBorealBiomeFactory;
import net.elaguilamc623.the_boreal.worldgen.features.BorealPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BorealWastelandFactory extends AbstractBorealBiomeFactory {
    @Override
    public float temperature(BootstapContext<Biome> context) {
        return 0.0F;
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
    public BiomeGenerationSettings.Builder defaultGenerationSettings(BootstapContext<Biome> context) {
        var builder = super.defaultGenerationSettings(context);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.DRY_NOCTURNAL_TREE_PLACED_DENSE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.BOREAL_COBBLESTONE_PILE_PLACED);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.CRYSTALIZED_DEAD_BUSH_PATCH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BorealPlacedFeatures.BOREAL_ROCK_PATCH);

        return builder;
    }
}

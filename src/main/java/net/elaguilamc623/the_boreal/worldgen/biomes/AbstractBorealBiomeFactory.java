package net.elaguilamc623.the_boreal.worldgen.biomes;

import net.elaguilamc623.complementary_core.world.biomes.AbstractBiomeFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public abstract class AbstractBorealBiomeFactory extends AbstractBiomeFactory {

    @Override
    public boolean hasPrecipitation(BootstapContext<Biome> context) {
        return false;
    }

    @Override
    public BiomeSpecialEffects.Builder specialEffects(BootstapContext<Biome> context) {
        return new BiomeSpecialEffects.Builder()
                .skyColor(1980488)
                .fogColor(2507703)
                .waterColor(5718385)
                .waterFogColor(2561575)
                .grassColorOverride(9794291)
                .foliageColorOverride(9794291)
                .ambientMoodSound(
                        new AmbientMoodSettings(
                                SoundEvents.AMBIENT_CAVE,
                                6000,
                                8,
                                2.0
                        )
                );
    }

    @Override
    public MobSpawnSettings.Builder mobSpawnSettings(BootstapContext<Biome> context) {
        return new MobSpawnSettings.Builder();
    }

    @Override
    public BiomeGenerationSettings.Builder defaultGenerationSettings(BootstapContext<Biome> context) {

        BiomeGenerationSettings.Builder builder =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER)
                );

        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);

        builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_LAVA);

        return builder;
    }
}
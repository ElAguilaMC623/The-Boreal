package net.elaguilamc623.the_boreal.worldgen.biomes;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class GlacialTundraBiome {

    public static Biome create(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER)
                );

        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(-0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0xAA66CC)
                        .waterFogColor(0xBB88DD)
                        .skyColor(0x330033)
                        .fogColor(0x99CCFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(null))
                        .build())
                .build();
    }

    public static SurfaceRules.RuleSource glacialTundraSurface() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.state(BorealBlocks.GLACIAL_GRASS_BLOCK.get().defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.state(BorealBlocks.GLACIAL_DIRT.get().defaultBlockState())),
                SurfaceRules.state(BorealBlocks.BOREAL_STONE.get().defaultBlockState())
        );
    }
}
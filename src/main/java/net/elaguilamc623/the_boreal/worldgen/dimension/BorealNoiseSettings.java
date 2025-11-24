package net.elaguilamc623.the_boreal.worldgen.dimension;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.worldgen.BorealBiomes;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.data.worldgen.BootstapContext;

public class BorealNoiseSettings {

    public static final ResourceKey<NoiseGeneratorSettings> BOREAL_NOISE =
            ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(TheBoreal.MOD_ID, "boreal_noise"));

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {

        Holder<NoiseGeneratorSettings> overworldHolder =
                context.lookup(Registries.NOISE_SETTINGS).getOrThrow(NoiseGeneratorSettings.OVERWORLD);
        NoiseGeneratorSettings overworld = overworldHolder.value();

        SurfaceRules.RuleSource tundraSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.state(Blocks.SNOW.defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.state(BorealBlocks.GLACIAL_GRASS_BLOCK.get().defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.state(BorealBlocks.GLACIAL_DIRT.get().defaultBlockState())),
                SurfaceRules.state(BorealBlocks.BOREAL_STONE.get().defaultBlockState())
        );

        SurfaceRules.RuleSource surfaceRule = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(BorealBiomes.GLACIAL_TUNDRA), tundraSurface),
                SurfaceRules.state(BorealBlocks.BOREAL_STONE.get().defaultBlockState())
        );

        NoiseGeneratorSettings boreal = new NoiseGeneratorSettings(
                overworld.noiseSettings(),
                BorealBlocks.BOREAL_STONE.get().defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                overworld.noiseRouter(),
                surfaceRule,
                overworld.spawnTarget(),
                overworld.seaLevel(),
                overworld.disableMobGeneration(),
                overworld.aquifersEnabled(),
                false,
                overworld.useLegacyRandomSource()
        );

        context.register(BOREAL_NOISE, boreal);
    }
}
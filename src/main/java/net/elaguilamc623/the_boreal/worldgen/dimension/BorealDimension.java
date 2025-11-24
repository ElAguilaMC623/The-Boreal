package net.elaguilamc623.the_boreal.worldgen.dimension;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.worldgen.BorealBiomes;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class BorealDimension {
    public static final ResourceKey<LevelStem> BOREAL =
            ResourceKey.create(Registries.LEVEL_STEM,
                    new ResourceLocation(TheBoreal.MOD_ID, "boreal"));

    public static final ResourceKey<NoiseGeneratorSettings> BOREAL_NOISE =
            ResourceKey.create(Registries.NOISE_SETTINGS,
                    new ResourceLocation(TheBoreal.MOD_ID, "boreal_noise"));

    public static final ResourceKey<DimensionType> BOREAL_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    new ResourceLocation(TheBoreal.MOD_ID, "boreal_type"));

    public static final ResourceKey<Level> BOREAL_LEVEL =
            ResourceKey.create(Registries.DIMENSION,
                    new ResourceLocation(TheBoreal.MOD_ID, "boreal"));

    public static void bootstrap(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        BiomeSource biomeSource = new FixedBiomeSource(
                biomes.getOrThrow(BorealBiomes.GLACIAL_TUNDRA));

        Holder<NoiseGeneratorSettings> noiseSettings =
                context.lookup(Registries.NOISE_SETTINGS).getOrThrow(BOREAL_NOISE);

        ChunkGenerator generator = new NoiseBasedChunkGenerator(biomeSource, noiseSettings);

        Holder<DimensionType> dimType =
                context.lookup(Registries.DIMENSION_TYPE).getOrThrow(BOREAL_TYPE);

        context.register(BOREAL, new LevelStem(dimType, generator));
    }
}
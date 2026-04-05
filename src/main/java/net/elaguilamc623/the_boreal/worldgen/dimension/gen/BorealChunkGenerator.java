package net.elaguilamc623.the_boreal.worldgen.dimension.gen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class BorealChunkGenerator extends NoiseBasedChunkGenerator {
    public BorealChunkGenerator(BiomeSource biomeSource,
                                Holder<NoiseGeneratorSettings> settings) {
        super(biomeSource, settings);
    }
}
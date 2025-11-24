package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.registries.worldgen.BorealBiomes;
import net.elaguilamc623.the_boreal.worldgen.dimension.BorealDimension;
import net.elaguilamc623.the_boreal.worldgen.dimension.BorealDimensionType;
import net.elaguilamc623.the_boreal.worldgen.dimension.BorealNoiseSettings;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class BorealBootstrapRegistry {
    public static void registerAll(BootstapContext<?> context) {
        BorealBiomes.bootstrap((BootstapContext<Biome>) context);
        BorealDimensionType.bootstrap((BootstapContext<DimensionType>) context);
        BorealNoiseSettings.bootstrap((BootstapContext<NoiseGeneratorSettings>) context);
        BorealDimension.bootstrap((BootstapContext<LevelStem>) context);
    }

}

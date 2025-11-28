package net.elaguilamc623.the_boreal.worldgen.dimension;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
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
}
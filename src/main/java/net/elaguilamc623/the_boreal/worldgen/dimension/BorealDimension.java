package net.elaguilamc623.the_boreal.worldgen.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class BorealDimension {
    public static final ResourceKey<Level> BOREAL_LEVEL =
            ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_boreal", "boreal"));
}
package net.elaguilamc623.the_boreal.registries.worldgen;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.worldgen.biomes.GlacialTundraBiome;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BorealBiomes {
    public static final ResourceKey<Biome> GLACIAL_TUNDRA =
            ResourceKey.create(Registries.BIOME,
                    new ResourceLocation(TheBoreal.MOD_ID, "glacial_tundra"));

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(GLACIAL_TUNDRA, GlacialTundraBiome.create(context));

    }
}
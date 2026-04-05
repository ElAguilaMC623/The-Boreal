package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.complementary_core.world.biomes.CCBiomeBuilder;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.worldgen.biomes.custom.NocturnalMarshFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BorealBiomes {
    public static final ResourceKey<Biome> GLACIAL_TUNDRA =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "glacial_tundra"));

    public static final ResourceKey<Biome> GLACIAL_OCEAN =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "nocturnal_marsh"));

    public static final ResourceKey<Biome> GLACIAL_DEEP_OCEAN =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "glacial_deep_ocean"));

    public static final ResourceKey<Biome> GLACIAL_SHRUBLAND =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "glacial_shrubland"));

    public static final ResourceKey<Biome> GLACIAL_PLAINS =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "glacial_plains"));

    public static final ResourceKey<Biome> GLACIAL_DESERT =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "glacial_desert"));

    public static final ResourceKey<Biome> SNOWY_AURORAL_FOREST =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "snowy_auroral_forest"));

    public static final ResourceKey<Biome> AURORAL_FOREST =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "auroral_forest"));

    public static final ResourceKey<Biome> NOCTURNAL_MARSH =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "nocturnal_marsh"));

    public static void bootstrap(BootstapContext<Biome> context) {

        context.register(BorealBiomes.NOCTURNAL_MARSH,
                new CCBiomeBuilder(NocturnalMarshFactory::new).build(context)
        );
    }
}

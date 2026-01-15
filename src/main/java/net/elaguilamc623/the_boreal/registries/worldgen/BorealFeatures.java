package net.elaguilamc623.the_boreal.registries.worldgen;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.worldgen.features.custom.GlacialCrystalSpikeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, TheBoreal.MOD_ID);

    public static final RegistryObject<Feature<GlacialCrystalSpikeFeature.Config>> GLACIAL_CRYSTAL_SPIKE = FEATURES.register("glacial_crystal_spike",
            () -> new GlacialCrystalSpikeFeature(GlacialCrystalSpikeFeature.Config.CODEC));
}

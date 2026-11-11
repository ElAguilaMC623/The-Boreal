package net.elaguilamc623.the_boreal.registries.world;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.worldgen.features.custom.GlacialCrystalSpikeFeature;
import net.elaguilamc623.the_boreal.worldgen.features.custom.HugeNocturnalFungusFeature;
import net.elaguilamc623.the_boreal.worldgen.features.custom.NocturnalTreeFeature;
import net.elaguilamc623.the_boreal.worldgen.features.custom.config.NocturnalTreeConfig;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, TheBoreal.MOD_ID);

    public static final RegistryObject<Feature<GlacialCrystalSpikeFeature.GlacialCrystalSpikeConfig>> GLACIAL_CRYSTAL_SPIKE = FEATURES.register("glacial_crystal_spike",
            () -> new GlacialCrystalSpikeFeature(GlacialCrystalSpikeFeature.GlacialCrystalSpikeConfig.CODEC));

    public static final RegistryObject<Feature<?>> HUGE_NOCTURNAL_FUNGUS_FEATURE = FEATURES.register("huge_nocturnal_fungus",
            () -> new HugeNocturnalFungusFeature(HugeMushroomFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<NocturnalTreeConfig>> NOCTURNAL_TREE_FEATURE = FEATURES.register("nocturnal_tree_feature",
            () -> new NocturnalTreeFeature());
}

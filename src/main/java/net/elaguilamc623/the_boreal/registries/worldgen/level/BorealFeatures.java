package net.elaguilamc623.the_boreal.registries.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.worldgen.level.trees.auroral.AuroralTreeConfiguration;
import net.elaguilamc623.the_boreal.worldgen.level.trees.auroral.AuroralTreeFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BorealFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, TheBoreal.MOD_ID);

    public static final RegistryObject<Feature<AuroralTreeConfiguration>> AURORAL_TREE =
            FEATURES.register("auroral_tree", () -> new AuroralTreeFeature(AuroralTreeConfiguration.CODEC));
}
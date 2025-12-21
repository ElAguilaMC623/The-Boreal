package net.elaguilamc623.the_boreal.registries.worldgen.level;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.worldgen.level.trees.auroral.AuroralFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BorealFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, TheBoreal.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<AuroralFoliagePlacer>> AURORAL_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("aurora_foliage_placer",
                    () -> new FoliagePlacerType<>(AuroralFoliagePlacer.CODEC));
}
package net.elaguilamc623.the_boreal.registries.world.structures;

import net.elaguilamc623.the_boreal.worldgen.structures.JigsawStructuresGenerationChecker;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class BorealStructureGeneration {

    public static final DeferredRegister<StructureType<?>> STRUCTURES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, "the_boreal");

    public static final RegistryObject<StructureType<JigsawStructuresGenerationChecker>> ADVANCED_STRUCTURE =
            STRUCTURES.register("jigsaw_generation_checker", () -> () -> JigsawStructuresGenerationChecker.CODEC.codec());

    public static void register(IEventBus bus) {
        STRUCTURES.register(bus);
    }
}
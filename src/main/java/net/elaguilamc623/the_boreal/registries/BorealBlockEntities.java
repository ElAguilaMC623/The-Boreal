package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.blocks.block_entities.BorealEssenceTableBlockEntity;
import net.elaguilamc623.the_boreal.blocks.block_entities.signs.BorealHangingSignBlockEntity;
import net.elaguilamc623.the_boreal.blocks.block_entities.signs.BorealSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheBoreal.MOD_ID);


    public static final RegistryObject<BlockEntityType<BorealSignBlockEntity>> BOREAL_SIGN =
            BLOCK_ENTITIES.register("auroral_sign", () ->
                    BlockEntityType.Builder.of(BorealSignBlockEntity::new,
                            BorealBlocks.AURORAL_SIGN.get(), BorealBlocks.AURORAL_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<BorealHangingSignBlockEntity>> BOREAL_HANGING_SIGN =
            BLOCK_ENTITIES.register("auroral_hanging_sign", () ->
                    BlockEntityType.Builder.of(BorealHangingSignBlockEntity::new,
                            BorealBlocks.AURORAL_HANGING_SIGN.get(), BorealBlocks.AURORAL_WALL_HANGING_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<BorealEssenceTableBlockEntity>> BOREAL_ESSENCE_TABLE =
            BLOCK_ENTITIES.register("gem_polishing_be", () ->
                    BlockEntityType.Builder.of(BorealEssenceTableBlockEntity::new,
                            BorealBlocks.BOREAL_ESSENCE_TABLE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
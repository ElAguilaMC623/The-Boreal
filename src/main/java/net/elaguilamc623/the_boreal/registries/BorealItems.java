package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.entities.custom.BorealBoatEntity;
import net.elaguilamc623.the_boreal.entities.custom.BorealChestBoatEntity;
import net.elaguilamc623.the_boreal.items.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheBoreal.MOD_ID);


    public static final RegistryObject<Item> ANCIENT_ICE_FRAGMENT = ITEMS.register("ancient_ice_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FROZEN_AMULET = ITEMS.register("frozen_amulet",
            () -> new FrozenAmuletItem(new Item.Properties()));

    public static final RegistryObject<Item> BOREAL_ROCK = ITEMS.register("boreal_rock",
            () -> new BorealRockItem(new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_SEED = ITEMS.register("glacial_seed",
            () -> new GlacialSeedItem(BorealBlocks.GLACIAL_WHEAT_PLANT.get(), new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_WHEAT = ITEMS.register("glacial_wheat",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_BREAD = ITEMS.register("glacial_bread",
            () -> new Item(new Item.Properties().food(BorealFoodProperties.GLACIAL_BREAD)));

    public static final RegistryObject<Item> GLACIAL_ZOMBIE_SPAWN_EGG = ITEMS.register("glacial_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.GLACIAL_ZOMBIE, 0x3A6BAF, 0xFFFFFFFF, new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_WOLF_SPAWN_EGG = ITEMS.register("glacial_wolf_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.GLACIAL_WOLF, 0xFFFFFFFF, 0x40E0D0, new Item.Properties()));

    public static final RegistryObject<Item> AURORA_SAPLING_ITEM = ITEMS.register("aurora_sapling",
            () -> new BlockItem(BorealBlocks.AURORA_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> AURORAL_SIGN = ITEMS.register("auroral_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BorealBlocks.AURORAL_SIGN.get(), BorealBlocks.AURORAL_WALL_SIGN.get()));

    public static final RegistryObject<Item> AURORAL_HANGING_SIGN = ITEMS.register("auroral_hanging_sign",
            () -> new HangingSignItem(BorealBlocks.AURORAL_HANGING_SIGN.get(), BorealBlocks.AURORAL_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> AURORAL_BOAT = ITEMS.register("auroral_boat",
            () -> new BorealBoatItem(false, BorealBoatEntity.Type.AURORAL, new Item.Properties()));

    public static final RegistryObject<Item> AURORAL_CHEST_BOAT = ITEMS.register("auroral_chest_boat",
            () -> new BorealBoatItem(true, BorealBoatEntity.Type.AURORAL, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

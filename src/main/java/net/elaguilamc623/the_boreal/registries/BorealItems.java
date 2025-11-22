package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheBoreal.MOD_ID);


    public static final RegistryObject<Item> ANCIENT_ICE_FRAGMENT = ITEMS.register("ancient_ice_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ICE_ACTIVATOR = ITEMS.register("ice_activator",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BOREAL_ROCK = ITEMS.register("boreal_rock",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

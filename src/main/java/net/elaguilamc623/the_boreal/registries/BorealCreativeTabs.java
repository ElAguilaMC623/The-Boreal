package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class BorealCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.
            create(Registries.CREATIVE_MODE_TAB, TheBoreal.MOD_ID);

    public static RegistryObject<CreativeModeTab> BOREAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_items_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealItems.ANCIENT_ICE_FRAGMENT.get()))
                            .title(Component.literal("The Boreal Items"))
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_blocks_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealBlocks.BOREAL_STONE.get()))
                            .title(Component.literal("The Boreal Blocks"))
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

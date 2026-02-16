package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.gui.boreal_essence_table.BorealEssenceTableMenu;
import net.elaguilamc623.the_boreal.gui.boreal_infuser.BorealInfuserMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheBoreal.MOD_ID);

    public static final RegistryObject<MenuType<BorealEssenceTableMenu>> BOREAL_ESSENCE_TABLE =
            MENUS.register("boreal_essence_table",
                    () -> IForgeMenuType.create((windowId, inv, buf) ->
                            new BorealEssenceTableMenu(windowId, inv, buf)));

    public static final RegistryObject<MenuType<BorealInfuserMenu>> BOREAL_INFUSER =
            MENUS.register("boreal_infuser",
                    () -> IForgeMenuType.create((windowId, inv, buf) ->
                            new BorealInfuserMenu(windowId, inv, buf)));
}

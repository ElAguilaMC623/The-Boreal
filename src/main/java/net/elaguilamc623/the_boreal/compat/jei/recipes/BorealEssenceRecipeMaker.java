package net.elaguilamc623.the_boreal.compat.jei.recipes;

import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.utils.BorealConversions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BorealEssenceRecipeMaker {
    public static List<BorealEssenceRecipe> getRecipes() {
        List<BorealEssenceRecipe> list = new ArrayList<>();

        for (Map.Entry<Item, Item> entry : BorealConversions.BOREAL_TO_VANILLA.entrySet()) {
            ItemStack boreal = new ItemStack(entry.getKey());
            ItemStack vanilla = new ItemStack(entry.getValue());

            list.add(new BorealEssenceRecipe(
                    boreal,
                    new ItemStack(BorealItems.DIORIUM_GEM.get()),
                    vanilla,
                    new ItemStack(BorealItems.BOREAL_ESSENCE.get())
            ));
        }

        return list;
    }
}
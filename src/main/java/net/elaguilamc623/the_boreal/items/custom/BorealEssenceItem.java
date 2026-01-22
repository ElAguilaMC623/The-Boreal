package net.elaguilamc623.the_boreal.items.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BorealEssenceItem extends Item {
    public BorealEssenceItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}

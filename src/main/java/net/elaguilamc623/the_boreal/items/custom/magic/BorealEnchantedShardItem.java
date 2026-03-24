package net.elaguilamc623.the_boreal.items.custom.magic;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BorealEnchantedShardItem extends Item {
    public BorealEnchantedShardItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack item) {
        return true;
    }
}

package net.elaguilamc623.the_boreal.items.custom.weapons;

import net.elaguilamc623.the_boreal.items.BorealItemProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class BorealArmorItem extends ArmorItem {

    private final boolean unbreakable;

    public BorealArmorItem(ArmorMaterial material, Type type, Properties props) {
        super(material, type, props);

        if (props instanceof BorealItemProperties borealProps) {
            this.unbreakable = borealProps.isUnbreakable();
        } else {
            this.unbreakable = false;
        }
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return !unbreakable;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return !unbreakable;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return unbreakable || super.isEnchantable(stack);
    }

}

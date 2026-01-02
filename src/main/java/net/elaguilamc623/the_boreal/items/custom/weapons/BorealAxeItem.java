package net.elaguilamc623.the_boreal.items.custom.weapons;

import net.elaguilamc623.the_boreal.items.BorealItemProperties;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class BorealAxeItem extends AxeItem {

    private final boolean unbreakable;

    public BorealAxeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);

        if (properties instanceof BorealItemProperties borealProps) {
            this.unbreakable = borealProps.isUnbreakable();
        } else {
            this.unbreakable = false;
        }
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        if (unbreakable) return false;
        return super.isDamageable(stack);
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        if (unbreakable) return false;
        return super.isRepairable(stack);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        if (unbreakable) return true;
        return super.isEnchantable(stack);
    }
}

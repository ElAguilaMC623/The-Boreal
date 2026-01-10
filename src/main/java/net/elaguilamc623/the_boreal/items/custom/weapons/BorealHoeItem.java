package net.elaguilamc623.the_boreal.items.custom.weapons;

import net.elaguilamc623.the_boreal.items.BorealItemProperties;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BorealHoeItem extends HoeItem {

    private final boolean unbreakable;

    public BorealHoeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.the_boreal.diorium_hoe").withStyle(ChatFormatting.AQUA));
    }
}

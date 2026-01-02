package net.elaguilamc623.the_boreal.items.tiers;

import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public enum BorealTiers implements Tier {

    TALISMANDIUM(new ForgeTier(
            3, 1700, 3.0F, 0.0F, 12,
            BorealTags.NEEDS_TALISMANDIUM_TOOL,
            () -> Ingredient.of(BorealItems.TALISMANDIUM_INGOT.get())
    )),

    CHRODIUM(new ForgeTier(
            4, 2500, 4.5F, 0.0F, 18,
            BorealTags.NEEDS_CHRODIUM_TOOL,
            () -> Ingredient.of(BorealItems.CHRODIUM.get())
    )),

    DIORIUM(new ForgeTier(
            5, 3200, 6.0F, 0.0F, 22,
            BorealTags.NEEDS_DIORIUM_TOOL,
            () -> Ingredient.of(BorealItems.DIORIUM_INGOT.get())
    ));

    private final ForgeTier tier;

    BorealTiers(ForgeTier tier) {
        this.tier = tier;
    }

    @Override public int getUses() { return tier.getUses(); }
    @Override public float getSpeed() { return tier.getSpeed(); }
    @Override public float getAttackDamageBonus() { return tier.getAttackDamageBonus(); }
    @Override public int getLevel() { return tier.getLevel(); }
    @Override public int getEnchantmentValue() { return tier.getEnchantmentValue(); }
    @Override public Ingredient getRepairIngredient() { return tier.getRepairIngredient(); }
}
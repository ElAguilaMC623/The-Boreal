package net.elaguilamc623.the_boreal.items.tiers;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum BorealArmorMaterials implements ArmorMaterial {
    TALISMANDIUM("talismandium", 33, new int[]{ 3, 6, 8, 3 }, 20,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 2, 0, () ->  Ingredient.of((BorealItems.TALISMANDIUM_INGOT.get()))),
    CHRODIUM("chrodium", 40, new int[]{ 4, 6, 7, 4 }, 20,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 3, 0, () ->  Ingredient.of((BorealItems.CHRODIUM.get()))),
    DIORIUM("diorium", 26, new int[]{ 6, 7, 8, 5 }, 25,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 4, 0.05F, () ->  Ingredient.of((BorealItems.DIORIUM_INGOT.get())));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    BorealArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
                         SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] + this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TheBoreal.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

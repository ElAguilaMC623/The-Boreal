package net.elaguilamc623.the_boreal.compat.jei.recipes;

import net.minecraft.world.item.ItemStack;

public class BorealEssenceTableRecipe {
    private final ItemStack borealInput;
    private final ItemStack gemInput;
    private final ItemStack vanillaOutput;
    private final ItemStack essenceOutput;

    public BorealEssenceTableRecipe(ItemStack borealInput, ItemStack gemInput, ItemStack vanillaOutput, ItemStack essenceOutput) {
        this.borealInput = borealInput;
        this.gemInput = gemInput;
        this.vanillaOutput = vanillaOutput;
        this.essenceOutput = essenceOutput;
    }

    public ItemStack getBorealInput() { return borealInput; }
    public ItemStack getGemInput() { return gemInput; }
    public ItemStack getVanillaOutput() { return vanillaOutput; }
    public ItemStack getEssenceOutput() { return essenceOutput; }
}
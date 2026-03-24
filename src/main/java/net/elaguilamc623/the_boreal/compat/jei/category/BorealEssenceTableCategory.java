package net.elaguilamc623.the_boreal.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.compat.jei.recipes.BorealEssenceTableRecipe;
import net.elaguilamc623.the_boreal.compat.jei.recipes.BorealJEIRecipeTypes;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BorealEssenceTableCategory implements IRecipeCategory<BorealEssenceTableRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(TheBoreal.MOD_ID, "boreal_essence_table");

    private final IDrawable background;
    private final IDrawable icon;

    public BorealEssenceTableCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(
                new ResourceLocation(TheBoreal.MOD_ID, "textures/gui/boreal_essence_table.png"),
                0, 0, 150, 80
        );

        this.icon = guiHelper.createDrawableIngredient(
                VanillaTypes.ITEM_STACK,
                new ItemStack(BorealBlocks.BOREAL_ESSENCE_TABLE.get())
        );
    }

    @Override
    public RecipeType<BorealEssenceTableRecipe> getRecipeType() {
        return BorealJEIRecipeTypes.ESSENCE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Boreal Essence Table");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BorealEssenceTableRecipe recipe, IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 30, 30)
                .addItemStack(recipe.getBorealInput());

        builder.addSlot(RecipeIngredientRole.INPUT, 80, 30)
                .addItemStack(recipe.getGemInput());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 130, 25)
                .addItemStack(recipe.getVanillaOutput());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 130, 50)
                .addItemStack(recipe.getEssenceOutput());
    }
}
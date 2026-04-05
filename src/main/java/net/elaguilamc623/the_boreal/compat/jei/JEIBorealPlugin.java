package net.elaguilamc623.the_boreal.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.compat.jei.category.BorealEssenceTableCategory;
import net.elaguilamc623.the_boreal.compat.jei.recipes.BorealEssenceRecipeMaker;
import net.elaguilamc623.the_boreal.compat.jei.recipes.JEIBorealRecipeTypes;
import net.elaguilamc623.the_boreal.gui.boreal_essence_table.BorealEssenceTableScreen;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIBorealPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TheBoreal.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new BorealEssenceTableCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
                JEIBorealRecipeTypes.ESSENCE,
                BorealEssenceRecipeMaker.getRecipes()
        );
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(
                BorealEssenceTableScreen.class,
                80, 20, 20, 20,
                JEIBorealRecipeTypes.ESSENCE
        );
    }
}
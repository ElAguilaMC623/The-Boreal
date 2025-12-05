package net.elaguilamc623.the_boreal.datagen;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import java.util.List;
import java.util.function.Consumer;

public class BorealRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private void generateStonecutterRecipes(Consumer<FinishedRecipe> consumer,
                                            ItemLike base,
                                            ItemLike... results) {
        for (ItemLike result : results) {
            int count = (result instanceof SlabBlock) ? 2 : 1;
            SingleItemRecipeBuilder.stonecutting(
                            Ingredient.of(base),
                            RecipeCategory.BUILDING_BLOCKS,
                            result,
                            count
                    )
                    .unlockedBy(getHasName(base), has(base))
                    .save(consumer, getConversionRecipeName(result, base) + "_stonecutting");
        }
    }

    private void slabRecipe(Consumer<FinishedRecipe> consumer, ItemLike base, ItemLike slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    private void stairsRecipe(Consumer<FinishedRecipe> consumer, ItemLike base, ItemLike stairs) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    private void wallRecipe(Consumer<FinishedRecipe> consumer, ItemLike base, ItemLike wall) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wall, 6)
                .pattern("###")
                .pattern("###")
                .define('#', base)
                .unlockedBy(getHasName(base), has(base))
                .save(consumer);
    }

    private void bricksRecipe(Consumer<FinishedRecipe> consumer,
                                 ItemLike input, ItemLike output,
                                 String unlockName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("##")
                .pattern("##")
                .define('#', input)
                .unlockedBy(unlockName, has(input))
                .save(consumer);
    }

    private void chiseledRecipe(Consumer<FinishedRecipe> consumer,
                                    ItemLike slab, ItemLike output,
                                    String unlockName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output)
                .pattern("#")
                .pattern("#")
                .define('#', slab)
                .unlockedBy(unlockName, has(slab))
                .save(consumer);
    }

    private void mossyBlockRecipe(Consumer<FinishedRecipe> consumer,
                             ItemLike base, ItemLike output,
                             String unlockName) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output)
                .pattern("S")
                .pattern("V")
                .define('S', base)
                .define('V', Items.VINE)
                .unlockedBy(unlockName, has(Items.VINE))
                .save(consumer);
    }

    public BorealRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BorealItems.FROZEN_AMULET.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', BorealItems.ANCIENT_ICE_FRAGMENT.get())
                .define('B', Items.BLUE_ICE)
                .unlockedBy("has_ancient_ice_fragment", has(BorealItems.ANCIENT_ICE_FRAGMENT.get()))
                .save(consumer);

        oreSmelting(consumer,
                List.of(BorealBlocks.BOREAL_COBBLESTONE.get()),
                RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_STONE.get(),
                0.1f, 200, "boreal_stone");

        oreBlasting(consumer,
                List.of(BorealBlocks.BOREAL_COBBLESTONE.get()),
                RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_STONE.get(),
                0.1f, 100, "boreal_stone");

        bricksRecipe(consumer, BorealBlocks.BOREAL_STONE.get(),
                BorealBlocks.BOREAL_STONE_BRICKS.get(), "has_boreal_stone");

        chiseledRecipe(consumer, BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get(),
                BorealBlocks.BOREAL_CHISELED_STONE.get(), "has_boreal_chiseled");

        bricksRecipe(consumer, BorealItems.BOREAL_ROCK.get(),
                BorealBlocks.BOREAL_COBBLESTONE.get(), "has_boreal_rock");

        mossyBlockRecipe(consumer, BorealBlocks.BOREAL_STONE_BRICKS.get(),
                BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get(), "has_moss");


        slabRecipe(consumer, BorealBlocks.BOREAL_STONE.get(), BorealBlocks.BOREAL_STONE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.BOREAL_STONE.get(), BorealBlocks.BOREAL_STONE_STAIRS.get());

        slabRecipe(consumer, BorealBlocks.BOREAL_COBBLESTONE.get(), BorealBlocks.BOREAL_COBBLESTONE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.BOREAL_COBBLESTONE.get(), BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get());
        wallRecipe(consumer, BorealBlocks.BOREAL_COBBLESTONE.get(), BorealBlocks.BOREAL_COBBLESTONE_WALL.get());

        slabRecipe(consumer, BorealBlocks.BOREAL_DEEP_STONE.get(), BorealBlocks.BOREAL_DEEP_STONE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.BOREAL_DEEP_STONE.get(), BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get());
        wallRecipe(consumer, BorealBlocks.BOREAL_DEEP_STONE.get(), BorealBlocks.BOREAL_DEEP_STONE_WALL.get());

        slabRecipe(consumer, BorealBlocks.BOREAL_STONE_BRICKS.get(), BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.BOREAL_STONE_BRICKS.get(), BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get());
        wallRecipe(consumer, BorealBlocks.BOREAL_STONE_BRICKS.get(), BorealBlocks.BOREAL_STONE_BRICK_WALL.get());

        slabRecipe(consumer, BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get(), BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get(), BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get());
        wallRecipe(consumer, BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get(), BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get());


        generateStonecutterRecipes(consumer, BorealBlocks.BOREAL_STONE.get(),
                BorealBlocks.BOREAL_STONE_SLAB.get(),
                BorealBlocks.BOREAL_STONE_STAIRS.get(),
                BorealBlocks.BOREAL_CHISELED_STONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_COBBLESTONE.get(), BorealBlocks.BOREAL_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_COBBLESTONE_SLAB.get(), BorealBlocks.BOREAL_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get(), BorealBlocks.BOREAL_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_COBBLESTONE_WALL.get(), BorealBlocks.BOREAL_STONE.get());

        generateStonecutterRecipes(consumer, BorealBlocks.BOREAL_COBBLESTONE.get(),
                BorealBlocks.BOREAL_COBBLESTONE_SLAB.get(),
                BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get(),
                BorealBlocks.BOREAL_COBBLESTONE_WALL.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_STONE_BRICKS.get(), BorealBlocks.BOREAL_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get(), BorealBlocks.BOREAL_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get(), BorealBlocks.BOREAL_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS,
                BorealBlocks.BOREAL_STONE_BRICK_WALL.get(), BorealBlocks.BOREAL_STONE.get());

        generateStonecutterRecipes(consumer, BorealBlocks.BOREAL_STONE_BRICKS.get(),
                BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get(),
                BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get(),
                BorealBlocks.BOREAL_STONE_BRICK_WALL.get());

        generateStonecutterRecipes(consumer, BorealBlocks.BOREAL_DEEP_STONE.get(),
                BorealBlocks.BOREAL_DEEP_STONE_SLAB.get(),
                BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get(),
                BorealBlocks.BOREAL_DEEP_STONE_WALL.get());

        generateStonecutterRecipes(consumer, BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get(),
                BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get(),
                BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get(),
                BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get());

    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  TheBoreal.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

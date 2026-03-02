package net.elaguilamc623.the_boreal.datagen.recipes;

import net.elaguilamc623.complementary_core.datagen.recipes.CCRecipeProvider;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BorealRecipeProvider extends CCRecipeProvider implements IConditionBuilder {

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

    private void simpleWoodFamilyRecipes(Consumer<FinishedRecipe> consumer,
                                         Supplier<Block> log,
                                         Supplier<Block> wood,
                                         Supplier<Block> strippedLog,
                                         Supplier<Block> strippedWood,
                                         Supplier<Block> planks) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks.get(), 4)
                .requires(log.get())
                .group("planks")
                .unlockedBy("has_log", has(log.get()))
                .save(consumer, TheBoreal.MOD_ID + ":aurora_planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks.get(), 4)
                .requires(wood.get())
                .group("planks")
                .unlockedBy("has_wood", has(wood.get()))
                .save(consumer, TheBoreal.MOD_ID + ":aurora_planks_from_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks.get(), 4)
                .requires(strippedLog.get())
                .group("planks")
                .unlockedBy("has_stripped_log", has(strippedLog.get()))
                .save(consumer, TheBoreal.MOD_ID + ":aurora_planks_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks.get(), 4)
                .requires(strippedWood.get())
                .group("planks")
                .unlockedBy("has_stripped_wood", has(strippedWood.get()))
                .save(consumer, TheBoreal.MOD_ID + ":aurora_planks_from_stripped_wood");
    }

    private void woodFromLogs(Consumer<FinishedRecipe> consumer,
                              Supplier<Block> log,
                              Supplier<Block> wood) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wood.get(), 3)
                .define('#', log.get())
                .pattern("##")
                .pattern("##")
                .group("boreal_wood")
                .unlockedBy("has_log", has(log.get()))
                .save(consumer);
    }

    public void stickRecipe(Consumer<FinishedRecipe> consumer,
                            ItemLike plank,
                            ItemLike stick,
                            int count,
                            String name) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stick, count)
                .pattern("A")
                .pattern("A")
                .define('A', plank)
                .unlockedBy("has_" + name, has(plank))
                .save(consumer, new ResourceLocation("the_boreal", name + "_stick"));
    }

    private void signRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 3)
                .define('#', planks)
                .define('X', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" X ")
                .unlockedBy("has_planks", has(planks))
                .save(consumer);
    }

    private void hangingSignRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike strippedLog) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, output, 6)
                .define('#', strippedLog)
                .define('X', Items.CHAIN)
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy("has_stripped_log", has(strippedLog))
                .save(consumer);
    }

    public void toolRecipe(Consumer<FinishedRecipe> consumer,
                           ItemLike result,
                           ItemLike material,
                           TagKey<Item> stickTag,
                           String pattern1,
                           String pattern2,
                           String pattern3,
                           String name) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern(pattern1)
                .pattern(pattern2)
                .pattern(pattern3)
                .define('X', material)
                .define('#', stickTag)
                .unlockedBy("has_" + name, has(material))
                .save(consumer);
    }

    private void dioriumToolRecipe(Consumer<FinishedRecipe> consumer,
                                   ItemLike result,
                                   String p1, String p2, String p3) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern(p1)
                .pattern(p2)
                .pattern(p3)
                .define('A', BorealItems.DIORIUM_INGOT.get())
                .define('B', BorealItems.DIORIUM_GEM.get())
                .define('C', BorealItems.AURORAL_STICK.get())
                .unlockedBy("has_diorium_ingot", has(BorealItems.DIORIUM_INGOT.get()))
                .save(consumer);
    }

    private void dioriumArmorRecipe(Consumer<FinishedRecipe> consumer,
                                    ItemLike result,
                                    String p1, String p2, String p3) {

        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(p1)
                .pattern(p2);

        if (p3 == null) {
            builder.pattern("   ");
        } else {
            builder.pattern(p3);
        }

        builder.define('A', BorealItems.DIORIUM_INGOT.get())
                .define('B', BorealItems.DIORIUM_GEM.get())
                .unlockedBy("has_diorium_ingot", has(BorealItems.DIORIUM_INGOT.get()))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BorealItems.GLACIAL_BREAD.get())
                .pattern("WWW")
                .define('W', BorealItems.GLACIAL_WHEAT.get())
                .unlockedBy("has_glacial_wheat", has(BorealItems.GLACIAL_WHEAT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BorealBlocks.BOREAL_ESSENCE_TABLE.get())
                .pattern(" C ")
                .pattern("BDB")
                .pattern("AAA")
                .define('A', BorealBlocks.BOREAL_CHISELED_STONE.get())
                .define('B', BorealItems.DIORIUM_GEM.get())
                .define('C', BorealItems.ANCIENT_ICE_FRAGMENT.get())
                .define('D', BorealItems.DIORIUM_INGOT.get())
                .unlockedBy("has_ancient_ice_fragment", has(BorealItems.DIORIUM_GEM.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BorealBlocks.BOREAL_INFUSER.get())
                .pattern("CDC")
                .pattern(" B ")
                .pattern("AAA")
                .define('A', BorealBlocks.PERMAFROST.get())
                .define('B', BorealBlocks.GLACIAL_CRYSTAL.get())
                .define('C', BorealItems.GLACIAL_CRYSTAL_SHARD.get())
                .define('D', BorealItems.BOREAL_ESSENCE.get())
                .unlockedBy("has_boreal_essence", has(BorealItems.BOREAL_ESSENCE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BorealItems.PRISON_LOCATOR.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('B', BorealItems.BOREAL_ESSENCE.get())
                .define('A', BorealItems.TALISMANDIUM_INGOT.get())
                .unlockedBy("has_boreal_essence", has(BorealItems.BOREAL_ESSENCE.get()))
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

        slabRecipe(consumer, BorealBlocks.VERNITE.get(), BorealBlocks.VERNITE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.VERNITE.get(), BorealBlocks.VERNITE_STAIRS.get());
        wallRecipe(consumer, BorealBlocks.VERNITE.get(), BorealBlocks.VERNITE_WALL.get());

        bricksRecipe(consumer,
                BorealBlocks.VERNITE.get(),
                BorealBlocks.POLISHED_VERNITE.get(),
                getHasName(BorealBlocks.VERNITE.get()));

        slabRecipe(consumer, BorealBlocks.POLISHED_VERNITE.get(), BorealBlocks.POLISHED_VERNITE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.POLISHED_VERNITE.get(), BorealBlocks.POLISHED_VERNITE_STAIRS.get());

        generateStonecutterRecipes(consumer,
                BorealBlocks.VERNITE.get(),
                BorealBlocks.VERNITE_SLAB.get(),
                BorealBlocks.VERNITE_STAIRS.get(),
                BorealBlocks.VERNITE_WALL.get(),
                BorealBlocks.POLISHED_VERNITE.get()
        );

        generateStonecutterRecipes(consumer,
                BorealBlocks.POLISHED_VERNITE.get(),
                BorealBlocks.POLISHED_VERNITE_SLAB.get(),
                BorealBlocks.POLISHED_VERNITE_STAIRS.get()
        );

        slabRecipe(consumer, BorealBlocks.TARNITE.get(), BorealBlocks.TARNITE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.TARNITE.get(), BorealBlocks.TARNITE_STAIRS.get());
        wallRecipe(consumer, BorealBlocks.TARNITE.get(), BorealBlocks.TARNITE_WALL.get());

        bricksRecipe(consumer,
                BorealBlocks.TARNITE.get(),
                BorealBlocks.POLISHED_TARNITE.get(),
                getHasName(BorealBlocks.TARNITE.get()));

        slabRecipe(consumer, BorealBlocks.POLISHED_TARNITE.get(), BorealBlocks.POLISHED_TARNITE_SLAB.get());
        stairsRecipe(consumer, BorealBlocks.POLISHED_TARNITE.get(), BorealBlocks.POLISHED_TARNITE_STAIRS.get());

        generateStonecutterRecipes(consumer,
                BorealBlocks.TARNITE.get(),
                BorealBlocks.TARNITE_SLAB.get(),
                BorealBlocks.TARNITE_STAIRS.get(),
                BorealBlocks.TARNITE_WALL.get(),
                BorealBlocks.POLISHED_TARNITE.get()
        );

        generateStonecutterRecipes(consumer,
                BorealBlocks.POLISHED_TARNITE.get(),
                BorealBlocks.POLISHED_TARNITE_SLAB.get(),
                BorealBlocks.POLISHED_TARNITE_STAIRS.get()
        );


        simpleWoodFamilyRecipes(consumer,
                BorealBlocks.AURORA_LOG,
                BorealBlocks.AURORA_WOOD,
                BorealBlocks.STRIPPED_AURORA_LOG,
                BorealBlocks.STRIPPED_AURORA_WOOD,
                BorealBlocks.AURORA_PLANKS
        );

        woodFromLogs(consumer,
                BorealBlocks.AURORA_LOG,
                BorealBlocks.AURORA_WOOD
        );

        woodFromLogs(consumer,
                BorealBlocks.STRIPPED_AURORA_LOG,
                BorealBlocks.STRIPPED_AURORA_WOOD
        );

        stickRecipe(consumer,
                BorealBlocks.AURORA_PLANKS.get(),
                BorealItems.AURORAL_STICK.get(),
                4,
                "auroral"
        );

        signRecipe(consumer, BorealItems.AURORAL_SIGN.get(), BorealBlocks.AURORA_PLANKS.get());
        hangingSignRecipe(consumer, BorealItems.AURORAL_HANGING_SIGN.get(), BorealBlocks.STRIPPED_AURORA_LOG.get());

        buttonRecipe(consumer, BorealBlocks.AURORAL_BUTTON.get(), BorealBlocks.AURORA_PLANKS.get());
        pressurePlateRecipe(consumer, BorealBlocks.AURORAL_PRESSURE_PLATE.get(), BorealBlocks.AURORA_PLANKS.get());

        fenceAndGateRecipes(
                consumer,
                BorealBlocks.AURORA_PLANKS.get(),
                BorealBlocks.AURORAL_FENCE.get(),
                BorealBlocks.AURORAL_FENCE_GATE.get()
        );

        doorRecipe(consumer, BorealBlocks.AURORAL_DOOR.get(), BorealBlocks.AURORA_PLANKS.get());
        trapdoorRecipe(consumer, BorealBlocks.AURORAL_TRAPDOOR.get(), BorealBlocks.AURORA_PLANKS.get());

        oreSmelting(consumer,
                List.of(
                        BorealItems.RAW_TALISMANDIUM.get(),
                        BorealBlocks.TALISMANDIUM_ORE.get(),
                        BorealBlocks.DEEP_TALISMANDIUM_ORE.get()
                ),
                RecipeCategory.MISC,
                BorealItems.TALISMANDIUM_INGOT.get(),
                0.7f, 200,
                "talismandium");

        oreBlasting(consumer,
                List.of(
                        BorealItems.RAW_TALISMANDIUM.get(),
                        BorealBlocks.TALISMANDIUM_ORE.get(),
                        BorealBlocks.DEEP_TALISMANDIUM_ORE.get()
                ),
                RecipeCategory.MISC,
                BorealItems.TALISMANDIUM_INGOT.get(),
                0.7f, 100,
                "talismandium");

        oreSmelting(consumer,
                List.of(
                        BorealBlocks.CHRODIUM_ORE.get(),
                        BorealBlocks.DEEP_CHRODIUM_ORE.get()
                ),
                RecipeCategory.MISC,
                BorealItems.CHRODIUM.get(),
                0.5f, 200,
                "chrodium");

        oreBlasting(consumer,
                List.of(
                        BorealBlocks.CHRODIUM_ORE.get(),
                        BorealBlocks.DEEP_CHRODIUM_ORE.get()
                ),
                RecipeCategory.MISC,
                BorealItems.CHRODIUM.get(),
                0.5f, 100,
                "chrodium");

        oreSmelting(consumer,
                List.of(
                        BorealItems.RAW_DIORIUM.get(),
                        BorealBlocks.DIORIUM_ORE.get(),
                        BorealBlocks.DEEP_DIORIUM_ORE.get()
                ),
                RecipeCategory.MISC,
                BorealItems.DIORIUM_INGOT.get(),
                0.9f, 200,
                "diorium");

        oreBlasting(consumer,
                List.of(
                        BorealItems.RAW_DIORIUM.get(),
                        BorealBlocks.DIORIUM_ORE.get(),
                        BorealBlocks.DEEP_DIORIUM_ORE.get()
                ),
                RecipeCategory.MISC,
                BorealItems.DIORIUM_INGOT.get(),
                0.9f, 100,
                "diorium");

        toolRecipe(consumer, BorealItems.TALISMANDIUM_TOOLS.getSword().get(),
                BorealItems.TALISMANDIUM_INGOT.get(),
                BorealTags.BOREAL_STICKS,
                "X", "X", "#",
                "talismandium_sword");

        toolRecipe(consumer, BorealItems.TALISMANDIUM_TOOLS.getPickaxe().get(),
                BorealItems.TALISMANDIUM_INGOT.get(),
                BorealTags.BOREAL_STICKS,
                "XXX", " # ", " # ",
                "talismandium_pickaxe");

        toolRecipe(consumer, BorealItems.TALISMANDIUM_TOOLS.getAxe().get(),
                BorealItems.TALISMANDIUM_INGOT.get(),
                BorealTags.BOREAL_STICKS,
                "XX ", "X# ", " # ",
                "talismandium_axe");

        toolRecipe(consumer, BorealItems.TALISMANDIUM_TOOLS.getShovel().get(),
                BorealItems.TALISMANDIUM_INGOT.get(),
                BorealTags.BOREAL_STICKS,
                "X", "#", "#",
                "talismandium_shovel");

        toolRecipe(consumer, BorealItems.TALISMANDIUM_TOOLS.getHoe().get(),
                BorealItems.TALISMANDIUM_INGOT.get(),
                BorealTags.BOREAL_STICKS,
                "XX ", " # ", " # ",
                "talismandium_hoe");

        toolRecipe(consumer, BorealItems.CHRODIUM_TOOLS.getSword().get(),
                BorealItems.CHRODIUM.get(),
                BorealTags.BOREAL_STICKS,
                "X", "X", "#",
                "chrodium_sword");

        toolRecipe(consumer, BorealItems.CHRODIUM_TOOLS.getPickaxe().get(),
                BorealItems.CHRODIUM.get(),
                BorealTags.BOREAL_STICKS,
                "XXX", " # ", " # ",
                "chrodium_pickaxe");

        toolRecipe(consumer, BorealItems.CHRODIUM_TOOLS.getAxe().get(),
                BorealItems.CHRODIUM.get(),
                BorealTags.BOREAL_STICKS,
                "XX ", "X# ", " # ",
                "chrodium_axe");

        toolRecipe(consumer, BorealItems.CHRODIUM_TOOLS.getShovel().get(),
                BorealItems.CHRODIUM.get(),
                BorealTags.BOREAL_STICKS,
                "X", "#", "#",
                "chrodium_shovel");

        toolRecipe(consumer, BorealItems.CHRODIUM_TOOLS.getHoe().get(),
                BorealItems.CHRODIUM.get(),
                BorealTags.BOREAL_STICKS,
                "XX ", " # ", " # ",
                "chrodium_hoe");

        dioriumToolRecipe(consumer, BorealItems.DIORIUM_SWORD.get(),
                " A ",
                "BAB",
                " C ");

        dioriumToolRecipe(consumer, BorealItems.DIORIUM_PICKAXE.get(),
                "BAB",
                " C ",
                " C ");

        dioriumToolRecipe(consumer, BorealItems.DIORIUM_AXE.get(),
                "AB ",
                "AC ",
                " C ");

        dioriumToolRecipe(consumer, BorealItems.DIORIUM_SHOVEL.get(),
                " A ",
                " B ",
                " C ");

        dioriumToolRecipe(consumer, BorealItems.DIORIUM_HOE.get(),
                "AB ",
                " C ",
                " C ");

        dioriumArmorRecipe(consumer, BorealItems.DIORIUM_HELMET.get(),
                "ABA",
                "A A",
                null);

        dioriumArmorRecipe(consumer, BorealItems.DIORIUM_CHESTPLATE.get(),
                "A A",
                "ABA",
                "BAB");

        dioriumArmorRecipe(consumer, BorealItems.DIORIUM_LEGGINGS.get(),
                "ABA",
                "A A",
                "B B");

        dioriumArmorRecipe(consumer, BorealItems.DIORIUM_BOOTS.get(),
                "B B",
                "A A",
                null);

        helmetRecipe(consumer, BorealItems.TALISMANDIUM_ARMOR.getHelmet().get(), BorealItems.TALISMANDIUM_INGOT.get());
        helmetRecipe(consumer, BorealItems.CHRODIUM_ARMOR.getHelmet().get(), BorealItems.CHRODIUM.get());

        chestplateRecipe(consumer, BorealItems.TALISMANDIUM_ARMOR.getChestplate().get(), BorealItems.TALISMANDIUM_INGOT.get());
        chestplateRecipe(consumer, BorealItems.CHRODIUM_ARMOR.getChestplate().get(), BorealItems.CHRODIUM.get());

        leggingsRecipe(consumer, BorealItems.TALISMANDIUM_ARMOR.getLeggings().get(), BorealItems.TALISMANDIUM_INGOT.get());
        leggingsRecipe(consumer, BorealItems.CHRODIUM_ARMOR.getLeggings().get(), BorealItems.CHRODIUM.get());

        bootsRecipe(consumer, BorealItems.TALISMANDIUM_ARMOR.getBoots().get(), BorealItems.TALISMANDIUM_INGOT.get());
        bootsRecipe(consumer, BorealItems.CHRODIUM_ARMOR.getBoots().get(), BorealItems.CHRODIUM.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 3)
                .requires(BorealItems.GLACIAL_BONE.get())
                .unlockedBy("has_glacial_bone", has(BorealItems.GLACIAL_BONE.get()))
                .save(consumer);
        
        torchRecipe(
                consumer,
                BorealItems.GLACIAL_TORCH_ITEM.get(),   
                BorealItems.GLACIAL_CRYSTAL_SHARD.get(),  
                BorealItems.AURORAL_STICK.get(),          
                4,                                     
                "has_glacial_shard"                     
        );

        lanternRecipe(
                consumer,
                BorealBlocks.GLACIAL_LANTERN.get(),
                BorealItems.GLACIAL_TORCH_ITEM.get(),    
                BorealItems.TALISMANDIUM_NUGGET.get(),    
                "has_glacial_torch"                     
        );

        nuggetFromIngotRecipe(
                consumer,
                BorealItems.TALISMANDIUM_NUGGET.get(),
                BorealItems.TALISMANDIUM_INGOT.get(),
                "has_talismandium_ingot"
        );

        barsRecipe(
                consumer,
                BorealBlocks.TALISMANDIUM_BARS.get(),
                BorealItems.TALISMANDIUM_INGOT.get()
        );

        defaultCrystalBlockRecipe(
                consumer,
                BorealBlocks.GLACIAL_CRYSTAL.get(),
                BorealItems.GLACIAL_CRYSTAL_SHARD.get()
        );

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

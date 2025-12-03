package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.blocks.GlacialGrasPlantBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class BorealBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheBoreal.MOD_ID);

    public static final RegistryObject<Block> BOREAL_COBBLESTONE = registerBlock("boreal_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> BOREAL_COBBLESTONE_SLAB = registerBlock("boreal_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)));

    public static final RegistryObject<Block> BOREAL_COBBLESTONE_STAIRS = registerBlock("boreal_cobblestone_stairs",
            () -> new StairBlock(() -> BOREAL_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));

    public static final RegistryObject<Block> BOREAL_COBBLESTONE_WALL = registerBlock("boreal_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> BOREAL_STONE = registerBlock("boreal_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> BOREAL_STONE_SLAB = registerBlock("boreal_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));

    public static final RegistryObject<Block> BOREAL_STONE_STAIRS = registerBlock("boreal_stone_stairs",
            () -> new StairBlock(() -> BOREAL_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE = registerBlock("boreal_deep_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE_SLAB = registerBlock("boreal_deep_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_SLAB)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE_STAIRS = registerBlock("boreal_deep_stone_stairs",
            () -> new StairBlock(() -> BOREAL_DEEP_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_STAIRS)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE_WALL = registerBlock("boreal_deep_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_WALL)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICKS = registerBlock("boreal_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICKS_SLAB = registerBlock("boreal_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICKS_STAIRS = registerBlock("boreal_stone_brick_stairs",
                    () -> new StairBlock(() -> BOREAL_STONE_BRICKS.get().defaultBlockState(),
                            BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICK_WALL = registerBlock("boreal_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICKS = registerBlock("boreal_mossy_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICK_SLAB = registerBlock("boreal_mossy_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICK_STAIRS = registerBlock("boreal_mossy_stone_brick_stairs",
            () -> new StairBlock(() -> BOREAL_MOSSY_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICK_WALL = registerBlock("boreal_mossy_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL)));

    public static final RegistryObject<Block> BOREAL_CHISELED_STONE = registerBlock("boreal_chiseled_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));

    public static final RegistryObject<Block> GLACIAL_GRASS_BLOCK = registerBlock("glacial_grass_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> GLACIAL_DIRT = registerBlock("glacial_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> GLACIAL_GRASS = registerBlock("glacial_grass",
            () -> new GlacialGrasPlantBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return BorealItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

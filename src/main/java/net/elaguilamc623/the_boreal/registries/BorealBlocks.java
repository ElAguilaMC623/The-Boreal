package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.blocks.block_entities.BorealEssenceTableBlock;
import net.elaguilamc623.the_boreal.blocks.block_entities.BorealInfuserBlock;
import net.elaguilamc623.the_boreal.blocks.custom.*;
import net.elaguilamc623.the_boreal.blocks.custom.plants.*;
import net.elaguilamc623.the_boreal.blocks.custom.GlacialGrassBlock;
import net.elaguilamc623.the_boreal.blocks.signs.hanging.BorealHangingSignBlock;
import net.elaguilamc623.the_boreal.blocks.signs.BorealStandingSignBlock;
import net.elaguilamc623.the_boreal.blocks.signs.hanging.BorealWallHangingSignBlock;
import net.elaguilamc623.the_boreal.blocks.signs.BorealWallSignBlock;
import net.elaguilamc623.the_boreal.utils.BorealWoodTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
            () -> new StairBlock(() -> BOREAL_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));

    public static final RegistryObject<Block> BOREAL_COBBLESTONE_WALL = registerBlock("boreal_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> BOREAL_STONE = registerBlock("boreal_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> BOREAL_STONE_SLAB = registerBlock("boreal_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));

    public static final RegistryObject<Block> BOREAL_STONE_STAIRS = registerBlock("boreal_stone_stairs",
            () -> new StairBlock(() -> BOREAL_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE = registerBlock("boreal_deep_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE_SLAB = registerBlock("boreal_deep_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_SLAB)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE_STAIRS = registerBlock("boreal_deep_stone_stairs",
            () -> new StairBlock(() -> BOREAL_DEEP_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_STAIRS)));

    public static final RegistryObject<Block> BOREAL_DEEP_STONE_WALL = registerBlock("boreal_deep_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE_WALL)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICKS = registerBlock("boreal_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICKS_SLAB = registerBlock("boreal_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICKS_STAIRS = registerBlock("boreal_stone_brick_stairs",
            () -> new StairBlock(() -> BOREAL_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BOREAL_STONE_BRICK_WALL = registerBlock("boreal_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICKS = registerBlock("boreal_mossy_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICK_SLAB = registerBlock("boreal_mossy_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICK_STAIRS = registerBlock("boreal_mossy_stone_brick_stairs",
            () -> new StairBlock(() -> BOREAL_MOSSY_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BOREAL_MOSSY_STONE_BRICK_WALL = registerBlock("boreal_mossy_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_WALL)));

    public static final RegistryObject<Block> BOREAL_CHISELED_STONE = registerBlock("boreal_chiseled_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));

    public static final RegistryObject<Block> VERNITE = registerBlock("vernite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));

    public static final RegistryObject<Block> VERNITE_SLAB = registerBlock("vernite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_SLAB)));

    public static final RegistryObject<Block> VERNITE_STAIRS = registerBlock("vernite_stairs",
            () -> new StairBlock(() -> VERNITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ANDESITE_STAIRS)));

    public static final RegistryObject<Block> VERNITE_WALL = registerBlock("vernite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_WALL)));

    public static final RegistryObject<Block> POLISHED_VERNITE = registerBlock("polished_vernite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)));

    public static final RegistryObject<Block> POLISHED_VERNITE_SLAB = registerBlock("polished_vernite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE_SLAB)));

    public static final RegistryObject<Block> POLISHED_VERNITE_STAIRS = registerBlock("polished_vernite_stairs",
            () -> new StairBlock(() -> POLISHED_VERNITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE_SLAB)));

    public static final RegistryObject<Block> TARNITE = registerBlock("tarnite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));

    public static final RegistryObject<Block> TARNITE_SLAB = registerBlock("tarnite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_SLAB)));

    public static final RegistryObject<Block> TARNITE_STAIRS = registerBlock("tarnite_stairs",
            () -> new StairBlock(() -> TARNITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ANDESITE_STAIRS)));

    public static final RegistryObject<Block> TARNITE_WALL = registerBlock("tarnite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE_WALL)));

    public static final RegistryObject<Block> POLISHED_TARNITE = registerBlock("polished_tarnite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)));

    public static final RegistryObject<Block> POLISHED_TARNITE_SLAB = registerBlock("polished_tarnite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE_SLAB)));

    public static final RegistryObject<Block> POLISHED_TARNITE_STAIRS = registerBlock("polished_tarnite_stairs",
            () -> new StairBlock(() -> POLISHED_TARNITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE_SLAB)));

    public static final RegistryObject<Block> TALISMANDIUM_ORE = registerBlock("talismandium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> DEEP_TALISMANDIUM_ORE = registerBlock("deep_talismandium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final RegistryObject<Block> CHRODIUM_ORE = registerBlock("chrodium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> DEEP_CHRODIUM_ORE = registerBlock("deep_chrodium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final RegistryObject<Block> DIORIUM_ORE = registerBlock("diorium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).strength(22.0F, 900.0F)));

    public static final RegistryObject<Block> DEEP_DIORIUM_ORE = registerBlock("deep_diorium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(27.0F, 1000.0F)));

    public static final RegistryObject<Block> GLACIAL_GRASS_BLOCK = registerBlock("glacial_grass_block",
            () -> new GlacialGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> GLACIAL_DIRT = registerBlock("glacial_dirt",
            () -> new GlacialDirtBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> GLACIAL_FARMLAND = registerBlock("glacial_farmland",
            () -> new GlacialFarmlandBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND)));

    public static final RegistryObject<Block> GLACIAL_GRASS = registerBlock("glacial_grass",
            () -> new GlacialGrassPlantBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).replaceable()));

    public static final RegistryObject<Block> GLACIAL_TALL_GRASS = registerBlock("glacial_tall_grass",
            () -> new GlacialTallGrassPlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).replaceable()));

    public static final RegistryObject<Block> BOREALIGHT_SHROOM = registerBlock("borealight_shroom",
            () -> new BorealightShroomBlock(BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY).replaceable().lightLevel(state -> 13)));

    public static final RegistryObject<Block> GLACIALIGHT_SHROOM = registerBlock("glacialight_shroom",
            () -> new BorealightShroomBlock(BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY).replaceable().lightLevel(state -> 13)));

    public static final RegistryObject<Block> GLACIAL_WHEAT_PLANT = BLOCKS.register("glacial_wheat_plant",
            () -> new GlacialWheatBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> PERMAFROST = registerBlock("permafrost",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)));

    public static final RegistryObject<Block> GLACIAL_CRYSTAL = registerBlock("glacial_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN)));

    public static final RegistryObject<Block> AURORA_LOG = registerBlock("aurora_log",
            () -> new BorealFlammableRotatePilarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3F)));

    public static final RegistryObject<Block> AURORA_WOOD = registerBlock("aurora_wood",
            () -> new BorealFlammableRotatePilarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3F)));

    public static final RegistryObject<Block> STRIPPED_AURORA_LOG = registerBlock("stripped_aurora_log",
            () -> new BorealFlammableRotatePilarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3F)));

    public static final RegistryObject<Block> STRIPPED_AURORA_WOOD = registerBlock("stripped_aurora_wood",
            () -> new BorealFlammableRotatePilarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3F)));

    public static final RegistryObject<Block> AURORA_PLANKS = registerBlock("aurora_planks",
            () -> new BorealPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> AURORA_LEAVES = registerBlock("aurora_leaves",
            () -> new BorealLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> AURORA_SAPLING = BLOCKS.register("aurora_sapling",
            () -> new AuroralSaplingBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));

    public static final RegistryObject<Block> AURORAL_SLAB = registerBlock("auroral_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> AURORAL_STAIRS = registerBlock("auroral_stairs",
            () -> new StairBlock(() -> AURORA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> AURORAL_FENCE = registerBlock("auroral_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> AURORAL_FENCE_GATE = registerBlock("auroral_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> AURORAL_DOOR = registerBlock("auroral_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> AURORAL_TRAPDOOR = registerBlock("auroral_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> AURORAL_SIGN = BLOCKS.register("auroral_sign",
            () -> new BorealStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), BorealWoodTypes.AURORAL));

    public static final RegistryObject<Block> AURORAL_WALL_SIGN = BLOCKS.register("auroral_wall_sign",
            () -> new BorealWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), BorealWoodTypes.AURORAL));

    public static final RegistryObject<Block> AURORAL_HANGING_SIGN = BLOCKS.register("auroral_hanging_sign",
            () -> new BorealHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), BorealWoodTypes.AURORAL));

    public static final RegistryObject<Block> AURORAL_WALL_HANGING_SIGN = BLOCKS.register("auroral_wall_hanging_sign",
            () -> new BorealWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), BorealWoodTypes.AURORAL));

    public static final RegistryObject<Block> AURORAL_BUTTON = registerBlock("auroral_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<Block> AURORAL_PRESSURE_PLATE = registerBlock("auroral_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> GLACIAL_TORCH = BLOCKS.register("glacial_torch",
            () -> new TorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).noOcclusion(), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> GLACIAL_WALL_TORCH = BLOCKS.register("glacial_wall_torch",
            () -> new WallTorchBlock(BlockBehaviour.Properties.copy(Blocks.WALL_TORCH).noOcclusion(), ParticleTypes.SOUL_FIRE_FLAME));

    public static final RegistryObject<Block> GLACIAL_LANTERN = registerBlock("glacial_lantern",
            () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(s -> 15).noOcclusion()));

    public static final RegistryObject<Block> BOREAL_ESSENCE_TABLE = registerBlock("boreal_essence_table",
            () -> new BorealEssenceTableBlock(BlockBehaviour.Properties.copy(BorealBlocks.AURORA_PLANKS.get()).noOcclusion().lightLevel(state -> 6)));

    public static final RegistryObject<Block> BOREAL_INFUSER = registerBlock("boreal_infuser",
            () -> new BorealInfuserBlock(BlockBehaviour.Properties.copy(Blocks.ENCHANTING_TABLE).noOcclusion().lightLevel(state -> 10)));

    public static final RegistryObject<IronBarsBlock> TALISMANDIUM_BARS = registerBlock("talismandium_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS)));

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

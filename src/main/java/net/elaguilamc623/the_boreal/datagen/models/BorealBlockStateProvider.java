package net.elaguilamc623.the_boreal.datagen.models;

import net.elaguilamc623.complementary_core.datagen.models.CCBlockStateProvider;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealBlockStateProvider extends CCBlockStateProvider {
    public BorealBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheBoreal.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BorealBlocks.BOREAL_COBBLESTONE);
        blockWithItem(BorealBlocks.BOREAL_STONE);
        blockWithItem(BorealBlocks.BOREAL_DEEP_STONE);
        blockWithItem(BorealBlocks.BOREAL_STONE_BRICKS);
        blockWithItem(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS);
        blockWithItem(BorealBlocks.BOREAL_CHISELED_STONE);
        blockWithItem(BorealBlocks.VERNITE);
        blockWithItem(BorealBlocks.POLISHED_VERNITE);
        blockWithItem(BorealBlocks.TARNITE);
        blockWithItem(BorealBlocks.POLISHED_TARNITE);
        blockWithItem(BorealBlocks.TALISMANDIUM_ORE);
        blockWithItem(BorealBlocks.DEEP_TALISMANDIUM_ORE);
        blockWithItem(BorealBlocks.CHRODIUM_ORE);
        blockWithItem(BorealBlocks.DEEP_CHRODIUM_ORE);
        blockWithItem(BorealBlocks.DIORIUM_ORE);
        blockWithItem(BorealBlocks.DEEP_DIORIUM_ORE);
        blockWithItem(BorealBlocks.AURORA_PLANKS);
        blockWithItem(BorealBlocks.GLACIAL_DIRT);
        blockWithItem(BorealBlocks.PERMAFROST);
        blockWithItem(BorealBlocks.GLACIAL_CRYSTAL);

        stairsBlock(((StairBlock)BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get()), blockTexture(BorealBlocks.BOREAL_COBBLESTONE.get()));
        slabBlock(((SlabBlock) BorealBlocks.BOREAL_COBBLESTONE_SLAB.get()), blockTexture(BorealBlocks.BOREAL_COBBLESTONE.get()), blockTexture(BorealBlocks.BOREAL_COBBLESTONE.get()));
        wallBlock(((WallBlock) BorealBlocks.BOREAL_COBBLESTONE_WALL.get()), blockTexture(BorealBlocks.BOREAL_COBBLESTONE.get()));
        stairsBlock(((StairBlock)BorealBlocks.BOREAL_STONE_STAIRS.get()), blockTexture(BorealBlocks.BOREAL_STONE.get()));
        slabBlock(((SlabBlock) BorealBlocks.BOREAL_STONE_SLAB.get()), blockTexture(BorealBlocks.BOREAL_STONE.get()), blockTexture(BorealBlocks.BOREAL_STONE.get()));
        stairsBlock(((StairBlock)BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get()), blockTexture(BorealBlocks.BOREAL_DEEP_STONE.get()));
        slabBlock(((SlabBlock)BorealBlocks.BOREAL_DEEP_STONE_SLAB.get()), blockTexture(BorealBlocks.BOREAL_DEEP_STONE.get()), blockTexture(BorealBlocks.BOREAL_DEEP_STONE.get()));
        wallBlock(((WallBlock) BorealBlocks.BOREAL_DEEP_STONE_WALL.get()), blockTexture(BorealBlocks.BOREAL_DEEP_STONE.get()));
        stairsBlock(((StairBlock)BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get()), blockTexture(BorealBlocks.BOREAL_STONE_BRICKS.get()));
        slabBlock(((SlabBlock)BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get()), blockTexture(BorealBlocks.BOREAL_STONE_BRICKS.get()), blockTexture(BorealBlocks.BOREAL_STONE_BRICKS.get()));
        wallBlock(((WallBlock) BorealBlocks.BOREAL_STONE_BRICK_WALL.get()), blockTexture(BorealBlocks.BOREAL_STONE_BRICKS.get()));
        stairsBlock(((StairBlock)BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get()), blockTexture(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get()));
        slabBlock(((SlabBlock)BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get()), blockTexture(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get()), blockTexture(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get()));
        wallBlock(((WallBlock) BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get()), blockTexture(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get()));
        stairsBlock(((StairBlock)BorealBlocks.AURORAL_STAIRS.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()));
        slabBlock(((SlabBlock)BorealBlocks.AURORAL_SLAB.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()));
        stairsBlock(((StairBlock)BorealBlocks.VERNITE_STAIRS.get()), blockTexture(BorealBlocks.VERNITE.get()));
        slabBlock(((SlabBlock)BorealBlocks.VERNITE_SLAB.get()), blockTexture(BorealBlocks.VERNITE.get()), blockTexture(BorealBlocks.VERNITE.get()));
        wallBlock(((WallBlock) BorealBlocks.VERNITE_WALL.get()), blockTexture(BorealBlocks.VERNITE.get()));
        stairsBlock(((StairBlock)BorealBlocks.POLISHED_VERNITE_STAIRS.get()), blockTexture(BorealBlocks.POLISHED_VERNITE.get()));
        slabBlock(((SlabBlock)BorealBlocks.POLISHED_VERNITE_SLAB.get()), blockTexture(BorealBlocks.POLISHED_VERNITE.get()), blockTexture(BorealBlocks.POLISHED_VERNITE.get()));
        stairsBlock(((StairBlock)BorealBlocks.TARNITE_STAIRS.get()), blockTexture(BorealBlocks.TARNITE.get()));
        slabBlock(((SlabBlock)BorealBlocks.TARNITE_SLAB.get()), blockTexture(BorealBlocks.TARNITE.get()), blockTexture(BorealBlocks.TARNITE.get()));
        wallBlock(((WallBlock) BorealBlocks.TARNITE_WALL.get()), blockTexture(BorealBlocks.TARNITE.get()));
        stairsBlock(((StairBlock)BorealBlocks.POLISHED_TARNITE_STAIRS.get()), blockTexture(BorealBlocks.POLISHED_TARNITE.get()));
        slabBlock(((SlabBlock)BorealBlocks.POLISHED_TARNITE_SLAB.get()), blockTexture(BorealBlocks.POLISHED_TARNITE.get()), blockTexture(BorealBlocks.POLISHED_TARNITE.get()));

        buttonBlock(((ButtonBlock)BorealBlocks.AURORAL_BUTTON.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock)BorealBlocks.AURORAL_PRESSURE_PLATE.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()));

        fenceBlock(((FenceBlock)BorealBlocks.AURORAL_FENCE.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) BorealBlocks.AURORAL_FENCE_GATE.get()), blockTexture(BorealBlocks.AURORA_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock)BorealBlocks.AURORAL_DOOR.get()), modLoc("block/auroral_door_bottom"), modLoc("block/auroral_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) BorealBlocks.AURORAL_TRAPDOOR.get()), modLoc("block/auroral_trapdoor"), true, "cutout");

        logBlock(((RotatedPillarBlock) BorealBlocks.AURORA_LOG.get()));
        axisBlock(((RotatedPillarBlock) BorealBlocks.AURORA_WOOD.get()), blockTexture(BorealBlocks.AURORA_LOG.get()), blockTexture(BorealBlocks.AURORA_LOG.get()));

        axisBlock(((RotatedPillarBlock) BorealBlocks.STRIPPED_AURORA_LOG.get()), blockTexture(BorealBlocks.STRIPPED_AURORA_LOG.get()), new ResourceLocation(TheBoreal.MOD_ID, "block/stripped_auroral_log_top"));
        axisBlock(((RotatedPillarBlock) BorealBlocks.STRIPPED_AURORA_WOOD.get()), blockTexture(BorealBlocks.STRIPPED_AURORA_LOG.get()), blockTexture(BorealBlocks.STRIPPED_AURORA_LOG.get()));

        blockItem(BorealBlocks.AURORA_LOG);
        blockItem(BorealBlocks.AURORA_WOOD);
        blockItem(BorealBlocks.STRIPPED_AURORA_LOG);
        blockItem(BorealBlocks.STRIPPED_AURORA_WOOD);

        leavesBlock(BorealBlocks.AURORA_LEAVES);
        doublePlant(BorealBlocks.GLACIAL_TALL_GRASS.get());
        simpleCrossBlock(BorealBlocks.BOREALIGHT_SHROOM.get());
        simpleCrossBlock(BorealBlocks.GLACIALIGHT_SHROOM.get());

        paneBlock(
                (IronBarsBlock) BorealBlocks.TALISMANDIUM_BARS.get(),
                modLoc("block/talismandium_bars"),
                modLoc("block/talismandium_bars")
        );

        simpleBlock(BorealBlocks.BOREAL_ESSENCE_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/boreal_essence_table")));

        simpleBlock(BorealBlocks.BOREAL_INFUSER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/boreal_infuser")));

        simpleBlock(BorealBlocks.BOREAL_ALTAR.get(),
                models().cube("boreal_altar",
                        modLoc("block/boreal_chiseled_stone"),
                        modLoc("block/boreal_altar_top"),
                        modLoc("block/boreal_chiseled_stone"),
                        modLoc("block/boreal_chiseled_stone"),
                        modLoc("block/boreal_chiseled_stone"),
                        modLoc("block/boreal_chiseled_stone")
                ).texture("particle", modLoc("block/boreal_chiseled_stone"))
        );

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void torchBlock(TorchBlock torch, WallTorchBlock wallTorch) {
        String name = ForgeRegistries.BLOCKS.getKey(torch).getPath();

        simpleBlock(torch,
                models().torch(name, modLoc("block/" + name)));

        horizontalBlock(wallTorch,
                models().torchWall(name + "_wall", modLoc("block/" + name)),
                90);
    }

    private void doublePlant(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ModelFile bottom = models().cross(name + "_bottom", modLoc("block/" + name + "_bottom"));
        ModelFile top = models().cross(name + "_top", modLoc("block/" + name + "_top"));

        getVariantBuilder(block)
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)
                .setModels(new ConfiguredModel(bottom))
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)
                .setModels(new ConfiguredModel(top));
    }
}

package net.elaguilamc623.the_boreal.datagen.tags;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;
import static net.elaguilamc623.the_boreal.registries.BorealTags.*;

public class BorealBlockTagGeneration extends BlockTagsProvider {
    public BorealBlockTagGeneration(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheBoreal.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BorealBlocks.BOREAL_STONE.get(),
                        BorealBlocks.BOREAL_COBBLESTONE.get(),
                        BorealBlocks.BOREAL_COBBLESTONE_SLAB.get(),
                        BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get(),
                        BorealBlocks.BOREAL_COBBLESTONE_WALL.get(),
                        BorealBlocks.BOREAL_STONE_SLAB.get(),
                        BorealBlocks.BOREAL_STONE_STAIRS.get(),
                        BorealBlocks.BOREAL_DEEP_STONE.get(),
                        BorealBlocks.BOREAL_DEEP_STONE_SLAB.get(),
                        BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get(),
                        BorealBlocks.BOREAL_DEEP_STONE_WALL.get(),
                        BorealBlocks.BOREAL_STONE_BRICKS.get(),
                        BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get(),
                        BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get(),
                        BorealBlocks.BOREAL_STONE_BRICK_WALL.get(),
                        BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get(),
                        BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get(),
                        BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get(),
                        BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get(),
                        BorealBlocks.BOREAL_CHISELED_STONE.get(),
                        BorealBlocks.TALISMANDIUM_ORE.get(),
                        BorealBlocks.DEEP_TALISMANDIUM_ORE.get(),
                        BorealBlocks.CHRODIUM_ORE.get(),
                        BorealBlocks.DEEP_CHRODIUM_ORE.get(),
                        BorealBlocks.DIORIUM_ORE.get(),
                        BorealBlocks.DEEP_DIORIUM_ORE.get(),
                        BorealBlocks.VERNITE.get(),
                        BorealBlocks.VERNITE_SLAB.get(),
                        BorealBlocks.VERNITE_STAIRS.get(),
                        BorealBlocks.VERNITE_WALL.get(),
                        BorealBlocks.POLISHED_VERNITE.get(),
                        BorealBlocks.POLISHED_VERNITE_SLAB.get(),
                        BorealBlocks.POLISHED_VERNITE_STAIRS.get(),
                        BorealBlocks.TARNITE.get(),
                        BorealBlocks.TARNITE_SLAB.get(),
                        BorealBlocks.TARNITE_STAIRS.get(),
                        BorealBlocks.TARNITE_WALL.get(),
                        BorealBlocks.POLISHED_TARNITE.get(),
                        BorealBlocks.POLISHED_TARNITE_SLAB.get(),
                        BorealBlocks.POLISHED_TARNITE_STAIRS.get(),
                        BorealBlocks.PERMAFROST.get(),
                        BorealBlocks.GLACIAL_CRYSTAL.get(),
                        BorealBlocks.BOREAL_ESSENCE_TABLE.get(),
                        BorealBlocks.BOREAL_INFUSER.get(),
                        BorealBlocks.TALISMANDIUM_BARS.get()
                        );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BorealBlocks.GLACIAL_GRASS_BLOCK.get(),
                        BorealBlocks.GLACIAL_DIRT.get(),
                        BorealBlocks.GLACIAL_FARMLAND.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BorealBlocks.AURORA_LOG.get(),
                        BorealBlocks.AURORA_WOOD.get(),
                        BorealBlocks.STRIPPED_AURORA_LOG.get(),
                        BorealBlocks.STRIPPED_AURORA_WOOD.get(),
                        BorealBlocks.AURORA_PLANKS.get(),
                        BorealBlocks.AURORAL_STAIRS.get(),
                        BorealBlocks.AURORAL_SLAB.get(),
                        BorealBlocks.AURORAL_FENCE.get(),
                        BorealBlocks.AURORAL_FENCE_GATE.get(),
                        BorealBlocks.AURORAL_BUTTON.get(),
                        BorealBlocks.AURORAL_PRESSURE_PLATE.get(),
                        BorealBlocks.AURORAL_DOOR.get(),
                        BorealBlocks.AURORAL_TRAPDOOR.get(),
                        BorealBlocks.AURORAL_SIGN.get(),
                        BorealBlocks.AURORAL_WALL_SIGN.get(),
                        BorealBlocks.AURORAL_HANGING_SIGN.get(),
                        BorealBlocks.AURORAL_WALL_HANGING_SIGN.get()
                );


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BorealBlocks.TALISMANDIUM_ORE.get(),
                        BorealBlocks.DEEP_TALISMANDIUM_ORE.get()
                );

        this.tag(BorealTags.NEEDS_TALISMANDIUM_TOOL)
                .add(BorealBlocks.CHRODIUM_ORE.get(),
                        BorealBlocks.DEEP_CHRODIUM_ORE.get()
                );

        this.tag(BorealTags.NEEDS_CHRODIUM_TOOL)
                .add(BorealBlocks.DIORIUM_ORE.get(),
                        BorealBlocks.DEEP_DIORIUM_ORE.get()
                );

        this.tag(BlockTags.WALLS)
                .add(BorealBlocks.BOREAL_COBBLESTONE_WALL.get(),
                        BorealBlocks.BOREAL_DEEP_STONE_WALL.get(),
                        BorealBlocks.BOREAL_STONE_BRICK_WALL.get(),
                        BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get(),
                        BorealBlocks.VERNITE_WALL.get(),
                        BorealBlocks.TARNITE_WALL.get(),
                        BorealBlocks.TALISMANDIUM_BARS.get()
                        );


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BorealBlocks.AURORA_LOG.get(),
                        BorealBlocks.AURORA_WOOD.get(),
                        BorealBlocks.STRIPPED_AURORA_LOG.get(),
                        BorealBlocks.STRIPPED_AURORA_WOOD.get()
                        );

        this.tag(BlockTags.PLANKS)
                .add(BorealBlocks.AURORA_PLANKS.get());

        this.tag(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON)
                .add(BorealBlocks.GLACIAL_GRASS_BLOCK.get());

        this.tag(TREE_REPLACEABLE)
                .add(Blocks.SNOW)
                .add(BorealBlocks.GLACIAL_GRASS_BLOCK.get())
                .add(BorealBlocks.GLACIAL_DIRT.get())
                .add(BorealBlocks.GLACIAL_GRASS.get());
        this.tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(Blocks.SNOW)
                .add(BorealBlocks.GLACIAL_GRASS.get());

        this.tag(BlockTags.FENCES)
                .add(BorealBlocks.AURORAL_FENCE.get());
        this.tag(BlockTags.WOODEN_FENCES)
                .add(BorealBlocks.AURORAL_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(BorealBlocks.AURORAL_FENCE_GATE.get());

        this.tag(BlockTags.STONE_ORE_REPLACEABLES)
                .add(BorealBlocks.BOREAL_STONE.get(),
                        BorealBlocks.BOREAL_DEEP_STONE.get()
                        );

        this.tag(BorealTags.MOBS_SPAWNABLE_ON)
                .add(BorealBlocks.GLACIAL_GRASS_BLOCK.get(),
                        BorealBlocks.GLACIAL_DIRT.get(),
                        BorealBlocks.GLACIAL_GRASS.get(),
                        Blocks.SNOW
                );

    }
}

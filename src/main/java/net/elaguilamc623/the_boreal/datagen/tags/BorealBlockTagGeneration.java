package net.elaguilamc623.the_boreal.datagen.tags;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

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
                        BorealBlocks.BOREAL_CHISELED_STONE.get()
                        );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BorealBlocks.GLACIAL_GRASS_BLOCK.get(),
                        BorealBlocks.GLACIAL_DIRT.get()
                );

    }
}

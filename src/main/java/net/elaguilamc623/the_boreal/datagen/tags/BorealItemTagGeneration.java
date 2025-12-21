package net.elaguilamc623.the_boreal.datagen.tags;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class BorealItemTagGeneration extends ItemTagsProvider {
    public BorealItemTagGeneration(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_) {
        super(p_275343_, p_275729_, p_275322_);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(BorealBlocks.AURORA_LOG.get().asItem())
                .add(BorealBlocks.AURORA_WOOD.get().asItem())
                .add(BorealBlocks.STRIPPED_AURORA_LOG.get().asItem())
                .add(BorealBlocks.STRIPPED_AURORA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(BorealBlocks.AURORA_PLANKS.get().asItem());

    }
}

package net.elaguilamc623.the_boreal.datagen.tags;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import java.util.concurrent.CompletableFuture;
import static net.elaguilamc623.the_boreal.registries.BorealTags.BOREAL_STICKS;

public class BorealItemTagGeneration extends ItemTagsProvider {
    public BorealItemTagGeneration(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagLookup<Block>> pFuture) {
        super(pOutput, pProvider, pFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(BorealBlocks.AURORA_LOG.get().asItem())
                .add(BorealBlocks.AURORA_WOOD.get().asItem())
                .add(BorealBlocks.STRIPPED_AURORA_LOG.get().asItem())
                .add(BorealBlocks.STRIPPED_AURORA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(BorealBlocks.AURORA_PLANKS.get().asItem());

        tag(BorealTags.STICKS)
                .replace(false)
                .add(BorealItems.AURORAL_STICK.get());

        tag(BOREAL_STICKS)
                .add(BorealItems.AURORAL_STICK.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(BorealItems.TALISMANDIUM_HELMET.get(),
                        BorealItems.TALISMANDIUM_CHESTPLATE.get(),
                        BorealItems.TALISMANDIUM_LEGGINGS.get(),
                        BorealItems.TALISMANDIUM_BOOTS.get(),
                        BorealItems.CHRODIUM_HELMET.get(),
                        BorealItems.CHRODIUM_CHESTPLATE.get(),
                        BorealItems.CHRODIUM_LEGGINGS.get(),
                        BorealItems.CHRODIUM_BOOTS.get(),
                        BorealItems.DIORIUM_HELMET.get(),
                        BorealItems.DIORIUM_CHESTPLATE.get(),
                        BorealItems.DIORIUM_LEGGINGS.get(),
                        BorealItems.DIORIUM_BOOTS.get()
                );


    }
}

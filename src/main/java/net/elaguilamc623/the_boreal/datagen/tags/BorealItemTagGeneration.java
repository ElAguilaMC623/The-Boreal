package net.elaguilamc623.the_boreal.datagen.tags;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
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
                .add(BorealItems.TALISMANDIUM_ARMOR.getHelmet().get(),
                        BorealItems.TALISMANDIUM_ARMOR.getChestplate().get(),
                        BorealItems.TALISMANDIUM_ARMOR.getLeggings().get(),
                        BorealItems.TALISMANDIUM_ARMOR.getBoots().get(),
                        BorealItems.CHRODIUM_ARMOR.getHelmet().get(),
                        BorealItems.CHRODIUM_ARMOR.getChestplate().get(),
                        BorealItems.CHRODIUM_ARMOR.getLeggings().get(),
                        BorealItems.CHRODIUM_ARMOR.getBoots().get(),
                        BorealItems.DIORIUM_HELMET.get(),
                        BorealItems.DIORIUM_CHESTPLATE.get(),
                        BorealItems.DIORIUM_LEGGINGS.get(),
                        BorealItems.DIORIUM_BOOTS.get()
                );

        this.tag(BorealTags.BOREAL_WEAPONS)
                .add(BorealItems.TALISMANDIUM_TOOLS.getSword().get(),
                        BorealItems.TALISMANDIUM_TOOLS.getAxe().get(),
                        BorealItems.TALISMANDIUM_TOOLS.getPickaxe().get(),
                        BorealItems.TALISMANDIUM_TOOLS.getShovel().get(),
                        BorealItems.TALISMANDIUM_TOOLS.getHoe().get(),
                        BorealItems.CHRODIUM_TOOLS.getSword().get(),
                        BorealItems.CHRODIUM_TOOLS.getAxe().get(),
                        BorealItems.CHRODIUM_TOOLS.getPickaxe().get(),
                        BorealItems.CHRODIUM_TOOLS.getShovel().get(),
                        BorealItems.CHRODIUM_TOOLS.getHoe().get(),
                        BorealItems.DIORIUM_SWORD.get(),
                        BorealItems.DIORIUM_PICKAXE.get(),
                        BorealItems.DIORIUM_AXE.get(),
                        BorealItems.DIORIUM_SHOVEL.get(),
                        BorealItems.DIORIUM_HOE.get()
                );

        this.tag(BorealTags.CRYSTALIZED_FOX_FOOD)
                .add(BorealItems.GLACIAL_BERRIES.get()
                );
    }
}

package net.elaguilamc623.the_boreal.utils;

import com.google.common.collect.ImmutableMap;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import java.util.Map;

public class BorealConversions {
    public static final Map<Item, Item> BOREAL_TO_VANILLA =
            ImmutableMap.<Item, Item>builder()
                    .put(BorealBlocks.GLACIAL_GRASS_BLOCK.get().asItem(), Items.GRASS_BLOCK)
                    .put(BorealBlocks.GLACIAL_DIRT.get().asItem(), Items.DIRT)
                    .put(BorealBlocks.GLACIAL_GRASS.get().asItem(), Items.GRASS)
                    .put(BorealBlocks.GLACIAL_TALL_GRASS.get().asItem(), Items.TALL_GRASS)
                    .put(BorealBlocks.BOREAL_STONE.get().asItem(), Items.STONE)
                    .put(BorealBlocks.BOREAL_STONE_BRICKS.get().asItem(), Items.STONE_BRICKS)
                    .put(BorealBlocks.AURORA_LOG.get().asItem(), Items.OAK_LOG)
                    .put(BorealBlocks.STRIPPED_AURORA_LOG.get().asItem(), Items.STRIPPED_OAK_LOG)
                    .put(BorealBlocks.AURORA_WOOD.get().asItem(), Items.OAK_WOOD)
                    .put(BorealBlocks.STRIPPED_AURORA_WOOD.get().asItem(), Items.STRIPPED_OAK_WOOD)
                    .put(BorealItems.GLACIAL_ROTTEN_FLESH.get(), Items.ROTTEN_FLESH)
                    .put(BorealItems.GLACIAL_BONE.get(), Items.BONE)
                    .build();
}
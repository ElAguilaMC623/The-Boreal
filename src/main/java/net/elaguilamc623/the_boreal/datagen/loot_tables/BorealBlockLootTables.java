package net.elaguilamc623.the_boreal.datagen.loot_tables;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import java.util.Set;

public class BorealBlockLootTables extends BlockLootSubProvider {
    public BorealBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BorealBlocks.BOREAL_COBBLESTONE.get());
        this.dropSelf(BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get());
        this.dropSelf(BorealBlocks.BOREAL_COBBLESTONE_WALL.get());
        this.dropSelf(BorealBlocks.BOREAL_STONE_STAIRS.get());
        this.dropSelf(BorealBlocks.BOREAL_DEEP_STONE.get());
        this.dropSelf(BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get());
        this.dropSelf(BorealBlocks.BOREAL_DEEP_STONE_WALL.get());
        this.dropSelf(BorealBlocks.BOREAL_STONE_BRICKS.get());
        this.dropSelf(BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get());
        this.dropSelf(BorealBlocks.BOREAL_STONE_BRICK_WALL.get());
        this.dropSelf(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get());
        this.dropSelf(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get());
        this.dropSelf(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get());
        this.dropSelf(BorealBlocks.BOREAL_CHISELED_STONE.get());
        this.dropSelf(BorealBlocks.GLACIAL_DIRT.get());
        this.dropSelf(BorealBlocks.AURORA_LOG.get());
        this.dropSelf(BorealBlocks.AURORA_WOOD.get());
        this.dropSelf(BorealBlocks.STRIPPED_AURORA_LOG.get());
        this.dropSelf(BorealBlocks.STRIPPED_AURORA_WOOD.get());
        this.dropSelf(BorealBlocks.AURORA_PLANKS.get());
        this.dropSelf(BorealBlocks.AURORAL_STAIRS.get());
        this.dropSelf(BorealBlocks.AURORAL_SLAB.get());
        this.dropSelf(BorealBlocks.AURORAL_FENCE.get());
        this.dropSelf(BorealBlocks.AURORAL_FENCE_GATE.get());
        this.dropSelf(BorealBlocks.AURORAL_TRAPDOOR.get());
        this.dropSelf(BorealBlocks.AURORA_SAPLING.get());
        this.dropSelf(BorealBlocks.AURORAL_BUTTON.get());
        this.dropSelf(BorealBlocks.AURORAL_PRESSURE_PLATE.get());


        this.add(BorealBlocks.BOREAL_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(block));

        this.add(BorealBlocks.BOREAL_STONE_SLAB.get(),
                block -> createSlabItemTable(block));

        this.add(BorealBlocks.BOREAL_DEEP_STONE_SLAB.get(),
                block -> createSlabItemTable(block));

        this.add(BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get(),
                block -> createSlabItemTable(block));

        this.add(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(block));

        this.add(BorealBlocks.AURORA_LEAVES.get(),
                block -> createLeavesDrops(block,
                        BorealBlocks.AURORA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(BorealBlocks.BOREAL_STONE.get(),
                block -> createSilkTouchDispatchTable(block,
                        LootItem.lootTableItem(BorealBlocks.BOREAL_COBBLESTONE.get())));

        this.add(BorealBlocks.GLACIAL_GRASS.get(), block ->
                createSingleItemTableWithSilkTouch(block,
                        BorealItems.GLACIAL_SEED.get()));

        this.add(BorealBlocks.GLACIAL_FARMLAND.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(BorealBlocks.GLACIAL_DIRT.get()))
                        )
        );

        this.add(BorealBlocks.GLACIAL_GRASS_BLOCK.get(),
                block -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(BorealBlocks.GLACIAL_DIRT.get()))
                        )
        );

        this.add(BorealBlocks.GLACIAL_WHEAT_PLANT.get(), block ->
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(BorealItems.GLACIAL_SEED.get()))
                        )
        );

        this.add(BorealBlocks.AURORAL_SIGN.get(),
                block -> createSingleItemTable(BorealItems.AURORAL_SIGN.get()));
        this.add(BorealBlocks.AURORAL_WALL_SIGN.get(),
                block -> createSingleItemTable(BorealItems.AURORAL_SIGN.get()));

        this.add(BorealBlocks.AURORAL_HANGING_SIGN.get(),
                block -> createSingleItemTable(BorealItems.AURORAL_HANGING_SIGN.get()));
        this.add(BorealBlocks.AURORAL_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(BorealItems.AURORAL_HANGING_SIGN.get()));

        this.add(BorealBlocks.AURORAL_DOOR.get(),
                block -> createDoorTable(BorealBlocks.AURORAL_DOOR.get()));

        this.add(BorealBlocks.TALISMANDIUM_ORE.get(),
                block -> createOreDrop(block, BorealItems.RAW_TALISMANDIUM.get()));

        this.add(BorealBlocks.DEEP_TALISMANDIUM_ORE.get(),
                block -> createOreDrop(block, BorealItems.RAW_TALISMANDIUM.get()));

        this.add(BorealBlocks.CHRODIUM_ORE.get(),
                block -> createOreDrop(block, BorealItems.CHRODIUM.get()));

        this.add(BorealBlocks.DEEP_CHRODIUM_ORE.get(),
                block -> createOreDrop(block, BorealItems.CHRODIUM.get()));

        this.add(BorealBlocks.DIORIUM_ORE.get(),
                block -> createOreDrop(block, BorealItems.RAW_DIORIUM.get()));

        this.add(BorealBlocks.DEEP_DIORIUM_ORE.get(),
                block -> createOreDrop(block, BorealItems.RAW_DIORIUM.get()));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BorealBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .toList();
    }
}

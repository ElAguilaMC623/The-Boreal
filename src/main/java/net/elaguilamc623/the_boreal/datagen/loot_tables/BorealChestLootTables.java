package net.elaguilamc623.the_boreal.datagen.loot_tables;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import java.util.function.BiConsumer;

public class BorealChestLootTables implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pConsumer) {
        pConsumer.accept(
                new ResourceLocation(TheBoreal.MOD_ID, "chests/glacial_tower"),
                createGlacialTowerLoot()
        );
    }

    private LootTable.Builder createGlacialTowerLoot() {
        LootTable.Builder table = LootTable.lootTable();

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.DIORIUM_GEM.get())
                        .when(LootItemRandomChanceCondition.randomChance(0.5f))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.GLACIAL_ROTTEN_FLESH.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.GLACIAL_BONE.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.AURORAL_STICK.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.BUCKET)
                        .when(LootItemRandomChanceCondition.randomChance(0.5f))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.TALISMANDIUM_INGOT.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.CHRODIUM.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.LEAD)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.AMETHYST_SHARD)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.STRING)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.GLACIAL_BREAD.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.GLACIAL_WHEAT.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)))));

        table.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(BorealItems.GLACIAL_SEED.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))));

        return table;
    }
}

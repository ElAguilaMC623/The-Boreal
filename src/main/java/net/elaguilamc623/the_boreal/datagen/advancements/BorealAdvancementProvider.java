package net.elaguilamc623.the_boreal.datagen.advancements;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BorealAdvancementProvider extends ForgeAdvancementProvider {

    public BorealAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper) {
        super(output, registries, fileHelper, List.of(new BorealAdvancementGenerator()));
    }

    private static class BorealAdvancementGenerator implements AdvancementGenerator {

        @SuppressWarnings("removal")
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {

            Advancement root = Advancement.Builder.advancement()
                    .display(
                            BorealItems.FROZEN_AMULET.get(),
                            Component.translatable("The Boreal"),
                            Component.translatable("A Boreal world to explore"),
                            new ResourceLocation("the_boreal:textures/gui/advancements/boreal_background.png"),
                            FrameType.TASK,
                            false,
                            false,
                            false
                    )

                    .addCriterion("tick", InventoryChangeTrigger.TriggerInstance.hasItems(BorealItems.ANCIENT_ICE_FRAGMENT.get()))
                    .save(consumer, "the_boreal:root");

            Advancement ancientIceFragment = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            BorealItems.ANCIENT_ICE_FRAGMENT.get(),
                            Component.literal("Ice From Ancient Times"),
                            Component.translatable("Obtain an Ancient Ice Fragment to craft the Frozen Amulet"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_fragment",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    BorealItems.ANCIENT_ICE_FRAGMENT.get()
                            )
                    )
                    .save(consumer, "the_boreal:ancient_ice_fragment");

            Advancement borealWorld = Advancement.Builder.advancement()
                    .parent(ancientIceFragment)
                    .display(
                            BorealBlocks.GLACIAL_GRASS_BLOCK.get(),
                            Component.literal("A Boreal World"),
                            Component.literal("Enter the Boreal dimension"),
                            null,
                            FrameType.GOAL,
                            true,
                            true,
                            false
                    )
                    .addCriterion("enter_boreal", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(
                            ResourceKey.create(Registries.DIMENSION, new ResourceLocation(TheBoreal.MOD_ID, "boreal"))
                    ))
                    .save(consumer, new ResourceLocation(TheBoreal.MOD_ID, "a_boreal_world"), fileHelper);

            Advancement auroralForest = Advancement.Builder.advancement()
                    .parent(borealWorld)
                    .display(
                            BorealBlocks.AURORA_SAPLING.get(),
                            Component.literal("The Auroral"),
                            Component.literal("Find an Auroral Forest or a Snowy Auroral Forest biome"),
                            null,
                            FrameType.GOAL,
                            true,
                            true,
                            false
                    )

                    .addCriterion("enter_auroral_forest", PlayerTrigger.TriggerInstance.located(
                            LocationPredicate.Builder.location()
                                    .setBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "auroral_forest")))
                                    .build()
                    ))

                    .addCriterion("enter_snowy_auroral_forest", PlayerTrigger.TriggerInstance.located(
                            LocationPredicate.Builder.location()
                                    .setBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "snowy_auroral_forest")))
                                    .build()
                    ))

                    .requirements(RequirementsStrategy.OR)
                    .save(consumer, new ResourceLocation(TheBoreal.MOD_ID, "auroral_forest"), fileHelper);

            Advancement crystalPeaks = Advancement.Builder.advancement()
                    .parent(borealWorld)
                    .display(
                            BorealItems.GLACIAL_CRYSTAL_SHARD.get(),
                            Component.translatable("Crystal Spikes"),
                            Component.translatable("Find a Glacial Desert biome"),
                            null,
                            FrameType.GOAL,
                            true,
                            true,
                            false
                    )
                    .addCriterion("enter_glacial_desert", PlayerTrigger.TriggerInstance.located(
                            LocationPredicate.Builder.location()
                                    .setBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation(TheBoreal.MOD_ID, "glacial_desert")))
                                    .build()
                    ))
                    .save(consumer, new ResourceLocation(TheBoreal.MOD_ID, "crystal_peaks"), fileHelper);

            Advancement theEssenceExtractor = Advancement.Builder.advancement()
                    .parent(borealWorld)
                    .display(
                            BorealBlocks.BOREAL_ESSENCE_TABLE.get(),
                            Component.literal("The Essence Extractor"),
                            Component.translatable("Craft the Boreal Essence Table to extract Boreal Essences"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_extractor",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    BorealBlocks.BOREAL_ESSENCE_TABLE.get()
                            )
                    )
                    .save(consumer, "the_boreal:the_essence_extractor");

            Advancement mysteriousEssence = Advancement.Builder.advancement()
                    .parent(theEssenceExtractor)
                    .display(
                            BorealItems.BOREAL_ESSENCE.get(),
                            Component.literal("A Mysterious Essence"),
                            Component.translatable("Obtain a Boreal Essence from the Boreal Essence Table"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_essence",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    BorealItems.BOREAL_ESSENCE.get()
                            )
                    )
                    .save(consumer, "the_boreal:a_mysterious_essence");

            Advancement borealEnchantments = Advancement.Builder.advancement()
                    .parent(mysteriousEssence)
                    .display(
                            BorealBlocks.BOREAL_INFUSER.get(),
                            Component.literal("Boreal Enchantments"),
                            Component.translatable("Obtain a Boreal Infuser to enchant your weapons with new enchantments"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_infuser",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    BorealBlocks.BOREAL_INFUSER.get()
                            )
                    )
                    .save(consumer, "the_boreal:boreal_enchantments");

            Advancement anAncientPrison = Advancement.Builder.advancement()
                    .parent(mysteriousEssence)
                    .display(
                            BorealItems.PRISON_LOCATOR.get(),
                            Component.literal("An Ancient Prison"),
                            Component.translatable("Obtain a Prison Locator to be able to find the Boreal Prison dungeon"),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("get_locator",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    BorealItems.PRISON_LOCATOR.get()
                            )
                    )
                    .save(consumer, "the_boreal:an_ancient_prison");
        }
    }
}

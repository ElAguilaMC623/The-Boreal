package net.elaguilamc623.the_boreal.datagen;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.datagen.loot_tables.BorealLootTableProvider;
import net.elaguilamc623.the_boreal.datagen.models.BorealBlockStateProvider;
import net.elaguilamc623.the_boreal.datagen.models.BorealItemModelProvider;
import net.elaguilamc623.the_boreal.datagen.tags.BorealBlockTagGeneration;
import net.elaguilamc623.the_boreal.datagen.tags.BorealItemTagGeneration;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TheBoreal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BorealRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), BorealLootTableProvider.create(packOutput));

        BorealBlockTagGeneration blockTagGenerator = generator.addProvider(event.includeServer(),
                new BorealBlockTagGeneration(packOutput, lookupProvider, TheBoreal.MOD_ID, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new BorealItemTagGeneration(packOutput, lookupProvider, blockTagGenerator.contentsGetter()));

        generator.addProvider(event.includeClient(),
                new BorealBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(),
                new BorealItemModelProvider(packOutput, existingFileHelper));

        RegistrySetBuilder builder = new RegistrySetBuilder();
    }
}


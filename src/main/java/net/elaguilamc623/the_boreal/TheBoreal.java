package net.elaguilamc623.the_boreal;

import com.mojang.logging.LogUtils;
import net.elaguilamc623.the_boreal.registries.*;
import net.elaguilamc623.the_boreal.registries.worldgen.level.BorealFeatures;
import net.elaguilamc623.the_boreal.registries.worldgen.level.BorealFoliagePlacers;
import net.elaguilamc623.the_boreal.registries.worldgen.structures.BorealStructureGeneration;
import net.elaguilamc623.the_boreal.registries.worldgen.structures.BorealStructurePlacements;
import net.elaguilamc623.the_boreal.utils.BorealWoodTypes;
import net.elaguilamc623.the_boreal.worldgen.level.BorealConfiguredFeatures;
import net.elaguilamc623.the_boreal.worldgen.level.BorealPlacedFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TheBoreal.MOD_ID)
public class TheBoreal
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "the_boreal";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TheBoreal(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        BorealItems.register(modEventBus);
        BorealCreativeTabs.register(modEventBus);
        BorealBlocks.register(modEventBus);
        BorealEntities.ENTITY_TYPES.register(modEventBus);
        BorealBlockEntities.register(modEventBus);
        BorealStructurePlacements.register(modEventBus);
        BorealStructureGeneration.register(modEventBus);
        BorealFoliagePlacers.FOLIAGE_PLACERS.register(modEventBus);
        BorealFeatures.FEATURES.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::AddCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == BorealCreativeTabs.BOREAL_ITEMS_TAB.get()) {
            event.accept(BorealItems.ANCIENT_ICE_FRAGMENT.get());
            event.accept(BorealItems.FROZEN_AMULET.get());
            event.accept(BorealItems.BOREAL_ROCK.get());
            event.accept(BorealItems.GLACIAL_SEED.get());
            event.accept(BorealItems.GLACIAL_WHEAT.get());
            event.accept(BorealItems.GLACIAL_BREAD.get());
            // event.accept(BorealBlocks.AURORA_SAPLING.get());
        }

        if(event.getTab() == BorealCreativeTabs.BOREAL_BLOCKS_TAB.get()) {
            event.accept(BorealBlocks.BOREAL_COBBLESTONE.get());
            event.accept(BorealBlocks.BOREAL_COBBLESTONE_SLAB.get());
            event.accept(BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get());
            event.accept(BorealBlocks.BOREAL_COBBLESTONE_WALL.get());
            event.accept(BorealBlocks.BOREAL_STONE.get());
            event.accept(BorealBlocks.BOREAL_STONE_SLAB.get());
            event.accept(BorealBlocks.BOREAL_STONE_STAIRS.get());
            event.accept(BorealBlocks.BOREAL_DEEP_STONE.get());
            event.accept(BorealBlocks.BOREAL_DEEP_STONE_SLAB.get());
            event.accept(BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get());
            event.accept(BorealBlocks.BOREAL_DEEP_STONE_WALL.get());
            event.accept(BorealBlocks.BOREAL_STONE_BRICKS.get());
            event.accept(BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get());
            event.accept(BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get());
            event.accept(BorealBlocks.BOREAL_STONE_BRICK_WALL.get());
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get());
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get());
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get());
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get());
            event.accept(BorealBlocks.BOREAL_CHISELED_STONE.get());
            event.accept(BorealBlocks.GLACIAL_GRASS_BLOCK.get());
            event.accept(BorealBlocks.GLACIAL_DIRT.get());
            event.accept(BorealBlocks.GLACIAL_GRASS.get());
            event.accept(BorealBlocks.AURORA_LOG.get());
            event.accept(BorealBlocks.AURORA_WOOD.get());
            event.accept(BorealBlocks.STRIPPED_AURORA_LOG.get());
            event.accept(BorealBlocks.STRIPPED_AURORA_WOOD.get());
            event.accept(BorealBlocks.AURORA_PLANKS.get());
            event.accept(BorealBlocks.AURORAL_STAIRS.get());
            event.accept(BorealBlocks.AURORAL_SLAB.get());
            event.accept(BorealItems.AURORAL_SIGN.get());
            event.accept(BorealItems.AURORAL_HANGING_SIGN.get());
            event.accept(BorealBlocks.AURORA_LEAVES.get());
        }

        if(event.getTab() == BorealCreativeTabs.BOREAL_ENTITIES_TAB.get()) {
            event.accept(BorealItems.GLACIAL_ZOMBIE_SPAWN_EGG.get());
            event.accept(BorealItems.GLACIAL_WOLF_SPAWN_EGG.get());
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(BorealWoodTypes.AURORAL);
            EntityRenderers.register(BorealEntities.BOREAL_ROCK_ENTITY.get(), ThrownItemRenderer::new);

        }
    }
}

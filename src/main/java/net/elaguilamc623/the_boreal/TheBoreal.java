package net.elaguilamc623.the_boreal;

import com.mojang.logging.LogUtils;
import net.elaguilamc623.the_boreal.registries.*;
import net.elaguilamc623.the_boreal.registries.worldgen.BorealStructureGeneration;
import net.elaguilamc623.the_boreal.registries.worldgen.BorealStructurePlacements;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
        BorealStructurePlacements.register(modEventBus);
        BorealStructureGeneration.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::AddCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == BorealCreativeTabs.BOREAL_ITEMS_TAB.get()) {
            event.accept(BorealItems.ANCIENT_ICE_FRAGMENT);
            event.accept(BorealItems.FROZEN_AMULET);
            event.accept(BorealItems.BOREAL_ROCK);
            event.accept(BorealItems.GLACIAL_SEED);
            event.accept(BorealItems.GLACIAL_WHEAT);
            event.accept(BorealItems.GLACIAL_BREAD);
        }

        if(event.getTab() == BorealCreativeTabs.BOREAL_BLOCKS_TAB.get()) {
            event.accept(BorealBlocks.BOREAL_COBBLESTONE);
            event.accept(BorealBlocks.BOREAL_COBBLESTONE_SLAB);
            event.accept(BorealBlocks.BOREAL_COBBLESTONE_STAIRS);
            event.accept(BorealBlocks.BOREAL_COBBLESTONE_WALL);
            event.accept(BorealBlocks.BOREAL_STONE);
            event.accept(BorealBlocks.BOREAL_STONE_SLAB);
            event.accept(BorealBlocks.BOREAL_STONE_STAIRS);
            event.accept(BorealBlocks.BOREAL_DEEP_STONE);
            event.accept(BorealBlocks.BOREAL_DEEP_STONE_SLAB);
            event.accept(BorealBlocks.BOREAL_DEEP_STONE_STAIRS);
            event.accept(BorealBlocks.BOREAL_DEEP_STONE_WALL);
            event.accept(BorealBlocks.BOREAL_STONE_BRICKS);
            event.accept(BorealBlocks.BOREAL_STONE_BRICKS_SLAB);
            event.accept(BorealBlocks.BOREAL_STONE_BRICKS_STAIRS);
            event.accept(BorealBlocks.BOREAL_STONE_BRICK_WALL);
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS);
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB);
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS);
            event.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL);
            event.accept(BorealBlocks.BOREAL_CHISELED_STONE);
            event.accept(BorealBlocks.GLACIAL_GRASS_BLOCK);
            event.accept(BorealBlocks.GLACIAL_DIRT);
            event.accept(BorealBlocks.GLACIAL_GRASS);
        }

        if(event.getTab() == BorealCreativeTabs.BOREAL_ENTITIES_TAB.get()) {
            event.accept(BorealItems.GLACIAL_ZOMBIE_SPAWN_EGG);
            event.accept(BorealItems.GLACIAL_WOLF_SPAWN_EGG);
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
            EntityRenderers.register(BorealEntities.BOREAL_ROCK_ENTITY.get(), ThrownItemRenderer::new);

        }
    }
}

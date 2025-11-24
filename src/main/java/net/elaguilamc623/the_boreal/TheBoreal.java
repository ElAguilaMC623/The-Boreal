package net.elaguilamc623.the_boreal;

import com.mojang.logging.LogUtils;
import net.elaguilamc623.the_boreal.registries.*;
import net.elaguilamc623.the_boreal.registries.worldgen.BorealBiomes;
import net.elaguilamc623.the_boreal.registries.worldgen.structures.BorealStructureGeneration;
import net.elaguilamc623.the_boreal.registries.worldgen.structures.BorealStructurePlacements;
import net.elaguilamc623.the_boreal.worldgen.dimension.BorealDimension;
import net.elaguilamc623.the_boreal.worldgen.dimension.BorealDimensionType;
import net.elaguilamc623.the_boreal.worldgen.dimension.BorealNoiseSettings;
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
        BorealEntities.register(modEventBus);
        BorealStructurePlacements.register(modEventBus);
        BorealStructureGeneration.register(modEventBus);

        modEventBus.addListener(BorealBiomes::bootstrap);
        modEventBus.addListener(BorealNoiseSettings::bootstrap);
        modEventBus.addListener(BorealDimensionType::bootstrap);
        modEventBus.addListener(BorealDimension::bootstrap);


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
        }

        if(event.getTab() == BorealCreativeTabs.BOREAL_BLOCKS_TAB.get()) {
            event.accept(BorealBlocks.BOREAL_STONE);
            event.accept(BorealBlocks.GLACIAL_GRASS_BLOCK);
            event.accept(BorealBlocks.GLACIAL_DIRT);
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

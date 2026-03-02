package net.elaguilamc623.the_boreal;

import com.mojang.logging.LogUtils;
import net.elaguilamc623.the_boreal.client.render.entities.BorealBoatRenderer;
import net.elaguilamc623.the_boreal.client.render.entities.mobs.BorealGolemRenderer;
import net.elaguilamc623.the_boreal.client.render.entities.mobs.NightDeerRenderer;
import net.elaguilamc623.the_boreal.gui.boreal_essence_table.BorealEssenceTableScreen;
import net.elaguilamc623.the_boreal.gui.boreal_infuser.BorealInfuserScreen;
import net.elaguilamc623.the_boreal.registries.*;
import net.elaguilamc623.the_boreal.registries.worldgen.BorealFeatures;
import net.elaguilamc623.the_boreal.registries.worldgen.structures.BorealStructureGeneration;
import net.elaguilamc623.the_boreal.registries.worldgen.structures.BorealStructurePlacements;
import net.elaguilamc623.the_boreal.utils.BorealWoodTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
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

        BorealMenus.MENUS.register(modEventBus);
        BorealItems.register(modEventBus);
        BorealCreativeTabs.register(modEventBus);
        BorealBlocks.register(modEventBus);
        BorealEntities.ENTITY_TYPES.register(modEventBus);
        BorealBlockEntities.register(modEventBus);
        BorealSounds.register(modEventBus);
        BorealStructurePlacements.register(modEventBus);
        BorealStructureGeneration.register(modEventBus);
        BorealFeatures.FEATURES.register(modEventBus);
        BorealEnchantments.ENCHANTMENTS.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(BorealWoodTypes.AURORAL);
            EntityRenderers.register(BorealEntities.BOREAL_ROCK_ENTITY.get(), ThrownItemRenderer::new);
            EntityRenderers.register(BorealEntities.AURORAL_BOAT.get(), pContext -> new BorealBoatRenderer(pContext, false));
            EntityRenderers.register(BorealEntities.AURORAL_CHEST_BOAT.get(), pContext -> new BorealBoatRenderer(pContext, true));
            EntityRenderers.register(BorealEntities.NIGHT_DEER.get(), NightDeerRenderer::new);
            EntityRenderers.register(BorealEntities.BOREAL_GOLEM.get(), BorealGolemRenderer::new);
            MenuScreens.register(BorealMenus.BOREAL_ESSENCE_TABLE.get(), BorealEssenceTableScreen::new);
            MenuScreens.register(BorealMenus.BOREAL_INFUSER.get(), BorealInfuserScreen::new);

            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(
                        BorealBlocks.TALISMANDIUM_BARS.get(),
                        RenderType.cutout()
                );
                ItemBlockRenderTypes.setRenderLayer(
                        BorealBlocks.GLACIAL_TALL_GRASS.get(),
                        RenderType.cutout()
                );
                ItemBlockRenderTypes.setRenderLayer(
                        BorealBlocks.BOREALIGHT_SHROOM.get(),
                        RenderType.cutout()
                );
                ItemBlockRenderTypes.setRenderLayer(
                        BorealBlocks.GLACIALIGHT_SHROOM.get(),
                        RenderType.cutout()
                );
            });
        }
    }
}

package net.elaguilamc623.the_boreal.client;

import net.elaguilamc623.the_boreal.client.render.BorealEffects;
import net.elaguilamc623.the_boreal.client.render.entities.GlacialWolfRenderer;
import net.elaguilamc623.the_boreal.client.render.entities.GlacialZombieRenderer;
import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "the_boreal", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BorealClientEvents {

    @SubscribeEvent
    public static void registerDimensionEffects(RegisterDimensionSpecialEffectsEvent e) {
        e.register(new ResourceLocation("the_boreal", "boreal_effects"), new BorealEffects());
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BorealEntities.GLACIAL_ZOMBIE.get(),
                GlacialZombieRenderer::new);

        event.registerEntityRenderer(BorealEntities.GLACIAL_WOLF.get(),
                GlacialWolfRenderer::new);
    }
}
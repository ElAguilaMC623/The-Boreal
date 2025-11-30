package net.elaguilamc623.the_boreal.client;

import net.elaguilamc623.the_boreal.client.render.BorealEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "the_boreal", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BorealClientEvents {
    @SubscribeEvent
    public static void registerDimensionEffects(RegisterDimensionSpecialEffectsEvent e) {
        e.register(new ResourceLocation("the_boreal", "boreal_effects"), new BorealEffects());
    }
}
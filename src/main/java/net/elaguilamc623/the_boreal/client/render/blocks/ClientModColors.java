package net.elaguilamc623.the_boreal.client.render.blocks;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheBoreal.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModColors {

    private static final int DEFAULT_COLOR = 0x66c2e5;

    @SubscribeEvent
    public static void onBlockColorRegister(RegisterColorHandlersEvent.Block event) {
        event.register((state, blockAndTintGetter, pos, tintIndex) -> {
            if (blockAndTintGetter != null && pos != null) {
                return BiomeColors.getAverageGrassColor(blockAndTintGetter, pos);
            }
            return DEFAULT_COLOR;
        }, BorealBlocks.GLACIAL_GRASS_BLOCK.get());
    }

    @SubscribeEvent
    public static void onItemColorRegister(RegisterColorHandlersEvent.Item event) {
        event.register((itemStack, tintIndex) -> {
            return DEFAULT_COLOR;
        }, BorealBlocks.GLACIAL_GRASS_BLOCK.get());
    }
}

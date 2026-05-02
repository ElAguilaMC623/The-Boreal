package net.elaguilamc623.the_boreal.client;

import net.elaguilamc623.the_boreal.client.render.BorealEffects;
import net.elaguilamc623.the_boreal.client.render.BorealModelLayers;
import net.elaguilamc623.the_boreal.client.render.blocks.BorealInfuserRenderer;
import net.elaguilamc623.the_boreal.client.render.entities.mobs.*;
import net.elaguilamc623.the_boreal.client.render.entities.GlacialArrowRenderer;
import net.elaguilamc623.the_boreal.entities.model.BorealGolemModel;
import net.elaguilamc623.the_boreal.entities.model.CrystalizedFoxModel;
import net.elaguilamc623.the_boreal.entities.model.NightDeerModel;
import net.elaguilamc623.the_boreal.client.render.particles.GlacialDustParticle;
import net.elaguilamc623.the_boreal.registries.BorealBlockEntities;
import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.elaguilamc623.the_boreal.registries.BorealParticles;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
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

        event.registerEntityRenderer(BorealEntities.FROZEN_BEAR.get(),
                FrozenBearRenderer::new);

        event.registerEntityRenderer(BorealEntities.GLACIAL_SKELETON.get(),
                GlacialSkeletonRenderer::new);

        event.registerEntityRenderer(
                BorealEntities.GLACIAL_ARROW.get(),
                GlacialArrowRenderer::new
        );

        event.registerEntityRenderer(BorealEntities.GREAT_BOREAL_GOLEM.get(),
                GreatBorealGolemRenderer::new);

        event.registerEntityRenderer(BorealEntities.SUMMONED_BOREAL_GOLEM.get(),
                SummonedBorealGolemRenderer::new);

        event.registerEntityRenderer(BorealEntities.CRYSTALIZED_FOX.get(),
                CrystalizedFoxRenderer::new);

        event.registerEntityRenderer(BorealEntities.NOCTURNAL_CUBE.get(),
                NocturnalCubeRenderer::new);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BorealBlockEntities.BOREAL_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(BorealBlockEntities.BOREAL_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(BorealBlockEntities.BOREAL_INFUSER.get(), BorealInfuserRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BorealModelLayers.AURORAL_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(BorealModelLayers.AURORAL_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(BorealModelLayers.NIGHT_DEER_LAYER, NightDeerModel::createBodyLayer);
        event.registerLayerDefinition(BorealModelLayers.BOREAL_GOLEM_LAYER, BorealGolemModel::createBodyLayer);
        event.registerLayerDefinition(BorealModelLayers.CRYSTALIZED_FOX_LAYER, CrystalizedFoxModel::createBodyLayer);
        event.registerLayerDefinition(BorealModelLayers.NOCTURNAL_CUBE_OUTER_LAYER, SlimeModel::createOuterBodyLayer);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(
                BorealParticles.GLACIAL_DUST.get(),
                GlacialDustParticle.Provider::new
        );
    }
}
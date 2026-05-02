package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elaguilamc623.the_boreal.client.render.BorealModelLayers;
import net.elaguilamc623.the_boreal.client.render.layers.CrystalizedFoxHeldItemLayer;
import net.elaguilamc623.the_boreal.entities.custom.animals.CrystalizedFox;
import net.elaguilamc623.the_boreal.entities.model.CrystalizedFoxModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrystalizedFoxRenderer extends MobRenderer<CrystalizedFox, CrystalizedFoxModel<CrystalizedFox>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("the_boreal:textures/entity/crystalized_fox/crystalized_fox.png");

    private static final ResourceLocation SLEEP_TEXTURE =
            new ResourceLocation("the_boreal:textures/entity/crystalized_fox/crystalized_fox_sleep.png");

    public CrystalizedFoxRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new CrystalizedFoxModel<CrystalizedFox>(ctx.bakeLayer(BorealModelLayers.CRYSTALIZED_FOX_LAYER)), 0.4F);
        this.addLayer(new CrystalizedFoxHeldItemLayer(this, ctx.getItemInHandRenderer()));

    }

    @Override
    public ResourceLocation getTextureLocation(CrystalizedFox fox) {
        return fox.isSleeping() ? SLEEP_TEXTURE : TEXTURE;
    }

    @Override
    protected void setupRotations(CrystalizedFox fox, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupRotations(fox, poseStack, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    protected RenderType getRenderType(CrystalizedFox crystalizedFox, boolean bodyVisible, boolean translucent, boolean glowing) {
        ResourceLocation texture = crystalizedFox.isSleeping() ? SLEEP_TEXTURE : TEXTURE;
        return RenderType.entityTranslucentEmissive(texture);
    }
}
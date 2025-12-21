package net.elaguilamc623.the_boreal.client.render.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elaguilamc623.the_boreal.entities.GlacialWolf;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;

public class GlacialWolfRenderer extends WolfRenderer {
    private static final ResourceLocation NORMAL_TEXTURE =
            new ResourceLocation("the_boreal", "textures/entity/glacial_wolf/glacial_wolf.png");
    private static final ResourceLocation ANGRY_TEXTURE =
            new ResourceLocation("the_boreal", "textures/entity/glacial_wolf/glacial_wolf_angry.png");
    private static final ResourceLocation TAME_TEXTURE =
            new ResourceLocation("the_boreal", "textures/entity/glacial_wolf/glacial_wolf_tame.png");

    public GlacialWolfRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void scale(Wolf entity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(1.4F, 1.4F, 1.4F);
        super.scale(entity, poseStack, partialTickTime);
    }

    @Override
    public ResourceLocation getTextureLocation(Wolf entity) {
        if (entity.isTame()) {
            return TAME_TEXTURE;
        } else if (entity instanceof GlacialWolf gw && gw.isCustomAngry()) {
            return ANGRY_TEXTURE;
        } else {
            return NORMAL_TEXTURE;
        }
    }
}
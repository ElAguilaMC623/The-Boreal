package net.elaguilamc623.the_boreal.client.render.entities;

import net.elaguilamc623.the_boreal.entities.projectiles.GlacialSkeletonArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GlacialArrowRenderer extends ArrowRenderer<GlacialSkeletonArrowEntity> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation("textures/entity/projectiles/arrow.png");

    public GlacialArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(GlacialSkeletonArrowEntity entity) {
        return TEXTURE;
    }

}
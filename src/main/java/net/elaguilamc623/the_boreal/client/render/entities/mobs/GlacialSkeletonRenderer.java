package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;

public class GlacialSkeletonRenderer extends SkeletonRenderer {
    private static final ResourceLocation GLACIAL_SKELETON_TEXTURE =
            new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/glacial_skeleton.png");

    public GlacialSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return GLACIAL_SKELETON_TEXTURE;
    }
}

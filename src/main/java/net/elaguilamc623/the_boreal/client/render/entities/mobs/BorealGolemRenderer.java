package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.client.render.BorealModelLayers;
import net.elaguilamc623.the_boreal.entities.custom.monsters.BorealGolem;
import net.elaguilamc623.the_boreal.entities.model.BorealGolemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BorealGolemRenderer extends MobRenderer<BorealGolem, BorealGolemModel> {
    public BorealGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new BorealGolemModel(context.bakeLayer(BorealModelLayers.BOREAL_GOLEM_LAYER)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(BorealGolem entity) {
        return new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/boreal_golem.png");
    }

    @Override
    public void render(BorealGolem entity, float entityJaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityJaw, partialTicks, poseStack, bufferSource, packedLight);
    }
}

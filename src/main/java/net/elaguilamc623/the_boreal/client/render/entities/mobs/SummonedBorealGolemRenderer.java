package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.client.render.BorealModelLayers;
import net.elaguilamc623.the_boreal.entities.custom.SummonedBorealGolem;
import net.elaguilamc623.the_boreal.entities.model.SummonedBorealGolemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SummonedBorealGolemRenderer extends MobRenderer<SummonedBorealGolem, SummonedBorealGolemModel> {
    public SummonedBorealGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new SummonedBorealGolemModel(context.bakeLayer(BorealModelLayers.BOREAL_GOLEM_LAYER)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(SummonedBorealGolem entity) {
        return new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/boreal_golem.png");
    }

    @Override
    public void render(SummonedBorealGolem entity, float entityJaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityJaw, partialTicks, poseStack, bufferSource, packedLight);
    }
}

package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.client.render.BorealModelLayers;
import net.elaguilamc623.the_boreal.entities.custom.NightDeer;
import net.elaguilamc623.the_boreal.entities.model.NightDeerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NightDeerRenderer extends MobRenderer<NightDeer, NightDeerModel<NightDeer>> {
    public NightDeerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NightDeerModel<>(pContext.bakeLayer(BorealModelLayers.NIGHT_DEER_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(NightDeer pEntity) {
        return new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/night_deer.png");
    }

    @Override
    public void render(NightDeer pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        pMatrixStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180));

        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

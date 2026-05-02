package net.elaguilamc623.the_boreal.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elaguilamc623.the_boreal.entities.custom.NocturnalCube;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

public class NocturnalCubeOuterLayer extends RenderLayer<NocturnalCube, SlimeModel<NocturnalCube>> {
    private final EntityModel<NocturnalCube> outerModel;

    public NocturnalCubeOuterLayer(RenderLayerParent<NocturnalCube, SlimeModel<NocturnalCube>> layerParent, EntityModelSet modelPart) {
        super(layerParent);
        this.outerModel = new SlimeModel<>(modelPart.bakeLayer(ModelLayers.SLIME_OUTER));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int light, NocturnalCube entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isInvisible()) {
            this.getParentModel().copyPropertiesTo(this.outerModel);
            this.outerModel.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
            this.outerModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

            VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entity)));

            this.outerModel.renderToBuffer(poseStack, vertexconsumer, light, LivingEntityRenderer.getOverlayCoords(
                    entity, 0.0F), 1.0F, 1.0F, 1.0F, 0.5F);
        }
    }
}

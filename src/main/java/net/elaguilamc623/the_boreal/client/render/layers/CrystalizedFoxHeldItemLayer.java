package net.elaguilamc623.the_boreal.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.elaguilamc623.the_boreal.entities.custom.animals.CrystalizedFox;
import net.elaguilamc623.the_boreal.entities.model.CrystalizedFoxModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class CrystalizedFoxHeldItemLayer extends RenderLayer<CrystalizedFox, CrystalizedFoxModel<CrystalizedFox>> {

    private final ItemInHandRenderer itemRenderer;

    public CrystalizedFoxHeldItemLayer(RenderLayerParent<CrystalizedFox, CrystalizedFoxModel<CrystalizedFox>> parent,
                                       ItemInHandRenderer itemRenderer) {
        super(parent);
        this.itemRenderer = itemRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                       CrystalizedFox crystalizedFox, float limbSwing, float limbSwingAmount,
                       float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        ItemStack itemstack = crystalizedFox.getItemBySlot(EquipmentSlot.MAINHAND);

        if (!itemstack.isEmpty()) {
            poseStack.pushPose();

            this.getParentModel().head.translateAndRotate(poseStack);
            poseStack.translate(0.1F, 0.2F, -0.55F);
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

            this.itemRenderer.renderItem(crystalizedFox, itemstack, ItemDisplayContext.GROUND, false,
                    poseStack, buffer, packedLight);

            poseStack.popPose();
        }
    }
}
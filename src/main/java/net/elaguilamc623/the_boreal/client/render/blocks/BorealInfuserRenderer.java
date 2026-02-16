package net.elaguilamc623.the_boreal.client.render.blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.elaguilamc623.the_boreal.blocks.block_entities.BorealInfuserBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class BorealInfuserRenderer implements BlockEntityRenderer<BorealInfuserBlockEntity> {

    public BorealInfuserRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(BorealInfuserBlockEntity be, float partialTicks, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {

        ItemStack stack = be.getItemHandler().getStackInSlot(BorealInfuserBlockEntity.OUTPUT_SLOT);

        if (stack.isEmpty()) return;

        pose.pushPose();

        pose.translate(0.5, 1.3, 0.5);

        float rotation = (be.getLevel().getGameTime() + partialTicks) % 360;
        pose.mulPose(Axis.YP.rotationDegrees(rotation));

        pose.scale(0.7f, 0.7f, 0.7f);

        Minecraft.getInstance().getItemRenderer().renderStatic(
                stack,
                ItemDisplayContext.FIXED,
                light,
                overlay,
                pose,
                buffer,
                be.getLevel(),
                0
        );

        pose.popPose();
    }
}
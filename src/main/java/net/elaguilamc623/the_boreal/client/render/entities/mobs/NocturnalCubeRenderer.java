package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.client.render.BorealModelLayers;
import net.elaguilamc623.the_boreal.client.render.layers.NocturnalCubeOuterLayer;
import net.elaguilamc623.the_boreal.entities.custom.NocturnalCube;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@SuppressWarnings("removal")
public class NocturnalCubeRenderer extends MobRenderer<NocturnalCube, SlimeModel<NocturnalCube>> {

    private static final ResourceLocation NOCTURNAL_CUBE_LOCATION = new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/nocturnal_cube/nocturnal_cube.png");

    public NocturnalCubeRenderer(EntityRendererProvider.Context context) {
        super(context, new SlimeModel<>(context.bakeLayer(BorealModelLayers.NOCTURNAL_CUBE_OUTER_LAYER)), 0.25F);
        this.addLayer(new NocturnalCubeOuterLayer(this, context.getModelSet()));
    }

    @Override
    protected void scale(NocturnalCube entity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.85F, 0.85F, 0.85F);
        poseStack.translate(0.0F, 0.001F, 0.0F);

        float f1 = 1.0F;
        float f2 = Mth.lerp(partialTickTime, entity.oSquish, entity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);

        poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }


    public void render(NocturnalCube nocturnalCube, float f, float f2, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        this.shadowRadius = 0.25F;
        super.render(nocturnalCube, f, f2, poseStack, multiBufferSource, i);
    }

    @Override
    public ResourceLocation getTextureLocation(NocturnalCube entity) {
        return NOCTURNAL_CUBE_LOCATION;
    }

    @Override
    protected RenderType getRenderType(NocturnalCube nocturnalCube, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(NOCTURNAL_CUBE_LOCATION);
    }
}

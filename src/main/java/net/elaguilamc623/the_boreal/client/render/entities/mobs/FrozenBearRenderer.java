package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.PolarBearRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.PolarBear;

public class FrozenBearRenderer extends PolarBearRenderer {
    private static final ResourceLocation FROZEN_BEAR_TEXTURE =
            new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/frozen_bear.png");

    public FrozenBearRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PolarBear entity) {
        return FROZEN_BEAR_TEXTURE;
    }
}

package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class GlacialZombieRenderer extends ZombieRenderer {
    private static final ResourceLocation GLACIAL_ZOMBIE_TEXTURE =
            new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/glacial_zombie.png");

    public GlacialZombieRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie entity) {
        return GLACIAL_ZOMBIE_TEXTURE;
    }
}
package net.elaguilamc623.the_boreal.client.render.entities.mobs;

import net.elaguilamc623.the_boreal.entities.custom.bosses.GreatBorealGolemBoss;
import net.elaguilamc623.the_boreal.entities.model.GreatBorealGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GreatBorealGolemRenderer extends GeoEntityRenderer<GreatBorealGolemBoss> {

    public GreatBorealGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GreatBorealGolemModel());
        this.shadowRadius = 1.8f;
    }
}
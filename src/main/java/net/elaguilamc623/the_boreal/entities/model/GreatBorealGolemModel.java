package net.elaguilamc623.the_boreal.entities.model;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.entities.custom.bosses.GreatBorealGolemBoss;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class GreatBorealGolemModel extends GeoModel<GreatBorealGolemBoss> {

    @Override
    public ResourceLocation getModelResource(GreatBorealGolemBoss animatable) {
        return new ResourceLocation(TheBoreal.MOD_ID, "geo/great_boreal_golem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreatBorealGolemBoss animatable) {
        return new ResourceLocation(TheBoreal.MOD_ID, "textures/entity/great_boreal_golem.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreatBorealGolemBoss animatable) {
        return new ResourceLocation(TheBoreal.MOD_ID, "animations/great_boreal_golem.animation.json");
    }

    @Override
    public void setCustomAnimations(GreatBorealGolemBoss animatable, long instanceId, AnimationState<GreatBorealGolemBoss> state) {
        super.setCustomAnimations(animatable, instanceId, state);

        var head = this.getAnimationProcessor().getBone("head");
        if (head == null) return;

        var modelData = state.getData(DataTickets.ENTITY_MODEL_DATA);

        float yaw = modelData.netHeadYaw() * ((float)Math.PI / 180F);
        float pitch = modelData.headPitch() * ((float)Math.PI / 180F);

        head.setRotY(yaw);
        head.setRotX(pitch);
    }
}
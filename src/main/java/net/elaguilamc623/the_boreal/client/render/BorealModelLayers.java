package net.elaguilamc623.the_boreal.client.render;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class BorealModelLayers {

    public static final ModelLayerLocation AURORAL_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheBoreal.MOD_ID,"boat/auroral"), "main");

    public static final ModelLayerLocation AURORAL_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheBoreal.MOD_ID,"chest_boat/auroral"), "main");

    public static final ModelLayerLocation NIGHT_DEER_LAYER = new ModelLayerLocation(
            new ResourceLocation(TheBoreal.MOD_ID,"night_deer_layer"), "main");
}

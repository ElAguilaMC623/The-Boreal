package net.elaguilamc623.the_boreal.utils;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BorealWoodTypes {
    public static final WoodType AURORAL = WoodType.register(new WoodType(
            TheBoreal.MOD_ID + ":auroral", BlockSetType.OAK));
}

package net.elaguilamc623.the_boreal.blocks;

import net.elaguilamc623.the_boreal.worldgen.level.trees.auroral.AuroralTreeGrower;
import net.minecraft.world.level.block.SaplingBlock;

public class AuroralSaplingBlock extends SaplingBlock {

    public AuroralSaplingBlock(Properties properties) {
        super(new AuroralTreeGrower(), properties);
    }
}


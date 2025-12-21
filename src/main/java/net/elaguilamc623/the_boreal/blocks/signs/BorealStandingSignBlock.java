package net.elaguilamc623.the_boreal.blocks.signs;

import net.elaguilamc623.the_boreal.entities.signs.BorealSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BorealStandingSignBlock extends StandingSignBlock {
    public BorealStandingSignBlock(Properties pProperties, WoodType pTypes) {
        super(pProperties, pTypes);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BorealSignBlockEntity(pPos, pState);
    }
}

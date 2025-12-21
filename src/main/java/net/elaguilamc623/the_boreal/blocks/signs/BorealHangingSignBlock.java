package net.elaguilamc623.the_boreal.blocks.signs;

import net.elaguilamc623.the_boreal.blocks.entities.BorealHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BorealHangingSignBlock extends CeilingHangingSignBlock {
    public BorealHangingSignBlock(Properties pProperties, WoodType pTypes) {
        super(pProperties, pTypes);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BorealHangingSignBlockEntity(pPos, pState);
    }
}

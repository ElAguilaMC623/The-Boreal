package net.elaguilamc623.the_boreal.blocks.signs.hanging;

import net.elaguilamc623.the_boreal.blocks.block_entities.signs.BorealHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class BorealWallHangingSignBlock extends WallHangingSignBlock {
    public BorealWallHangingSignBlock(Properties pProperties, WoodType pTypes) {
        super(pProperties, pTypes);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BorealHangingSignBlockEntity(pPos, pState);
    }
}

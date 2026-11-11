package net.elaguilamc623.the_boreal.blocks.custom.plants;

import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class BorealSaplingBlock extends SaplingBlock {

    public BorealSaplingBlock(AbstractTreeGrower grower, Properties properties) {
        super(grower, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        return below.is(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON);
    }

    @Override
    public boolean canBeReplaced(BlockState state, net.minecraft.world.item.context.BlockPlaceContext useContext) {
        return true;
    }
}


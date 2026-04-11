package net.elaguilamc623.the_boreal.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import java.util.Map;

public class NocturnalFungusCapBlock extends Block {

    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    public static final BooleanProperty UP = PipeBlock.UP;
    public static final BooleanProperty DOWN = PipeBlock.DOWN;

    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;

    public NocturnalFungusCapBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(NORTH, true)
                        .setValue(EAST, true)
                        .setValue(SOUTH, true)
                        .setValue(WEST, true)
                        .setValue(UP, true)
                        .setValue(DOWN, true)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return this.defaultBlockState()
                .setValue(DOWN, !level.getBlockState(pos.below()).is(this))
                .setValue(UP, !level.getBlockState(pos.above()).is(this))
                .setValue(NORTH, !level.getBlockState(pos.north()).is(this))
                .setValue(EAST, !level.getBlockState(pos.east()).is(this))
                .setValue(SOUTH, !level.getBlockState(pos.south()).is(this))
                .setValue(WEST, !level.getBlockState(pos.west()).is(this));
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState neighbor, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos neighborPos) {
        return neighbor.is(this)
                ? blockState.setValue(PROPERTY_BY_DIRECTION.get(direction), false)
                : super.updateShape(blockState, direction, neighbor, levelAccessor, blockPos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
    }
}

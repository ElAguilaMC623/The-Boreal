package net.elaguilamc623.the_boreal.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BorealRockBlock extends Block {

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(9, 1, 11, 12, 2, 14),
            Block.box(8, 0, 10, 12, 1, 14),
            Block.box(9, 0, 10, 13, 1, 13),
            Block.box(5, 0, 5, 9, 1, 7),
            Block.box(6, 1, 4, 8, 2, 6),
            Block.box(4, 1, 2, 9, 2, 5),
            Block.box(4, 0, 2, 10, 1, 6)
    );

    public BorealRockBlock(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }
}
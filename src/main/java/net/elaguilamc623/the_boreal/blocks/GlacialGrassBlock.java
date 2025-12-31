package net.elaguilamc623.the_boreal.blocks;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public class GlacialGrassBlock extends SpreadingSnowyDirtBlock {

    public GlacialGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        if (!canSurviveGrass(state, level, pos)) {
            level.setBlockAndUpdate(pos, BorealBlocks.GLACIAL_DIRT.get().defaultBlockState());
            return;
        }

        if (canSpread(state, level, pos)) {
            BlockState grassState = this.defaultBlockState();

            for (int i = 0; i < 4; ++i) {
                BlockPos target = pos.offset(
                        random.nextInt(3) - 1,
                        random.nextInt(5) - 3,
                        random.nextInt(3) - 1
                );

                if (level.getBlockState(target).is(BorealBlocks.GLACIAL_DIRT.get())
                        && canSpread(grassState, level, target)) {
                    level.setBlockAndUpdate(target, grassState);
                }
            }
        }
    }

    private static boolean canSurviveGrass(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos above = pos.above();
        BlockState aboveState = level.getBlockState(above);

        if (aboveState.getFluidState().isSource()) {
            return false;
        }

        if (aboveState.is(Blocks.SNOW) && aboveState.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        }

        int light = LightEngine.getLightBlockInto(level, state, pos, aboveState, above, Direction.UP, aboveState.getLightBlock(level, above));
        return light < level.getMaxLightLevel();
    }

    private static boolean canSpread(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos above = pos.above();
        return canSurviveGrass(state, level, pos)
                && !level.getBlockState(above).getFluidState().isSource();
    }
}
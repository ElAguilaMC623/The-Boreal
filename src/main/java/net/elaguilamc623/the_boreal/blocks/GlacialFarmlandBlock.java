package net.elaguilamc623.the_boreal.blocks;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import javax.annotation.Nullable;

public class GlacialFarmlandBlock extends FarmBlock {
    public GlacialFarmlandBlock(Properties properties) {
        super(properties);
    }

    public static void turnToGlacialDirt(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
        BlockState blockstate = pushEntitiesUp(state, BorealBlocks.GLACIAL_DIRT.get().defaultBlockState(), level, pos);
        level.setBlockAndUpdate(pos, blockstate);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.causeFallDamage(fallDistance, 1.0F, level.damageSources().fall());

        if (!level.isClientSide && level.random.nextFloat() < fallDistance - 0.5F) {
            if (!(entity instanceof net.minecraft.world.entity.player.Player) && level.getGameRules().getBoolean(net.minecraft.world.level.GameRules.RULE_MOBGRIEFING)) {
                turnToGlacialDirt(entity, state, level, pos);
            } else if (entity instanceof net.minecraft.world.entity.player.Player) {
                turnToGlacialDirt(entity, state, level, pos);
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, net.minecraft.core.Direction dir, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (dir == net.minecraft.core.Direction.UP && !state.canSurvive(level, pos)) {
            turnToGlacialDirt(null, state, (Level) level, pos);
        }
        return super.updateShape(state, dir, neighborState, level, pos, neighborPos);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int moisture = state.getValue(MOISTURE);

        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (moisture > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, moisture - 1), 2);
            } else {

                if (!shouldMaintainGlacialFarmland(level, pos)) {
                    turnToGlacialDirt(null, state, level, pos);
                }
            }
        } else if (moisture < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter level, BlockPos pos,
                                   Direction facing, net.minecraftforge.common.IPlantable plantable) {

        return plantable == BorealBlocks.GLACIAL_WHEAT_PLANT.get();
    }

    private boolean isNearWater(Level level, BlockPos pos) {
        for (BlockPos checkPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (level.getFluidState(checkPos).is(net.minecraft.tags.FluidTags.WATER)) {
                return true;
            }
        }
        return false;
    }

    private boolean shouldMaintainGlacialFarmland(LevelAccessor level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        return above.getBlock() == BorealBlocks.GLACIAL_WHEAT_PLANT.get();
    }
}
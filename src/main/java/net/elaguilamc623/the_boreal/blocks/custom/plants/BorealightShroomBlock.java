package net.elaguilamc623.the_boreal.blocks.custom.plants;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class BorealightShroomBlock extends BushBlock {

    public BorealightShroomBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return true;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.3F) {

            int radius = 2;

            double x = pos.getX() + 0.5 + (random.nextDouble() * radius * 2 - radius);
            double y = pos.getY() + 0.8 + random.nextDouble() * 0.6;
            double z = pos.getZ() + 0.5 + (random.nextDouble() * radius * 2 - radius);

            double vx = 0;
            double vy = 0.02 + random.nextDouble() * 0.02;
            double vz = 0;

            level.addParticle(ParticleTypes.END_ROD, x, y, z, vx, vy, vz);
        }
    }
}

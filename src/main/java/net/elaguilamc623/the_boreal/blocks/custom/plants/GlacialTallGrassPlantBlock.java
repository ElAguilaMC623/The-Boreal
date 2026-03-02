package net.elaguilamc623.the_boreal.blocks.custom.plants;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GlacialTallGrassPlantBlock extends DoublePlantBlock {

    public GlacialTallGrassPlantBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == BorealBlocks.GLACIAL_GRASS_BLOCK.get()
                || block == BorealBlocks.GLACIAL_DIRT.get();
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return true;
    }
}
package net.elaguilamc623.the_boreal.blocks.custom.plants;

import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.elaguilamc623.the_boreal.worldgen.features.growers.HugeNocturnalMushroomGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class NocturnalFungusBlock extends SaplingBlock {

    public NocturnalFungusBlock(Properties properties) {
        super(new HugeNocturnalMushroomGrower(), properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BorealTags.Blocks.AURORA_SAPLING_CAN_PLANT_ON);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return true;
    }
}

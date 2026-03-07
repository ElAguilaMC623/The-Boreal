package net.elaguilamc623.the_boreal.items.custom.nature;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class GlacialBerriesItem extends Item {

    public GlacialBerriesItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockPos placePos = pos.above();
        BlockState below = level.getBlockState(pos);

        if (!level.isClientSide) {
            if (below.is(BorealBlocks.GLACIAL_GRASS_BLOCK.get())) {

                BlockPlaceContext placeContext = new BlockPlaceContext(context);

                BlockState bushState = BorealBlocks.GLACIAL_BERRY_BUSH.get()
                        .getStateForPlacement(placeContext);

                if (bushState != null && level.isEmptyBlock(placePos)) {
                    level.setBlock(placePos, bushState, 3);

                    if (!context.getPlayer().isCreative()) {
                        context.getItemInHand().shrink(1);
                    }

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }
}
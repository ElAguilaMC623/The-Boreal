package net.elaguilamc623.the_boreal.items.custom.nature;

import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GlacialSeedItem extends ItemNameBlockItem {
    public GlacialSeedItem(Block cropBlock, Item.Properties properties) {
        super(cropBlock, properties);

    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (state.is(BorealBlocks.GLACIAL_FARMLAND.get())) {
            return super.useOn(context);
        }

        return InteractionResult.FAIL;
    }

}
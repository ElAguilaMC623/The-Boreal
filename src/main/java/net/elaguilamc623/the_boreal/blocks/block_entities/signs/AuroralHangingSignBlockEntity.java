package net.elaguilamc623.the_boreal.blocks.block_entities.signs;

import net.elaguilamc623.the_boreal.registries.BorealBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AuroralHangingSignBlockEntity extends HangingSignBlockEntity {
    public AuroralHangingSignBlockEntity(BlockPos pPos, BlockState pBlockstate) {
        super(BorealBlockEntities.AURORAL_HANGING_SIGN.get(), pPos, pBlockstate);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BorealBlockEntities.AURORAL_HANGING_SIGN.get();
    }
}


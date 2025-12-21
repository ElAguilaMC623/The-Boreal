package net.elaguilamc623.the_boreal.blocks.entities;

import net.elaguilamc623.the_boreal.registries.BorealBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BorealHangingSignBlockEntity extends HangingSignBlockEntity {
    public BorealHangingSignBlockEntity(BlockPos pPos, BlockState pBlockstate) {
        super(BorealBlockEntities.BOREAL_HANGING_SIGN.get(), pPos, pBlockstate);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BorealBlockEntities.BOREAL_HANGING_SIGN.get();
    }
}


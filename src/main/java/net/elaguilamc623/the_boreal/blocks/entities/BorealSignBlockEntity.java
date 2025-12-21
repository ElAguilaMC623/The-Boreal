package net.elaguilamc623.the_boreal.blocks.entities;

import net.elaguilamc623.the_boreal.registries.BorealBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BorealSignBlockEntity extends SignBlockEntity {
    public BorealSignBlockEntity(BlockPos pPos, BlockState pBlockstate) {
        super(BorealBlockEntities.BOREAL_SIGN.get(), pPos, pBlockstate);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BorealBlockEntities.BOREAL_SIGN.get();
    }
}

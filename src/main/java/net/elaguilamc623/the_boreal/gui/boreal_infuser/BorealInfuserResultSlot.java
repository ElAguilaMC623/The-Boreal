package net.elaguilamc623.the_boreal.gui.boreal_infuser;

import net.elaguilamc623.the_boreal.blocks.block_entities.BorealInfuserBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BorealInfuserResultSlot extends SlotItemHandler {

    private final Player player;
    private final BorealInfuserBlockEntity blockEntity;

    public BorealInfuserResultSlot(Player player, BorealInfuserBlockEntity be,
                                   IItemHandler handler, int index, int x, int y) {
        super(handler, index, x, y);
        this.player = player;
        this.blockEntity = be;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public void onTake(Player player, ItemStack stack) {
        super.onTake(player, stack);
        if (!player.level().isClientSide()) {
            blockEntity.onTakeResult(player, stack);
        }
    }
}
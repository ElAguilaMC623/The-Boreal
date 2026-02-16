package net.elaguilamc623.the_boreal.gui.boreal_infuser;

import net.elaguilamc623.the_boreal.blocks.block_entities.BorealInfuserBlockEntity;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BorealInfuserMenu extends AbstractContainerMenu {

    private final BorealInfuserBlockEntity blockEntity;
    private final Level level;

    public BorealInfuserMenu(int id, Inventory playerInv, BorealInfuserBlockEntity blockEntity) {
        super(BorealMenus.BOREAL_INFUSER.get(), id);
        this.blockEntity = blockEntity;
        this.level = playerInv.player.level();

        IItemHandler handler = blockEntity.getItemHandler();

        this.addSlot(new SlotItemHandler(handler, BorealInfuserBlockEntity.INPUT_SLOT, 30, 23));
        this.addSlot(new SlotItemHandler(handler, BorealInfuserBlockEntity.ESSENCE_SLOT, 30, 47));
        this.addSlot(new BorealInfuserResultSlot(playerInv.player, blockEntity, handler,
                BorealInfuserBlockEntity.OUTPUT_SLOT, 124, 35));

        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);
    }

    public BorealInfuserMenu(int id, Inventory playerInv, FriendlyByteBuf buf) {
        this(id, playerInv,
                (BorealInfuserBlockEntity) playerInv.player.level().getBlockEntity(buf.readBlockPos()));
    }

    private void addPlayerInventory(Inventory playerInv) {
        for (int row = 0; row < 3; ++row)
            for (int col = 0; col < 9; ++col)
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
    }

    private void addPlayerHotbar(Inventory playerInv) {
        for (int col = 0; col < 9; ++col)
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity != null && player.distanceToSqr(blockEntity.getBlockPos().getCenter()) < 64;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        ItemStack copy = stack.copy();

        if (index < 3) {
            if (!this.moveItemStackTo(stack, 3, this.slots.size(), true))
                return ItemStack.EMPTY;
        } else {
            if (blockEntity.isValidInput(stack)) {
                if (!this.moveItemStackTo(stack, 0, 1, false))
                    return ItemStack.EMPTY;
            } else if (stack.is(BorealItems.BOREAL_ESSENCE.get())) {
                if (!this.moveItemStackTo(stack, 1, 2, false))
                    return ItemStack.EMPTY;
            } else {
                return ItemStack.EMPTY;
            }
        }

        if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
        else slot.setChanged();

        return copy;
    }
}
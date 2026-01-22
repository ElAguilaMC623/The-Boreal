package net.elaguilamc623.the_boreal.gui.boreal_essence_table;

import net.elaguilamc623.the_boreal.blocks.block_entities.BorealEssenceTableBlockEntity;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BorealEssenceTableMenu extends AbstractContainerMenu {

    private final BorealEssenceTableBlockEntity blockEntity;
    private final ContainerData data;

    public BorealEssenceTableMenu(int id, Inventory playerInv, BorealEssenceTableBlockEntity blockEntity, ContainerData data) {
        super(BorealMenus.BOREAL_ESSENCE_TABLE.get(), id);
        this.blockEntity = blockEntity;
        this.data = data;

        addDataSlots(data);

        IItemHandler handler = blockEntity
                .getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                .orElseThrow(IllegalStateException::new);

        this.addSlot(new SlotItemHandler(handler, BorealEssenceTableBlockEntity.INPUT_MATERIAL_SLOT, 30, 30));
        this.addSlot(new SlotItemHandler(handler, BorealEssenceTableBlockEntity.INPUT_GEM_SLOT, 80, 30) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(BorealItems.DIORIUM_GEM.get());
            }
        });
        this.addSlot(new SlotItemHandler(handler, BorealEssenceTableBlockEntity.OUTPUT_MATERIAL_SLOT, 130, 25) {
            @Override public boolean mayPlace(ItemStack stack) { return false; }
        });
        this.addSlot(new SlotItemHandler(handler, BorealEssenceTableBlockEntity.OUTPUT_ESSENCE_SLOT, 130, 50) {
            @Override public boolean mayPlace(ItemStack stack) { return false; }
        });

        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);
    }

    public BorealEssenceTableMenu(int id, Inventory playerInv, FriendlyByteBuf buf) {
        this(id, playerInv,
                (BorealEssenceTableBlockEntity) playerInv.player.level().getBlockEntity(buf.readBlockPos()),
                new SimpleContainerData(2));
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

    public int getScaledProgress() {
        int progress = data.get(0);
        int max = data.get(1);
        return max != 0 && progress != 0 ? progress * 24 / max : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        ItemStack copy = stack.copy();

        if (index < 4) {
            if (!this.moveItemStackTo(stack, 4, this.slots.size(), true))
                return ItemStack.EMPTY;
        } else {
            if (!this.moveItemStackTo(stack, 0, 2, false))
                return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
        else slot.setChanged();

        return copy;
    }
}
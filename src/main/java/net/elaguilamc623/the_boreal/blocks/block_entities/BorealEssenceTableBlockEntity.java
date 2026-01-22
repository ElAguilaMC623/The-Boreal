package net.elaguilamc623.the_boreal.blocks.block_entities;

import net.elaguilamc623.the_boreal.gui.boreal_essence_table.BorealEssenceTableMenu;
import net.elaguilamc623.the_boreal.registries.BorealBlockEntities;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.utils.BorealConversions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BorealEssenceTableBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            if (level != null && !level.isClientSide()) {
                level.scheduleTick(worldPosition, getBlockState().getBlock(), 1);
            }
            setChanged();
        }
    };

    public static final int INPUT_MATERIAL_SLOT = 0;
    public static final int INPUT_GEM_SLOT = 1;
    public static final int OUTPUT_MATERIAL_SLOT = 2;
    public static final int OUTPUT_ESSENCE_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 70;

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public BorealEssenceTableBlockEntity(BlockPos pPos, BlockState pState) {
        super(BorealBlockEntities.BOREAL_ESSENCE_TABLE.get(), pPos, pState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> BorealEssenceTableBlockEntity.this.progress;
                    case 1 -> BorealEssenceTableBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> BorealEssenceTableBlockEntity.this.progress = pValue;
                    case 1 -> BorealEssenceTableBlockEntity.this.maxProgress = pValue;
                };
            }

            @Override
            public int getCount() {
                return 0;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(  "block.the_boreal.boreal_essence_table");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BorealEssenceTableMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("boreal_essence_table.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("boreal_essence_table.progress");
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BorealEssenceTableBlockEntity be) {
        if (level.isClientSide()) return;

        if (be.hasValidRecipe()) {
            be.craftItem();
            be.setChanged();
        }
    }

    private boolean hasValidRecipe() {
        ItemStack input = itemHandler.getStackInSlot(INPUT_MATERIAL_SLOT);
        ItemStack gems = itemHandler.getStackInSlot(INPUT_GEM_SLOT);

        if (input.isEmpty() || gems.isEmpty()) return false;

        Item vanillaOutput = BorealConversions.BOREAL_TO_VANILLA.get(input.getItem());
        if (vanillaOutput == null) return false;

        int inputCount = input.getCount();
        int gemCount = gems.getCount();
        int craftAmount = Math.min(inputCount, gemCount);

        if (craftAmount <= 0) return false;

        ItemStack outputMaterial = itemHandler.getStackInSlot(OUTPUT_MATERIAL_SLOT);
        ItemStack outputEssence = itemHandler.getStackInSlot(OUTPUT_ESSENCE_SLOT);

        boolean canOutputMaterial =
                (outputMaterial.isEmpty() ||
                        (outputMaterial.is(vanillaOutput) &&
                                outputMaterial.getCount() + craftAmount <= outputMaterial.getMaxStackSize()));

        boolean canOutputEssence =
                (outputEssence.isEmpty() ||
                        (outputEssence.is(BorealItems.BOREAL_ESSENCE.get()) &&
                                outputEssence.getCount() + craftAmount <= outputEssence.getMaxStackSize()));

        return canOutputMaterial && canOutputEssence;
    }

    private void craftItem() {
        ItemStack input = itemHandler.getStackInSlot(INPUT_MATERIAL_SLOT);
        ItemStack gems = itemHandler.getStackInSlot(INPUT_GEM_SLOT);

        int craftAmount = Math.min(input.getCount(), gems.getCount());
        if (craftAmount <= 0) return;

        Item vanillaOutput = BorealConversions.BOREAL_TO_VANILLA.get(input.getItem());

        ItemStack outputMaterial = itemHandler.getStackInSlot(OUTPUT_MATERIAL_SLOT);
        if (outputMaterial.isEmpty()) {
            itemHandler.setStackInSlot(OUTPUT_MATERIAL_SLOT, new ItemStack(vanillaOutput, craftAmount));
        } else {
            outputMaterial.grow(craftAmount);
        }

        ItemStack outputEssence = itemHandler.getStackInSlot(OUTPUT_ESSENCE_SLOT);
        if (outputEssence.isEmpty()) {
            itemHandler.setStackInSlot(OUTPUT_ESSENCE_SLOT, new ItemStack(BorealItems.BOREAL_ESSENCE.get(), craftAmount));
        } else {
            outputEssence.grow(craftAmount);
        }

        input.shrink(craftAmount);
        gems.shrink(craftAmount);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        BorealEssenceTableBlockEntity.tick(level, pos, state, this);
    }
}


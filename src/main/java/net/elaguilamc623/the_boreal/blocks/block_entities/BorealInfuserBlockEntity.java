package net.elaguilamc623.the_boreal.blocks.block_entities;

import net.elaguilamc623.the_boreal.gui.boreal_infuser.BorealInfuserMenu;
import net.elaguilamc623.the_boreal.registries.BorealBlockEntities;
import net.elaguilamc623.the_boreal.registries.BorealEnchantments;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class BorealInfuserBlockEntity extends BlockEntity implements MenuProvider {

    private boolean updating = false;
    private boolean needsUpdate = false;

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if (slot == INPUT_SLOT) {
                if (stack.isEnchanted()) return false;

                return stack.is(BorealTags.BOREAL_WEAPONS)
                        || stack.is(Items.BOOK)
                        || stack.is(Items.ENCHANTED_BOOK);
            }

            if (slot == ESSENCE_SLOT) {
                return stack.is(BorealItems.BOREAL_ESSENCE.get());
            }

            if (slot == OUTPUT_SLOT) {
                return false;
            }

            return super.isItemValid(slot, stack);
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            needsUpdate = true;
        }
    };

    public static final int INPUT_SLOT = 0;
    public static final int ESSENCE_SLOT = 1;
    public static final int OUTPUT_SLOT = 2;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public BorealInfuserBlockEntity(BlockPos pos, BlockState state) {
        super(BorealBlockEntities.BOREAL_INFUSER.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BorealInfuserBlockEntity be) {
        if (!level.isClientSide()) {
            if (be.needsUpdate) {
                be.needsUpdate = false;
                be.updateResult();
            }
        }
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

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.the_boreal.boreal_infuser");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new BorealInfuserMenu(id, inv, this);
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    private void updateResult() {
        if (updating) return;
        updating = true;

        try {
            ItemStack input = itemHandler.getStackInSlot(INPUT_SLOT);
            ItemStack essence = itemHandler.getStackInSlot(ESSENCE_SLOT);

            if (input.isEmpty() || essence.isEmpty() || !isValidInput(input)) {
                itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);
                return;
            }

            ItemStack result = input.copy();
            applyRandomBorealEnchantment(result);

            itemHandler.setStackInSlot(OUTPUT_SLOT, result);

        } finally {
            updating = false;
        }
    }

    public boolean isValidInput(ItemStack stack) {
        return stack.is(BorealTags.BOREAL_WEAPONS) || stack.is(Items.BOOK) || stack.is(Items.ENCHANTED_BOOK);
    }

    private void applyRandomBorealEnchantment(ItemStack stack) {
        List<Enchantment> enchants = List.of(
                BorealEnchantments.BOREAL_CURSE.get(),
                BorealEnchantments.RANDOM_CRIT.get(),
                BorealEnchantments.EMISSIVE.get()
        );

        Enchantment chosen = enchants.get(level.random.nextInt(enchants.size()));
        int lvl = 1 + level.random.nextInt(chosen.getMaxLevel());
        forceApplyEnchantment(stack, chosen, lvl);
    }

    public void onTakeResult(Player player, ItemStack taken) {
        ItemStack input = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack essence = itemHandler.getStackInSlot(ESSENCE_SLOT);

        if (input.isEmpty() || essence.isEmpty()) return;

        essence.shrink(1);

        itemHandler.setStackInSlot(INPUT_SLOT, ItemStack.EMPTY);

        itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);

        level.playSound(null, worldPosition, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    private void forceApplyEnchantment(ItemStack stack, Enchantment enchantment, int level) {
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack);

        map.put(enchantment, level);

        EnchantmentHelper.setEnchantments(map, stack);
    }
}
package net.elaguilamc623.the_boreal.entities.custom.animals;

import com.google.common.collect.Lists;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CrystalizedFox extends Animal {

    public float interestedAngle;
    public float interestedAngleO;
    private static final int FLAG_INTERESTED = 8;
    private static final int FLAG_SLEEPING = 32;
    private static final int FLAG_PURIFYING = 64;
    private int ticksSinceEaten;
    private int purifyingTicks = 0;

    public CrystalizedFox(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setBaby(false);
    }

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID =
            SynchedEntityData.defineId(CrystalizedFox.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_0 =
            SynchedEntityData.defineId(CrystalizedFox.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_1 =
            SynchedEntityData.defineId(CrystalizedFox.class, EntityDataSerializers.OPTIONAL_UUID);

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(DATA_TRUSTED_ID_0, Optional.empty());
        this.entityData.define(DATA_TRUSTED_ID_1, Optional.empty());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    List<UUID> getTrustedUUIDs() {
        List<UUID> list = Lists.newArrayList();
        list.add(this.entityData.get(DATA_TRUSTED_ID_0).orElse((UUID)null));
        list.add(this.entityData.get(DATA_TRUSTED_ID_1).orElse((UUID)null));
        return list;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(2, new CrystalizedFoxSleepGoal(this));
        this.goalSelector.addGoal(3, new CrystalizedFoxEatBerriesGoal(this));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public void aiStep() {
        if (!this.level().isClientSide && this.isAlive() && this.isEffectiveAi()) {
            ++this.ticksSinceEaten;
            ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (this.canEat(itemstack)) {
                if (this.ticksSinceEaten > 600) {
                    ItemStack itemstack1 = itemstack.finishUsingItem(this.level(), this);
                    if (!itemstack1.isEmpty()) {
                        this.setItemSlot(EquipmentSlot.MAINHAND, itemstack1);
                    }

                    this.ticksSinceEaten = 0;
                } else if (this.ticksSinceEaten > 560 && this.random.nextFloat() < 0.1F) {
                    this.playSound(this.getEatingSound(itemstack), 1.0F, 1.0F);
                    this.level().broadcastEntityEvent(this, (byte)45);
                }
            }

            LivingEntity livingentity = this.getTarget();
            if (livingentity == null || !livingentity.isAlive()) {
                this.setIsCrouching(false);
                this.setIsInterested(false);
            }
        }

        if (this.isSleeping() || this.isImmobile()) {
            this.jumping = false;
            this.xxa = 0.0F;
            this.zza = 0.0F;
        }

        super.aiStep();
        if (this.isDefending() && this.random.nextFloat() < 0.05F) {
            this.playSound(SoundEvents.FOX_AGGRO, 1.0F, 1.0F);
        }

        this.interestedAngleO = this.interestedAngle;

        if (this.isInterested()) {
            this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
        } else {
            this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
        }

        if (this.isPurifying()) {

            this.getNavigation().stop();
            this.jumping = false;
            this.xxa = 0;
            this.zza = 0;

            purifyingTicks++;

            if (purifyingTicks >= 60) {

                ItemStack purified = new ItemStack(BorealItems.PURIFIED_GLACIAL_CRYSTAL_SHARD.get());
                ItemEntity drop = new ItemEntity(this.level(), this.getX(), this.getY() + 1.0, this.getZ(), purified);
                this.level().addFreshEntity(drop);

                this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);

                this.setPurifying(false);
                this.purifyingTicks = 0;
            }
        }

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(BorealItems.GLACIAL_CRYSTAL_SHARD.get()) && !this.isPurifying()) {

            ItemStack mouth = this.getItemBySlot(EquipmentSlot.MAINHAND);
            if (!mouth.isEmpty()) {
                this.spitOutItem(mouth);
                this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            this.setItemSlot(EquipmentSlot.MAINHAND,
                    new ItemStack(BorealItems.GLACIAL_CRYSTAL_SHARD.get()));

            this.setPurifying(true);
            this.purifyingTicks = 0;

            this.getNavigation().stop();
            this.jumping = false;
            this.xxa = 0;
            this.zza = 0;

            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        return super.mobInteract(player, hand);
    }

    /* @Override
       public boolean isImmobile() {
           return this.isSleeping() || this.isPurifying();
       }
    */

    private boolean canEat(ItemStack itemStack) {
        return itemStack.getItem().isEdible() && this.getTarget() == null && this.onGround() && !this.isSleeping();
    }

    boolean isDefending() {
        return this.getFlag(128);
    }

    public void setIsInterested(boolean interested) {
        this.setFlag(8, interested);
    }

    public void setIsCrouching(boolean crouching) {
        this.setFlag(4, crouching);
    }

    public boolean isSitting() {
        return false;
    }

    public boolean isCrouching() {
        return false;
    }

    public boolean isFaceplanted() {
        return false;
    }

    public float getCrouchAmount(float partialTicks) {
        return 0.0F;
    }

    public boolean canTakeItem(ItemStack itemStack) {
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(itemStack);
        if (!this.getItemBySlot(equipmentslot).isEmpty()) {
            return false;
        } else {
            return equipmentslot == EquipmentSlot.MAINHAND && super.canTakeItem(itemStack);
        }
    }

    public boolean canHoldItem(ItemStack itemStack) {
        Item item = itemStack.getItem();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        return itemstack.isEmpty() || this.ticksSinceEaten > 0 && item.isEdible() && !itemstack.getItem().isEdible();
    }

    private void spitOutItem(ItemStack itemStack) {
        if (!itemStack.isEmpty() && !this.level().isClientSide) {
            ItemEntity itementity = new ItemEntity(this.level(), this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, itemStack);
            itementity.setPickUpDelay(40);
            itementity.setThrower(this.getUUID());
            this.playSound(SoundEvents.FOX_SPIT, 1.0F, 1.0F);
            this.level().addFreshEntity(itementity);
        }
    }

    private void dropItemStack(ItemStack itemStack) {
        ItemEntity itementity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), itemStack);
        this.level().addFreshEntity(itementity);
    }

    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
        if (this.canHoldItem(itemstack)) {
            int i = itemstack.getCount();
            if (i > 1) {
                this.dropItemStack(itemstack.split(i - 1));
            }

            this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
            this.onItemPickup(itemEntity);
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
            this.setGuaranteedDrop(EquipmentSlot.MAINHAND);
            this.take(itemEntity, itemstack.getCount());
            itemEntity.discard();
            this.ticksSinceEaten = 0;
        }
    }

    public void setSleeping(boolean sleeping) {
        this.setFlag(FLAG_SLEEPING, sleeping);
    }

    public boolean isSleeping() {
        return this.getFlag(FLAG_SLEEPING);
    }

    public boolean isInterested() {
        return this.getFlag(FLAG_INTERESTED);
    }

    private boolean getFlag(int flagBit) {
        return (this.entityData.get(DATA_FLAGS_ID) & flagBit) != 0;
    }

    public boolean isPurifying() {
        return this.getFlag(FLAG_PURIFYING);
    }

    public void setPurifying(boolean value) {
        this.setFlag(FLAG_PURIFYING, value);
    }


    private void setFlag(int flagBit, boolean enabled) {
        byte currentFlags = this.entityData.get(DATA_FLAGS_ID);

        if (enabled) {
            this.entityData.set(DATA_FLAGS_ID, (byte)(currentFlags | flagBit));
        } else {
            this.entityData.set(DATA_FLAGS_ID, (byte)(currentFlags & ~flagBit));
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(BorealTags.CRYSTALIZED_FOX_FOOD);
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    public void playAmbientSound() {
        SoundEvent soundevent = this.getAmbientSound();
        if (soundevent == SoundEvents.FOX_SCREECH) {
            this.playSound(soundevent, 2.0F, this.getVoicePitch());
        } else {
            super.playAmbientSound();
        }

    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        if (this.isSleeping()) {
            return SoundEvents.FOX_SLEEP;
        } else {
            if (!this.level().isDay() && this.random.nextFloat() < 0.1F) {
                List<Player> list = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(16.0D, 16.0D, 16.0D), EntitySelector.NO_SPECTATORS);
                if (list.isEmpty()) {
                    return SoundEvents.FOX_SCREECH;
                }
            }

            return SoundEvents.FOX_AMBIENT;
        }
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_28548_) {
        return SoundEvents.FOX_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }

    public float getHeadRollAngle(float partialTicks) {
        return Mth.lerp(partialTicks, this.interestedAngleO, this.interestedAngle) * 0.15F;
    }

    private boolean trusts(UUID uuid) {
        return this.getTrustedUUIDs().contains(uuid);
    }

    protected void dropAllDeathLoot(DamageSource source) {
        super.dropAllDeathLoot(source);
    }

    public class CrystalizedFoxSleepGoal extends Goal {

        private final CrystalizedFox fox;

        public CrystalizedFoxSleepGoal(CrystalizedFox fox) {
            this.fox = fox;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            List<ItemEntity> items = fox.level().getEntitiesOfClass(
                    ItemEntity.class,
                    fox.getBoundingBox().inflate(6.0D),
                    item -> item.getItem().is(BorealTags.CRYSTALIZED_FOX_FOOD)
            );

            boolean found = !items.isEmpty();
            fox.setIsInterested(found);
            return found && !fox.isSleeping();
        }

        @Override
        public boolean canContinueToUse() {
            return fox.isSleeping()
                    && fox.getTarget() == null
                    && fox.getRandom().nextInt(20) != 0;
        }

        @Override
        public void start() {
            fox.setSleeping(true);
            fox.getNavigation().stop();
        }

        @Override
        public void stop() {
            fox.setSleeping(false);
        }
    }

    public class CrystalizedFoxEatBerriesGoal extends Goal {

        private final CrystalizedFox fox;

        public CrystalizedFoxEatBerriesGoal(CrystalizedFox fox) {
            this.fox = fox;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            List<ItemEntity> items = fox.level().getEntitiesOfClass(
                    ItemEntity.class,
                    fox.getBoundingBox().inflate(6.0D),
                    item -> item.getItem().is(BorealTags.CRYSTALIZED_FOX_FOOD)
            );

            return !items.isEmpty() && !fox.isSleeping();
        }

        @Override
        public void tick() {
            List<ItemEntity> items = fox.level().getEntitiesOfClass(
                    ItemEntity.class,
                    fox.getBoundingBox().inflate(6.0D),
                    item -> item.getItem().is(BorealTags.CRYSTALIZED_FOX_FOOD)
            );

            if (!items.isEmpty()) {
                ItemEntity target = items.get(0);
                fox.getNavigation().moveTo(target, 1.2F);
            }
        }
    }
}

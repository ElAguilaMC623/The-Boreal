package net.elaguilamc623.the_boreal.entities.custom;

import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.elaguilamc623.the_boreal.registries.BorealSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class NightDeer extends Animal {
    public NightDeer(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new BreedGoal(this, 1.5));
        this.goalSelector.addGoal(0, new TemptGoal(this, 1.2D, Ingredient.of(BorealItems.GLACIAL_WHEAT.get()), false));
        this.goalSelector.addGoal(0, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(0, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.MOVEMENT_SPEED, 0.250);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return BorealEntities.NIGHT_DEER.get().create(pLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(BorealItems.GLACIAL_WHEAT.get());
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return BorealSounds.NIGHT_DEER_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return BorealSounds.NIGHT_DEER_AMBIENCE.get();
    }

    @Override
    public int getAmbientSoundInterval() {
        return 400;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.GOAT_HURT;
    }

    @Override
    public MobCategory getClassification(boolean forSpawnCount) {
        return MobCategory.CREATURE;
    }

    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnType) {
        return true;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {

        this.spawnAtLocation(BorealItems.NIGHT_HORNS.get());

        int min = 1;
        int max = 3;

        int count = this.random.nextInt(max - min + 1) + min;

        if (looting > 0) {
            count += this.random.nextInt(looting + 1);
        }

        ItemLike meat = this.isOnFire()
                ? BorealItems.COOKED_NIGHT_MEAT.get()
                : BorealItems.NIGHT_MEAT.get();

        for (int i = 0; i < count; i++) {
            this.spawnAtLocation(meat);
        }
    }
}

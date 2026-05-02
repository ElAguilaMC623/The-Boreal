package net.elaguilamc623.the_boreal.entities.custom.bosses;

import net.elaguilamc623.complementary_core.entities.bosses.DefaultBossEntity;
import net.elaguilamc623.the_boreal.entities.ai.GreatBorealGolemMeleeAttackGoal;
import net.elaguilamc623.the_boreal.entities.custom.monsters.BorealGolem;
import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GreatBorealGolemBoss extends DefaultBossEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int wakeUpTimer = 0;

    private int summonCooldown = 0;
    private int nextSummonTime = 0;

    public GreatBorealGolemBoss(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.state = GolemState.SLEEPING;
        this.isSleep = true;
        this.setNoAi(true);
        this.nextSummonTime = this.random.nextInt(20 * 20) + 20 * 10;
    }

    public enum GolemState {
        SLEEPING,
        WAKING_UP,
        ACTIVE
    }

    private GolemState state = GolemState.SLEEPING;

    public enum BossPhase {
        PHASE_1,
        PHASE_2
    }

    private BossPhase phase = BossPhase.PHASE_1;

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        tag.putString("GolemState", this.state.name());
        tag.putBoolean("IsSleep", this.isSleep);
        tag.putBoolean("IsWakingUp", this.isWakingUp);
        tag.putBoolean("BossBarEnabled", this.bossBarEnabled);
        tag.putInt("Phase", this.phase.ordinal());
        tag.putInt("SummonCooldown", this.summonCooldown);
        tag.putInt("NextSummonTime", this.nextSummonTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (tag.contains("GolemState")) {
            this.state = GolemState.valueOf(tag.getString("GolemState"));
        }

        this.isSleep = tag.getBoolean("IsSleep");
        this.isWakingUp = tag.getBoolean("IsWakingUp");
        this.bossBarEnabled = tag.getBoolean("BossBarEnabled");

        if (tag.contains("Phase")) {
            this.phase = BossPhase.values()[tag.getInt("Phase")];
        }

        this.summonCooldown = tag.getInt("SummonCooldown");
        this.nextSummonTime = tag.getInt("NextSummonTime");

        if (this.state == GolemState.ACTIVE) {
            this.setNoAi(false);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 1000.0D)
                .add(Attributes.ATTACK_DAMAGE, 29.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.FOLLOW_RANGE, 100.0D);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "main_controller", 0, state -> {

            if (this.state == GolemState.SLEEPING) {
                return state.setAndContinue(
                        RawAnimation.begin().thenLoop("animation.great_boreal_golem.sleep")
                );
            }

            if (this.state == GolemState.ACTIVE && state.isMoving()) {
                return state.setAndContinue(
                        RawAnimation.begin().thenLoop("animation.great_boreal_golem.walk")
                );
            }

            if (this.state == GolemState.ACTIVE) {
                return state.setAndContinue(
                        RawAnimation.begin().thenLoop("animation.great_boreal_golem.idle")
                );
            }

            return PlayState.STOP;
        }));

        controllers.add(
                new AnimationController<>(this, "action_controller", 0, state -> PlayState.CONTINUE)
                        .triggerableAnim("wake_up",
                                RawAnimation.begin().thenPlay("animation.great_boreal_golem.wake_up"))
        );

        controllers.add(
                new AnimationController<>(this, "action_controller", 0, state -> PlayState.CONTINUE)
                        .triggerableAnim("wake_up",
                                RawAnimation.begin().thenPlay("animation.great_boreal_golem.wake_up"))
                        .triggerableAnim("attack",
                                RawAnimation.begin().thenPlay("animation.great_boreal_golem.attack"))
        );
    }

    private void onPhaseTwoStart() {

        this.level().playSound(null, this.blockPosition(),
                SoundEvents.WARDEN_ROAR, SoundSource.HOSTILE, 3f, 0.8f);

        for (int i = 0; i < 20; i++) {
            this.level().addParticle(ParticleTypes.SNOWFLAKE,
                    this.getX(), this.getY() + 2, this.getZ(),
                    (this.random.nextDouble() - 0.5) * 0.5,
                    0.2,
                    (this.random.nextDouble() - 0.5) * 0.5);
        }
    }

    @Override
    public void playWakeUpAnimation() {
        this.state = GolemState.WAKING_UP;
        this.isSleep = false;
        this.isWakingUp = true;
        this.wakeUpTimer = 0;

        this.triggerAnim("action_controller", "wake_up");
    }

    /* This method is for entering on sleep mode when you get at
    least 100 blocks away, but not for the sleep mode the boss spawns. */
    private void enterSleepMode() {
        this.state = GolemState.SLEEPING;
        this.isSleep = true;
        this.isWakingUp = false;
        this.bossBarEnabled = false;

        this.setNoAi(true);

        this.getNavigation().stop();
        this.getMoveControl().setWantedPosition(this.getX(), this.getY(), this.getZ(), 0);
        this.getLookControl().setLookAt(this.getX(), this.getEyeY(), this.getZ());

        this.wakeUpTimer = 0;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new GreatBorealGolemMeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.8D, 32.0F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 16.0F));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean isFreezing() {
        return false;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        if (this.phase == BossPhase.PHASE_2 && source.is(DamageTypeTags.IS_PROJECTILE)) {
            return true;
        }
        return super.isInvulnerableTo(source);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {

        if (this.phase == BossPhase.PHASE_2 && source.is(DamageTypeTags.IS_PROJECTILE)) {

            this.level().playSound(
                    null,
                    this.blockPosition(),
                    SoundEvents.SHIELD_BLOCK,
                    SoundSource.HOSTILE,
                    1f,
                    0.5f
            );

            return false;
        }

        boolean result = super.hurt(source, amount);

        if (result) {
            this.level().playSound(
                    null,
                    this.blockPosition(),
                    SoundEvents.IRON_GOLEM_HURT,
                    SoundSource.HOSTILE,
                    1.5f,
                    0.5f
            );
        }

        return result;
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        float damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);

        boolean hit = target.hurt(this.damageSources().mobAttack(this), damage);

        if (hit && target instanceof Player player) {
            if (player.isBlocking()) {
                player.disableShield(true);
            }

            if (this.phase == BossPhase.PHASE_2) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 0));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 50, 0));
            }
        }

        if (hit) {
            this.triggerAnim("action_controller", "attack");
            this.level().playSound(
                    null,
                    this.blockPosition(),
                    SoundEvents.IRON_GOLEM_ATTACK,
                    SoundSource.HOSTILE,
                    1.5f,
                    0.6f
            );
        }

        return hit;
    }

    private void summonBorealGolems() {
        int amount = (this.phase == BossPhase.PHASE_2) ? 2 + this.random.nextInt(2) : 1;

        for (int i = 0; i < amount; i++) {
            BorealGolem borealGolem = new BorealGolem(BorealEntities.BOREAL_GOLEM.get(), this.level());

            double offsetX = (this.random.nextDouble() - 0.5) * 6;
            double offsetZ = (this.random.nextDouble() - 0.5) * 6;

            borealGolem.moveTo(this.getX() + offsetX, this.getY(), this.getZ() + offsetZ,
                    this.random.nextFloat() * 360F, 0);

            this.level().addFreshEntity(borealGolem);
        }

        for (int i = 0; i < 20; i++) {
            this.level().addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                    this.getX(), this.getY() + 1, this.getZ(),
                    (this.random.nextDouble() - 0.5) * 0.5,
                    0.2,
                    (this.random.nextDouble() - 0.5) * 0.5);
        }

        this.level().playSound(null, this.blockPosition(),
                SoundEvents.EVOKER_PREPARE_SUMMON, SoundSource.HOSTILE, 2f, 1f);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount < 20) {
            return;
        }

        if (this.state == GolemState.ACTIVE) {
            Player nearest = this.level().getNearestPlayer(this, 100.0);

            if (nearest == null) {
                enterSleepMode();
                return;
            }
        }


        if (this.phase == BossPhase.PHASE_1 && this.getHealth() <= this.getMaxHealth() * 0.5f) {
            this.phase = BossPhase.PHASE_2;
            onPhaseTwoStart();
        }

        if (this.state == GolemState.WAKING_UP) {
            wakeUpTimer++;

            if (wakeUpTimer == 1) {
                this.setNoAi(true);
            }

            if (wakeUpTimer >= 90) {
                this.state = GolemState.ACTIVE;
                this.bossBarEnabled = true;
                this.setNoAi(false);
                this.isWakingUp = false;

                if (!this.level().isClientSide()) {
                    for (ServerPlayer player : this.level().getEntitiesOfClass(ServerPlayer.class, this.getBoundingBox().inflate(32))) {
                        this.playerBossEvent.addPlayer(player);
                    }
                }
            }
        }

        if (this.state != GolemState.ACTIVE) return;

        summonCooldown++;

        if (summonCooldown >= nextSummonTime) {
            summonCooldown = 0;

            nextSummonTime = this.random.nextInt(20 * 20) + 20 * 10;

            summonBorealGolems();
        }
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        this.spawnAtLocation(new ItemStack(BorealItems.BOREAL_ENCHANTED_SHARD.get(), 2));
    }
}

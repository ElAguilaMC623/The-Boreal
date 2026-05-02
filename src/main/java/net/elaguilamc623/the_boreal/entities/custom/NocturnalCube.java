package net.elaguilamc623.the_boreal.entities.custom;

import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import java.util.EnumSet;

public class NocturnalCube extends Mob {
    public float targetSquish;
    public float squish;
    public float oSquish;
    private boolean wasOnGround;

    public NocturnalCube(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new NocturnalCube.NocturnalCubeFloatGoal(this));
        this.goalSelector.addGoal(3, new NocturnalCube.NocturnalCubeRandomDirectionGoal(this));
        this.goalSelector.addGoal(5, new NocturnalCube.NocturnalCubeKeepOnJumpingGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (p_289461_) -> {
            return Math.abs(p_289461_.getY() - this.getY()) <= 4.0D;
        }));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.moveControl = new NocturnalCube.NocturnalCubeMoveControl(this);
    }

    public void tick() {
        this.squish += (this.targetSquish - this.squish) * 0.5F;
        this.oSquish = this.squish;
        super.tick();
        if (this.onGround() && !this.wasOnGround) {
            int i = this.getSize();

            if (!spawnCustomParticles())
                for(int j = 0; j < i * 8; ++j) {
                    float f = this.random.nextFloat() * ((float)Math.PI * 2F);
                    float f1 = this.random.nextFloat() * 0.5F + 0.5F;
                    float f2 = Mth.sin(f) * (float)i * 0.5F * f1;
                    float f3 = Mth.cos(f) * (float)i * 0.5F * f1;
                    this.level().addParticle(this.getParticleType(), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
                }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.targetSquish = -0.5F;
        } else if (!this.onGround() && this.wasOnGround) {
            this.targetSquish = 1.0F;
        }

        this.wasOnGround = this.onGround();
        this.decreaseSquish();
    }

    protected int getSize() {
        return 1;
    }

    protected ParticleOptions getParticleType() {
        return ParticleTypes.ITEM_SLIME;
    }

    protected boolean spawnCustomParticles() {
        return false;
    }

    protected void decreaseSquish() {
        this.targetSquish *= 0.6F;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SLIME_HURT_SMALL;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH_SMALL;
    }

    protected SoundEvent getSquishSound() {
        return SoundEvents.SLIME_SQUISH_SMALL;
    }

    public float getSoundPitch() {
        float f = this.getSize() == 1 ? 1.4F : 0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected boolean doPlayJumpSound() {
        return true;
    }

    protected SoundEvent getJumpSound() {
        return SoundEvents.SLIME_JUMP_SMALL;
    }

    protected int getJumpDelay() {
        return this.random.nextInt(20) + 10;
    }

    protected void jumpFromGround() {
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, (double)this.getJumpPower(), vec3.z);
        this.hasImpulse = true;
    }

    public static class NocturnalCubeFloatGoal extends Goal {
        private final NocturnalCube nocturnalCube;

        public NocturnalCubeFloatGoal(NocturnalCube nocturnalCube) {
            this.nocturnalCube = nocturnalCube;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            nocturnalCube.getNavigation().setCanFloat(true);
        }

        public boolean canUse() {
            return (this.nocturnalCube.isInWater() || this.nocturnalCube.isInLava()) && this.nocturnalCube.getMoveControl() instanceof NocturnalCube.NocturnalCubeMoveControl;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (this.nocturnalCube.getRandom().nextFloat() < 0.8F) {
                this.nocturnalCube.getJumpControl().jump();
            }

            MoveControl movecontrol = this.nocturnalCube.getMoveControl();
            if (movecontrol instanceof NocturnalCube.NocturnalCubeMoveControl nocturnalCubeMoveControl) {
                nocturnalCubeMoveControl.setWantedMovement(1.2D);
            }

        }
    }

    public static class NocturnalCubeKeepOnJumpingGoal extends Goal {
        private final NocturnalCube nocturnalCube;

        public NocturnalCubeKeepOnJumpingGoal(NocturnalCube nocturnalCube) {
            this.nocturnalCube = nocturnalCube;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return !this.nocturnalCube.isPassenger();
        }

        public void tick() {
            MoveControl movecontrol = this.nocturnalCube.getMoveControl();
            if (movecontrol instanceof NocturnalCube.NocturnalCubeMoveControl nocturnalCubeMoveControl) {
                nocturnalCubeMoveControl.setWantedMovement(1.0D);
            }

        }
    }


    public static class NocturnalCubeMoveControl extends MoveControl {
        private float yRot;
        private int jumpDelay;
        private final NocturnalCube nocturnalCube;
        private boolean isAggressive;

        public NocturnalCubeMoveControl(NocturnalCube nocturnalCube) {
            super(nocturnalCube);
            this.nocturnalCube = nocturnalCube;
            this.yRot = 180.0F * nocturnalCube.getYRot() / (float)Math.PI;
        }

        public void setDirection(float rotation) {
            this.yRot = rotation;
        }

        public void setWantedMovement(double speed) {
            this.speedModifier = speed;
            this.operation = MoveControl.Operation.MOVE_TO;
        }

        public void tick() {
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), this.yRot, 90.0F));
            this.mob.yHeadRot = this.mob.getYRot();
            this.mob.yBodyRot = this.mob.getYRot();
            if (this.operation != MoveControl.Operation.MOVE_TO) {
                this.mob.setZza(0.0F);
            } else {
                this.operation = MoveControl.Operation.WAIT;
                if (this.mob.onGround()) {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.nocturnalCube.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.nocturnalCube.getJumpControl().jump();
                        if (this.nocturnalCube.doPlayJumpSound()) {
                            this.nocturnalCube.playSound(this.nocturnalCube.getJumpSound(), this.nocturnalCube.getSoundVolume(), this.nocturnalCube.getSoundPitch());
                        }
                    } else {
                        this.nocturnalCube.xxa = 0.0F;
                        this.nocturnalCube.zza = 0.0F;
                        this.mob.setSpeed(0.0F);
                    }
                } else {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }

            }
        }
    }

    public static class NocturnalCubeRandomDirectionGoal extends Goal {
        private final NocturnalCube nocturnalCube;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public NocturnalCubeRandomDirectionGoal(NocturnalCube nocturnalCube) {
            this.nocturnalCube = nocturnalCube;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return this.nocturnalCube.getTarget() == null && (this.nocturnalCube.onGround() || this.nocturnalCube.isInWater() || this.nocturnalCube.isInLava() || this.nocturnalCube.hasEffect(MobEffects.LEVITATION)) && this.nocturnalCube.getMoveControl() instanceof NocturnalCube.NocturnalCubeMoveControl;
        }

        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = this.adjustedTickDelay(40 + this.nocturnalCube.getRandom().nextInt(60));
                this.chosenDegrees = (float)this.nocturnalCube.getRandom().nextInt(360);
            }

            MoveControl moveControl = this.nocturnalCube.getMoveControl();
            if (moveControl instanceof NocturnalCube.NocturnalCubeMoveControl nocturnalCubeMoveControl) {
                nocturnalCubeMoveControl.setDirection(this.chosenDegrees);
                nocturnalCubeMoveControl.setWantedMovement(1.0D);
            }
        }

    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {

        int min = 1;
        int max = 2;

        int count = this.random.nextInt(max - min + 1) + min;

        if (looting > 0) {
            count += this.random.nextInt(looting + 1);
        }

        for (int i = 0; i < count; i++) {
            this.spawnAtLocation(BorealItems.NOCTURNAL_CREAM.get());
        }
    }
}

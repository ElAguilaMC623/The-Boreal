package net.elaguilamc623.the_boreal.entities.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class SummonedBorealGolem extends PathfinderMob {

    private UUID ownerUUID;
    private int lifeSpan = 20 * 60;

    public SummonedBorealGolem(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    private Player owner;

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return this.owner;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new Goal() {
            @Override
            public boolean canUse() {
                return owner != null && SummonedBorealGolem.this.distanceTo(owner) > 4;
            }

            @Override
            public void tick() {
                SummonedBorealGolem.this.getNavigation().moveTo(owner, 1.0D);
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, entity -> owner != null && owner.getLastHurtMob() == entity));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
    }

    @Override
    public void tick() {
        super.tick();
        if (lifeSpan-- <= 0) this.discard();
    }

    @Override
    public boolean doHurtTarget(Entity target) {

        if (target == owner) return false;

        boolean hit = super.doHurtTarget(target);

        if (hit && target instanceof Mob mob) {

            mob.setTarget(this);

            mob.setLastHurtByMob(this);
        }

        return hit;
    }
}
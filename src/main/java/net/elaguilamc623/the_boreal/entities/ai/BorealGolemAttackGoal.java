package net.elaguilamc623.the_boreal.entities.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class BorealGolemAttackGoal extends MeleeAttackGoal {

    public BorealGolemAttackGoal(PathfinderMob mob, double speedModifier, boolean followEvenIfNotSeen) {
        super(mob, speedModifier, followEvenIfNotSeen);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return (double)(this.mob.getBbWidth() * 2.25F * this.mob.getBbWidth() * 2.0F + target.getBbWidth());
    }
}
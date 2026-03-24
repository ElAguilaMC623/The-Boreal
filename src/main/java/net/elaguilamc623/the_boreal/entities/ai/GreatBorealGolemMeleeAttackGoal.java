package net.elaguilamc623.the_boreal.entities.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class GreatBorealGolemMeleeAttackGoal extends MeleeAttackGoal {

    public GreatBorealGolemMeleeAttackGoal(PathfinderMob mob, double speed, boolean pauseWhenIdle) {
        super(mob, speed, pauseWhenIdle);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        return 10.0D;
    }
}
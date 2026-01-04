package net.elaguilamc623.the_boreal.entities.custom.boats;

import net.elaguilamc623.the_boreal.entities.custom.projectiles.GlacialSkeletonArrowEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GlacialSkeletonEntity extends Skeleton {
    public GlacialSkeletonEntity(EntityType<? extends Skeleton> type, Level pLevel) {
        super(type, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        GlacialSkeletonArrowEntity arrow = new GlacialSkeletonArrowEntity(this.level(), this);

        arrow.setBaseDamage(8.0D);

        double dx = target.getX() - this.getX();
        double dy = target.getY(0.3333333333333D) - arrow.getY();
        double dz = target.getZ() - this.getZ();

        double speed = 1.6D;
        double inaccuracy = 1.0D;

        arrow.shoot(dx, dy, dz, (float) speed, (float) inaccuracy);

        this.level().addFreshEntity(arrow);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }
}

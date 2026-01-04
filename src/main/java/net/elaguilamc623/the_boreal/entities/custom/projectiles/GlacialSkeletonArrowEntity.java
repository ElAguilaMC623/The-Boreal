package net.elaguilamc623.the_boreal.entities.custom.projectiles;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class GlacialSkeletonArrowEntity extends Arrow {
    public GlacialSkeletonArrowEntity(EntityType<? extends GlacialSkeletonArrowEntity> type, Level level) {
        super(type, level);
    }

    public GlacialSkeletonArrowEntity(Level level, LivingEntity shooter) {
        super(level, shooter);
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);

        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
    }

}

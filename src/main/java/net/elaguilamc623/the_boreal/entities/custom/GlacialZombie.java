package net.elaguilamc623.the_boreal.entities.custom;

import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GlacialZombie extends Zombie {
    public GlacialZombie(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean flag = super.doHurtTarget(target);

        if (flag && target instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0));

            living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
        }

        return flag;
    }

    @Override
    protected void doUnderWaterConversion() {
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);

        int amount = this.random.nextInt(2 + looting);
        if (amount > 0) {
            this.spawnAtLocation(new ItemStack(BorealItems.GLACIAL_ROTTEN_FLESH.get(), amount));
        }
    }
}
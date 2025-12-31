package net.elaguilamc623.the_boreal.entities.projectiles;

import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class BorealRockEntity extends ThrowableItemProjectile {
    public BorealRockEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public BorealRockEntity(Level pLevel) {
        super(BorealEntities.BOREAL_ROCK_ENTITY.get(), pLevel);
    }

    public BorealRockEntity(Level pLevel, LivingEntity livingEntity) {
        super(BorealEntities.BOREAL_ROCK_ENTITY.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return BorealItems.BOREAL_ROCK.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
        super.onHitBlock(result);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level().isClientSide) {
            Entity target = result.getEntity();

            target.hurt(this.level().damageSources().thrown(this, this.getOwner()), 1.0F);

            double strength = 0.15D;
            target.setDeltaMovement(
                    target.getDeltaMovement().add(
                            this.getDeltaMovement().x * strength,
                            0.06D,
                            this.getDeltaMovement().z * strength
                    )
            );

            this.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                    SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.PLAYERS, 1.0F, 1.0F);

            this.discard();
        }
    }


    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(
                        new ItemParticleOption(ParticleTypes.ITEM, this.getItem()),
                        this.getX(), this.getY(), this.getZ(),
                        0.0D, 0.0D, 0.0D
                );
            }
        } else {
            super.handleEntityEvent(id);
        }
    }
}

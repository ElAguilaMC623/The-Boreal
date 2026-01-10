package net.elaguilamc623.the_boreal.entities.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.List;

public class GlacialWolfEntity extends Wolf {
    public GlacialWolfEntity(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.is(Items.BONE)) {
            if (!this.level().isClientSide) {
                this.tame(player);
                this.navigation.stop();
                this.setTarget(null);
                this.level().broadcastEntityEvent(this, (byte)7);
            }
            return InteractionResult.SUCCESS;
        }

        if (this.isTame() && itemstack.getItem() instanceof DyeItem dye) {
            DyeColor color = dye.getDyeColor();
            this.setCollarColor(color);
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);

    }

    private boolean customAngry;

    public boolean isCustomAngry() {
        return customAngry;
    }

    public void setCustomAngry(boolean angry) {
        this.customAngry = angry;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide && this.tickCount == 20) {
            Player player = this.level().getNearestPlayer(this, 20);
            if (player != null) {
                System.out.println("Mob category is "+ this.getType().getCategory());
                player.sendSystemMessage(
                        Component.literal("Categoría real del GlacialWolf: " + this.getType().getCategory())
                );
            }
        }

        Player nearest = this.level().getNearestPlayer(this, 10.0D);
        if (nearest != null && !this.isTame()) {

            if (!nearest.isCreative() && !nearest.isSpectator()) {
                this.setCustomAngry(true);
                this.setTarget(nearest);

                List<GlacialWolfEntity> nearbyWolves = this.level().getEntitiesOfClass(
                        GlacialWolfEntity.class,
                        this.getBoundingBox().inflate(30.0D)
                );

                for (GlacialWolfEntity wolf : nearbyWolves) {
                    if (!wolf.isTame()) {
                        wolf.setCustomAngry(true);
                        wolf.setTarget(nearest);
                    }
                }
            }
        } else {
            this.setCustomAngry(false);
        }
    }

    @Override
    public MobCategory getClassification(boolean forSpawnCount) {
        return MobCategory.MONSTER;
    }
}
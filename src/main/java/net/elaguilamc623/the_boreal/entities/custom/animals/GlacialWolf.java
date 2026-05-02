package net.elaguilamc623.the_boreal.entities.custom.animals;

import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.List;

public class GlacialWolf extends Wolf {
    public GlacialWolf(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.is(BorealItems.GLACIAL_BONE.get())) {
            if (!this.level().isClientSide) {
                this.tame(player);
                this.navigation.stop();
                this.setTarget(null);
                this.level().broadcastEntityEvent(this, (byte)7);
                this.setAggressive(true);
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

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
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

        Player nearest = this.level().getNearestPlayer(this, 10.0D);
        if (nearest != null && !this.isTame()) {

            if (!nearest.isCreative() && !nearest.isSpectator()) {
                this.setCustomAngry(true);
                this.setTarget(nearest);

                List<GlacialWolf> nearbyWolves = this.level().getEntitiesOfClass(
                        GlacialWolf.class,
                        this.getBoundingBox().inflate(30.0D)
                );

                for (GlacialWolf wolf : nearbyWolves) {
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
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnType) {
        return true;
    }
}
package net.elaguilamc623.the_boreal.items.custom;

import net.elaguilamc623.the_boreal.worldgen.dimension.BorealDimension;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class FrozenAmuletItem extends Item {
    public FrozenAmuletItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 35;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingTicks) {
        if (!level.isClientSide && entity instanceof ServerPlayer player) {
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,
                    60, 0, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
                    40, 3, false, false));

            if (remainingTicks <= 1) {
                teleportPlayer(player);
                player.stopUsingItem();
            }
        }
    }

    private void teleportPlayer(ServerPlayer player) {
        ServerLevel dest;
        BlockPos target;

        if (player.level().dimension() == BorealDimension.BOREAL_LEVEL) {
            dest = player.server.getLevel(Level.OVERWORLD);
            BlockPos respawn = player.getRespawnPosition();
            target = respawn != null ? respawn : dest.getSharedSpawnPos();

        } else {
            dest = player.server.getLevel(BorealDimension.BOREAL_LEVEL);

            int x = player.getBlockX();
            int z = player.getBlockZ();
            target = new BlockPos(x, 130, z);
        }

        if (dest != null) {
            player.teleportTo(
                    dest,
                    target.getX() + 0.5,
                    target.getY(),
                    target.getZ() + 0.5,
                    player.getYRot(),
                    player.getXRot()
            );

            if (dest.dimension() == BorealDimension.BOREAL_LEVEL) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.SLOW_FALLING,
                        300,
                        0,
                        false,
                        false
                ));
            }
        }
    }
}
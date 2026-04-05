package net.elaguilamc623.the_boreal.items.custom.nature;

import net.elaguilamc623.the_boreal.entities.custom.projectiles.BorealRockEntity;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class BorealRockItem extends Item {
    public BorealRockItem(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        HitResult hit = Item.getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.NONE);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if (blockHit.getDirection() == Direction.UP) {
                BlockPos placePos = blockHit.getBlockPos().above();

                if (pLevel.getBlockState(placePos).canBeReplaced()) {
                    pLevel.setBlock(placePos,
                            BorealBlocks.BOREAL_ROCK.get().defaultBlockState(),
                            3);
                    pPlayer.playSound(SoundEvents.STONE_BREAK, 1.0F,1.0F);

                    if (!pPlayer.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                }
            }
        }

        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!pLevel.isClientSide) {
            BorealRockEntity boreal_rock = new BorealRockEntity(pLevel, pPlayer);
            boreal_rock.setItem(itemstack);
            boreal_rock.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(boreal_rock);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}

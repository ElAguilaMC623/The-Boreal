package net.elaguilamc623.the_boreal.blocks.custom;

import net.elaguilamc623.the_boreal.entities.custom.bosses.GreatBorealGolemBoss;
import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BorealAltarBlock extends Block {

    public BorealAltarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        ItemStack item = player.getItemInHand(hand);

        if (item.is(BorealItems.GLACIAL_STAR_AMULET.get())) {

            if (!level.isClientSide()) {
                summonBoss(level, pos);
                item.shrink(1);
                level.destroyBlock(pos, false);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private void summonBoss(Level level, BlockPos pos) {

        GreatBorealGolemBoss boss = new GreatBorealGolemBoss(BorealEntities.GREAT_BOREAL_GOLEM.get(), level);

        boss.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5,
                level.random.nextFloat() * 360F, 0);

        level.addFreshEntity(boss);

        level.playSound(null, pos, SoundEvents.END_PORTAL_SPAWN, SoundSource.HOSTILE, 3f, 0.8f);

        for (int i = 0; i < 40; i++) {
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                    pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                    (level.random.nextDouble() - 0.5) * 0.5,
                    0.2,
                    (level.random.nextDouble() - 0.5) * 0.5);
        }
    }
}
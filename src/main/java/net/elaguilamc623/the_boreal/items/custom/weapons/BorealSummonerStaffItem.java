package net.elaguilamc623.the_boreal.items.custom.weapons;

import net.elaguilamc623.the_boreal.entities.custom.SummonedBorealGolem;
import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BorealSummonerStaffItem extends Item {

    public BorealSummonerStaffItem(Properties properties) {
        super(properties.durability(100));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack stack = player.getItemInHand(interactionHand);

        if (!level.isClientSide()) {

            player.getCooldowns().addCooldown(this, 20 * 20);
            SummonedBorealGolem golem = new SummonedBorealGolem(BorealEntities.SUMMONED_BOREAL_GOLEM.get(), level);

            golem.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), 0);
            golem.setOwner(player);

            level.addFreshEntity(golem);
            stack.hurtAndBreak(4, player, p -> p.broadcastBreakEvent(interactionHand));
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(interactionHand), level.isClientSide());
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.the_boreal.boreal_summoner_staff").withStyle(ChatFormatting.GRAY));
    }
}

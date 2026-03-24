package net.elaguilamc623.the_boreal.items.custom.magic;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class GlacialStarAmuletItem extends Item {
    public GlacialStarAmuletItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Component.translatable("tooltip.the_boreal.glacial_star_amulet").withStyle(ChatFormatting.GRAY));
    }
}

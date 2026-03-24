package net.elaguilamc623.the_boreal.items.custom.magic;

import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

import javax.annotation.Nullable;
import java.util.List;

public class PrisonLocatorItem extends Item {
    public PrisonLocatorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            ServerLevel server = (ServerLevel) level;

            ResourceKey<Structure> PRISON_KEY =
                    ResourceKey.create(Registries.STRUCTURE, new ResourceLocation("the_boreal", "prison/boreal_prison"));

            Holder<Structure> prisonHolder =
                    server.registryAccess().registryOrThrow(Registries.STRUCTURE).getHolderOrThrow(PRISON_KEY);

            Pair<BlockPos, Holder<Structure>> result =
                    server.getChunkSource().getGenerator().findNearestMapStructure(
                            server,
                            HolderSet.direct(prisonHolder),
                            player.blockPosition(),
                            2000,
                            false
                    );

            if (result != null) {
                BlockPos pos = result.getFirst();

                player.displayClientMessage(
                        Component.literal("Boreal Prison found in: " +
                                pos.getX() + ", " + pos.getY() + ", " + pos.getZ()),
                        true
                );
            } else {
                player.displayClientMessage(
                        Component.literal("Boreal Prison hasn't been found nearby"),
                        true
                );
            }
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.the_boreal.prison_locator").withStyle(ChatFormatting.GRAY));
    }
}

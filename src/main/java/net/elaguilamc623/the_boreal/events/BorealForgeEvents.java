package net.elaguilamc623.the_boreal.events;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealEnchantments;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheBoreal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BorealForgeEvents {

    @SubscribeEvent
    public static void onPlayerAttack(LivingHurtEvent event) {

        if (!(event.getSource().getEntity() instanceof Player player)) return;

        ItemStack weapon = player.getMainHandItem();

        int curseLevel = weapon.getEnchantmentLevel(BorealEnchantments.BOREAL_CURSE.get());

        if (curseLevel > 0 && event.getEntity().getType().is(BorealTags.BOREAL_MOBS)) {
            float extra = 2.0f * curseLevel;
            event.setAmount(event.getAmount() + extra);
        }

        int critLevel = weapon.getEnchantmentLevel(BorealEnchantments.RANDOM_CRIT.get());

        if (critLevel > 0) {
            float chance = 0.10f * critLevel;

            if (player.getRandom().nextFloat() < chance) {
                float multiplier = 1.25f + (0.25f * critLevel);

                event.setAmount(event.getAmount() * multiplier);
            }
        }

        if (weapon.getEnchantmentLevel(BorealEnchantments.EMISSIVE.get()) > 0) {
            if (player.getRandom().nextFloat() < 0.25f) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
            }
        }
    }
}
package net.elaguilamc623.the_boreal.events;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealEnchantments;
import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheBoreal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BorealForgeEvents {

    @SubscribeEvent
    public static void onDamage(LivingDamageEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        ItemStack weapon = player.getMainHandItem();
        int level = weapon.getEnchantmentLevel(BorealEnchantments.BOREAL_CURSE.get());
        if (level <= 0) return;

        if (!event.getEntity().getType().is(BorealTags.BOREAL_MOBS)) return;

        float base = event.getAmount();
        float extra = 2.0f * level;

        event.setAmount(base + extra);
    }

    @SubscribeEvent
    public static void onAttack(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        ItemStack weapon = player.getMainHandItem();
        if (weapon.getEnchantmentLevel(BorealEnchantments.RANDOM_CRIT.get()) > 0) {

            if (player.getRandom().nextFloat() < 0.15f) {
                event.setAmount(event.getAmount() * 1.5f);
            }
        }
    }

    @SubscribeEvent
    public static void onHitGlow(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        ItemStack weapon = player.getMainHandItem();
        if (weapon.getEnchantmentLevel(BorealEnchantments.EMISSIVE.get()) > 0) {

            if (player.getRandom().nextFloat() < 0.25f) { // 25%
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
            }
        }
    }
}

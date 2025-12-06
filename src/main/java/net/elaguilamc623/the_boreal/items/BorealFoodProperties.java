package net.elaguilamc623.the_boreal.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class BorealFoodProperties {
    public static final FoodProperties GLACIAL_BREAD =
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.7F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 6, 0), 1.0F)
                    .build();
}
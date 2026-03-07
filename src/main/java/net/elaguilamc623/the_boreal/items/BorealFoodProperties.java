package net.elaguilamc623.the_boreal.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class BorealFoodProperties {
    public static final FoodProperties GLACIAL_BERRIES =
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.1F)
                    .build();

    public static final FoodProperties GLACIAL_ROTTEN_FLESH =
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.1F)
                    .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1.0F)
                    .build();

    public static final FoodProperties GLACIAL_BREAD =
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.7F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 6, 0), 1.0F)
                    .build();

    public static final FoodProperties NIGHT_MEET =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 6, 0), 0.2F)
                    .meat().
                    build();

    public static final FoodProperties COOKED_NIGHT_MEET =
            new FoodProperties.Builder().
                    nutrition(8)
                    .saturationMod(0.8F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 6, 0), 0.8F)
                    .meat()
                    .build();
}
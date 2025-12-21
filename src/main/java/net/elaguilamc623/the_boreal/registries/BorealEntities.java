package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.entities.BorealRockEntity;
import net.elaguilamc623.the_boreal.entities.GlacialWolf;
import net.elaguilamc623.the_boreal.entities.GlacialZombie;
import net.elaguilamc623.the_boreal.entities.custom.BorealBoatEntity;
import net.elaguilamc623.the_boreal.entities.custom.BorealChestBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheBoreal.MOD_ID);

    public static final RegistryObject<EntityType<BorealRockEntity>> BOREAL_ROCK_ENTITY =
            ENTITY_TYPES.register("boreal_rock_projectile", () -> EntityType.Builder.<BorealRockEntity>of(BorealRockEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("boreal_rock_projectile"));

    public static final RegistryObject<EntityType<GlacialZombie>> GLACIAL_ZOMBIE =
            ENTITY_TYPES.register("glacial_zombie", () -> EntityType.Builder.of(GlacialZombie::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("glacial_zombie"));

    public static final RegistryObject<EntityType<GlacialWolf>> GLACIAL_WOLF =
            ENTITY_TYPES.register("glacial_wolf", () -> EntityType.Builder
                    .of(GlacialWolf::new, MobCategory.CREATURE)
                    .sized(0.8f, 1.0f)
                    .build("glacial_wolf"));

    public static final RegistryObject<EntityType<BorealBoatEntity>> AURORAL_BOAT = ENTITY_TYPES.register("auroral_boat",
            () -> EntityType.Builder.<BorealBoatEntity>of(BorealBoatEntity::new, MobCategory.MISC).sized(
                    1.375f, 0.5625f)
                    .build("auroral_boat"));

    public static final RegistryObject<EntityType<BorealChestBoatEntity>> AURORAL_CHEST_BOAT =
            ENTITY_TYPES.register("auroral_chest_boat", () -> EntityType.Builder.<BorealChestBoatEntity>of(BorealChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("auroral_chest_boat"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

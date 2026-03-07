package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.entities.custom.*;
import net.elaguilamc623.the_boreal.entities.custom.projectiles.BorealRockEntity;
import net.elaguilamc623.the_boreal.entities.custom.boats.BorealBoatEntity;
import net.elaguilamc623.the_boreal.entities.custom.boats.BorealChestBoatEntity;
import net.elaguilamc623.the_boreal.entities.custom.projectiles.GlacialSkeletonArrowEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.block.SweetBerryBushBlock;
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

    public static final RegistryObject<EntityType<GlacialZombieEntity>> GLACIAL_ZOMBIE =
            ENTITY_TYPES.register("glacial_zombie", () -> EntityType.Builder.of(GlacialZombieEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("glacial_zombie"));

    public static final RegistryObject<EntityType<GlacialWolfEntity>> GLACIAL_WOLF =
            ENTITY_TYPES.register("glacial_wolf", () -> EntityType.Builder
                    .of(GlacialWolfEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 1.0f)
                    .build("glacial_wolf"));

    public static final RegistryObject<EntityType<FrozenBearEntity>> FROZEN_BEAR =
            ENTITY_TYPES.register("frozen_bear", () -> EntityType.Builder
                    .of(FrozenBearEntity::new, MobCategory.CREATURE)
                    .sized(1.6F, 1.6F)
                    .build("frozen_bear"));

    public static final RegistryObject<EntityType<GlacialSkeletonEntity>> GLACIAL_SKELETON =
            ENTITY_TYPES.register("glacial_skeleton", () -> EntityType.Builder
                    .of(GlacialSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F)
                    .build("glacial_skeleton"));

    public static final RegistryObject<EntityType<NightDeerEntity>> NIGHT_DEER =
            ENTITY_TYPES.register("night_deer", () -> EntityType.Builder
                    .of(NightDeerEntity::new, MobCategory.CREATURE)
                    .sized(1.0F, 2.0F)
                    .build("night_deer"));

    public static final RegistryObject<EntityType<BorealGolemEntity>> BOREAL_GOLEM =
            ENTITY_TYPES.register("boreal_golem", () -> EntityType.Builder
                    .of(BorealGolemEntity::new, MobCategory.MONSTER)
                    .sized(1.0F, 2.1F)
                    .build("boreal_golem"));

    public static final RegistryObject<EntityType<GlacialSkeletonArrowEntity>> GLACIAL_ARROW =
            ENTITY_TYPES.register("glacial_arrow",
                    () -> EntityType.Builder.<GlacialSkeletonArrowEntity>of(GlacialSkeletonArrowEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("glacial_arrow"));

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

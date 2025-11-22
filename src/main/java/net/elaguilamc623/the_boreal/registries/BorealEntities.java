package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.entities.BorealRockEntity;
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

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

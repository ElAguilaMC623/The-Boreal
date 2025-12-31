package net.elaguilamc623.the_boreal.events;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheBoreal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BorealEntityEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BorealEntities.GLACIAL_ZOMBIE.get(),
                Zombie.createAttributes()
                        .add(Attributes.MAX_HEALTH, 40.0D)
                        .add(Attributes.ATTACK_DAMAGE, 4.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.23D)
                        .build()
        );
        event.put(BorealEntities.GLACIAL_WOLF.get(),
                Wolf.createAttributes()
                        .add(Attributes.MAX_HEALTH, 40.0D)
                        .add(Attributes.ATTACK_DAMAGE, 4.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.3D)
                        .build()
        );

        event.put(BorealEntities.FROZEN_BEAR.get(),
                Wolf.createAttributes()
                        .add(Attributes.MAX_HEALTH, 80.0D)
                        .add(Attributes.ATTACK_DAMAGE, 8.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.5D)
                        .build()
        );

        event.put(BorealEntities.GLACIAL_SKELETON.get(),
                Wolf.createAttributes()
                        .add(Attributes.MAX_HEALTH, 50.0D)
                        .add(Attributes.ATTACK_DAMAGE, 8.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.32D)
                        .add(Attributes.FOLLOW_RANGE, 30.0D)
                        .build()
        );

    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                BorealEntities.GLACIAL_ZOMBIE.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        pos.getY() < 55 && Monster.checkMonsterSpawnRules(entityType, level, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );

        event.register(
                BorealEntities.GLACIAL_SKELETON.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        pos.getY() < 55 && Monster.checkMonsterSpawnRules(entityType, level, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );

        event.register(
                BorealEntities.GLACIAL_WOLF.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        pos.getY() > level.getSeaLevel() &&
                                Animal.checkAnimalSpawnRules(entityType, level, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );

        event.register(
                BorealEntities.FROZEN_BEAR.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) ->
                        pos.getY() > level.getSeaLevel() &&
                                Animal.checkAnimalSpawnRules(entityType, level, spawnType, pos, random),
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
    }
}
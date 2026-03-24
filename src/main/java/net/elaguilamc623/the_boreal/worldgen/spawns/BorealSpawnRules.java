package net.elaguilamc623.the_boreal.worldgen.spawns;

import net.elaguilamc623.the_boreal.registries.BorealTags;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

public class BorealSpawnRules {
    public static boolean frozenBearRules(EntityType<? extends Mob> type,
                                          LevelAccessor level,
                                          MobSpawnType spawnType,
                                          BlockPos pos,
                                          RandomSource random) {

        ServerLevelAccessor serverLevel = (ServerLevelAccessor) level;
        if (!Monster.checkMonsterSpawnRules((EntityType<? extends Monster>) type, serverLevel, spawnType, pos, random))
            return false;

        if (!level.getBlockState(pos.below()).is(BorealTags.MOBS_SPAWNABLE_ON)) return false;

        if (!level.getBlockState(pos).getCollisionShape(level, pos).isEmpty())
            return false;

        return true;
    }

    public static boolean glacialWolfRules(EntityType<? extends Mob> type,
                                           LevelAccessor level,
                                           MobSpawnType spawnType,
                                           BlockPos pos,
                                           RandomSource random) {

        ServerLevelAccessor serverLevel = (ServerLevelAccessor) level;

        if (!Mob.checkMobSpawnRules(type, serverLevel, spawnType, pos, random))
            return false;

        if (!level.getBlockState(pos.below()).is(BorealTags.MOBS_SPAWNABLE_ON))
            return false;

        if (!level.getBlockState(pos).getCollisionShape(level, pos).isEmpty())
            return false;

        return true;
    }

    public static boolean nightDeerRules(EntityType<? extends Mob> type,
                                         LevelAccessor level,
                                         MobSpawnType spawnType,
                                         BlockPos pos,
                                         RandomSource random) {

        ServerLevelAccessor serverLevel = (ServerLevelAccessor) level;

        if (!Mob.checkMobSpawnRules(type, serverLevel, spawnType, pos, random))
            return false;

        if (!level.getBlockState(pos.below()).is(BorealTags.MOBS_SPAWNABLE_ON))
            return false;

        if (!level.getBlockState(pos).getCollisionShape(level, pos).isEmpty())
            return false;

        return true;
    }
}

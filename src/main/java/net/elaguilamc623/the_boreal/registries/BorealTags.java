package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BorealTags {
    public static class Blocks {
        public static final TagKey<Block> AURORA_SAPLING_CAN_PLANT_ON =
                BlockTags.create(new ResourceLocation(TheBoreal.MOD_ID, "aurora_sapling_can_plant_on"));
    }

    public static final TagKey<Block> TREE_REPLACEABLE =
            TagKey.create(Registries.BLOCK, new ResourceLocation(TheBoreal.MOD_ID, "tree_replaceable")
    );
}

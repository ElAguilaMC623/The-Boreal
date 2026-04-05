package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BorealTags {
    public static class Blocks {
        public static final TagKey<Block> AURORA_SAPLING_CAN_PLANT_ON =
                BlockTags.create(new ResourceLocation(TheBoreal.MOD_ID, "aurora_sapling_can_plant_on"));
    }

    public static final TagKey<Block> TREE_REPLACEABLE =
            TagKey.create(Registries.BLOCK, new ResourceLocation(TheBoreal.MOD_ID, "tree_replaceable"));

    public static final TagKey<Item> STICKS =
            TagKey.create(Registries.ITEM, new ResourceLocation("minecraft", "sticks"));

    public static final TagKey<Item> BOREAL_STICKS =
            TagKey.create(Registries.ITEM, new ResourceLocation("the_boreal", "boreal_sticks"));

    public static final TagKey<Item> BOREAL_WEAPONS =
            TagKey.create(Registries.ITEM, new ResourceLocation("the_boreal", "boreal_weapons"));

    public static final TagKey<Block> NEEDS_TALISMANDIUM_TOOL =
            TagKey.create(Registries.BLOCK, new ResourceLocation("the_boreal", "needs_talismandium_tool"));

    public static final TagKey<Block> NEEDS_CHRODIUM_TOOL =
            TagKey.create(Registries.BLOCK, new ResourceLocation("the_boreal", "needs_chrodium_tool"));

    public static final TagKey<Block> NEEDS_DIORIUM_TOOL =
            TagKey.create(Registries.BLOCK, new ResourceLocation("the_boreal", "needs_diorium_tool"));

    public static final TagKey<Block> MOBS_SPAWNABLE_ON =
            TagKey.create(Registries.BLOCK, new ResourceLocation("the_boreal", "mobs_spawnable_on"));

    public static final TagKey<Block> CAN_SUSTAIN_ON_GLACIAL_GRASS =
            TagKey.create(Registries.BLOCK, new ResourceLocation("the_boreal", "can_sustain_on_glacial_grass"));

    public static final TagKey<Item> CRYSTALIZED_FOX_FOOD =
            TagKey.create(Registries.ITEM, new ResourceLocation("the_boreal", "crystalized_fox_food"));

    public static final TagKey<EntityType<?>> BOREAL_MOBS =
            TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(TheBoreal.MOD_ID, "boreal_mobs"));
}

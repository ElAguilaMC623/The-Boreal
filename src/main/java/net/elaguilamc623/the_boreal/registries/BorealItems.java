package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.entities.custom.boats.BorealBoatEntity;
import net.elaguilamc623.the_boreal.items.BorealFoodProperties;
import net.elaguilamc623.the_boreal.items.BorealItemProperties;
import net.elaguilamc623.the_boreal.items.custom.*;
import net.elaguilamc623.the_boreal.items.custom.weapons.*;
import net.elaguilamc623.the_boreal.items.tiers.BorealArmorMaterials;
import net.elaguilamc623.the_boreal.items.tiers.BorealTiers;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheBoreal.MOD_ID);


    public static final RegistryObject<Item> ANCIENT_ICE_FRAGMENT = ITEMS.register("ancient_ice_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FROZEN_AMULET = ITEMS.register("frozen_amulet",
            () -> new FrozenAmuletItem(new Item.Properties()));

    public static final RegistryObject<Item> BOREAL_ROCK = ITEMS.register("boreal_rock",
            () -> new BorealRockItem(new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_SEED = ITEMS.register("glacial_seed",
            () -> new GlacialSeedItem(BorealBlocks.GLACIAL_WHEAT_PLANT.get(), new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_WHEAT = ITEMS.register("glacial_wheat",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_BREAD = ITEMS.register("glacial_bread",
            () -> new Item(new Item.Properties().food(BorealFoodProperties.GLACIAL_BREAD)));

    public static final RegistryObject<Item> GLACIAL_ZOMBIE_SPAWN_EGG = ITEMS.register("glacial_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.GLACIAL_ZOMBIE, 0x3A6BAF, 0xFFFFFFFF, new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_WOLF_SPAWN_EGG = ITEMS.register("glacial_wolf_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.GLACIAL_WOLF, 0xFFFFFFFF, 0x007dff, new Item.Properties()));

    public static final RegistryObject<Item> FROZEN_BEAR_SPAWN_EGG = ITEMS.register("frozen_bear_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.FROZEN_BEAR, 0x00a972, 0xa94289, new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_SKELETON_SPAWN_EGG = ITEMS.register("glacial_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.GLACIAL_SKELETON, 0xFFFFFFFF, 0x40E0D0, new Item.Properties()));

    public static final RegistryObject<Item> NIGHT_DEER_SPAWN_EGG = ITEMS.register("night_deer_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.NIGHT_DEER, 0x5d296f, 0x26d2d6, new Item.Properties()));

    public static final RegistryObject<Item> GLACIAL_ROTTEN_FLESH = ITEMS.register("glacial_rotten_flesh",
            () -> new Item(new Item.Properties().food(BorealFoodProperties.GLACIAL_ROTTEN_FLESH)));

    public static final RegistryObject<Item> GLACIAL_BONE = ITEMS.register("glacial_bone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AURORAL_STICK = ITEMS.register("auroral_stick",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AURORA_SAPLING_ITEM = ITEMS.register("aurora_sapling",
            () -> new BlockItem(BorealBlocks.AURORA_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<Item> AURORAL_SIGN = ITEMS.register("auroral_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BorealBlocks.AURORAL_SIGN.get(), BorealBlocks.AURORAL_WALL_SIGN.get()));

    public static final RegistryObject<Item> AURORAL_HANGING_SIGN = ITEMS.register("auroral_hanging_sign",
            () -> new HangingSignItem(BorealBlocks.AURORAL_HANGING_SIGN.get(), BorealBlocks.AURORAL_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> AURORAL_BOAT = ITEMS.register("auroral_boat",
            () -> new BorealBoatItem(false, BorealBoatEntity.Type.AURORAL, new Item.Properties()));

    public static final RegistryObject<Item> AURORAL_CHEST_BOAT = ITEMS.register("auroral_chest_boat",
            () -> new BorealBoatItem(true, BorealBoatEntity.Type.AURORAL, new Item.Properties()));

    public static final RegistryObject<Item> RAW_TALISMANDIUM = ITEMS.register("raw_talismandium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_INGOT = ITEMS.register("talismandium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_NUGGET = ITEMS.register("talismandium_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM = ITEMS.register("chrodium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_DIORIUM = ITEMS.register("raw_diorium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIORIUM_INGOT = ITEMS.register("diorium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIORIUM_GEM = ITEMS.register("diorium_gem",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> TALISMANDIUM_SWORD = ITEMS.register("talismandium_sword",
            () -> new SwordItem(BorealTiers.TALISMANDIUM, 6, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_PICKAXE = ITEMS.register("talismandium_pickaxe",
            () -> new PickaxeItem(BorealTiers.TALISMANDIUM, 4, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_AXE = ITEMS.register("talismandium_axe",
            () -> new AxeItem(BorealTiers.TALISMANDIUM, 8, -3.0F, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_SHOVEL = ITEMS.register("talismandium_shovel",
            () -> new ShovelItem(BorealTiers.TALISMANDIUM, 4.5F, -3.0F, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_HOE = ITEMS.register("talismandium_hoe",
            () -> new HoeItem(BorealTiers.TALISMANDIUM, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_SWORD = ITEMS.register("chrodium_sword",
            () -> new SwordItem(BorealTiers.CHRODIUM, 7, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_PICKAXE = ITEMS.register("chrodium_pickaxe",
            () -> new PickaxeItem(BorealTiers.CHRODIUM, 5, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_AXE = ITEMS.register("chrodium_axe",
            () -> new AxeItem(BorealTiers.CHRODIUM, 8.5F, -2.9F, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_SHOVEL = ITEMS.register("chrodium_shovel",
            () -> new ShovelItem(BorealTiers.CHRODIUM, 6, -3.0F, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_HOE = ITEMS.register("chrodium_hoe",
            () -> new HoeItem(BorealTiers.CHRODIUM, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> DIORIUM_SWORD = ITEMS.register("diorium_sword",
            () -> new BorealSwordItem(BorealTiers.DIORIUM, 9, -2.4F, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_PICKAXE = ITEMS.register("diorium_pickaxe",
            () -> new BorealPickaxeItem(BorealTiers.DIORIUM, 7, -2.8F, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_AXE = ITEMS.register("diorium_axe",
            () -> new BorealAxeItem(BorealTiers.DIORIUM, 10, -2.9F, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_SHOVEL = ITEMS.register("diorium_shovel",
            () -> new BorealShovelItem(BorealTiers.DIORIUM, 7.5F, -3.0F, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_HOE = ITEMS.register("diorium_hoe",
            () -> new BorealHoeItem(BorealTiers.DIORIUM, 0, 0, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> TALISMANDIUM_HELMET = ITEMS.register("talismandium_helmet",
            () -> new ArmorItem(BorealArmorMaterials.TALISMANDIUM, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_CHESTPLATE = ITEMS.register("talismandium_chestplate",
            () -> new ArmorItem(BorealArmorMaterials.TALISMANDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_LEGGINGS = ITEMS.register("talismandium_leggings",
            () -> new ArmorItem(BorealArmorMaterials.TALISMANDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> TALISMANDIUM_BOOTS = ITEMS.register("talismandium_boots",
            () -> new ArmorItem(BorealArmorMaterials.TALISMANDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_HELMET = ITEMS.register("chrodium_helmet",
            () -> new ArmorItem(BorealArmorMaterials.CHRODIUM, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_CHESTPLATE = ITEMS.register("chrodium_chestplate",
            () -> new ArmorItem(BorealArmorMaterials.CHRODIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_LEGGINGS = ITEMS.register("chrodium_leggings",
            () -> new ArmorItem(BorealArmorMaterials.CHRODIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> CHRODIUM_BOOTS = ITEMS.register("chrodium_boots",
            () -> new ArmorItem(BorealArmorMaterials.CHRODIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DIORIUM_HELMET = ITEMS.register("diorium_helmet",
            () -> new BorealArmorItem(BorealArmorMaterials.DIORIUM, ArmorItem.Type.HELMET, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_CHESTPLATE = ITEMS.register("diorium_chestplate",
            () -> new BorealArmorItem(BorealArmorMaterials.DIORIUM, ArmorItem.Type.CHESTPLATE, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_LEGGINGS = ITEMS.register("diorium_leggings",
            () -> new BorealArmorItem(BorealArmorMaterials.DIORIUM, ArmorItem.Type.LEGGINGS, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> DIORIUM_BOOTS = ITEMS.register("diorium_boots",
            () -> new BorealArmorItem(BorealArmorMaterials.DIORIUM, ArmorItem.Type.BOOTS, new BorealItemProperties().unbreakable().stacksTo(1)));

    public static final RegistryObject<Item> GLACIAL_TORCH_ITEM = ITEMS.register("glacial_torch",
            () -> new StandingAndWallBlockItem(BorealBlocks.GLACIAL_TORCH.get(), BorealBlocks.GLACIAL_WALL_TORCH.get(), new Item.Properties(), Direction.DOWN));

    public static final RegistryObject<Item> GLACIAL_CRYSTAL_SHARD = ITEMS.register("glacial_crystal_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BOREAL_ESSENCE = ITEMS.register("boreal_essence",
            () -> new BorealEssenceItem(new Item.Properties().rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

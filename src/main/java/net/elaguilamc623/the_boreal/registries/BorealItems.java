package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.complementary_core.utils.armors.ArmorSetBuilder;
import net.elaguilamc623.complementary_core.utils.weapons.ToolSetBuilder;
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
            () -> new FrozenAmuletItem(new Item.Properties().rarity(Rarity.RARE)));

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

    public static final RegistryObject<Item> BOREAL_GOLEM_SPAWN_EGG = ITEMS.register("boreal_golem_spawn_egg",
            () -> new ForgeSpawnEggItem(BorealEntities.BOREAL_GOLEM, 0x1A2E4A, 0x0D1A2B, new Item.Properties()));

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

    public static final ToolSetBuilder TALISMANDIUM_TOOLS = ToolSetBuilder.create("talismandium",
            BorealItems.ITEMS, BorealTiers.TALISMANDIUM).sword().axe().pickaxe().shovel().hoe();

    public static final ToolSetBuilder CHRODIUM_TOOLS = ToolSetBuilder.create("chrodium",
            BorealItems.ITEMS, BorealTiers.CHRODIUM).sword().axe().pickaxe().shovel().hoe();

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

    public static final ArmorSetBuilder TALISMANDIUM_ARMOR = ArmorSetBuilder.create("talismandium",
            BorealItems.ITEMS, BorealArmorMaterials.TALISMANDIUM).helmet().chestplate().leggings().boots();

    public static final ArmorSetBuilder CHRODIUM_ARMOR = ArmorSetBuilder.create("chrodium",
            BorealItems.ITEMS, BorealArmorMaterials.CHRODIUM).helmet().chestplate().leggings().boots();

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

    public static final RegistryObject<Item> BOREAL_SHARD = ITEMS.register("boreal_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PRISON_LOCATOR = ITEMS.register("prison_locator",
            () -> new PrisonLocatorItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        TALISMANDIUM_TOOLS.register();
        CHRODIUM_TOOLS.register();
        TALISMANDIUM_ARMOR.register();
        CHRODIUM_ARMOR.register();
    }
}

package net.elaguilamc623.the_boreal.registries;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class BorealCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.
            create(Registries.CREATIVE_MODE_TAB, TheBoreal.MOD_ID);

    public static RegistryObject<CreativeModeTab> BOREAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_items_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealItems.ANCIENT_ICE_FRAGMENT.get()))
                            .title(Component.literal("The Boreal Items"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealItems.ANCIENT_ICE_FRAGMENT.get());
                                pOutput.accept(BorealItems.FROZEN_AMULET.get());
                                pOutput.accept(BorealItems.BOREAL_ROCK.get());
                                pOutput.accept(BorealItems.GLACIAL_CRYSTAL_SHARD.get());
                                pOutput.accept(BorealItems.AURORAL_STICK.get());
                                pOutput.accept(BorealItems.GLACIAL_BREAD.get());
                                pOutput.accept(BorealItems.NIGHT_HORNS.get());
                                pOutput.accept(BorealItems.NIGHT_MEAT.get());
                                pOutput.accept(BorealItems.COOKED_NIGHT_MEAT.get());
                                pOutput.accept(BorealItems.FROZEN_FUR.get());
                                pOutput.accept(BorealItems.RAW_TALISMANDIUM.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_INGOT.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_NUGGET.get());
                                pOutput.accept(BorealItems.CHRODIUM.get());
                                pOutput.accept(BorealItems.RAW_DIORIUM.get());
                                pOutput.accept(BorealItems.DIORIUM_INGOT.get());
                                pOutput.accept(BorealItems.DIORIUM_GEM.get());
                                pOutput.accept(BorealItems.BOREAL_ESSENCE.get());
                                pOutput.accept(BorealItems.BOREAL_SHARD.get());
                                pOutput.accept(BorealItems.PRISON_LOCATOR.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_TOOLS_COMBAT_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_tools_combat_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealItems.TALISMANDIUM_TOOLS.getSword().get()))
                            .title(Component.literal("The Boreal Tools and Combat"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealItems.TALISMANDIUM_TOOLS.getSword().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_TOOLS.getPickaxe().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_TOOLS.getAxe().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_TOOLS.getShovel().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_TOOLS.getHoe().get());
                                pOutput.accept(BorealItems.CHRODIUM_TOOLS.getSword().get());
                                pOutput.accept(BorealItems.CHRODIUM_TOOLS.getPickaxe().get());
                                pOutput.accept(BorealItems.CHRODIUM_TOOLS.getAxe().get());
                                pOutput.accept(BorealItems.CHRODIUM_TOOLS.getShovel().get());
                                pOutput.accept(BorealItems.CHRODIUM_TOOLS.getHoe().get());
                                pOutput.accept(BorealItems.DIORIUM_SWORD.get());
                                pOutput.accept(BorealItems.DIORIUM_PICKAXE.get());
                                pOutput.accept(BorealItems.DIORIUM_AXE.get());
                                pOutput.accept(BorealItems.DIORIUM_SHOVEL.get());
                                pOutput.accept(BorealItems.DIORIUM_HOE.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_ARMOR.getHelmet().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_ARMOR.getChestplate().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_ARMOR.getLeggings().get());
                                pOutput.accept(BorealItems.TALISMANDIUM_ARMOR.getBoots().get());
                                pOutput.accept(BorealItems.CHRODIUM_ARMOR.getHelmet().get());
                                pOutput.accept(BorealItems.CHRODIUM_ARMOR.getChestplate().get());
                                pOutput.accept(BorealItems.CHRODIUM_ARMOR.getLeggings().get());
                                pOutput.accept(BorealItems.CHRODIUM_ARMOR.getBoots().get());
                                pOutput.accept(BorealItems.DIORIUM_HELMET.get());
                                pOutput.accept(BorealItems.DIORIUM_CHESTPLATE.get());
                                pOutput.accept(BorealItems.DIORIUM_LEGGINGS.get());
                                pOutput.accept(BorealItems.DIORIUM_BOOTS.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_NATURE_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_nature_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealItems.GLACIAL_WHEAT.get()))
                            .title(Component.literal("The Boreal Nature"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealBlocks.GLACIAL_GRASS_BLOCK.get());
                                pOutput.accept(BorealBlocks.GLACIAL_DIRT.get());
                                pOutput.accept(BorealBlocks.GLACIAL_GRASS.get());
                                pOutput.accept(BorealBlocks.GLACIAL_TALL_GRASS.get());
                                pOutput.accept(BorealBlocks.BOREALIGHT_SHROOM.get());
                                pOutput.accept(BorealBlocks.GLACIALIGHT_SHROOM.get());
                                pOutput.accept(BorealBlocks.GLACIAL_CRYSTAL.get());
                                pOutput.accept(BorealBlocks.PERMAFROST.get());
                                pOutput.accept(BorealItems.GLACIAL_SEED.get());
                                pOutput.accept(BorealItems.GLACIAL_WHEAT.get());
                                pOutput.accept(BorealItems.GLACIAL_BERRIES.get());
                                pOutput.accept(BorealItems.NIGHT_HORNS.get());
                                pOutput.accept(BorealItems.NIGHT_MEAT.get());
                                pOutput.accept(BorealItems.FROZEN_FUR.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE.get());
                                pOutput.accept(BorealBlocks.TARNITE.get());
                                pOutput.accept(BorealBlocks.VERNITE.get());
                                pOutput.accept(BorealBlocks.TALISMANDIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DEEP_TALISMANDIUM_ORE.get());
                                pOutput.accept(BorealBlocks.CHRODIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DEEP_CHRODIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DIORIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DEEP_DIORIUM_ORE.get());
                                pOutput.accept(BorealBlocks.AURORA_LOG.get());
                                pOutput.accept(BorealBlocks.AURORA_SAPLING.get());
                                pOutput.accept(BorealBlocks.AURORA_LEAVES.get());
                                pOutput.accept(BorealItems.GLACIAL_ROTTEN_FLESH.get());
                                pOutput.accept(BorealItems.GLACIAL_BONE.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_BUILDING_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_blocks_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealBlocks.BOREAL_STONE_BRICKS.get()))
                            .title(Component.literal("The Boreal Blocks"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealBlocks.BOREAL_COBBLESTONE.get());
                                pOutput.accept(BorealBlocks.BOREAL_COBBLESTONE_SLAB.get());
                                pOutput.accept(BorealBlocks.BOREAL_COBBLESTONE_STAIRS.get());
                                pOutput.accept(BorealBlocks.BOREAL_COBBLESTONE_WALL.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE_SLAB.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE_STAIRS.get());
                                pOutput.accept(BorealBlocks.BOREAL_DEEP_STONE.get());
                                pOutput.accept(BorealBlocks.BOREAL_DEEP_STONE_SLAB.get());
                                pOutput.accept(BorealBlocks.BOREAL_DEEP_STONE_STAIRS.get());
                                pOutput.accept(BorealBlocks.BOREAL_DEEP_STONE_WALL.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE_BRICKS.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE_BRICKS_SLAB.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE_BRICKS_STAIRS.get());
                                pOutput.accept(BorealBlocks.BOREAL_STONE_BRICK_WALL.get());
                                pOutput.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICKS.get());
                                pOutput.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB.get());
                                pOutput.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS.get());
                                pOutput.accept(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL.get());
                                pOutput.accept(BorealBlocks.BOREAL_CHISELED_STONE.get());
                                pOutput.accept(BorealBlocks.VERNITE.get());
                                pOutput.accept(BorealBlocks.VERNITE_SLAB.get());
                                pOutput.accept(BorealBlocks.VERNITE_STAIRS.get());
                                pOutput.accept(BorealBlocks.VERNITE_WALL.get());
                                pOutput.accept(BorealBlocks.POLISHED_VERNITE.get());
                                pOutput.accept(BorealBlocks.POLISHED_VERNITE_SLAB.get());
                                pOutput.accept(BorealBlocks.POLISHED_VERNITE_STAIRS.get());
                                pOutput.accept(BorealBlocks.TARNITE.get());
                                pOutput.accept(BorealBlocks.TARNITE_SLAB.get());
                                pOutput.accept(BorealBlocks.TARNITE_STAIRS.get());
                                pOutput.accept(BorealBlocks.TARNITE_WALL.get());
                                pOutput.accept(BorealBlocks.POLISHED_TARNITE.get());
                                pOutput.accept(BorealBlocks.POLISHED_TARNITE_SLAB.get());
                                pOutput.accept(BorealBlocks.POLISHED_TARNITE_STAIRS.get());
                                pOutput.accept(BorealBlocks.AURORA_LOG.get());
                                pOutput.accept(BorealBlocks.AURORA_WOOD.get());
                                pOutput.accept(BorealBlocks.STRIPPED_AURORA_LOG.get());
                                pOutput.accept(BorealBlocks.STRIPPED_AURORA_WOOD.get());
                                pOutput.accept(BorealBlocks.AURORA_PLANKS.get());
                                pOutput.accept(BorealBlocks.AURORAL_STAIRS.get());
                                pOutput.accept(BorealBlocks.AURORAL_SLAB.get());
                                pOutput.accept(BorealBlocks.AURORAL_FENCE.get());
                                pOutput.accept(BorealBlocks.AURORAL_FENCE_GATE.get());
                                pOutput.accept(BorealBlocks.AURORAL_DOOR.get());
                                pOutput.accept(BorealBlocks.AURORAL_TRAPDOOR.get());
                                pOutput.accept(BorealBlocks.AURORAL_BUTTON.get());
                                pOutput.accept(BorealBlocks.AURORAL_PRESSURE_PLATE.get());
                                pOutput.accept(BorealBlocks.TALISMANDIUM_BARS.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_FUNCTIONAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_functional_blocks_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealBlocks.BOREAL_ESSENCE_TABLE.get()))
                            .title(Component.literal("The Boreal Functional Blocks"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealBlocks.BOREAL_ESSENCE_TABLE.get());
                                pOutput.accept(BorealBlocks.BOREAL_INFUSER.get());
                                pOutput.accept(BorealItems.AURORAL_BOAT.get());
                                pOutput.accept(BorealItems.AURORAL_CHEST_BOAT.get());
                                pOutput.accept(BorealItems.AURORAL_SIGN.get());
                                pOutput.accept(BorealItems.AURORAL_HANGING_SIGN.get());
                                pOutput.accept(BorealItems.GLACIAL_TORCH_ITEM.get());
                                pOutput.accept(BorealBlocks.GLACIAL_LANTERN.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_ENTITIES_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_entities_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealItems.GLACIAL_ZOMBIE_SPAWN_EGG.get()))
                            .title(Component.literal("The Boreal Mobs"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealItems.GLACIAL_ZOMBIE_SPAWN_EGG.get());
                                pOutput.accept(BorealItems.GLACIAL_WOLF_SPAWN_EGG.get());
                                pOutput.accept(BorealItems.FROZEN_BEAR_SPAWN_EGG.get());
                                pOutput.accept(BorealItems.GLACIAL_SKELETON_SPAWN_EGG.get());
                                pOutput.accept(BorealItems.NIGHT_DEER_SPAWN_EGG.get());
                                pOutput.accept(BorealItems.BOREAL_GOLEM_SPAWN_EGG.get());
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

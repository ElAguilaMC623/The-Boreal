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
                                pOutput.accept(BorealItems.AURORAL_STICK.get());
                                pOutput.accept(BorealItems.RAW_TALISMANDIUM.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_INGOT.get());
                                pOutput.accept(BorealItems.CHRODIUM.get());
                                pOutput.accept(BorealItems.RAW_DIORIUM.get());
                                pOutput.accept(BorealItems.DIORIUM_INGOT.get());
                                pOutput.accept(BorealItems.AURORAL_BOAT.get());
                                pOutput.accept(BorealItems.AURORAL_CHEST_BOAT.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_TOOLS_COMBAT_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_tools_combat_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealItems.TALISMANDIUM_SWORD.get()))
                            .title(Component.literal("The Boreal Tools and Combat"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(BorealItems.TALISMANDIUM_SWORD.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_PICKAXE.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_AXE.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_SHOVEL.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_HOE.get());
                                pOutput.accept(BorealItems.CHRODIUM_SWORD.get());
                                pOutput.accept(BorealItems.CHRODIUM_PICKAXE.get());
                                pOutput.accept(BorealItems.CHRODIUM_AXE.get());
                                pOutput.accept(BorealItems.CHRODIUM_SHOVEL.get());
                                pOutput.accept(BorealItems.CHRODIUM_HOE.get());
                                pOutput.accept(BorealItems.DIORIUM_SWORD.get());
                                pOutput.accept(BorealItems.DIORIUM_PICKAXE.get());
                                pOutput.accept(BorealItems.DIORIUM_AXE.get());
                                pOutput.accept(BorealItems.DIORIUM_SHOVEL.get());
                                pOutput.accept(BorealItems.DIORIUM_HOE.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_HELMET.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_CHESTPLATE.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_LEGGINGS.get());
                                pOutput.accept(BorealItems.TALISMANDIUM_BOOTS.get());
                                pOutput.accept(BorealItems.CHRODIUM_HELMET.get());
                                pOutput.accept(BorealItems.CHRODIUM_CHESTPLATE.get());
                                pOutput.accept(BorealItems.CHRODIUM_LEGGINGS.get());
                                pOutput.accept(BorealItems.CHRODIUM_BOOTS.get());
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
                                pOutput.accept(BorealItems.GLACIAL_SEED.get());
                                pOutput.accept(BorealItems.GLACIAL_WHEAT.get());
                                pOutput.accept(BorealItems.GLACIAL_BREAD.get());
                                pOutput.accept(BorealBlocks.AURORA_SAPLING.get());
                                pOutput.accept(BorealBlocks.AURORA_LEAVES.get());
                            })
                            .build()
            );

    public static RegistryObject<CreativeModeTab> BOREAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("the_boreal_blocks_tab", () ->
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(BorealBlocks.BOREAL_STONE.get()))
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
                                pOutput.accept(BorealBlocks.TALISMANDIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DEEP_TALISMANDIUM_ORE.get());
                                pOutput.accept(BorealBlocks.CHRODIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DEEP_CHRODIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DIORIUM_ORE.get());
                                pOutput.accept(BorealBlocks.DEEP_DIORIUM_ORE.get());
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
                                pOutput.accept(BorealItems.AURORAL_SIGN.get());
                                pOutput.accept(BorealItems.AURORAL_HANGING_SIGN.get());
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
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

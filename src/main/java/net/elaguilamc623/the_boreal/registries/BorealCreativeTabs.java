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
                                pOutput.accept(BorealItems.AURORAL_BOAT.get());
                                pOutput.accept(BorealItems.AURORAL_CHEST_BOAT.get());
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
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

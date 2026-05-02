package net.elaguilamc623.the_boreal.datagen.models;

import net.elaguilamc623.complementary_core.datagen.models.CCItemModelProvider;
import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BorealItemModelProvider extends CCItemModelProvider {
    public BorealItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheBoreal.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(BorealItems.ANCIENT_ICE_FRAGMENT);
        simpleItem(BorealItems.FROZEN_AMULET);
        simpleItem(BorealItems.BOREAL_ROCK);
        simpleItem(BorealItems.GLACIAL_CRYSTAL_SHARD);
        simpleItem(BorealItems.PURIFIED_GLACIAL_CRYSTAL_SHARD);
        simpleItem(BorealItems.GLACIAL_SEED);
        simpleItem(BorealItems.GLACIAL_WHEAT);
        simpleItem(BorealItems.GLACIAL_BREAD);
        simpleItem(BorealItems.GLACIAL_ROTTEN_FLESH);
        simpleItem(BorealItems.GLACIAL_BONE);
        simpleItem(BorealItems.RAW_TALISMANDIUM);
        simpleItem(BorealItems.TALISMANDIUM_INGOT);
        simpleItem(BorealItems.TALISMANDIUM_NUGGET);
        simpleItem(BorealItems.CHRODIUM);
        simpleItem(BorealItems.RAW_DIORIUM);
        simpleItem(BorealItems.DIORIUM_INGOT);
        simpleItem(BorealItems.DIORIUM_GEM);
        simpleItem(BorealItems.AURORAL_SIGN);
        simpleItem(BorealItems.AURORAL_HANGING_SIGN);
        simpleItem(BorealItems.AURORAL_BOAT);
        simpleItem(BorealItems.AURORAL_CHEST_BOAT);
        simpleItem(BorealItems.BOREAL_ESSENCE);
        simpleItem(BorealItems.BOREAL_SHARD);
        simpleItem(BorealItems.BOREAL_ENCHANTED_SHARD);
        simpleItem(BorealItems.PRISON_LOCATOR);
        simpleItem(BorealItems.GLACIAL_BERRIES);
        simpleItem(BorealItems.NIGHT_HORNS);
        simpleItem(BorealItems.NIGHT_MEAT);
        simpleItem(BorealItems.COOKED_NIGHT_MEAT);
        simpleItem(BorealItems.FROZEN_FUR);
        simpleItem(BorealItems.GLACIAL_STAR_AMULET);
        simpleItem(BorealItems.NOCTURNAL_CREAM);

        handheldItem(BorealItems.AURORAL_STICK);
        handheldItem(BorealItems.GLACIAL_TORCH_ITEM);
        handheldItem(BorealItems.TALISMANDIUM_TOOLS.getSword());
        handheldItem(BorealItems.TALISMANDIUM_TOOLS.getPickaxe());
        handheldItem(BorealItems.TALISMANDIUM_TOOLS.getAxe());
        handheldItem(BorealItems.TALISMANDIUM_TOOLS.getShovel());
        handheldItem(BorealItems.TALISMANDIUM_TOOLS.getHoe());
        handheldItem(BorealItems.CHRODIUM_TOOLS.getSword());
        handheldItem(BorealItems.CHRODIUM_TOOLS.getPickaxe());
        handheldItem(BorealItems.CHRODIUM_TOOLS.getAxe());
        handheldItem(BorealItems.CHRODIUM_TOOLS.getShovel());
        handheldItem(BorealItems.CHRODIUM_TOOLS.getHoe());
        handheldItem(BorealItems.DIORIUM_SWORD);
        handheldItem(BorealItems.DIORIUM_PICKAXE);
        handheldItem(BorealItems.DIORIUM_AXE);
        handheldItem(BorealItems.DIORIUM_SHOVEL);
        handheldItem(BorealItems.DIORIUM_HOE);
        handheldItem(BorealItems.BOREAL_SUMMONER_STAFF);

        trimmedArmorItem(BorealItems.TALISMANDIUM_ARMOR.getHelmet());
        trimmedArmorItem(BorealItems.TALISMANDIUM_ARMOR.getChestplate());
        trimmedArmorItem(BorealItems.TALISMANDIUM_ARMOR.getLeggings());
        trimmedArmorItem(BorealItems.TALISMANDIUM_ARMOR.getBoots());
        trimmedArmorItem(BorealItems.CHRODIUM_ARMOR.getHelmet());
        trimmedArmorItem(BorealItems.CHRODIUM_ARMOR.getChestplate());
        trimmedArmorItem(BorealItems.CHRODIUM_ARMOR.getLeggings());
        trimmedArmorItem(BorealItems.CHRODIUM_ARMOR.getBoots());
        trimmedArmorItem(BorealItems.DIORIUM_HELMET);
        trimmedArmorItem(BorealItems.DIORIUM_CHESTPLATE);
        trimmedArmorItem(BorealItems.DIORIUM_LEGGINGS);
        trimmedArmorItem(BorealItems.DIORIUM_BOOTS);

        withExistingParent(BorealItems.GLACIAL_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.GLACIAL_SKELETON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.GLACIAL_WOLF_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.FROZEN_BEAR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.NIGHT_DEER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.CRYSTALIZED_FOX_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.NOCTURNAL_CUBE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.BOREAL_GOLEM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.SUMMONED_BOREAL_GOLEM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.GREAT_BOREAL_GOLEM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        wallItem(BorealBlocks.BOREAL_COBBLESTONE_WALL, BorealBlocks.BOREAL_COBBLESTONE);
        wallItem(BorealBlocks.BOREAL_DEEP_STONE_WALL, BorealBlocks.BOREAL_DEEP_STONE);
        wallItem(BorealBlocks.BOREAL_STONE_BRICK_WALL, BorealBlocks.BOREAL_STONE_BRICKS);
        wallItem(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_WALL, BorealBlocks.BOREAL_MOSSY_STONE_BRICKS);
        wallItem(BorealBlocks.VERNITE_WALL, BorealBlocks.VERNITE);
        wallItem(BorealBlocks.TARNITE_WALL, BorealBlocks.TARNITE);

        evenSimplerBlockItem(BorealBlocks.BOREAL_COBBLESTONE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.BOREAL_COBBLESTONE_SLAB);
        evenSimplerBlockItem(BorealBlocks.BOREAL_STONE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.BOREAL_STONE_SLAB);
        evenSimplerBlockItem(BorealBlocks.BOREAL_DEEP_STONE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.BOREAL_DEEP_STONE_SLAB);
        evenSimplerBlockItem(BorealBlocks.BOREAL_STONE_BRICKS_STAIRS);
        evenSimplerBlockItem(BorealBlocks.BOREAL_STONE_BRICKS_SLAB);
        evenSimplerBlockItem(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(BorealBlocks.BOREAL_MOSSY_STONE_BRICK_SLAB);
        evenSimplerBlockItem(BorealBlocks.AURORAL_STAIRS);
        evenSimplerBlockItem(BorealBlocks.AURORAL_SLAB);
        evenSimplerBlockItem(BorealBlocks.AURORAL_FENCE_GATE);
        evenSimplerBlockItem(BorealBlocks.AURORAL_PRESSURE_PLATE);
        evenSimplerBlockItem(BorealBlocks.VERNITE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.VERNITE_SLAB);
        evenSimplerBlockItem(BorealBlocks.POLISHED_VERNITE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.POLISHED_VERNITE_SLAB);
        evenSimplerBlockItem(BorealBlocks.TARNITE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.TARNITE_SLAB);
        evenSimplerBlockItem(BorealBlocks.POLISHED_TARNITE_STAIRS);
        evenSimplerBlockItem(BorealBlocks.POLISHED_TARNITE_SLAB);

        simpleBlockItem(BorealBlocks.AURORAL_DOOR);

        fenceItem(BorealBlocks.AURORAL_FENCE, BorealBlocks.AURORA_PLANKS);
        buttonItem(BorealBlocks.AURORAL_BUTTON, BorealBlocks.AURORA_PLANKS);
        trapdoorItem(BorealBlocks.AURORAL_TRAPDOOR);

        withExistingParent("boreal_essence_table",
                modLoc("block/boreal_essence_table"));
        withExistingParent("boreal_infuser",
                modLoc("block/boreal_infuser"));

        singleTexture(
                BorealBlocks.TALISMANDIUM_BARS.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/talismandium_bars")
        );

        singleTexture(
                BorealBlocks.GLACIAL_TALL_GRASS.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/glacial_tall_grass_top")
        );

        singleTexture(
                BorealBlocks.NOCTURNAL_GRASS.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/nocturnal_grass")
        );

        singleTexture(
                BorealBlocks.NOCTURNAL_TALL_GRASS.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/nocturnal_tall_grass_top")
        );

        singleTexture(
                BorealBlocks.BOREALIGHT_SHROOM.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/borealight_shroom")
        );

        singleTexture(
                BorealBlocks.GLACIALIGHT_SHROOM.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/glacialight_shroom")
        );

        singleTexture(
                BorealBlocks.STARLIGHT_SHROOM.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/starlight_shroom")
        );

        singleTexture(
                BorealBlocks.NOCTURNALIGHT_SHROOM.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/nocturnalight_shroom")
        );

        singleTexture(
                BorealBlocks.NOCTURNALWEED.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/nocturnalweed")
        );

        singleTexture(
                BorealBlocks.GLACIALWEED.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/glacialweed")
        );

        singleTexture(
                BorealBlocks.NOCTURNAL_FUNGUS.getId().getPath(),
                mcLoc("item/generated"),
                "layer0",
                modLoc("block/nocturnal_fungus")
        );

        withExistingParent(
                BorealBlocks.BOREAL_ALTAR.getId().getPath(),
                modLoc("block/boreal_altar")
        );
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheBoreal.MOD_ID, "item/" + item.getId().getPath()));

    }

    public void torchItem(Block torch) {
        String name = ForgeRegistries.BLOCKS.getKey(torch).getPath();
        withExistingParent(name, modLoc("block/" + name));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TheBoreal.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}

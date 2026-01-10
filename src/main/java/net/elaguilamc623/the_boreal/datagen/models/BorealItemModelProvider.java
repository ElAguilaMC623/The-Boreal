package net.elaguilamc623.the_boreal.datagen.models;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class BorealItemModelProvider extends ItemModelProvider {
    public BorealItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheBoreal.MOD_ID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    @Override
    protected void registerModels() {
        simpleItem(BorealItems.ANCIENT_ICE_FRAGMENT);
        simpleItem(BorealItems.FROZEN_AMULET);
        simpleItem(BorealItems.BOREAL_ROCK);
        simpleItem(BorealItems.GLACIAL_SEED);
        simpleItem(BorealItems.GLACIAL_WHEAT);
        simpleItem(BorealItems.GLACIAL_BREAD);
        simpleItem(BorealItems.GLACIAL_ROTTEN_FLESH);
        simpleItem(BorealItems.GLACIAL_BONE);
        simpleItem(BorealItems.RAW_TALISMANDIUM);
        simpleItem(BorealItems.TALISMANDIUM_INGOT);
        simpleItem(BorealItems.CHRODIUM);
        simpleItem(BorealItems.RAW_DIORIUM);
        simpleItem(BorealItems.DIORIUM_INGOT);
        simpleItem(BorealItems.DIORIUM_GEM);
        simpleItem(BorealItems.AURORAL_SIGN);
        simpleItem(BorealItems.AURORAL_HANGING_SIGN);
        simpleItem(BorealItems.AURORAL_BOAT);
        simpleItem(BorealItems.AURORAL_CHEST_BOAT);

        handheldItem(BorealItems.AURORAL_STICK);
        handheldItem(BorealItems.TALISMANDIUM_SWORD);
        handheldItem(BorealItems.TALISMANDIUM_PICKAXE);
        handheldItem(BorealItems.TALISMANDIUM_AXE);
        handheldItem(BorealItems.TALISMANDIUM_SHOVEL);
        handheldItem(BorealItems.TALISMANDIUM_HOE);
        handheldItem(BorealItems.CHRODIUM_SWORD);
        handheldItem(BorealItems.CHRODIUM_PICKAXE);
        handheldItem(BorealItems.CHRODIUM_AXE);
        handheldItem(BorealItems.CHRODIUM_SHOVEL);
        handheldItem(BorealItems.CHRODIUM_HOE);
        handheldItem(BorealItems.DIORIUM_SWORD);
        handheldItem(BorealItems.DIORIUM_PICKAXE);
        handheldItem(BorealItems.DIORIUM_AXE);
        handheldItem(BorealItems.DIORIUM_SHOVEL);
        handheldItem(BorealItems.DIORIUM_HOE);

        trimmedArmorItem(BorealItems.TALISMANDIUM_HELMET);
        trimmedArmorItem(BorealItems.TALISMANDIUM_CHESTPLATE);
        trimmedArmorItem(BorealItems.TALISMANDIUM_LEGGINGS);
        trimmedArmorItem(BorealItems.TALISMANDIUM_BOOTS);
        trimmedArmorItem(BorealItems.CHRODIUM_HELMET);
        trimmedArmorItem(BorealItems.CHRODIUM_CHESTPLATE);
        trimmedArmorItem(BorealItems.CHRODIUM_LEGGINGS);
        trimmedArmorItem(BorealItems.CHRODIUM_BOOTS);
        trimmedArmorItem(BorealItems.DIORIUM_HELMET);
        trimmedArmorItem(BorealItems.DIORIUM_CHESTPLATE);
        trimmedArmorItem(BorealItems.DIORIUM_LEGGINGS);
        trimmedArmorItem(BorealItems.DIORIUM_BOOTS);

        withExistingParent(BorealItems.GLACIAL_ZOMBIE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.GLACIAL_SKELETON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.GLACIAL_WOLF_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.FROZEN_BEAR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(BorealItems.NIGHT_DEER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

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
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TheBoreal.MOD_ID;

        withExistingParent(itemRegistryObject.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", new ResourceLocation(MOD_ID, "item/" + itemRegistryObject.getId().getPath()));

        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath);
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheBoreal.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TheBoreal.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TheBoreal.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(TheBoreal.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(TheBoreal.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(TheBoreal.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheBoreal.MOD_ID, "item/" + item.getId().getPath()));

    }
}

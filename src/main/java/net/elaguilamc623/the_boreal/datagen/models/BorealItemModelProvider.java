package net.elaguilamc623.the_boreal.datagen.models;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        simpleItem(BorealItems.RAW_TALISMANDIUM);
        simpleItem(BorealItems.TALISMANDIUM_INGOT);
        simpleItem(BorealItems.CHRODIUM);
        simpleItem(BorealItems.RAW_DIORIUM);
        simpleItem(BorealItems.DIORIUM_INGOT);

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

    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TheBoreal.MOD_ID;

        withExistingParent(itemRegistryObject.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", new ResourceLocation(MOD_ID, "item/" + itemRegistryObject.getId().getPath()));

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
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
                new ResourceLocation(TheBoreal.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TheBoreal.MOD_ID,"item/" + item.getId().getPath()));
    }
}

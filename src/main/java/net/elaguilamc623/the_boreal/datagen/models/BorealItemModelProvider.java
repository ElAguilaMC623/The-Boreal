package net.elaguilamc623.the_boreal.datagen.models;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BorealItemModelProvider extends ItemModelProvider {
    public BorealItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheBoreal.MOD_ID, existingFileHelper);
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

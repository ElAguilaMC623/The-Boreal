package net.elaguilamc623.the_boreal.datagen.models;

import net.elaguilamc623.the_boreal.TheBoreal;
import net.elaguilamc623.the_boreal.registries.BorealBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BorealBlockStateProvider extends BlockStateProvider {
    public BorealBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheBoreal.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BorealBlocks.TALISMANDIUM_ORE);
        blockWithItem(BorealBlocks.DEEP_TALISMANDIUM_ORE);
        blockWithItem(BorealBlocks.CHRODIUM_ORE);
        blockWithItem(BorealBlocks.DEEP_CHRODIUM_ORE);
        blockWithItem(BorealBlocks.DIORIUM_ORE);
        blockWithItem(BorealBlocks.DEEP_DIORIUM_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

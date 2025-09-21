package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ichorio.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_ENDERIUM_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.IGNAR_ORE);
        blockWithItem(ModBlocks.ENDERIUM_ORE);
        blockWithItem(ModBlocks.NETHERINE_ORE);
        blockWithItem(ModBlocks.ENDERIUM_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.ENDERIUM_BLOCK);
        blockWithItem(ModBlocks.NETHERINE_BLOCK);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

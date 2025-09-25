package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ichorio.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PRIMAL_STONE);
        blockWithItem(ModBlocks.ANCIENTWOOD_PLANKS);
        blockWithItem(ModBlocks.RAW_ENDERIUM_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.IGNAR_ORE);
        blockWithItem(ModBlocks.ENDERIUM_ORE);
        blockWithItem(ModBlocks.NETHERINE_ORE);
        blockWithItem(ModBlocks.ENDERIUM_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.ENDERIUM_BLOCK);
        blockWithItem(ModBlocks.NETHERINE_BLOCK);

        //ACIENTWOOD:
        stairsBlock(ModBlocks.ANCIENTWOOD_STAIRS.get(), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()));
        slabBlock(ModBlocks.ANCIENTWOOD_SLAB.get(), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()));
        buttonBlock(ModBlocks.ANCIENTWOOD_BUTTON.get(), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()));
        pressurePlateBlock(ModBlocks.ANCIENTWOOD_PLATE.get(), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()));
        fenceBlock(ModBlocks.ANCIENTWOOD_FENCE.get(), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()));
        fenceGateBlock(ModBlocks.ANCIENTWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.ANCIENTWOOD_PLANKS.get()));

        blockItem(ModBlocks.ANCIENTWOOD_STAIRS);
        blockItem(ModBlocks.ANCIENTWOOD_SLAB);
        blockItem(ModBlocks.ANCIENTWOOD_PLATE);
        blockItem(ModBlocks.ANCIENTWOOD_FENCE_GATE);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath() + appendix));
    }

}

package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.ModBlocks;
import net.amagitsyne.ichorio.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ichorio.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    basicItem(ModItems.RAW_ENDERIUM.get());
    basicItem(ModItems.CHISEL.get());
    basicItem(ModItems.ENDERIUM_INGOT.get());
    basicItem(ModItems.IGNAR.get());
    basicItem(ModItems.NETHERINE.get());

        buttonItem(ModBlocks.ANCIENTWOOD_BUTTON, ModBlocks.ANCIENTWOOD_PLANKS);
        fenceItem(ModBlocks.ANCIENTWOOD_BUTTON, ModBlocks.ANCIENTWOOD_PLANKS);
    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ichorio.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ichorio.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Ichorio.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}


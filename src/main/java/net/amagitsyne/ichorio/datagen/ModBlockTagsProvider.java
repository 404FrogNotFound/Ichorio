package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ichorio.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ENDERIUM_BLOCK.get())
                .add(ModBlocks.ENDERIUM_ORE.get())
                .add(ModBlocks.ENDERIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.RAW_ENDERIUM_BLOCK.get())
                .add(ModBlocks.NETHERINE_BLOCK.get())
                .add(ModBlocks.NETHERINE_ORE.get())
                .add(ModBlocks.IGNAR_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENDERIUM_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ENDERIUM_DEEPSLATE_ORE.get());

    }
    }

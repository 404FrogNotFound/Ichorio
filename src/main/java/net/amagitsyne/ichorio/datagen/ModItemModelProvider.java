package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}

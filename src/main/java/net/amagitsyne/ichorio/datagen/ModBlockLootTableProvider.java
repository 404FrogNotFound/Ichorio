package net.amagitsyne.ichorio.datagen;

import net.amagitsyne.ichorio.block.ModBlocks;
import net.amagitsyne.ichorio.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PRIMAL_STONE.get());
        dropSelf(ModBlocks.ENDERIUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_ENDERIUM_BLOCK.get());
        dropSelf(ModBlocks.NETHERINE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.IGNAR_ORE.get());

        //ANCIENTWOOD:
        dropSelf(ModBlocks.ANCIENTWOOD_PLANKS.get());
        dropSelf(ModBlocks.ANCIENTWOOD_STAIRS.get());
        add(ModBlocks.ANCIENTWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ANCIENTWOOD_SLAB.get()));
        dropSelf(ModBlocks.ANCIENTWOOD_FENCE.get());
        dropSelf(ModBlocks.ANCIENTWOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.ANCIENTWOOD_BUTTON.get());
        dropSelf(ModBlocks.ANCIENTWOOD_DOOR.get());
        dropSelf(ModBlocks.ANCIENTWOOD_TRAPDOOR.get());

        add(ModBlocks.ENDERIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ENDERIUM_ORE.get(), ModItems.RAW_ENDERIUM.get()));
        add(ModBlocks.ENDERIUM_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.ENDERIUM_DEEPSLATE_ORE.get(), ModItems.RAW_ENDERIUM.get()));
        add(ModBlocks.NETHERINE_ORE.get(),
                block -> createVariableOreDrop(block, ModItems.NETHERINE.get(), 2, 5));

    }

    protected LootTable.Builder createVariableOreDrop(Block block, Item item, int minDrop, int maxDrop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrop, maxDrop)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
        //Если ты это читаешь, ты милашка!
    }
}

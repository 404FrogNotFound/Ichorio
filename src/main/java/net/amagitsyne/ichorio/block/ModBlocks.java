package net.amagitsyne.ichorio.block;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.custom.MagicBlock;
import net.amagitsyne.ichorio.item.ModItems;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Ichorio.MOD_ID);

    public static final DeferredBlock<Block> ENDERIUM_BLOCK = registerBlock("enderium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(12F,1200.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RAW_ENDERIUM_BLOCK = registerBlock("raw_enderium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(12F,1200.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ENDERIUM_ORE = registerBlock("enderium_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of().strength(8F, 1200.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ENDERIUM_DEEPSLATE_ORE = registerBlock("enderium_deepslate_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of().strength(9.5F, 1200.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> NETHERINE_ORE = registerBlock("netherine_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(4.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> IGNAR_ORE = registerBlock("ignar_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(8F, 1200.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<Block> NETHERINE_BLOCK = registerBlock("netherine_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f, 6f).requiresCorrectToolForDrops()));

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
package net.amagitsyne.ichorio.item;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "ichorio");


    public static final Supplier<CreativeModeTab> Ichorio = CREATIVE_MODE_TAB.register("ichorio",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERIUM_INGOT.get()))
                            .title(Component.translatable("Ichorio"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModBlocks.PRIMAL_STONE);
                        output.accept(ModBlocks.NETHERINE_ORE);
                        output.accept(ModBlocks.IGNAR_ORE);
                        output.accept(ModBlocks.ENDERIUM_ORE);
                        output.accept(ModBlocks.ENDERIUM_DEEPSLATE_ORE);
                        output.accept(ModItems.RAW_ENDERIUM);
                        output.accept(ModBlocks.RAW_ENDERIUM_BLOCK);
                        output.accept(ModItems.NETHERINE);
                        output.accept(ModItems.IGNAR);
                        output.accept(ModItems.ENDERIUM_INGOT);
                        output.accept(ModBlocks.NETHERINE_BLOCK);
                        output.accept(ModBlocks.ENDERIUM_BLOCK);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModItems.CHISEL);

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

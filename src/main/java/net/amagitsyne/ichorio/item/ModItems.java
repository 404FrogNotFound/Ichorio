package net.amagitsyne.ichorio.item;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.item.custom.ChiselItem;
import net.amagitsyne.ichorio.item.custom.FuelItem;
import net.amagitsyne.ichorio.client.render.AnimatedText;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ichorio.MOD_ID);

    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.registerItem("enderium_ingot",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> RAW_ENDERIUM = ITEMS.registerItem("raw_enderium",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> NETHERINE = ITEMS.registerItem("netherine",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> IGNAR = ITEMS.register("ignar",
            () -> new FuelItem(new Item.Properties(), 3200) {

                @Override
                public Component getName(ItemStack stack) {
                    return Component.translatable(this.getDescriptionId(stack))
                            .withStyle(s -> s.withColor(TextColor.fromRgb(0xFFFACD)));
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext ctx,
                                            List<Component> tooltip, TooltipFlag flag) {
                    if (Screen.hasShiftDown()) {
                        String base = Component.translatable("tooltip.ichorio.ignar.shift_down").getString();
                        tooltip.add(AnimatedText.fireText(base));

                        super.appendHoverText(stack, ctx, tooltip, flag);
                    }
                }
            });
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

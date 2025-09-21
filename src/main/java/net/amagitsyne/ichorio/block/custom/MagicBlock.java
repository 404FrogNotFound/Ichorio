package net.amagitsyne.ichorio.block.custom;

import net.amagitsyne.ichorio.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MagicBlock extends Block {
    // Вместо Item — используем Supplier<Item>, чтобы не дёргать get() раньше времени
    private final Map<Supplier<Item>, Transformation> transformations;

    public MagicBlock(Properties properties) {
        super(properties);

        // Привязки предметов задаём здесь, безопасно
        this.transformations = Map.of(
                ModItems.RAW_ENDERIUM, new Transformation(ModItems.ENDERIUM_INGOT, 20)
        );
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getItem();

            // Проверяем по Supplier
            transformations.forEach((input, transformation) -> {
                if (stack.is(input.get()) && itemEntity.getAge() >= transformation.requiredAge) {
                    itemEntity.setItem(new ItemStack(transformation.result().get(), stack.getCount()));

                    // Эффект для красоты
                    level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_CHIME,
                            SoundSource.BLOCKS, 1f, 1f);
                }
            });
        }

        super.stepOn(level, pos, state, entity);
    }

    // Вспомогательная запись: результат и нужное время
    private record Transformation(Supplier<Item> result, int requiredAge) {}

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.ichorio.magic_block.tooltip")
                .withStyle(ChatFormatting.LIGHT_PURPLE));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

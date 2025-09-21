package net.amagitsyne.ichorio.client.render;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;

public class AnimatedText {
    private static int tick = 0;

    public static void clientTick() {
        tick++;
    }

    public static Component fireText(String text) {
        MutableComponent result = Component.literal("");

        int[] colors = {0xFF4500, 0xFF8C00, 0xFFA500, 0xFFD700, 0xFFFF00};
        int speed = 2; // замедление анимации

        int i = 0;
        for (char c : text.toCharArray()) {
            int colorIndex = (i + (tick / speed)) % colors.length;
            int color = colors[colorIndex];
            result = result.append(
                    Component.literal(String.valueOf(c))
                            .withStyle(s -> s.withColor(TextColor.fromRgb(color)))
            );
            i++;
        }
        return result;
    }
}
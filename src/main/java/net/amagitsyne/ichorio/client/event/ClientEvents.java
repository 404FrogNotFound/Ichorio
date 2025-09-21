package net.amagitsyne.ichorio.client.event;

import net.amagitsyne.ichorio.Ichorio;
import net.amagitsyne.ichorio.client.render.AnimatedText;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = Ichorio.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        AnimatedText.clientTick();
    }
}
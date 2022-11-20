package com.crispysynth.pooped.forge;

import com.crispysynth.pooped.registry.forge.EarlySoundEvents;
import com.crispysynth.pooped.Pooped;
import com.crispysynth.pooped.client.PoopedClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Pooped.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PoopedForgeClient {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        PoopedClient.init();
        EarlySoundEvents.init();
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }


}

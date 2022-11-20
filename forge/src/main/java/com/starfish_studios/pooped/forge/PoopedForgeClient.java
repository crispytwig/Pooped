package com.starfish_studios.pooped.forge;

import com.starfish_studios.pooped.Pooped;
import com.starfish_studios.pooped.client.PoopedClient;
import com.starfish_studios.pooped.registry.forge.EarlySoundEvents;
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

package com.crispysynth.pooped.fabric;

import com.crispysynth.pooped.client.PoopedClient;
import com.crispysynth.pooped.registry.PBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class PoopedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PoopedClient.init();
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                PBlocks.POOP.get(), PBlocks.GOLDEN_POOP.get()
        );
    }
}

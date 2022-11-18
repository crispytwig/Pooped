package com.starfish_studios.pooped.fabric;

import com.starfish_studios.pooped.client.PoopedClient;
import net.fabricmc.api.ClientModInitializer;

public class PoopedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PoopedClient.init();
//        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
//                AFBlocks.OAK_TABLE.get(),
//        );
    }
}

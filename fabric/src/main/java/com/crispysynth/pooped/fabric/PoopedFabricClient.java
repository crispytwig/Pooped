package com.crispysynth.pooped.fabric;

import com.crispysynth.pooped.client.PoopedClient;
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

package com.crispysynth.pooped.fabric;

import com.crispysynth.pooped.Pooped;
import net.fabricmc.api.ModInitializer;

public class PoopedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Pooped.init();
        Pooped.registerFlammables();
    }

}
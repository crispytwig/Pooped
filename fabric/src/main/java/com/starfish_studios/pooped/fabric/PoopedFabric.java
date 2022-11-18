package com.starfish_studios.pooped.fabric;

import com.starfish_studios.pooped.Pooped;
import net.fabricmc.api.ModInitializer;

public class PoopedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Pooped.init();
        Pooped.registerFlammables();
    }

}
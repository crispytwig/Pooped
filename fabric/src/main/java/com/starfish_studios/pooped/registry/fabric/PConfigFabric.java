package com.starfish_studios.pooped.registry.fabric;

import com.starfish_studios.pooped.Pooped;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Pooped.MOD_ID)
public class PConfigFabric implements ConfigData {

    public int poopSpawnWeight = 5;
}
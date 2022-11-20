package com.crispysynth.pooped.registry.fabric;

import com.crispysynth.pooped.Pooped;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Pooped.MOD_ID)
public class PConfigFabric implements ConfigData {

    public int poopSpawnWeight = 5;
}
package com.starfish_studios.pooped.registry;

import com.starfish_studios.pooped.Pooped;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class PSoundEvents {


    public static Supplier<SoundEvent> register(String name) {
        return PRegistry.registerSoundEvent(name, () -> new SoundEvent(new ResourceLocation(Pooped.MOD_ID, name)));
    }

    public static void init() {}
}

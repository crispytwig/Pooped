package com.crispysynth.pooped.registry.forge;

import com.crispysynth.pooped.Pooped;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class EarlySoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Pooped.MOD_ID);
    public static final Map<ResourceLocation, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

    public static final SoundEvent NOTE_BLOCK_FART = add("block.note_block.fart");

    private static SoundEvent add(String key) {
        ResourceLocation id = new ResourceLocation(Pooped.MOD_ID, key);
        SoundEvent sve = new SoundEvent(id);
        SOUND_EVENTS.put(id, sve);
        return sve;
    }

    public static void init() {
        SOUND_EVENTS.forEach((id, sve) -> {
            SOUNDS.register(id.getPath(), () -> sve);
        });
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

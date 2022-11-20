package com.crispysynth.pooped.mixin;

import com.crispysynth.pooped.registry.PBlockTags;
import com.crispysynth.pooped.registry.PRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Mixin(NoteBlockInstrument.class)
public class NoteBlockInstrumentMixin {
    @Final
    @Shadow
    @Mutable
    private static NoteBlockInstrument[] $VALUES;

    @Mutable
    @Shadow @Final private SoundEvent soundEvent;

    static {
        addVariant("FART", "fart", PRegistry.getFartSound());
    }

    @Invoker("<init>")
    public static NoteBlockInstrument invokeInit(String internalName, int internalId, String noteName, SoundEvent sound) {
        throw new AssertionError();
    }

    @Inject(method = "byState", at = @At("HEAD"), cancellable = true)
    private static void hookByState(BlockState state, CallbackInfoReturnable<NoteBlockInstrument> cir) {
        if (state.is(PBlockTags.POOP)) {
            cir.setReturnValue(NoteBlockInstrument.valueOf("FART"));
        }
    }

    private static void addVariant(String newName, String noteName, SoundEvent sound) {
        List<NoteBlockInstrument> variants = new ArrayList<>(Arrays.asList(NoteBlockInstrumentMixin.$VALUES));
        variants.add(invokeInit(newName, variants.get(variants.size() - 1).ordinal() + 1, noteName, sound));
        NoteBlockInstrumentMixin.$VALUES = variants.toArray(new NoteBlockInstrument[0]);
    }
}
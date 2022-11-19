package com.starfish_studios.pooped.mixin;

import com.starfish_studios.pooped.registry.PBlocks;
import com.starfish_studios.pooped.registry.PSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(NoteBlockInstrument.class)
    public class NoteBlockInstrumentMixin implements StringRepresentable {

    @Inject(method = "byState", at = @At("HEAD"), cancellable = true)
    private static void fromBlockState(BlockState state, CallbackInfoReturnable<SoundEvent> ci) {
        if (state.is(PBlocks.POOP_BLOCK.get()) || state.is(PBlocks.POOP_BRICKS.get())) {
            ci.setReturnValue(PSoundEvents.NOTE_BLOCK_FART);
        }
    }

    @Override
    public String getSerializedName() {
        return null;
    }
}
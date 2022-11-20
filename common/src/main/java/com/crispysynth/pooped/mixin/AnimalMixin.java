package com.crispysynth.pooped.mixin;

import com.crispysynth.pooped.registry.PBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Animal.class)
public class AnimalMixin extends AgeableMob {
    public int poopTime;

    protected AnimalMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "aiStep", at = @At("HEAD"))
    public void aiStep(CallbackInfo ci) {
        if (!this.level.isClientSide && this.isAlive() && !this.isBaby() && --this.poopTime <= 0 || this.isAlive() && this.isBaby() && --this.poopTime <= 0) {
            this.playSound(SoundEvents.HONEY_BLOCK_PLACE, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(PBlocks.POOP.get().asItem());
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.poopTime = this.random.nextInt(10000) + 10000;
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    @Override
    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }
}

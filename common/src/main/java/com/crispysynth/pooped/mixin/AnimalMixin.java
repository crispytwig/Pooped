package com.crispysynth.pooped.mixin;

import com.crispysynth.pooped.registry.PBlocks;
import com.crispysynth.pooped.util.block.PoopSpawningUtil;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Animal.class)
public class AnimalMixin extends AgeableMob {
    public int poopTime = this.random.nextInt(50) + 50;

    protected AnimalMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "aiStep", at = @At("HEAD"))
    public void aiStep(CallbackInfo ci) {
        if (!this.level.isClientSide && this.isAlive()) {
            if (this.poopTime <= 0) {
                this.playSound(SoundEvents.HONEY_BLOCK_PLACE, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                PoopSpawningUtil.trySetPoop(level, this, this.random);
                this.gameEvent(GameEvent.ENTITY_PLACE);
                this.poopTime = this.random.nextInt(5000) + 5000;
            } else {
                --this.poopTime;
            }
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }
}

package com.crispysynth.pooped.util.block;

import com.crispysynth.pooped.block.PoopBlock;
import com.crispysynth.pooped.registry.PBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class PoopSpawningUtil {
    public static void trySetPoop(Level level, AgeableMob entity, RandomSource random) {
//        if (!config.poopsSpawnAsItem) { TODO set up config
//            entity.spawnAtLocation(PBlocks.POOP.get().asItem());
//            return;
//        }
        BlockPos attemptLoc = getPosition(entity);
        if (!level.getBlockState(attemptLoc).getMaterial().isReplaceable()) {
            attemptLoc = entity.blockPosition();
            if (!level.getBlockState(attemptLoc).getMaterial().isReplaceable()) {
                return;
            }
        }
        level.setBlockAndUpdate(attemptLoc, getPoopState(entity, random));
        entity.playSound(SoundEvents.HONEY_BLOCK_PLACE, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
        entity.gameEvent(GameEvent.ENTITY_PLACE);
    }

    public static BlockPos getPosition(AgeableMob entity) {
        Vec3 loc = entity.position();
        float rotx = entity.getRotationVector().y;
        double forwards = -entity.getBoundingBox().getXsize() / 2;

        float x1 = Mth.cos((rotx + 90) * 0.017453292F);
        float z1 = Mth.sin((rotx + 90) * 0.017453292F);
        float x2 = (float) (x1 * forwards);
        float z2 = (float) (z1 * forwards);
        return new BlockPos(new Vec3(loc.x + x2, loc.y, loc.z + z2));
    }

    public static BlockState getPoopState(AgeableMob entity, RandomSource random) {
        if (random.nextInt(200) == 0) {
            return PBlocks.GOLDEN_POOP.get().defaultBlockState();
        };
        return PBlocks.POOP.get().defaultBlockState().setValue(PoopBlock.POOPS, getPoopSize(entity, random));
    }

    public static int getPoopSize(AgeableMob entity, RandomSource random) {
        double size = entity.getBoundingBox().getXsize() + entity.getBoundingBox().getYsize() + (entity.isBaby() ? -random.nextDouble() : random.nextDouble());
        return (int)Mth.clamp(size, 1, 3);
    }
}

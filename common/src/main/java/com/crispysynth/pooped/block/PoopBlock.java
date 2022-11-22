package com.crispysynth.pooped.block;

import com.crispysynth.pooped.block.properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PoopBlock extends Block {

    public static final IntegerProperty POOPS = ModBlockStateProperties.LEVEL_1_3;

    private static final VoxelShape ONE_AABB = Block.box(4.0, 0.0, 4.0, 12.0, 2.0, 12.0);
    private static final VoxelShape TWO_AABB = Block.box(3.0, 0.0, 3.0, 13.0, 5.0, 13.0);
    private static final VoxelShape THREE_AABB = Shapes.or(Block.box(1.0, 0.0, 1.0, 15.0, 4.0, 15.0), Block.box(3.0, 4.0, 3.0, 13.0, 9.0, 13.0));


    public PoopBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any()
                .setValue(ModBlockStateProperties.STEAMING, true));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().getItem() == this.asItem() && state.getValue(POOPS) < 3 || super.canBeReplaced(state, useContext);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean steaming = context.getPlayer() == null;
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.cycle(POOPS);
        } else {
            return super.getStateForPlacement(context).setValue(ModBlockStateProperties.STEAMING, steaming);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(POOPS)) {
            default -> ONE_AABB;
            case 2 -> TWO_AABB;
            case 3 -> THREE_AABB;
        };
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return Block.canSupportCenter(level, pos.below(), Direction.UP);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(ModBlockStateProperties.STEAMING) && random.nextInt(2) == 0) {
            level.setBlockAndUpdate(pos, state.setValue(ModBlockStateProperties.STEAMING, false));
        }
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        float chance = 0.95F;
        if (state.getValue(ModBlockStateProperties.STEAMING) && chance < random.nextFloat()) {
            double d = (float)pos.getX() + 0.5 + (random.nextFloat() - 0.5);
            double e = (float)pos.getY() + 0.8 + (random.nextFloat() - 0.5);
            double f = (float)pos.getZ() + 0.5 + (random.nextFloat() - 0.5);
            level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d, e, f, 0.0, 0.01, 0.0);

        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POOPS, ModBlockStateProperties.STEAMING);
    }


}

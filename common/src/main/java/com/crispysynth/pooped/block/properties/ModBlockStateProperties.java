package com.crispysynth.pooped.block.properties;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties {
    public static final IntegerProperty LEVEL_1_3 = IntegerProperty.create("level", 1, 3);
    public static final BooleanProperty STEAMING = BooleanProperty.create("steaming");
}
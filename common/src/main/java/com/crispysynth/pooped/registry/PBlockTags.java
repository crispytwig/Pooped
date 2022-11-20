package com.crispysynth.pooped.registry;

import com.crispysynth.pooped.Pooped;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PBlockTags {

    public static final TagKey<Block> POOP = blockTag("poop");

    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Pooped.MOD_ID, name));
    }
}

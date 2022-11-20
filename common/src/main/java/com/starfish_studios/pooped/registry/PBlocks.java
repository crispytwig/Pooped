package com.starfish_studios.pooped.registry;

import com.starfish_studios.pooped.Pooped;
import com.starfish_studios.pooped.block.GoldenPoopBlock;
import com.starfish_studios.pooped.block.PoopBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class PBlocks {

    public static final Supplier<Block> POOP = registerBlock("poop", () -> new PoopBlock(Block.Properties.of(Material.FROGSPAWN).randomTicks().strength(0.1F).sound(SoundType.HONEY_BLOCK).noOcclusion()));
    public static final Supplier<Block> GOLDEN_POOP = registerBlock("golden_poop", () -> new GoldenPoopBlock(Block.Properties.of(Material.METAL).strength(0.3F).sound(SoundType.METAL).lightLevel((state) -> 8).noOcclusion().emissiveRendering((state, level, pos) -> true)));

    public static final Supplier<Block> POOP_BLOCK = registerBlock("poop_block", () -> new Block(Block.Properties.of(Material.FROGSPAWN).strength(0.4F).sound(SoundType.HONEY_BLOCK)));
    public static final Supplier<Block> POOP_BRICKS = registerBlock("poop_bricks", () -> new Block(Block.Properties.of(Material.FROGSPAWN).strength(0.4F).sound(SoundType.HONEY_BLOCK)));
    public static final Supplier<Block> POOP_BRICK_SLAB = registerBlock("poop_brick_slab", () -> new SlabBlock(Block.Properties.of(Material.FROGSPAWN).strength(0.4F).sound(SoundType.HONEY_BLOCK)));
    public static final Supplier<Block> POOP_BRICK_STAIRS = registerBlock("poop_brick_stairs", () -> new com.starfish_studios.pooped.block.StairBlock(POOP_BRICKS.get().defaultBlockState(), Block.Properties.of(Material.FROGSPAWN).strength(0.4F).sound(SoundType.HONEY_BLOCK)));
    public static final Supplier<Block> POOP_BRICK_WALL = registerBlock("poop_brick_wall", () -> new WallBlock(Block.Properties.of(Material.FROGSPAWN).strength(0.4F).sound(SoundType.HONEY_BLOCK)));

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> supplier = PRegistry.registerBlock(name, block);
        PRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties().tab(Pooped.TAB)));
        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockHidden(String name, Supplier<T> block) {
        Supplier<T> supplier = PRegistry.registerBlock(name, block);
        PRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()));
        return supplier;
    }

    public static <T extends Block> Supplier<T> registerBlockOnly(String name, Supplier<T> block) {
        return PRegistry.registerBlock(name, block);
    }

    public static <T extends StairBlock> Supplier<T> registerStairBlock(String name, Supplier<T> block) {
        Supplier<T> supplier = PRegistry.registerBlock(name, block);
        PRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()));
        return supplier;
    }

    public static void init() {}
}

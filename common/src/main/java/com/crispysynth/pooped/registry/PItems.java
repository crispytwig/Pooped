package com.crispysynth.pooped.registry;

import com.crispysynth.pooped.Pooped;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static com.crispysynth.pooped.registry.PRegistry.registerItem;

public class PItems {

    public static void init() {}

    public static final Supplier<Item> FERTILIZER = registerItem("fertilizer", () -> new BoneMealItem(new Item.Properties().tab(Pooped.TAB)));

}

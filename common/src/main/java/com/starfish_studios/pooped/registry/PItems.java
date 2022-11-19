package com.starfish_studios.pooped.registry;

import com.starfish_studios.pooped.Pooped;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static com.starfish_studios.pooped.registry.PRegistry.registerItem;

public class PItems {

    public static void init() {}

    public static final Supplier<Item> MANURE = registerItem("manure", () -> new BoneMealItem(new Item.Properties().tab(Pooped.TAB)));

}

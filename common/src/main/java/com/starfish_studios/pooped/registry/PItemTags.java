package com.starfish_studios.pooped.registry;

import com.starfish_studios.pooped.Pooped;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PItemTags {



    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Pooped.MOD_ID, name));
    }
}

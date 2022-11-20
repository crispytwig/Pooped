package com.crispysynth.pooped;

import com.crispysynth.pooped.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pooped {
    public static final String MOD_ID = "pooped";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final CreativeModeTab TAB = PRegistry.registerCreativeModeTab(new ResourceLocation(MOD_ID, "pooped"), () -> new ItemStack(PBlocks.POOP.get()));

    public static void init() {
        PBlocks.init();
        PItems.init();
        PSoundEvents.init();
        PEntityTypes.init();
        PBlockEntityTypes.init();
    }

    public static void registerFlammables() {

    }
}
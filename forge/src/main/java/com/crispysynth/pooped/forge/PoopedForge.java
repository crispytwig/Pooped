package com.crispysynth.pooped.forge;

import com.crispysynth.pooped.Pooped;
import com.crispysynth.pooped.registry.forge.PRegistryImpl;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Pooped.MOD_ID)
public class PoopedForge {
    public PoopedForge() {
        Pooped.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        PRegistryImpl.BLOCKS.register(bus);
        PRegistryImpl.ITEMS.register(bus);
        PRegistryImpl.SOUND_EVENTS.register(bus);
        PRegistryImpl.ENTITY_TYPES.register(bus);
        PRegistryImpl.BLOCK_ENTITY_TYPES.register(bus);

        bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Pooped.registerFlammables();
        });
    }

//    @SubscribeEvent
//    public void onChunkLoad(ChunkDataEvent.Load e){
//        CompoundTag nbt = e.getData();
//        ListTag wallpaperData = nbt.getList("wallpaper_data", 10);
//        AnotherFurniture.wallpaperManager.loadWallpaperChunk(e.getLevel(), e.getChunk(), wallpaperData);
//    }
//
//    @SubscribeEvent
//    public void onChunkUnload(ChunkDataEvent.Unload e){
//        ChunkAccess chunk = e.getChunk();
//        AnotherFurniture.wallpaperManager.unloadWallpaperChunk(chunk);
//    }
//
//    @SubscribeEvent
//    public void onChunkSave(ChunkDataEvent.Save e){
//        ChunkAccess chunk = e.getChunk();
//        if (chunk.getStatus().isOrAfter(ChunkStatus.FULL)) {
//            ListTag wallpaper_data = AnotherFurniture.wallpaperManager.saveWallpaperChunk(chunk);
//            e.getData().put("wallpaper_data", wallpaper_data);
//        }
//    }
//    @SubscribeEvent
//    public static void worldRender(RenderLevelStageEvent event) {
//        final Minecraft mc = Minecraft.getInstance();
//        if (mc.level != null && event.getStage() == RenderLevelStageEvent.Stage.AFTER_SOLID_BLOCKS) {
//            AnotherFurniture.wallpaperManager.renderWallpapers(event.getPoseStack(), event.getFrustum());
//        }
//    }
//
//    @SubscribeEvent
//    public static void rightClick(PlayerInteractEvent.RightClickBlock event) {
//        ItemStack stack = event.getItemStack();
//        Direction face = event.getFace();
//
//        if (stack.is(Items.STICK) && face != Direction.UP && face != Direction.DOWN) {
//            AnotherFurniture.wallpaperManager.addWallpaper(event.getLevel(), event.getPos(), face);
//        }
//    }

}
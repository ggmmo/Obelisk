package com.github.ggmmo.obelisk;

import com.github.ggmmo.obelisk.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;

@Mod("obelisk")
public class Obelisk {
    public static Obelisk instance;
    public static final String modid = "obelisk";

    private static final Logger logger = LogManager.getLogger();

    public Obelisk() {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // Previously the preInit function
    private void setup(final FMLCommonSetupEvent event) {
        logger.info("Setup method registered");
    }

    // Things running on client-side such as models
    private void clientRegistries(final FMLClientSetupEvent event) {
        logger.info("Client side registered");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            logger.info("Registering items...");

            event.getRegistry().registerAll(

            ItemList.copper_coin = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location( "copper_coin"))

            );
        }

        private static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }
    }
}

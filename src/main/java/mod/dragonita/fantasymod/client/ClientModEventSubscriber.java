package mod.dragonita.fantasymod.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.dragonita.fantasymod.Main;
import mod.dragonita.fantasymod.client.gui.RainbowChestScreen;
import mod.dragonita.fantasymod.client.renders.UnicornEntityRender;
import mod.dragonita.fantasymod.init.ModBlocks;
import mod.dragonita.fantasymod.init.ModContainerTypes;
import mod.dragonita.fantasymod.init.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber {
	private static final Logger LOGGER = LogManager.getLogger(Main.MODID + " Client Mod Event Subscriber");
	
	/**
	 * We need to register our renderers on the client because rendering code does not exist on the server
	 * and trying to use it on a dedicated server will crash the game.
	 * <p>
	 * This method will be called by Forge when it is time for the mod to do its client-side setup
	 * This method will always be called after the Registry events.
	 * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
	 */

	@SubscribeEvent
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {
		// Register Entity Renderers
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNICORN.get(), UnicornEntityRender::new);
		LOGGER.debug("Registered Entity Renderers");

		RenderTypeLookup.setRenderLayer(ModBlocks.RAINBOW_SAPLING.get(), RenderType.getCutout());
		// Register ContainerType Screens
		// ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
		DeferredWorkQueue.runLater(() -> {
			ScreenManager.registerFactory(ModContainerTypes.RAINBOW_CHEST.get(), RainbowChestScreen::new);
		});
	} 
}
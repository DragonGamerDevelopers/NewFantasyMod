package mod.dragonita.fantasymod;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.dragonita.fantasymod.customthings.PacketHandler;
import mod.dragonita.fantasymod.init.ModBiomes;
import mod.dragonita.fantasymod.init.ModBlocks;
import mod.dragonita.fantasymod.init.ModContainerTypes;
import mod.dragonita.fantasymod.init.ModDimensions;
import mod.dragonita.fantasymod.init.ModEntityTypes;
import mod.dragonita.fantasymod.init.ModItems;
import mod.dragonita.fantasymod.init.ModTileEntityTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("deprecation")
@Mod(Main.MODID)
public final class Main
{
	public static final String MODID = "fantasymod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ResourceLocation DIMENSION_TYPE = new ResourceLocation(Main.MODID, "rainbow_dimension");

	public Main()
	{
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

		LOGGER.debug("Hello from Fantasy Mod");
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register Deferred Registers (Does not need to be before Configs)
		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		ModDimensions.DIMENSION.register(modEventBus);
		ModBiomes.BIOMES.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(this);
	}	
	
	public void setup(final FMLCommonSetupEvent event) {
		PacketHandler.init();
		DeferredWorkQueue.runLater(new Runnable() {
			@Override
			public void run() {
				for(Biome biome : ForgeRegistries.BIOMES) {
					if(biome == ModBiomes.RAINBOW_FOREST.get()) {
						ConfiguredPlacement<CountRangeConfig> customConfig = Placement.COUNT_RANGE
								.configure(new CountRangeConfig(20, 5, 5, 25));
						biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RAINBOW_ORE.get().getDefaultState(), 10))
								.withPlacement(customConfig));
						}
					}
				}
		});	
	}
	
    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
    
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("fantasymod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }
    
    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    }
}
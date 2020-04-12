package mod.dragonita.fantasymod.init;

import mod.dragonita.fantasymod.Main;
import mod.dragonita.fantasymod.world.biomes.FantasyWarmOcean;
import mod.dragonita.fantasymod.world.biomes.RainbowForest;
import mod.dragonita.fantasymod.world.biomes.RainbowPlains;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Main.MODID);
	
	public static final RegistryObject<Biome> RAINBOW_FOREST = BIOMES.register("rainbow_forest", 
			() -> new RainbowForest(new Biome.Builder().precipitation(RainType.RAIN).scale(0.2F)
					.temperature(0.7F)
			.waterColor(16724639).waterFogColor(16762304)
			.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
					Blocks.GRASS_BLOCK.getDefaultState(), 
					Blocks.STONE.getDefaultState(), 
					Blocks.DIRT.getDefaultState()))
			.category(Category.FOREST)
			.downfall(0.8F)
			.depth(0.1F)	
			.parent(null)));
	
	public static final RegistryObject<Biome> RAINBOW_PLAINS = BIOMES.register("rainbow_plains", 
			() -> new RainbowPlains(new Biome.Builder().precipitation(RainType.RAIN).scale(0.05F)
					.temperature(0.8F)
			.waterColor(16724639).waterFogColor(16762304)
			.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
					Blocks.GRASS_BLOCK.getDefaultState(), 
					Blocks.STONE.getDefaultState(), 
					Blocks.DIRT.getDefaultState()))
			.category(Category.PLAINS)
			.downfall(1F)
			.depth(0.4F)
			.parent(null)));
	
	public static final RegistryObject<Biome> FANTASY_WARM_OCEAN = BIOMES.register("fantasy_warm_ocean", () -> new FantasyWarmOcean((new Biome.Builder())
			.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_CONFIG).precipitation(Biome.RainType.RAIN)
			.category(Biome.Category.OCEAN)
			.depth(-1.0F).scale(0.1F)
			.temperature(0.5F).downfall(0.5F)
			.waterColor(16724639).waterFogColor(270131)
			.parent(null)));
	
	public static void registerBiomes() {
		registerBiome(RAINBOW_PLAINS.get(), Type.PLAINS);
		registerBiome(RAINBOW_FOREST.get(), Type.FOREST);
		registerBiome(FANTASY_WARM_OCEAN.get(), Type.OCEAN);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
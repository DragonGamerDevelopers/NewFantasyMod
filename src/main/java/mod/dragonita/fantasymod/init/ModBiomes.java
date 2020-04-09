package mod.dragonita.fantasymod.init;

import mod.dragonita.fantasymod.Main;
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
import mod.dragonita.fantasymod.world.biomes.RainbowForest;

public class ModBiomes {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Main.MODID);
	
	public static final RegistryObject<Biome> RAINBOW_FOREST = BIOMES.register("rainbow_forest", 
			() -> new RainbowForest(new Biome.Builder().precipitation(RainType.RAIN).scale(1.2F)
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
	
	public static void registerBiomes() {
		registerBiome(RAINBOW_FOREST.get(), Type.FOREST);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
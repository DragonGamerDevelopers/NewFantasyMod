package mod.dragonita.fantasymod.world.dimensions;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import mod.dragonita.fantasymod.init.ModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class FantasyBiomeProvider extends BiomeProvider {

	@SuppressWarnings("unused")
	private Random rand;
	
	public FantasyBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(ModBiomes.RAINBOW_FOREST.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return ModBiomes.RAINBOW_FOREST.get();
	}
}
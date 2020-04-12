package mod.dragonita.fantasymod.world.dimensions;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import mod.dragonita.fantasymod.init.ModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class FantasyBiomeProvider extends BiomeProvider {

	private Random rand;
	public FantasyBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(ModBiomes.FANTASY_WARM_OCEAN.get(), ModBiomes.RAINBOW_FOREST.get(), ModBiomes.RAINBOW_PLAINS.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return getBiome(new LinkedList<Biome>(biomeList));
	}

	private Biome getBiome(List<Biome> biomeList) {
		//int randomNumber = this.rand.ints(1, 4).findFirst().getAsInt();
		return ModBiomes.FANTASY_WARM_OCEAN.get();
		//return biomeList.get(randomNumber);
	}
}
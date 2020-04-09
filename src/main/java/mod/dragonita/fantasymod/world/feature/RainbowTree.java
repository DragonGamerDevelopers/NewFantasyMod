package mod.dragonita.fantasymod.world.feature;

import java.util.Random;

import mod.dragonita.fantasymod.init.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class RainbowTree extends Tree{
	public static final TreeFeatureConfig RAINBOW_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(3, 0))).baseHeight(8).heightRandA(5).foliageHeight(6).ignoreVines()
				.setSapling((IPlantable)ModBlocks.RAINBOW_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(RAINBOW_TREE_CONFIG);
	}
}
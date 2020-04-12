package mod.dragonita.fantasymod.world.feature;

import java.util.Random;

import com.mojang.datafixers.Dynamic;

import mod.dragonita.fantasymod.init.ModBlocks;
import mod.dragonita.fantasymod.init.ModFeature;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class RainbowTree extends BigTree{
	public static final TreeFeatureConfig RAINBOW_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(3, 0))).baseHeight(8).heightRandA(5).foliageHeight(6).ignoreVines()
				.setSapling((IPlantable)ModBlocks.RAINBOW_SAPLING.get()).build();
	
	public static final TreeFeatureConfig RAINBOW_ACAIATREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LEAVES.get().getDefaultState()), 
			new AcaciaFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(2).trunkHeight(0).ignoreVines()
			.setSapling((IPlantable)ModBlocks.RAINBOW_SAPLING.get()).build();
	
	public static final HugeTreeFeatureConfig RAINBOW_BIGTREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.RAINBOW_LEAVES.get().getDefaultState())))
			.baseHeight(8).setSapling((IPlantable)ModBlocks.RAINBOW_SAPLING.get()).build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(RAINBOW_TREE_CONFIG);
	}
	
	@Override
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> func_225547_a_(Random p_225547_1_) {
		return ModFeature.MEGATREE.get().withConfiguration(RAINBOW_BIGTREE_CONFIG);
	}
	
	public static <T> HugeTreeFeatureConfig deserilizeBigRainbowTree(Dynamic<T> data) {
		return RAINBOW_BIGTREE_CONFIG;
	}
}
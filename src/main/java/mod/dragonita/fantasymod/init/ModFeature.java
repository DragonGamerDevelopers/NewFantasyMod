package mod.dragonita.fantasymod.init;

import mod.dragonita.fantasymod.Main;
import mod.dragonita.fantasymod.customthings.world.gen.feature.MegaTreeFeature;
import mod.dragonita.fantasymod.world.feature.RainbowTree;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeature extends ForgeRegistries{
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Main.MODID);
	
	public static final RegistryObject<Feature<HugeTreeFeatureConfig>> MEGATREE = FEATURES.register("fantasy_megatree", () -> new MegaTreeFeature(RainbowTree::deserilizeBigRainbowTree));
}
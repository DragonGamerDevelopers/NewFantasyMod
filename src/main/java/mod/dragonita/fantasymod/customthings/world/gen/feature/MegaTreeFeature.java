package mod.dragonita.fantasymod.customthings.world.gen.feature;

import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.world.gen.feature.DarkOakTreeFeature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;

public class MegaTreeFeature extends DarkOakTreeFeature{
	public MegaTreeFeature(Function<Dynamic<?>, ? extends HugeTreeFeatureConfig> p_i225800_1_) {
		super(p_i225800_1_);
	}
}
package mod.dragonita.fantasymod.materials;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.Material.Builder;
import net.minecraft.block.material.MaterialColor;

public class CustomMaterials extends Builder{
	public static final Material INFLAMMABLE_WOOD = new Builder(MaterialColor.WOOD).build();

	public CustomMaterials(MaterialColor color) {
		super(color);
	}
}
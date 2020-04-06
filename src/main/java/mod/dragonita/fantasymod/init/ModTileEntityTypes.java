package mod.dragonita.fantasymod.init;

import mod.dragonita.fantasymod.Main;
import mod.dragonita.fantasymod.tileentity.RainbowChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Main.MODID);
	
	public static final RegistryObject<TileEntityType<RainbowChestTileEntity>> RAINBOW_CHEST = TILE_ENTITY_TYPES.register("rainbow_chest", () ->
	TileEntityType.Builder.create(RainbowChestTileEntity::new, ModBlocks.RAINBOW_CHEST.get())
			.build(null)
	);
}
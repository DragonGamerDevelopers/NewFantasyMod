package mod.dragonita.fantasymod.init;

import mod.dragonita.fantasymod.Main;
import mod.dragonita.fantasymod.block.RainbowChestBlock;
import mod.dragonita.fantasymod.materials.CustomMaterials;
import mod.dragonita.fantasymod.saplings.RainbowSapling;
import mod.dragonita.fantasymod.world.feature.RainbowTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MODID);
	//Rainbow Blocks
	public static final RegistryObject<Block> RAINBOW_ORE = BLOCKS.register("rainbow_ore", () -> new Block(Block.Properties.from(Blocks.DIAMOND_ORE)));
	public static final RegistryObject<Block> RAINBOW_BLOCK = BLOCKS.register("rainbow_block", () -> new Block(Block.Properties.from(Blocks.DIAMOND_BLOCK)));
	public static final RegistryObject<Block> RAINBOW_CHEST = BLOCKS.register("rainbow_chest", () -> new RainbowChestBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F, 1200.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAINBOW_PLANKS = BLOCKS.register("rainbow_planks", () -> new Block(Block.Properties.create(CustomMaterials.INFLAMMABLE_WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAINBOW_LOG = BLOCKS.register("rainbow_log", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RAINBOW_LEAVES = BLOCKS.register("rainbow_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> RAINBOW_SAPLING = BLOCKS.register("rainbow_sapling", () -> new RainbowSapling(() -> new RainbowTree(), Block.Properties.from(Blocks.OAK_LEAVES)));

}
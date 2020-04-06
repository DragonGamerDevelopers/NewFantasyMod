package mod.dragonita.fantasymod.customthings;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Logger;

import mod.dragonita.fantasymod.Main;
import mod.dragonita.fantasymod.util.KeyboardHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class FullRainbowPickAxe extends PickaxeItem {
	@SuppressWarnings("unused")
	private Logger LOGGER = Main.LOGGER;
	public FullRainbowPickAxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	@SuppressWarnings("unused")
	private BlockPos getBlockPos(BlockPos BlockP, double dx, double dy, double dz) {
		BlockPos TargetBlock = BlockP.add(dx, dy, dz);
		return TargetBlock;
	}
	
	@SuppressWarnings("unused")
	private boolean tryHarvestBlockCustom(BlockPos pos, World World, ServerPlayerEntity Player) {
		World world = World;
		GameType gameType = GameType.NOT_SET;
		ServerPlayerEntity player = Player;
	    //BlockState blockstate = world.getBlockState(pos);
	    int exp = net.minecraftforge.common.ForgeHooks.onBlockBreakEvent(world, gameType, player, pos);
	    if (exp == -1) {
	       return false;
	    } else {
	    	return true;
	    }
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("This Pickaxe will destroy 9x9x9 Block"));
		}else {
			tooltip.add(new StringTextComponent("Hold SHIFT for more information"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	
	@SuppressWarnings("unused")
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		boolean dropBlock = state.hasTileEntity();
		for (int lx = 0; lx < 3; lx++) {
			for (int lz = 0; lz < 3; lz++) {
				BlockPos posToBreak = new BlockPos(x + lx, y, z + lz);
				destroyBlock(posToBreak, true, entityLiving);
			}
		}
		//tryHarvestBlockCustom(pos, worldIn, (ServerPlayerEntity)null);
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
	
	@SuppressWarnings("unused")
	private BlockState getBlockState(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos);
	}

	private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
		World world = entity.world;
		BlockState blockstate = world.getBlockState(pos);
		if (blockstate.isAir(entity.world, pos))
			return false;
		else {
			IFluidState ifluidstate = world.getFluidState(pos);
			world.playEvent(2001, pos, Block.getStateId(blockstate));
			if (dropBlock) {
				TileEntity tileentity = blockstate.hasTileEntity() ? world.getTileEntity(pos) : null;
				Block.spawnDrops(blockstate, world, world.getTileEntity(pos).getPos().add(0, 1.5, 0), tileentity, entity, ItemStack.EMPTY);
			}
			return world.setBlockState(pos, ifluidstate.getBlockState(), 3);
		}
	}
}

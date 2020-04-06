package mod.dragonita.fantasymod.tileentity;

import javax.annotation.Nonnull;

import mod.dragonita.fantasymod.block.RainbowChestBlock;
import mod.dragonita.fantasymod.containers.RainbowChestContainer;
import mod.dragonita.fantasymod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class RainbowChestTileEntity extends LockableLootTileEntity
{	
	private NonNullList<ItemStack> ChestContents = NonNullList.withSize(36, ItemStack.EMPTY);
	protected int numPlayerUsing;
	private IItemHandlerModifiable items = CreateHandler();
	private LazyOptional<IItemHandler> ItemHandler = LazyOptional.of(() -> items);
	
	public RainbowChestTileEntity() {
		super(ModTileEntityTypes.RAINBOW_CHEST.get());
	}

	@Override
	public int getSizeInventory() {
		return 36;
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.ChestContents;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.ChestContents = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.rainbow_chest");
	}
	
	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new RainbowChestContainer(id, player, this);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if(!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.ChestContents);
		}
		return compound;
	}
	
	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.ChestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if(!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.ChestContents);
		}
	}
	
	@SuppressWarnings("unused")
	private void playsound(SoundEvent sound) {
		double dx = (double)this.pos.getX() + 0.5D;
		double dy = (double)this.pos.getY() + 0.5D;
		double dz = (double)this.pos.getZ() + 0.5D;
		this.world.playSound((PlayerEntity)null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat()*0.1f + 0.9f);
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type) {
		if(id == 1) {
			this.numPlayerUsing = type;
			return true;
		}else {
			return super.receiveClientEvent(id, type);
		}
	}
	
	@Override
	public void openInventory(PlayerEntity player) {
		if(!player.isSpectator()) {
			if(this.numPlayerUsing < 0) {
				this.numPlayerUsing = 0;
			}
			++this.numPlayerUsing;
			this.onOpenOrClose();
		}
	}

	@Override
	public void closeInventory(PlayerEntity player) {
		if(!player.isSpectator()) {
			--this.numPlayerUsing;
			this.onOpenOrClose();
		}
	}
	
	private void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if(block instanceof RainbowChestBlock) {
			this.world.addBlockEvent(pos, block, 1, this.numPlayerUsing);
			this.world.notifyNeighborsOfStateChange(pos, block);
		}
	}
	
	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
		BlockState blockstate = reader.getBlockState(pos);
		if(blockstate.hasTileEntity()) {
			TileEntity tileentity = reader.getTileEntity(pos);
			if(tileentity instanceof RainbowChestTileEntity) {
				return ((RainbowChestTileEntity)tileentity).numPlayerUsing;
			}
		}
		return 0;
	}
	
	@SuppressWarnings("unused")
	private void swapContents(RainbowChestTileEntity tileentity, RainbowChestTileEntity othertileentity) {
		NonNullList<ItemStack> list = tileentity.getItems();
		tileentity.setItems(othertileentity.getItems());
		othertileentity.setItems(list);
	}
	
	@Override
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
		if(this.ItemHandler != null) {
			this.ItemHandler.invalidate();
			this.ItemHandler = null;
		}
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
		// TODO Auto-generated method stub
		return super.getCapability(cap, side);
	}
	
	private IItemHandlerModifiable CreateHandler() {
		return new InvWrapper(this);
	}
	
	@Override
	public void remove() {
		super.remove();
		if(ItemHandler != null) {
			ItemHandler.invalidate();
		}
	}
}
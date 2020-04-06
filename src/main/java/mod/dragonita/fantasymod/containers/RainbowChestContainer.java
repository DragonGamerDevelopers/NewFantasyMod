package mod.dragonita.fantasymod.containers;

import java.util.Objects;

import mod.dragonita.fantasymod.init.ModBlocks;
import mod.dragonita.fantasymod.init.ModContainerTypes;
import mod.dragonita.fantasymod.tileentity.RainbowChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class RainbowChestContainer extends Container {

	public final RainbowChestTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	
	public RainbowChestContainer(final int windowId, final PlayerInventory playerInventory, final RainbowChestTileEntity tileEntity) {
		super(ModContainerTypes.RAINBOW_CHEST.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
		//Main Inventory
		int startX = 8;
		int startY = 18;
		int slotSizePlus2 = 18;
		for(int row = 0; row < 4; ++row) {
			for(int colum = 0; colum < 9; ++colum) {
				this.addSlot(new Slot(tileEntity, (row*9)+colum, startX + (colum*slotSizePlus2), startY + (row*slotSizePlus2)));
			}
		}
		//Main Player Inventory
		int startPlayerInvY = startY*5+12;
		for(int row = 0; row < 3; ++row) {
			for(int colum = 0; colum < 9; ++colum) {
				this.addSlot(new Slot(playerInventory, 9+(row*9)+colum, startX + (colum*slotSizePlus2), startPlayerInvY + (row*slotSizePlus2)));
			}
		}
		//Hotbar
		int hotbarY = 160;
		for(int colum = 0; colum < 9; ++colum) {
			this.addSlot(new Slot(playerInventory, colum, startX+(colum*slotSizePlus2), hotbarY));
		}
	}
	private static RainbowChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if(tileAtPos instanceof RainbowChestTileEntity) {
			return (RainbowChestTileEntity)tileAtPos;
		}
		throw new IllegalStateException("Tile emtoty is not correct: " + tileAtPos);
	}
	public RainbowChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, ModBlocks.RAINBOW_CHEST.get());
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(index < 36) {
				if(this.mergeItemStack(itemstack, 36, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			}else if(!this.mergeItemStack(itemstack1, 0, 36, false)) {
				return ItemStack.EMPTY;
			}
			if(itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			}else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
}
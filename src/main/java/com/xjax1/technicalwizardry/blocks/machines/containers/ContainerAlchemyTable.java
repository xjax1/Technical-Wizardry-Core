package com.xjax1.technicalwizardry.blocks.machines.containers;

import com.xjax1.technicalwizardry.blocks.machines.tileentity.TileEntityAlchemyTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerAlchemyTable extends Container{

    
	public ContainerAlchemyTable(InventoryPlayer ip, TileEntityAlchemyTable te) {
		// TODO Auto-generated constructor stub
		if (te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
			IItemHandler alchemyGrid = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
					//blue slots
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 1, 111, 9));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 2, 129, 9));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 3, 111, 27));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 4, 129, 27));
                    //green slots
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 5, 70, 48));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 6, 88, 48));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 7, 70, 66));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 8, 88, 66));
                    //red slots
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 9, 152, 48));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 10, 170, 48));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 11, 152, 66));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 12, 170, 66));
                    //white slots
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 13, 111, 87));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 14, 129, 87));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 15, 111, 105));
                    addSlotToContainer(new SlotItemHandler(alchemyGrid, 0, 129, 105));

            // MAIN PLAYER INVENTORY
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 9; x++) {
                    addSlotToContainer(new Slot(ip, x + (y * 9) + 9, 48 + x * 18, 167 + y * 18));
                }
            }

            // PLAYER HOTBAR INVENTORY
            for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(ip, i, 48 + (i * 18), 225));
            }
			
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	 @Override
	    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
	        ItemStack stack = ItemStack.EMPTY;
	        Slot slot = inventorySlots.get(index);

	        if (slot != null && slot.getHasStack()) {
	            ItemStack stackInSlot = slot.getStack();
	            stack = stackInSlot.copy();

	            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

	            if (index < containerSlots) {
	                if (!this.mergeItemStack(stackInSlot, containerSlots, inventorySlots.size(), true)) {
	                    return ItemStack.EMPTY;
	                }
	            } else if (!this.mergeItemStack(stackInSlot, 0, containerSlots, false)) {
	                return ItemStack.EMPTY;
	            }

	            if (stackInSlot.getCount() == 0) {
	                slot.putStack(ItemStack.EMPTY);
	            } else {
	                slot.onSlotChanged();
	            }

	            slot.onTake(player, stackInSlot);

	        }
	        return stack;
	    }

}

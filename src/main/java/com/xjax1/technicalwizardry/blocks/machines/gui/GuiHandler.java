package com.xjax1.technicalwizardry.blocks.machines.gui;

import com.xjax1.technicalwizardry.blocks.machines.containers.ContainerAlchemyTable;
import com.xjax1.technicalwizardry.blocks.machines.tileentity.TileEntityAlchemyTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int ALCHEMY_TABLE_GUI_ID = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		switch (ID) {
			case ALCHEMY_TABLE_GUI_ID:
				return new ContainerAlchemyTable(player.inventory, (TileEntityAlchemyTable)te);
			default: 
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		switch (ID) {
			case ALCHEMY_TABLE_GUI_ID:
				return new GUIAlchemyTable(player.inventory, (TileEntityAlchemyTable)te);
			default: 
				return null;
		}
	}

}

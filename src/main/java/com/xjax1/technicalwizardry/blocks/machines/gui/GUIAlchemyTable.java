package com.xjax1.technicalwizardry.blocks.machines.gui;

import com.xjax1.technicalwizardry.blocks.machines.containers.ContainerAlchemyTable;
import com.xjax1.technicalwizardry.blocks.machines.tileentity.TileEntityAlchemyTable;
import com.xjax1.technicalwizardry.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIAlchemyTable extends GuiContainer{

	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/alchemy_table.png");
	
	public GUIAlchemyTable(InventoryPlayer ip, TileEntityAlchemyTable te) {
		super(new ContainerAlchemyTable(ip, te));
		xSize = 256;
		ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}
}

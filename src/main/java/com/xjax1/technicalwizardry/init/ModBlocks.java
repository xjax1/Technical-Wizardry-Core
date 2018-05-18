package com.xjax1.technicalwizardry.init;

import java.util.ArrayList;
import java.util.List;

import com.xjax1.technicalwizardry.blocks.BlockBase;
import com.xjax1.technicalwizardry.blocks.InfusedCobblestone;
import com.xjax1.technicalwizardry.blocks.machines.BlockAlchemyTable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block INFUSED_COBBLESTONE = new InfusedCobblestone("infused_cobblestone", Material.ROCK);	
	public static final Block NEW_COBBLESTONE = new BlockBase("new_cobblestone", Material.ROCK);	
	public static final Block EMPOWERED_COBBLESTONE = new BlockBase("empowered_cobblestone", Material.ROCK);
	public static final Block ALCHEMY_TABLE = new BlockAlchemyTable("alchemy_table");
	
}

package com.xjax1.technicalwizardry.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class InfusedCobblestone extends BlockBase{

	public InfusedCobblestone(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(3.0f);
		setResistance(25.0f);
		setHarvestLevel("pickaxe", 0);
		
		
	}

}

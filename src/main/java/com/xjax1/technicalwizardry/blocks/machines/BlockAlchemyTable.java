package com.xjax1.technicalwizardry.blocks.machines;

import com.xjax1.technicalwizardry.Main;
import com.xjax1.technicalwizardry.blocks.BlockBase;
import com.xjax1.technicalwizardry.blocks.machines.gui.GuiHandler;
import com.xjax1.technicalwizardry.blocks.machines.tileentity.TileEntityAlchemyTable;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class BlockAlchemyTable extends BlockBase implements ITileEntityProvider {

	public BlockAlchemyTable(String name)
    {
        super(name, Material.ROCK);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAlchemyTable();
	}
	
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	TileEntity tileEntity = (TileEntityAlchemyTable) worldIn.getTileEntity(pos);
    	 
        if (tileEntity != null && tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
        	
            playerIn.openGui(Main.instance, GuiHandler.ALCHEMY_TABLE_GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
            
            }
        return true;
        }
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
    	// TODO Auto-generated method stub
    	super.breakBlock(worldIn, pos, state);
    }

}

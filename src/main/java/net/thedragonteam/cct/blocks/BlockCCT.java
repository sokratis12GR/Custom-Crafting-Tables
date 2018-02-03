package net.thedragonteam.cct.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thedragonteam.cct.blocks.base.BaseBlock;

import javax.annotation.Nullable;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;

public class BlockCCT extends BaseBlock {
    public CCT cct;
    private int blockNumber;

    public BlockCCT(CCT cctIn) {
        super(Material.WOOD, cctIn.getName());
        cct = cctIn;
        blockNumber = cctIn.getBlockNumber();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(MODID, blockNumber, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    public CCT getCct() {
        return cct;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return cct.getTileEntity();
    }
}

package net.thedragonteam.cct.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.cct.blocks.base.BaseBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Objects;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;

public class BlockCCT extends BaseBlock implements ITileEntityProvider {
    private EnumCCT cct;

    public BlockCCT(EnumCCT cctIn) {
        super(Material.WOOD, cctIn.getName());
        this.cct = cctIn;
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this) {
            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return cctIn.getDisplayName() != null && !Objects.equals(cctIn.getDisplayName(), "") && !Objects.equals(cctIn.getDisplayName(), " ") ? cctIn.getDisplayName() : new TextComponentTranslation(this.getUnlocalizedNameInefficiently(stack) + ".name").getFormattedText();
            }
        }, getRegistryName());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (cct == cct.getCCT() && !worldIn.isRemote) {
            playerIn.openGui(MODID, cct.getBlockNumber(), worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return cct.getTileEntity();
    }
}

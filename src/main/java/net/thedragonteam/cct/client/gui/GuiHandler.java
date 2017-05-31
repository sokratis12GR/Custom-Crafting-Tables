/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.cct.container.ContainerOneByOne;
import net.thedragonteam.cct.container.*;
import net.thedragonteam.cct.tileentity.*;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_1X1 = 0;
    public static final int GUI_2X2 = 1;
    public static final int GUI_3X3 = 2;
    public static final int GUI_4X4 = 3;
    public static final int GUI_5X5 = 4;
    public static final int GUI_6X6 = 5;
    public static final int GUI_7X7 = 6;
    public static final int GUI_8X8 = 7;
    public static final int GUI_9X9 = 8;
    public static final int GUI_10X10 = 9;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
            case GUI_1X1:
                if (te != null && te instanceof TileEntityOneByOne)
                    return new ContainerOneByOne(player.inventory, (TileEntityOneByOne) te);
            case GUI_2X2:
                if (te != null && te instanceof TileEntityTwoByTwo)
                    return new ContainerTwoByTwo(player.inventory, (TileEntityTwoByTwo) te);
            case GUI_3X3:
                if (te != null && te instanceof TileEntityThreeByThree)
                    return new ContainerThreeByThree(player.inventory, (TileEntityThreeByThree) te);
            case GUI_4X4:
                if (te != null && te instanceof TileEntityFourByFour)
                    return new ContainerFourByFour(player.inventory, (TileEntityFourByFour) te);
            case GUI_5X5:
                if (te != null && te instanceof TileEntityFiveByFive)
                    return new ContainerFiveByFive(player.inventory, (TileEntityFiveByFive) te);
            case GUI_6X6:
                if (te != null && te instanceof TileEntitySixBySix)
                    return new ContainerSixBySix(player.inventory, (TileEntitySixBySix) te);
            case GUI_7X7:
                if (te != null && te instanceof TileEntitySevenBySeven)
                    return new ContainerSevenBySeven(player.inventory, (TileEntitySevenBySeven) te);
            case GUI_8X8:
                if (te != null && te instanceof TileEntityEightByEight)
                    return new ContainerEightByEight(player.inventory, (TileEntityEightByEight) te);
            case GUI_9X9:
                if (te != null && te instanceof TileEntityNineByNine)
                    return new ContainerNineByNine(player.inventory, (TileEntityNineByNine) te);
            case GUI_10X10:
                if (te != null && te instanceof TileEntityTenByTen)
                    return new ContainerTenByTen(player.inventory, (TileEntityTenByTen) te);
            default:
                break;
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
            case GUI_1X1:
                if (te != null && te instanceof TileEntityOneByOne)
                    return new GuiOneByOne(player.inventory, (TileEntityOneByOne) te);
            case GUI_2X2:
                if (te != null && te instanceof TileEntityTwoByTwo)
                    return new GuiTwoByTwo(player.inventory, (TileEntityTwoByTwo) te);
            case GUI_3X3:
                if (te != null && te instanceof TileEntityThreeByThree)
                    return new GuiThreeByThree(player.inventory, (TileEntityThreeByThree) te);
            case GUI_4X4:
                if (te != null && te instanceof TileEntityFourByFour)
                    return new GuiFourByFour(player.inventory, (TileEntityFourByFour) te);
            case GUI_5X5:
                if (te != null && te instanceof TileEntityFiveByFive)
                    return new GuiFiveByFive(player.inventory, (TileEntityFiveByFive) te);
            case GUI_6X6:
                if (te != null && te instanceof TileEntitySixBySix)
                    return new GuiSixBySix(player.inventory, (TileEntitySixBySix) te);
            case GUI_7X7:
                if (te != null && te instanceof TileEntitySevenBySeven)
                    return new GuiSevenBySeven(player.inventory, (TileEntitySevenBySeven) te);
            case GUI_8X8:
                if (te != null && te instanceof TileEntityEightByEight)
                    return new GuiEightByEight(player.inventory, (TileEntityEightByEight) te);
            case GUI_9X9:
                if (te != null && te instanceof TileEntityNineByNine)
                    return new GuiNineByNine(player.inventory, (TileEntityNineByNine) te);
            case GUI_10X10:
                if (te != null && te instanceof TileEntityTenByTen)
                    return new GuiTenByTen(player.inventory, (TileEntityTenByTen) te);
            default:
                break;
        }
        return null;
    }
}
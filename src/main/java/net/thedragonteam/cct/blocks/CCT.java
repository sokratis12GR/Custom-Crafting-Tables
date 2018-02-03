package net.thedragonteam.cct.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;
import net.thedragonteam.cct.tileentity.*;

import javax.annotation.Nonnull;
import java.util.Objects;

import static java.lang.String.format;
import static net.minecraft.util.text.TextFormatting.WHITE;
import static net.minecraft.util.text.TextFormatting.getValueByName;
import static net.thedragonteam.cct.CCTConfig.*;
import static net.thedragonteam.cct.client.gui.GuiHandler.*;
import static net.thedragonteam.thedragonlib.util.LogHelper.info;

public enum CCT implements IStringSerializable {
    CCT_1X1("cct_1x1", GUI_1X1, new TileEntityOneByOne()),
    CCT_2X2("cct_2x2", GUI_2X2, new TileEntityTwoByTwo()),
    CCT_3X3("cct_3x3", GUI_3X3, new TileEntityThreeByThree()),
    CCT_4X4("cct_4x4", GUI_4X4, new TileEntityFourByFour()),
    CCT_5X5("cct_5x5", GUI_5X5, new TileEntityFiveByFive()),
    CCT_6X6("cct_6x6", GUI_6X6, new TileEntitySixBySix()),
    CCT_7X7("cct_7x7", GUI_7X7, new TileEntitySevenBySeven()),
    CCT_8X8("cct_8x8", GUI_8X8, new TileEntityEightByEight()),
    CCT_9X9("cct_9x9", GUI_9X9, new TileEntityNineByNine()),
    CCT_10X10("cct_10x10", GUI_10X10, new TileEntityTenByTen()),;

    private final String name;
    private final int blockNumber;
    private final TileEntity tileEntity;

    CCT(String nameIn, int blockNumberIn, TileEntity tileEntityIn) {
        this.name = nameIn;
        this.blockNumber = blockNumberIn;
        this.tileEntity = tileEntityIn;
    }

    public String toString() {
        return this.name;
    }

    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public TileEntity getTileEntity() {
        return tileEntity;
    }

    public String getDisplayName() {
        return this.getBlockNumber() < cctNames.length ? cctNames[this.getBlockNumber()] : "Not enough array members for the cctNames array";
    }

    public String getDisplayName(String alternative) {
        String displayName = getDisplayName();
        if (displayName != null && !Objects.equals(displayName, "") && !Objects.equals(displayName, " ")) {
            return displayName;
        }
        if (enableDebug) {
            info(format("The name \"%s\" for the block is invalid", displayName));
        }
        return alternative;
    }

    public TextFormatting getColor() {
        return this.getBlockNumber() < recolorCCTNames.length ? getValueByName(recolorCCTNames[this.getBlockNumber()]) : WHITE;
    }

    public int getStackSize() {
        return this.getBlockNumber() < cctMaxStackSize.length ? cctMaxStackSize[this.getBlockNumber()] : 64;
    }
}

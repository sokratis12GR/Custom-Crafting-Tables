/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerNineByNine;
import net.thedragonteam.cct.tileentity.TileEntityNineByNine;

import java.util.Objects;

import static net.thedragonteam.cct.CCTConfig.cctGuiNames;


public class GuiNineByNine extends GuiBaseBench {

    public GuiNineByNine(InventoryPlayer playerInv, TileEntityNineByNine tile) {
        super(new ContainerNineByNine(playerInv, tile), 9, 256, 256, 8);
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(cctGuiNames[8] != null && !Objects.equals(cctGuiNames[8], "") && !Objects.equals(cctGuiNames[8], " ") ? cctGuiNames[8] : new TextComponentTranslation("container.cct.9x9").getFormattedText(), 28, 5, 4210752);
        this.fontRenderer.drawString(new TextComponentTranslation("container.cct.inventory").getFormattedText(), 8, this.ySize - 78 + 2, 4210752);
    }
}

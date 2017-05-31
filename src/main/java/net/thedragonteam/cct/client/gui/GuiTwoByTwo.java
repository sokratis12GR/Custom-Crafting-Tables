/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerTwoByTwo;
import net.thedragonteam.cct.tileentity.TileEntityTwoByTwo;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiTwoByTwo extends GuiBaseBench {
    private static final ResourceLocation TWO_BY_TWO_GUI_TEXTURES = setRL("textures/gui/container/gui_2x2.png");

    public GuiTwoByTwo(InventoryPlayer playerInv, TileEntityTwoByTwo tile) {
        super(new ContainerTwoByTwo(playerInv, tile), TWO_BY_TWO_GUI_TEXTURES, "2x2", 176, 165,1);
    }
}

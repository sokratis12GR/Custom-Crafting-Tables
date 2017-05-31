/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerSevenBySeven;
import net.thedragonteam.cct.tileentity.TileEntitySevenBySeven;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiSevenBySeven extends GuiBaseBench {
    private static final ResourceLocation SEVEN_BY_SEVEN_GUI_TEXTURES = setRL("textures/gui/container/gui_7x7.png");

    public GuiSevenBySeven(InventoryPlayer playerInv, TileEntitySevenBySeven tile) {
        super(new ContainerSevenBySeven(playerInv, tile), SEVEN_BY_SEVEN_GUI_TEXTURES, "7x7", 192, 237, 6);
    }
}

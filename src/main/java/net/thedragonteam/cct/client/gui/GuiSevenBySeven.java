/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerSevenBySeven;
import net.thedragonteam.cct.tileentity.TileEntitySevenBySeven;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiSevenBySeven extends GuiBaseBench {

    public GuiSevenBySeven(InventoryPlayer playerInv, TileEntitySevenBySeven tile) {
        super(new ContainerSevenBySeven(playerInv, tile), "7x7", 192, 237, 6);
    }
}

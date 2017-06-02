/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerFiveByFive;
import net.thedragonteam.cct.tileentity.TileEntityFiveByFive;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiFiveByFive extends GuiBaseBench {

    public GuiFiveByFive(InventoryPlayer playerInv, TileEntityFiveByFive tile) {
        super(new ContainerFiveByFive(playerInv, tile),"5x5", 176, 199, 4);
    }
}

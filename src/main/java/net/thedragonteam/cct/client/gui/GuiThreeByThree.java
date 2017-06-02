/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerThreeByThree;
import net.thedragonteam.cct.tileentity.TileEntityThreeByThree;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiThreeByThree extends GuiBaseBench {

    public GuiThreeByThree(InventoryPlayer playerInv, TileEntityThreeByThree tile) {
        super(new ContainerThreeByThree(playerInv, tile),"3x3", 176, 165,2);
    }
}

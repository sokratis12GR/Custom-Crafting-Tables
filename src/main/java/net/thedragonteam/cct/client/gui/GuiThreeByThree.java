/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerThreeByThree;
import net.thedragonteam.cct.tileentity.TileEntityThreeByThree;


public class GuiThreeByThree extends GuiBaseBench {

    public GuiThreeByThree(InventoryPlayer playerInv, TileEntityThreeByThree tile) {
        super(new ContainerThreeByThree(playerInv, tile), 3, 176, 165,2);
    }
}

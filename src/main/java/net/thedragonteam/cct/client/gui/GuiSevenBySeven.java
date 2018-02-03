/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerSevenBySeven;
import net.thedragonteam.cct.tileentity.TileEntitySevenBySeven;

public class GuiSevenBySeven extends GuiBaseBench {

    public GuiSevenBySeven(InventoryPlayer playerInv, TileEntitySevenBySeven tile) {
        super(new ContainerSevenBySeven(playerInv, tile), 7, 192, 237, 6);
    }
}

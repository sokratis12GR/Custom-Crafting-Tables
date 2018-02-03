/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerOneByOne;
import net.thedragonteam.cct.tileentity.TileEntityOneByOne;

public class GuiOneByOne extends GuiBaseBench {

    public GuiOneByOne(InventoryPlayer playerInv, TileEntityOneByOne tile) {
        super(new ContainerOneByOne(playerInv, tile), 1, 176, 165, 0);
    }
}

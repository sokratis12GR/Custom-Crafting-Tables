/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerFourByFour;
import net.thedragonteam.cct.tileentity.TileEntityFourByFour;


public class GuiFourByFour extends GuiBaseBench {

    public GuiFourByFour(InventoryPlayer playerInv, TileEntityFourByFour tile) {
        super(new ContainerFourByFour(playerInv, tile), 4, 176, 184, 3);
    }
}

/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerTwoByTwo;
import net.thedragonteam.cct.tileentity.TileEntityTwoByTwo;

public class GuiTwoByTwo extends GuiBaseBench {

    public GuiTwoByTwo(InventoryPlayer playerInv, TileEntityTwoByTwo tile) {
        super(new ContainerTwoByTwo(playerInv, tile), 2, 176, 165, 1);
    }
}

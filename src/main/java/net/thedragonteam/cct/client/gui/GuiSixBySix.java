/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerSixBySix;
import net.thedragonteam.cct.tileentity.TileEntitySixBySix;

public class GuiSixBySix extends GuiBaseBench {

    public GuiSixBySix(InventoryPlayer playerInv, TileEntitySixBySix tile) {
        super(new ContainerSixBySix(playerInv, tile), 6, 176, 219, 5);
    }
}

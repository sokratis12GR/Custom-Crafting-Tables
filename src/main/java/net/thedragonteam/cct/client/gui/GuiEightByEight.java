/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerEightByEight;
import net.thedragonteam.cct.tileentity.TileEntityEightByEight;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiEightByEight extends GuiBaseBench {

    public GuiEightByEight(InventoryPlayer playerInv, TileEntityEightByEight tile) {
        super(new ContainerEightByEight(playerInv, tile), "8x8", 215, 255, 7);
    }
}

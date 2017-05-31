/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerOneByOne;
import net.thedragonteam.cct.tileentity.TileEntityOneByOne;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiOneByOne extends GuiBaseBench {
    private static final ResourceLocation ONE_BY_ONE_GUI_TEXTURES = setRL("textures/gui/container/gui_1x1.png");

    public GuiOneByOne(InventoryPlayer playerInv, TileEntityOneByOne tile) {
        super(new ContainerOneByOne(playerInv, tile), ONE_BY_ONE_GUI_TEXTURES, "1x1", 176, 165, 0);
    }
}

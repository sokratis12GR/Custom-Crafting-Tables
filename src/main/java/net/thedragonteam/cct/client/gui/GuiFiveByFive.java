/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerFiveByFive;
import net.thedragonteam.cct.tileentity.TileEntityFiveByFive;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiFiveByFive extends GuiBaseBench {
    private static final ResourceLocation FIVE_BY_FIVE_GUI_TEXTURES = setRL("textures/gui/container/gui_5x5.png");

    public GuiFiveByFive(InventoryPlayer playerInv, TileEntityFiveByFive tile) {
        super(new ContainerFiveByFive(playerInv, tile), FIVE_BY_FIVE_GUI_TEXTURES, "5x5", 176, 199, 4);
    }
}

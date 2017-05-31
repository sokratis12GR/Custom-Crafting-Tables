/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerFourByFour;
import net.thedragonteam.cct.tileentity.TileEntityFourByFour;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiFourByFour extends GuiBaseBench {
    private static final ResourceLocation FOUR_BY_FOUR_GUI_TEXTURES = setRL("textures/gui/container/gui_4x4.png");

    public GuiFourByFour(InventoryPlayer playerInv, TileEntityFourByFour tile) {
        super(new ContainerFourByFour(playerInv, tile), FOUR_BY_FOUR_GUI_TEXTURES, "4x4", 176, 184, 3);
    }
}

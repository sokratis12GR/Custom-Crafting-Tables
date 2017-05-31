/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerEightByEight;
import net.thedragonteam.cct.tileentity.TileEntityEightByEight;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiEightByEight extends GuiBaseBench {
    private static final ResourceLocation EIGHT_BY_EIGHT_GUI_TEXTURES = setRL("textures/gui/container/gui_8x8.png");

    public GuiEightByEight(InventoryPlayer playerInv, TileEntityEightByEight tile) {
        super(new ContainerEightByEight(playerInv, tile), EIGHT_BY_EIGHT_GUI_TEXTURES, "8x8", 215, 255, 7);
    }
}

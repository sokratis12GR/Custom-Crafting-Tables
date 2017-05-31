/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.client.gui.base.GuiBaseBench;
import net.thedragonteam.cct.container.ContainerSixBySix;
import net.thedragonteam.cct.tileentity.TileEntitySixBySix;

import static net.thedragonteam.cct.util.Utils.setRL;

/**
 * net.thedragonteam.armorplus.client.gui
 * ArmorPlus created by sokratis12GR on 6/19/2016 10:37 AM.
 * - TheDragonTeam
 */
public class GuiSixBySix extends GuiBaseBench {
    private static final ResourceLocation SIX_BY_SIX_GUI_TEXTURES = setRL("textures/gui/container/gui_6x6.png");

    public GuiSixBySix(InventoryPlayer playerInv, TileEntitySixBySix tile) {
        super(new ContainerSixBySix(playerInv, tile), SIX_BY_SIX_GUI_TEXTURES, "6x6", 176, 219, 5);
    }
}

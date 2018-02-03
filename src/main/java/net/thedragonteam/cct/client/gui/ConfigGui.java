/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.thedragonteam.cct.proxy.CommonProxy;

import java.util.ArrayList;
import java.util.List;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;

public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(parentScreen), MODID, false, true,
            new TextComponentTranslation("gui." + MODID + ".config.title").getFormattedText());
    }

    private static List<IConfigElement> getConfigElements(GuiScreen parent) {
        List<IConfigElement> list = new ArrayList<>();

        list.add(new ConfigElement(CommonProxy.configuration.getCategory("CCT".toLowerCase())));
        return list;
    }
}
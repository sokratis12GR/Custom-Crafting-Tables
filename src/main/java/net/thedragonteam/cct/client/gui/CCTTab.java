/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.client.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

public class CCTTab extends CreativeTabs {
    private String label;

    public CCTTab(int id, String modid, String label) {
        super(id, modid);
        this.label = label;
        this.setBackgroundImageName("items.png"); // Automatically has tab_ applied to it. Make sure you change the texture name.
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return getItemStack(Blocks.CRAFTING_TABLE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
        return getIconItemStack();
    }

    @Override
    public String getTabLabel() {
        return this.label;
    }
}
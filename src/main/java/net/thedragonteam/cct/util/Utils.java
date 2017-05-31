/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;

public final class Utils {

    public static ItemStack setUnbreakable(ItemStack stack) {
        NBTHelper.checkNBT(stack);
        stack.getTagCompound().setBoolean("Unbreakable", true);
        return stack;
    }

    public static String setName(String name) {
        return MODID + "." + name;
    }

    public static String setLocation(String name) {
        return MODID + ":" + name;
    }

    public static ResourceLocation setRL(String path) {
        return new ResourceLocation(MODID, path);
    }

    public static String getFormatted(String key) {
        return new TextComponentTranslation(key).getFormattedText();
    }

    public static String getFormatted(String key, Object... args) {
        return new TextComponentTranslation(key, args).getFormattedText();
    }
}
/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.Objects;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;
import static net.thedragonteam.cct.util.NBTHelper.checkNBT;

public final class Utils {

    public static ItemStack setUnbreakable(ItemStack stack) {
        checkNBT(stack);
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

    public static boolean isNotEmpty(ItemStack stack) {
        return !stack.isEmpty();
    }

    public static boolean isEmpty(ItemStack stack) {
        return stack.isEmpty();
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static boolean areNotNull(Object object1, Object object2) {
        return object1 != null && object2 != null;
    }

    public static boolean isNotNullNorEmpty(String object) {
        return isNotNull(object) && !Objects.equals(object, "") && !Objects.equals(object, " ");
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNullOrEmpty(String object) {
        return isNull(object) || Objects.equals(object, "");
    }

}
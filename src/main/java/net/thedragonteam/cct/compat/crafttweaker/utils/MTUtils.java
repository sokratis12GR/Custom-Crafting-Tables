package net.thedragonteam.cct.compat.crafttweaker.utils;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import net.thedragonteam.thedragonlib.util.LogHelper;

import java.util.Arrays;

public class MTUtils {

    public static Object[] toObjects(IIngredient[] ingredient) {
        return ingredient == null ? null : Arrays.stream(ingredient).map(iIngredient -> iIngredient != null ? toObject(iIngredient) : "").toArray();
    }

    public static String toString(IOreDictEntry entry) {
        return entry.getName();
    }

    public static Object toObject(IIngredient iStack) {
        return iStack == null ? null : iStack instanceof IOreDictEntry ? toString((IOreDictEntry) iStack) : iStack instanceof IItemStack ? toStack((IItemStack) iStack) : null;
    }

    public static ItemStack[] toStacks(IItemStack[] iStack) {
        return iStack == null ? null : Arrays.stream(iStack).map(MTUtils::toStack).toArray(ItemStack[]::new);
    }

    public static ItemStack toStack(IItemStack iStack) {
        if (iStack == null) return ItemStack.EMPTY;
        Object internal = iStack.getInternal();
        if (!(internal instanceof ItemStack)) {
            LogHelper.error("Not a valid item stack: " + iStack);
        }
        //noinspection ConstantConditions
        return (ItemStack) internal;
    }
}

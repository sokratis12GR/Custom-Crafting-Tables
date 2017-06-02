/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.base;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class CCTRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(int width, int height, ItemStack output, Object... params) {
        addShapedRecipe(width, height, output, params);
    }

    public static void addShapedRecipe(int width, int height, ItemStack output, Object... params) {
        CCTManager.getInstance().addRecipe(width, height, output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        CCTManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link CCTManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        CCTManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link CCTManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        CCTManager.getInstance().getRecipeList().remove(recipe);
    }
}

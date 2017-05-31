/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_6x6;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class SixBySixRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static void addShapedRecipe(ItemStack output, Object... params) {
        SixBySixManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        SixBySixManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link SixBySixManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        SixBySixManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link SixBySixManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        SixBySixManager.getInstance().getRecipeList().remove(recipe);
    }
}

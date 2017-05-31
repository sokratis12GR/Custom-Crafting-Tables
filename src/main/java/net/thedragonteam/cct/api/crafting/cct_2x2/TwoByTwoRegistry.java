/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_2x2;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class TwoByTwoRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static void addShapedRecipe(ItemStack output, Object... params) {
        TwoByTwoManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        TwoByTwoManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link TwoByTwoManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        TwoByTwoManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link TwoByTwoManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        TwoByTwoManager.getInstance().getRecipeList().remove(recipe);
    }
}

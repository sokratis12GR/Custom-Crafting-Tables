/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_3x3;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class ThreeByThreeRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static IRecipe addShapedRecipe(ItemStack output, Object... params) {
        return ThreeByThreeManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        ThreeByThreeManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link ThreeByThreeManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        ThreeByThreeManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link ThreeByThreeManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        ThreeByThreeManager.getInstance().getRecipeList().remove(recipe);
    }
}

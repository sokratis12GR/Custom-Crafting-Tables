/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_1x1;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class OneByOneRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        OneByOneManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link OneByOneManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        OneByOneManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link OneByOneManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        OneByOneManager.getInstance().getRecipeList().remove(recipe);
    }
}

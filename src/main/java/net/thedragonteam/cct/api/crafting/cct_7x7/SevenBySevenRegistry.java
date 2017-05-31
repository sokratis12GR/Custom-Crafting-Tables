/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_7x7;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class SevenBySevenRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static void addShapedRecipe(ItemStack output, Object... params) {
        SevenBySevenManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        SevenBySevenManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link SevenBySevenManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        SevenBySevenManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link SevenBySevenManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        SevenBySevenManager.getInstance().getRecipeList().remove(recipe);
    }
}

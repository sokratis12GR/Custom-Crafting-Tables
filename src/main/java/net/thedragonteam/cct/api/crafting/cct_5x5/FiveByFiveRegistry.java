/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_5x5;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class FiveByFiveRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static void addShapedRecipe(ItemStack output, Object... params) {
        FiveByFiveManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        FiveByFiveManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link FiveByFiveManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        FiveByFiveManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link FiveByFiveManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        FiveByFiveManager.getInstance().getRecipeList().remove(recipe);
    }
}

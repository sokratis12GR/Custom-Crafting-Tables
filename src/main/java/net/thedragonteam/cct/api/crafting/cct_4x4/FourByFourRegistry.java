/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_4x4;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class FourByFourRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static IRecipe addShapedRecipe(ItemStack output, Object... params) {
        return FourByFourManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        FourByFourManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link FourByFourManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        FourByFourManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link FourByFourManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        FourByFourManager.getInstance().getRecipeList().remove(recipe);
    }
}

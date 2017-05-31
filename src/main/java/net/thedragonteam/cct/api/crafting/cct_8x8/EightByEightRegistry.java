/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_8x8;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class EightByEightRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static IRecipe addShapedRecipe(ItemStack output, Object... params) {
        return EightByEightManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        EightByEightManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link EightByEightManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        EightByEightManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link EightByEightManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        EightByEightManager.getInstance().getRecipeList().remove(recipe);
    }
}

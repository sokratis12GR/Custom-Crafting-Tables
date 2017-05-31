/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_10x10;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class TenByTenRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static void addShapedRecipe(ItemStack output, Object... params) {
        TenByTenManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        TenByTenManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link TenByTenManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        TenByTenManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link TenByTenManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        TenByTenManager.getInstance().getRecipeList().remove(recipe);
    }
}

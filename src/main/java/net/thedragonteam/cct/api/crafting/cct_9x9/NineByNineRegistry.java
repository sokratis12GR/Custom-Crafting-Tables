/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.cct_9x9;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class NineByNineRegistry {

    /**
     * @param output is the recipe's result
     * @param params are the parameters for the recipe
     */
    public static void addRecipe(ItemStack output, Object... params) {
        addShapedRecipe(output, params);
    }

    public static IRecipe addShapedRecipe(ItemStack output, Object... params) {
        return NineByNineManager.getInstance().addRecipe(output, params);
    }

    public static void addShapelessRecipe(ItemStack output, Object... params) {
        NineByNineManager.getInstance().addShapelessRecipe(output, params);
    }

    /**
     * @param recipe {@link NineByNineManager#addRecipe(IRecipe)}
     */
    public static void addRecipe(IRecipe recipe) {
        NineByNineManager.getInstance().getRecipeList().add(recipe);
    }

    /**
     * @param recipe {@link NineByNineManager#removeRecipe(IRecipe)}
     */
    public static void removeRecipe(IRecipe recipe) {
        NineByNineManager.getInstance().getRecipeList().remove(recipe);
    }
}

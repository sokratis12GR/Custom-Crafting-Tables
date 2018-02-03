package net.thedragonteam.cct.compat.jei.base;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thedragonteam.cct.api.crafting.IRecipe;
import net.thedragonteam.cct.compat.jei.JEIUtils;

public class ShapelessRecipeWrapper extends BlankRecipeWrapper implements IRecipeWrapper {

    private final IRecipe recipe;
    private final NonNullList<ItemStack> inputList;

    public ShapelessRecipeWrapper(IRecipe recipe, NonNullList<ItemStack> inputList) {
        this.recipe = recipe;
        this.inputList = inputList;
        inputList.stream().filter(ItemStack.class::isInstance).filter(itemStack ->
            !itemStack.isEmpty() && itemStack.getCount() != 1
        ).forEachOrdered(itemStack -> itemStack.setCount(1));
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        JEIUtils.getIngredients(ingredients, recipe, inputList);
    }
}
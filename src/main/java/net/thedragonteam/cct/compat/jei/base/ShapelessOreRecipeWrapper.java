package net.thedragonteam.cct.compat.jei.base;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thedragonteam.cct.api.crafting.IRecipe;
import net.thedragonteam.cct.compat.jei.JEIUtils;

public class ShapelessOreRecipeWrapper implements IRecipeWrapper {

    private final IJeiHelpers jeiHelpers;
    private final IRecipe recipe;
    private final NonNullList<Object> inputItems;

    public ShapelessOreRecipeWrapper(IJeiHelpers jeiHelpers, IRecipe recipe, NonNullList<Object> inputItems) {
        this.jeiHelpers = jeiHelpers;
        this.recipe = recipe;
        this.inputItems = inputItems;
        inputItems.stream().filter(input -> input instanceof ItemStack).map(input -> (ItemStack) input).filter(itemStack -> !itemStack.isEmpty() && itemStack.getCount() != 1).forEach(itemStack -> itemStack.setCount(1));
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        JEIUtils.getIngredients(ingredients, recipe, jeiHelpers, inputItems);
    }
}
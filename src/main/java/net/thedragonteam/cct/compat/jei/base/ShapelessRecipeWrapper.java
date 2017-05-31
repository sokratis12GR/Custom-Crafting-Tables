package net.thedragonteam.cct.compat.jei.base;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.thedragonteam.cct.compat.jei.JEIUtils;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by sokratis12GR on 5/30/2017.
 */
public class ShapelessRecipeWrapper extends BlankRecipeWrapper implements IRecipeWrapper {

    private final IRecipe recipe;
    private final List<ItemStack> inputList;

    public ShapelessRecipeWrapper(IRecipe recipe, List<ItemStack> inputList) {
        this.recipe = recipe;
        this.inputList = inputList;
        for (Object input : inputList) {
            if (input instanceof ItemStack) {
                ItemStack itemStack = (ItemStack) input;
                if (!itemStack.isEmpty() && itemStack.getCount() != 1) {
                    itemStack.setCount(1);
                }
            }
        }
    }

    @Override
    public void getIngredients(@Nonnull IIngredients ingredients) {
        JEIUtils.getIngredients(ingredients, recipe, inputList);
    }
}
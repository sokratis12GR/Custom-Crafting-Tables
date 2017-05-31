package net.thedragonteam.cct.compat.jei.base;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.thedragonteam.cct.compat.jei.JEIUtils;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class ShapedRecipeWrapper extends BlankRecipeWrapper implements IShapedCraftingRecipeWrapper {

    private final IRecipe recipe;
    private final ItemStack[] inputItems;
    private final int width;
    private final int height;

    public ShapedRecipeWrapper(IRecipe recipe, ItemStack[] inputItems, int width, int height) {
        this.recipe = recipe;
        this.inputItems = inputItems;
        this.width = width;
        this.height = height;
        for (ItemStack itemStack : inputItems) {
            if (!itemStack.isEmpty() && itemStack.getCount() != 1) {
                itemStack.setCount(1);
            }
        }
    }

    @Override
    public void getIngredients(@Nonnull IIngredients ingredients) {
        JEIUtils.getIngredients(ingredients, recipe, Arrays.asList(inputItems));
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
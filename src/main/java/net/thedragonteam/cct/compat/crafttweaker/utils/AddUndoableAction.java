package net.thedragonteam.cct.compat.crafttweaker.utils;

import crafttweaker.IAction;
import net.thedragonteam.cct.api.crafting.IRecipe;

import static java.lang.String.format;

/**
 * Created by sokratis12GR on 6/10/2017.
 */
public abstract class AddUndoableAction implements IAction {

    private IRecipe recipe;
    private String xy;

    public AddUndoableAction(IRecipe recipe, int size) {
        this.recipe = recipe;
        this.xy = format("%sx%s", size, size);
    }

    @Override
    public String describe() {
        return format("Adding %s Recipe for %s", xy, recipe.getRecipeOutput().getDisplayName());
    }
}

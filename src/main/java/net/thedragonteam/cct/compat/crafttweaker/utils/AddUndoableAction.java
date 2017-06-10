package net.thedragonteam.cct.compat.crafttweaker.utils;

import minetweaker.IUndoableAction;
import net.minecraft.item.crafting.IRecipe;

import static java.lang.String.format;

/**
 * Created by sokratis12GR on 6/10/2017.
 */
public abstract class AddUndoableAction implements IUndoableAction {

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

    @Override
    public String describeUndo() {
        return format("Un-adding %s for %s", xy, recipe.getRecipeOutput().getDisplayName());
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    @Override
    public Object getOverrideKey() {
        return null;
    }
}

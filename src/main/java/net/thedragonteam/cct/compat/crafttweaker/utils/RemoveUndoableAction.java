package net.thedragonteam.cct.compat.crafttweaker.utils;

import minetweaker.IUndoableAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import static java.lang.String.format;

public abstract class RemoveUndoableAction implements IUndoableAction {
    private IRecipe recipe = null;
    private ItemStack remove;
    private String xy;

    public RemoveUndoableAction( ItemStack remove, int size) {
        this.remove = remove;
        this.xy = format("%sx%s", size, size);
    }

    @Override
    public boolean canUndo() {
        return recipe != null;
    }

    @Override
    public String describe() {
        return format("Removing %s Recipe for %s", xy, remove.getDisplayName());
    }

    @Override
    public String describeUndo() {
        return format("Un-removing %s Recipe for %s", xy, remove.getDisplayName());
    }

    @Override
    public Object getOverrideKey() {
        return null;
    }

}
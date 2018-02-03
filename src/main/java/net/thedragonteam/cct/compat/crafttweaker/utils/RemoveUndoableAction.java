package net.thedragonteam.cct.compat.crafttweaker.utils;

import crafttweaker.IAction;
import net.minecraft.item.ItemStack;

import static java.lang.String.format;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 **/
public abstract class RemoveUndoableAction implements IAction {
    private ItemStack remove;
    private String xy;

    public RemoveUndoableAction(ItemStack remove, int size) {
        this.remove = remove;
        this.xy = format("%sx%s", size, size);
    }

    @Override
    public String describe() {
        return format("Removing %s Recipe for %s", xy, remove.getDisplayName());
    }
}
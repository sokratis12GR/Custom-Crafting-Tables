/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.api.crafting.base;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nonnull;

public class ShapedRecipe implements IRecipe {
    /**
     * How many horizontal itemHandler this recipe is wide.
     */
    public int recipeWidth;
    /**
     * How many vertical itemHandler this recipe uses.
     */
    public int recipeHeight;
    /**
     * Is a array of ItemStack that composes the recipe.
     */
    public final ItemStack[] input;
    /**
     * Is the ItemStack that you get when craft the recipe.
     */
    private final ItemStack recipeOutput;
    private boolean copyIngredientNBT;
    public int cctWidth;
    public int cctHeight;

    public ShapedRecipe(int width, int height, ItemStack[] ingredientsIn, ItemStack output, int cctWidth, int cctHeight) {
        this.recipeWidth = width;
        this.recipeHeight = height;
        this.input = ingredientsIn;
        this.cctWidth = cctWidth;
        this.cctHeight = cctHeight;
        for (int i = 0; i < this.input.length; ++i) {
            if (this.input[i].isEmpty()) this.input[i] = ItemStack.EMPTY;
        }

        this.recipeOutput = output;
    }

    @Override
    @Nonnull
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    @Override
    @Nonnull
    public NonNullList<ItemStack> getRemainingItems(@Nonnull InventoryCrafting inv) {
        NonNullList<ItemStack> nonnulllist = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);
            nonnulllist.set(i, ForgeHooks.getContainerItem(itemstack));
        }

        return nonnulllist;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(@Nonnull InventoryCrafting inv, @Nonnull World worldIn) {
        for (int i = 0; i <= cctWidth - this.recipeWidth; ++i) {
            for (int j = 0; j <= cctHeight - this.recipeHeight; ++j) {
                if (this.checkMatch(inv, i, j, true) || this.checkMatch(inv, i, j, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(InventoryCrafting inv, int width, int height, boolean isMirrored) {
        for (int i = 0; i < cctWidth; ++i) {
            for (int j = 0; j < cctHeight; ++j) {
                int k = i - width;
                int l = j - height;
                ItemStack itemstack = ItemStack.EMPTY;

                if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight) {
                    itemstack = isMirrored ? this.input[this.recipeWidth - k - 1 + l * this.recipeWidth] : this.input[k + l * this.recipeWidth];
                }

                ItemStack itemstack1 = inv.getStackInRowAndColumn(i, j);

                if ((!itemstack1.isEmpty() || !itemstack.isEmpty()) && (itemstack1.isEmpty() != itemstack.isEmpty() || itemstack.getItem() != itemstack1.getItem() || itemstack.getMetadata() != 32767 && itemstack.getMetadata() != itemstack1.getMetadata())) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    @Nonnull
    public ItemStack getCraftingResult(@Nonnull InventoryCrafting inv) {
        ItemStack itemstack = this.getRecipeOutput().copy();

        if (this.copyIngredientNBT) {
            for (int i = 0; i < inv.getSizeInventory(); ++i) {
                ItemStack itemstack1 = inv.getStackInSlot(i);

                if (!itemstack1.isEmpty() && itemstack1.hasTagCompound()) {
                    itemstack.setTagCompound(itemstack1.getTagCompound().copy());
                }
            }
        }

        return itemstack;
    }

    /**
     * Returns the input for this recipe, any mod accessing this value should never
     * manipulate the values in this array as it will effect the recipe itself.
     *
     * @return The recipes input vales.
     */
    public ItemStack[] getInput() {
        return this.input;
    }

    /**
     * Returns the size of the recipe area
     */
    @Override
    public int getRecipeSize() {
        return this.recipeWidth * this.recipeHeight;
    }

    public int getWidth() {
        return recipeWidth;
    }

    public int getHeight() {
        return recipeHeight;
    }
}
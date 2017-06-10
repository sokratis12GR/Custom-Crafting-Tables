/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.crafttweaker.tables;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.thedragonteam.cct.api.crafting.cct_4x4.FourByFourManager;
import net.thedragonteam.cct.api.crafting.cct_4x4.ShapedOreRecipe;
import net.thedragonteam.cct.api.crafting.cct_4x4.ShapelessOreRecipe;
import net.thedragonteam.cct.compat.crafttweaker.utils.AddUndoableAction;
import net.thedragonteam.cct.compat.crafttweaker.utils.RemoveUndoableAction;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;
import static net.thedragonteam.cct.compat.crafttweaker.MTCCTPlugin.toFourByFourShapedObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toStack;

@ZenClass("mods." + MODID + ".FourByFour")
public class FourByFour {

    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] ingredients) {
        MineTweakerAPI.apply(new Add(new ShapelessOreRecipe(toStack(output), toObjects(ingredients))));
    }

    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] ingredients) {
        MineTweakerAPI.apply(new Add(new ShapedOreRecipe(toStack(output), toFourByFourShapedObjects(ingredients))));
    }

    @ZenMethod
    public static void remove(IItemStack target) {
        MineTweakerAPI.apply(new Remove(toStack(target)));
    }

    private static class Add extends AddUndoableAction {
        IRecipe recipe;

        public Add(IRecipe add) {
            super(add, 4);
            this.recipe = add;
        }

        @Override
        public void apply() {
            FourByFourManager.getInstance().getRecipeList().add(recipe);
            MineTweakerAPI.getIjeiRecipeRegistry().addRecipe(recipe);
        }

        @Override
        public void undo() {
            FourByFourManager.getInstance().getRecipeList().remove(recipe);
            MineTweakerAPI.getIjeiRecipeRegistry().removeRecipe(recipe);
        }

    }

    private static class Remove extends RemoveUndoableAction {
        IRecipe recipe = null;
        ItemStack remove;

        public Remove(ItemStack remove) {
            super(remove, 4);
            this.remove = remove;
        }

        @Override
        public void apply() {

            for (Object obj : FourByFourManager.getInstance().getRecipeList()) {
                if (obj instanceof IRecipe) {
                    IRecipe craft = (IRecipe) obj;
                    if (craft.getRecipeOutput().isItemEqual(remove)) {
                        recipe = craft;
                        FourByFourManager.getInstance().getRecipeList().remove(obj);
                        MineTweakerAPI.getIjeiRecipeRegistry().removeRecipe(recipe);
                        break;
                    }
                }
            }
        }

        @Override
        public void undo() {
            FourByFourManager.getInstance().getRecipeList().add(recipe);
            MineTweakerAPI.getIjeiRecipeRegistry().addRecipe(recipe);
        }

    }
}
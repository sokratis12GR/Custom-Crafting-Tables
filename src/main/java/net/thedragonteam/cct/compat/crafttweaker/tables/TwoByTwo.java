/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.crafttweaker.tables;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.thedragonteam.cct.api.crafting.cct_2x2.ShapedOreRecipe;
import net.thedragonteam.cct.api.crafting.cct_2x2.ShapelessOreRecipe;
import net.thedragonteam.cct.api.crafting.cct_2x2.TwoByTwoManager;
import net.thedragonteam.cct.compat.crafttweaker.utils.AddUndoableAction;
import net.thedragonteam.cct.compat.crafttweaker.utils.RemoveUndoableAction;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;
import static net.thedragonteam.cct.compat.crafttweaker.MTCCTPlugin.toTwoByTwoObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toStack;

@ZenClass("mods." + MODID + ".TwoByTwo")
public class TwoByTwo {

    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] ingredients) {
        MineTweakerAPI.apply(new AddAction(new ShapelessOreRecipe(toStack(output), toObjects(ingredients))));
    }

    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] ingredients) {
        MineTweakerAPI.apply(new AddAction(new ShapedOreRecipe(toStack(output), toTwoByTwoObjects(ingredients))));
    }

    @ZenMethod
    public static void remove(IItemStack target) {
        MineTweakerAPI.apply(new Remove(toStack(target)));
    }

    private static class AddAction extends AddUndoableAction {
        IRecipe recipe;

        public AddAction(IRecipe add) {
            super(add, 2);
            this.recipe = add;
        }

        @Override
        public void apply() {
            TwoByTwoManager.getInstance().getRecipeList().add(recipe);
            //MineTweakerAPI.getIjeiRecipeRegistry().addRecipe(recipe);
        }

        @Override
        public void undo() {
            TwoByTwoManager.getInstance().getRecipeList().remove(recipe);
            //MineTweakerAPI.getIjeiRecipeRegistry().removeRecipe(recipe);
        }
    }

    private static class Remove extends RemoveUndoableAction {
        IRecipe recipe = null;
        ItemStack remove;

        public Remove(ItemStack remove) {
            super(remove, 2);
            this.remove = remove;
        }

        @Override
        public void apply() {
            for (Object obj : TwoByTwoManager.getInstance().getRecipeList()) {
                if (obj instanceof IRecipe) {
                    IRecipe craft = (IRecipe) obj;
                    if (craft.getRecipeOutput().isItemEqual(remove)) {
                        recipe = craft;
                        TwoByTwoManager.getInstance().getRecipeList().remove(obj);
                        //MineTweakerAPI.getIjeiRecipeRegistry().removeRecipe(recipe);
                        break;
                    }
                }
            }
        }

        @Override
        public void undo() {
            TwoByTwoManager.getInstance().getRecipeList().add(recipe);
            //MineTweakerAPI.getIjeiRecipeRegistry().addRecipe(recipe);
        }

    }
}
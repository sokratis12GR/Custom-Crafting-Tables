/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.crafttweaker.tables;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.thedragonteam.cct.api.crafting.cct_3x3.ShapedOreRecipe;
import net.thedragonteam.cct.api.crafting.cct_3x3.ShapelessOreRecipe;
import net.thedragonteam.cct.api.crafting.cct_3x3.ThreeByThreeManager;
import net.thedragonteam.cct.compat.crafttweaker.utils.AddUndoableAction;
import net.thedragonteam.cct.compat.crafttweaker.utils.RemoveUndoableAction;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import static net.thedragonteam.cct.CustomCraftingTables.MODID;
import static net.thedragonteam.cct.compat.crafttweaker.MTCCTPlugin.toThreeByThreeObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toStack;

@ZenClass("mods." + MODID + ".ThreeByThree")
public class ThreeByThree {

    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] ingredients) {
        MineTweakerAPI.apply(new Add(new ShapelessOreRecipe(toStack(output), toObjects(ingredients))));
    }

    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] ingredients) {
        MineTweakerAPI.apply(new Add(new ShapedOreRecipe(toStack(output), toThreeByThreeObjects(ingredients))));
    }

    @ZenMethod
    public static void remove(IItemStack target) {
        MineTweakerAPI.apply(new Remove(toStack(target)));
    }

    private static class Add extends AddUndoableAction {
        IRecipe recipe;

        public Add(IRecipe add) {
            super(add, 3);
            this.recipe = add;
        }

        @Override
        public void apply() {
            ThreeByThreeManager.getInstance().getRecipeList().add(recipe);
            MineTweakerAPI.getIjeiRecipeRegistry().addRecipe(recipe);
        }

        @Override
        public void undo() {
            ThreeByThreeManager.getInstance().getRecipeList().remove(recipe);
            MineTweakerAPI.getIjeiRecipeRegistry().removeRecipe(recipe);
        }

    }

    private static class Remove extends RemoveUndoableAction {
        IRecipe recipe = null;
        ItemStack remove;

        public Remove(ItemStack remove) {
            super(remove, 3);
            this.remove = remove;
        }

        @Override
        public void apply() {

            for (Object obj : ThreeByThreeManager.getInstance().getRecipeList()) {
                if (obj instanceof IRecipe) {
                    IRecipe craft = (IRecipe) obj;
                    if (craft.getRecipeOutput().isItemEqual(remove)) {
                        recipe = craft;
                        ThreeByThreeManager.getInstance().getRecipeList().remove(obj);
                        MineTweakerAPI.getIjeiRecipeRegistry().removeRecipe(recipe);
                        break;
                    }
                }
            }
        }

        @Override
        public void undo() {
            ThreeByThreeManager.getInstance().getRecipeList().add(recipe);
            MineTweakerAPI.getIjeiRecipeRegistry().addRecipe(recipe);
        }
    }
}
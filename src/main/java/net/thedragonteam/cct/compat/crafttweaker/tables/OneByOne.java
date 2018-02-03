/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.crafttweaker.tables;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import net.thedragonteam.cct.api.crafting.IRecipe;
import net.thedragonteam.cct.api.crafting.base.BaseCraftingManager;
import net.thedragonteam.cct.api.crafting.base.BaseShapelessOreRecipe;
import net.thedragonteam.cct.compat.crafttweaker.CTCCTPlugin;
import net.thedragonteam.cct.compat.crafttweaker.utils.AddUndoableAction;
import net.thedragonteam.cct.compat.crafttweaker.utils.RemoveUndoableAction;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toStack;

@ZenClass("mods.cct.OneByOne")
public class OneByOne {

    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient[] ingredients) {
        CraftTweakerAPI.apply(new Add(new BaseShapelessOreRecipe(toStack(output), toObjects(ingredients))));
    }

    @ZenMethod
    public static void remove(IItemStack target) {
        CraftTweakerAPI.apply(new Remove(toStack(target)));
    }

    private static class Add extends AddUndoableAction {
        IRecipe recipe;

        public Add(IRecipe add) {
            super(add, 1);
            this.recipe = add;
        }

        @Override
        public void apply() {
            BaseCraftingManager.getOneByOne().getRecipeList().add(recipe);
        }
    }

    private static class Remove extends RemoveUndoableAction {
        ItemStack remove;
        List<IRecipe> recipeList = BaseCraftingManager.getOneByOne().getRecipeList();

        public Remove(ItemStack remove) {
            super(remove, 1);
            this.remove = remove;
        }

        @Override
        public void apply() {
            CTCCTPlugin.removeRecipe(recipeList, remove);
        }
    }
}
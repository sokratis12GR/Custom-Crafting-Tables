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
import net.thedragonteam.cct.api.crafting.base.BaseShapedOreRecipe;
import net.thedragonteam.cct.api.crafting.base.BaseShapelessOreRecipe;
import net.thedragonteam.cct.compat.crafttweaker.CTCCTPlugin;
import net.thedragonteam.cct.compat.crafttweaker.utils.AddUndoableAction;
import net.thedragonteam.cct.compat.crafttweaker.utils.RemoveUndoableAction;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

import static net.thedragonteam.cct.compat.crafttweaker.CTCCTPlugin.toSevenBySevenObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toObjects;
import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toStack;

@ZenClass("mods.cct.SevenBySeven")
public class SevenBySeven {

    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] ingredients) {
        CraftTweakerAPI.apply(new Add(new BaseShapelessOreRecipe(toStack(output), toObjects(ingredients))));
    }

    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] ingredients) {
        CraftTweakerAPI.apply(new Add(new BaseShapedOreRecipe(7, toStack(output), toSevenBySevenObjects(ingredients))));
    }

    @ZenMethod
    public static void remove(IItemStack target) {
        CraftTweakerAPI.apply(new Remove(toStack(target)));
    }

    private static class Add extends AddUndoableAction {
        IRecipe recipe;

        public Add(IRecipe add) {
            super(add, 7);
            this.recipe = add;
        }

        @Override
        public void apply() {
            BaseCraftingManager.getSevenBySeven().getRecipeList().add(recipe);
        }
    }

    private static class Remove extends RemoveUndoableAction {
        ItemStack remove;
        List<IRecipe> recipeList = BaseCraftingManager.getSevenBySeven().getRecipeList();

        public Remove(ItemStack remove) {
            super(remove, 7);
            this.remove = remove;
        }

        @Override
        public void apply() {
            CTCCTPlugin.removeRecipe(recipeList, remove);
        }
    }
}
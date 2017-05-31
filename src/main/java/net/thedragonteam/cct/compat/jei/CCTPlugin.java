/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.jei;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandlerHelper;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import mezz.jei.startup.StackHelper;
import net.thedragonteam.cct.api.crafting.cct_10x10.TenByTenManager;
import net.thedragonteam.cct.api.crafting.cct_3x3.ThreeByThreeManager;
import net.thedragonteam.cct.api.crafting.cct_4x4.FourByFourManager;
import net.thedragonteam.cct.api.crafting.cct_5x5.FiveByFiveManager;
import net.thedragonteam.cct.api.crafting.cct_6x6.SixBySixManager;
import net.thedragonteam.cct.api.crafting.cct_7x7.SevenBySevenManager;
import net.thedragonteam.cct.api.crafting.cct_8x8.EightByEightManager;
import net.thedragonteam.cct.api.crafting.cct_9x9.NineByNineManager;
import net.thedragonteam.cct.client.gui.*;
import net.thedragonteam.cct.compat.jei.base.ShapedOreRecipeWrapper;
import net.thedragonteam.cct.compat.jei.base.ShapedRecipeWrapper;
import net.thedragonteam.cct.compat.jei.base.ShapelessOreRecipeWrapper;
import net.thedragonteam.cct.compat.jei.base.ShapelessRecipeWrapper;
import net.thedragonteam.cct.compat.jei.categories.*;
import net.thedragonteam.cct.container.*;
import net.thedragonteam.cct.container.base.AdvancedRecipeTransferInfo;
import net.thedragonteam.cct.registry.ModBlocks;

import static net.thedragonteam.cct.util.Utils.setLocation;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

@JEIPlugin
public class CCTPlugin extends BlankModPlugin {

    public static final String JEI_CATEGORY_2X2 = setLocation("2x2");
    public static final String JEI_CATEGORY_3X3 = setLocation("3x3");
    public static final String JEI_CATEGORY_4X4 = setLocation("4x4");
    public static final String JEI_CATEGORY_5X5 = setLocation("5x5");
    public static final String JEI_CATEGORY_6X6 = setLocation("6x6");
    public static final String JEI_CATEGORY_7X7 = setLocation("7x7");
    public static final String JEI_CATEGORY_8X8 = setLocation("8x8");
    public static final String JEI_CATEGORY_9X9 = setLocation("9x9");
    public static final String JEI_CATEGORY_10X10 = setLocation("10x10");

    public static IJeiHelpers jeiHelper;

    @Override
    public void register(IModRegistry registry) {
        jeiHelper = registry.getJeiHelpers();
        IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        IRecipeTransferHandlerHelper recipeTransferHandlerHelper = jeiHelper.recipeTransferHandlerHelper();
        StackHelper stackHelper = (StackHelper) jeiHelper.getStackHelper();
        IIngredientBlacklist blacklist = jeiHelper.getIngredientBlacklist();
        registry.addRecipeCategories(
                new ThreeByThreeCategory(),
                new FourByFourCategory(),
                new FiveByFiveCategory(),
                new SixBySixCategory(),
                new SevenBySevenCategory(),
                new EightByEightCategory(),
                new NineByNineCategory(),
                new TenByTenCategory()
        );

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_3x3.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_3X3);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_3x3.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_3X3);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_3x3.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_3X3);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_3x3.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_3X3);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_4x4.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_4X4);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_4x4.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_4X4);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_4x4.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_4X4);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_4x4.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_4X4);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_5x5.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_5X5);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_5x5.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_5X5);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_5x5.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_5X5);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_5x5.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_5X5);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_6x6.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_6X6);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_6x6.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_6X6);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_6x6.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_6X6);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_6x6.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_6X6);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_7x7.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_7X7);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_7x7.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_7X7);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_7x7.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_7X7);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_7x7.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_7X7);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_8x8.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_8X8);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_8x8.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_8X8);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_8x8.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_8X8);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_8x8.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_8X8);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_9x9.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_9X9);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_9x9.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_9X9);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_9x9.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_9X9);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_9x9.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_9X9);

        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_10x10.ShapedRecipes.class, recipe -> new ShapedRecipeWrapper(recipe, recipe.input, recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_10X10);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_10x10.ShapelessRecipes.class, recipe -> new ShapelessRecipeWrapper(recipe, recipe.input), JEI_CATEGORY_10X10);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_10x10.ShapelessOreRecipe.class, recipe -> new ShapelessOreRecipeWrapper(jeiHelper, recipe, recipe.getInput()), JEI_CATEGORY_10X10);
        registry.handleRecipes(net.thedragonteam.cct.api.crafting.cct_10x10.ShapedOreRecipe.class, recipe -> new ShapedOreRecipeWrapper(jeiHelper, recipe, recipe.getInput(), recipe.getWidth(), recipe.getHeight()), JEI_CATEGORY_10X10);

        registry.addRecipeClickArea(GuiThreeByThree.class, 88, 32, 28, 23, JEI_CATEGORY_3X3);
        registry.addRecipeClickArea(GuiFourByFour.class, 88, 40, 28, 27, JEI_CATEGORY_4X4);
        registry.addRecipeClickArea(GuiFiveByFive.class, 112, 50, 28, 27, JEI_CATEGORY_5X5);
        registry.addRecipeClickArea(GuiSixBySix.class, 120, 62, 24, 17, JEI_CATEGORY_6X6);
        registry.addRecipeClickArea(GuiSevenBySeven.class, 138, 70, 24, 17, JEI_CATEGORY_7X7);
        registry.addRecipeClickArea(GuiEightByEight.class, 161, 80, 24, 17, JEI_CATEGORY_8X8);
        registry.addRecipeClickArea(GuiNineByNine.class, 185, 23, 24, 17, JEI_CATEGORY_9X9);
        registry.addRecipeClickArea(GuiTenByTen.class, 219, 103, 28, 25, JEI_CATEGORY_10X10);

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();

        recipeTransferRegistry.addRecipeTransferHandler(ContainerThreeByThree.class, JEI_CATEGORY_3X3, 1, 9, 10, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerFourByFour.class, JEI_CATEGORY_4X4, 1, 16, 17, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerFiveByFive.class, JEI_CATEGORY_5X5, 1, 25, 26, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerSixBySix.class, JEI_CATEGORY_6X6, 1, 36, 37, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerSevenBySeven.class, JEI_CATEGORY_7X7, 1, 49, 50, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerEightByEight.class, JEI_CATEGORY_8X8, 1, 64, 65, 36);
        recipeTransferRegistry.addRecipeTransferHandler(new AdvancedRecipeTransferInfo<>(ContainerNineByNine.class, JEI_CATEGORY_9X9, 1, 81, 82, 36));
        recipeTransferRegistry.addRecipeTransferHandler(new AdvancedRecipeTransferInfo<>(ContainerTenByTen.class, JEI_CATEGORY_10X10, 1, 100, 101, 36, true, 4));

        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[2]), JEI_CATEGORY_3X3);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[3]), JEI_CATEGORY_4X4);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[4]), JEI_CATEGORY_5X5);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[5]), JEI_CATEGORY_6X6);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[6]), JEI_CATEGORY_7X7);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[7]), JEI_CATEGORY_8X8);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[8]), JEI_CATEGORY_9X9);
        registry.addRecipeCategoryCraftingItem(getItemStack(ModBlocks.blockCCT[9]), JEI_CATEGORY_10X10);

        registry.addRecipes(ThreeByThreeManager.getInstance().getRecipeList(), JEI_CATEGORY_3X3);
        registry.addRecipes(FourByFourManager.getInstance().getRecipeList(), JEI_CATEGORY_4X4);
        registry.addRecipes(FiveByFiveManager.getInstance().getRecipeList(), JEI_CATEGORY_5X5);
        registry.addRecipes(SixBySixManager.getInstance().getRecipeList(), JEI_CATEGORY_6X6);
        registry.addRecipes(SevenBySevenManager.getInstance().getRecipeList(), JEI_CATEGORY_7X7);
        registry.addRecipes(EightByEightManager.getInstance().getRecipeList(), JEI_CATEGORY_8X8);
        registry.addRecipes(NineByNineManager.getInstance().getRecipeList(), JEI_CATEGORY_9X9);
        registry.addRecipes(TenByTenManager.getInstance().getRecipeList(), JEI_CATEGORY_10X10);
        super.register(registry);
    }
}

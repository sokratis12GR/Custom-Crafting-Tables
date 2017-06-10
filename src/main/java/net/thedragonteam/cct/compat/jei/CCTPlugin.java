/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.jei;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.thedragonteam.cct.api.crafting.cct_10x10.TenByTenManager;
import net.thedragonteam.cct.api.crafting.cct_3x3.ThreeByThreeManager;
import net.thedragonteam.cct.api.crafting.cct_4x4.FourByFourManager;
import net.thedragonteam.cct.api.crafting.cct_5x5.FiveByFiveManager;
import net.thedragonteam.cct.api.crafting.cct_6x6.SixBySixManager;
import net.thedragonteam.cct.api.crafting.cct_7x7.SevenBySevenManager;
import net.thedragonteam.cct.api.crafting.cct_8x8.EightByEightManager;
import net.thedragonteam.cct.api.crafting.cct_9x9.NineByNineManager;
import net.thedragonteam.cct.client.gui.*;
import net.thedragonteam.cct.compat.jei.base.*;
import net.thedragonteam.cct.container.*;
import net.thedragonteam.cct.container.base.AdvancedRecipeTransferInfo;
import net.thedragonteam.cct.registry.ModBlocks;

import static net.thedragonteam.cct.util.Utils.setLocation;
import static net.thedragonteam.thedragonlib.util.ItemStackUtils.getItemStack;

@JEIPlugin
public class CCTPlugin extends BlankModPlugin {

    private static final String JEI_CATEGORY_3X3 = setLocation("3x3");
    private static final String JEI_CATEGORY_4X4 = setLocation("4x4");
    private static final String JEI_CATEGORY_5X5 = setLocation("5x5");
    private static final String JEI_CATEGORY_6X6 = setLocation("6x6");
    private static final String JEI_CATEGORY_7X7 = setLocation("7x7");
    private static final String JEI_CATEGORY_8X8 = setLocation("8x8");
    private static final String JEI_CATEGORY_9X9 = setLocation("9x9");
    private static final String JEI_CATEGORY_10X10 = setLocation("10x10");

    private static final String[] JEI_CATEGORIES = new String[]{JEI_CATEGORY_3X3, JEI_CATEGORY_4X4, JEI_CATEGORY_5X5, JEI_CATEGORY_6X6, JEI_CATEGORY_7X7, JEI_CATEGORY_8X8, JEI_CATEGORY_9X9, JEI_CATEGORY_10X10};

    public static IJeiHelpers jeiHelper;

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        jeiHelper = registry.getJeiHelpers();
        registry.addRecipeCategories(
                new CategoryBase(29, 16, 116, 54, 94, 18, 3, JEI_CATEGORY_3X3),
                new CategoryBase(11, 16, 136, 70, 113, 26, 4, JEI_CATEGORY_4X4),
                new CategoryBase(11, 16, 156, 93, 136, 36, 5, JEI_CATEGORY_5X5),
                new CategoryBase(11, 16, 158, 108, 138, 46, 6, JEI_CATEGORY_6X6),
                new CategoryBaseAdvanced(11, 16, 178, 126, 156, 54, 7, JEI_CATEGORY_7X7, 160, 180),
                new CategoryBaseAdvanced(11, 16, 201, 144, 180, 65, 8, JEI_CATEGORY_8X8, 180, 90),
                new CategoryBaseAdvanced(11, 16, 200, 162, 178, 35, 9, JEI_CATEGORY_9X9, 185, 60),
                new CategoryBaseAdvanced(38, 16, 213, 180, 190, 117, 10, JEI_CATEGORY_10X10, 194, 140)
        );
        super.registerCategories(registry);
    }

    @Override
    public void register(IModRegistry registry) {
        jeiHelper = registry.getJeiHelpers();

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

        for (int i = 0; i < JEI_CATEGORIES.length; i++) {
            registry.addRecipeCatalyst(getItemStack(ModBlocks.blockCCT[i + 2]), JEI_CATEGORIES[i]);
        }

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

/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.jei.categories;

import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;
import net.thedragonteam.cct.compat.jei.CCTPlugin;
import net.thedragonteam.cct.compat.jei.JEIUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

import static net.thedragonteam.cct.CCTConfig.cctJEINames;
import static net.thedragonteam.cct.util.Utils.getFormatted;
import static net.thedragonteam.cct.util.Utils.setRL;

public class EightByEightCategory extends BlankRecipeCategory<IRecipeWrapper> {

    public static final int width = 201;
    public static final int height = 144;
    private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private final IDrawable background;
    private final String localizedName;
    private final ICraftingGridHelper craftingGridHelper;

    public EightByEightCategory() {
        ResourceLocation location = setRL("textures/gui/container/gui_8x8.png");
        background = CCTPlugin.jeiHelper.getGuiHelper().createDrawable(location, 11, 16, width, height);
        localizedName = cctJEINames[7] != null && !Objects.equals(cctJEINames[7], "") && !Objects.equals(cctJEINames[7], " ") ? cctJEINames[7] : getFormatted("gui.jei.category.8x8");
        craftingGridHelper = CCTPlugin.jeiHelper.getGuiHelper().createCraftingGridHelper(INPUT_SLOT, OUTPUT_SLOT);
    }

    @Nonnull
    @Override
    public String getUid() {
        return CCTPlugin.JEI_CATEGORY_8X8;
    }

    @Nonnull
    @Override
    public String getTitle() {
        return localizedName;
    }

    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        recipeLayout.setRecipeTransferButton(180, 90);
        JEIUtils.setRecipe(recipeLayout, recipeWrapper, ingredients, craftingGridHelper, 180, 65, 8, 8, INPUT_SLOT, OUTPUT_SLOT);
    }
}

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

public class FourByFourCategory extends BlankRecipeCategory<IRecipeWrapper> {

    public static final int width = 136;
    public static final int height = 70;
    private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    @Nonnull
    private final IDrawable background;
    @Nonnull
    private final String localizedName;
    @Nonnull
    private final ICraftingGridHelper craftingGridHelper;

    public FourByFourCategory() {
        ResourceLocation location = setRL("textures/gui/container/gui_4x4.png");
        background = CCTPlugin.jeiHelper.getGuiHelper().createDrawable(location, 11, 16, width, height);
        localizedName = cctJEINames[3] != null && !Objects.equals(cctJEINames[3], "") && !Objects.equals(cctJEINames[3], " ") ? cctJEINames[3] : getFormatted("gui.jei.category.4x4");
        craftingGridHelper = CCTPlugin.jeiHelper.getGuiHelper().createCraftingGridHelper(INPUT_SLOT, OUTPUT_SLOT);
    }

    @Nonnull
    @Override
    public String getUid() {
        return CCTPlugin.JEI_CATEGORY_4X4;
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
        JEIUtils.setRecipe(recipeLayout, recipeWrapper, ingredients, craftingGridHelper, 113, 26, 4, 4, INPUT_SLOT, OUTPUT_SLOT);
    }
}

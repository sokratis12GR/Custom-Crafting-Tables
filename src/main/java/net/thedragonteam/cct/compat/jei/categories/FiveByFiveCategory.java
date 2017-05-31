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

public class FiveByFiveCategory extends BlankRecipeCategory<IRecipeWrapper> {

    public static final int width = 156;
    public static final int height = 93;
    private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private final IDrawable background;
    private final String localizedName;
    private final ICraftingGridHelper craftingGridHelper;

    public FiveByFiveCategory() {
        ResourceLocation location = setRL("textures/gui/container/gui_5x5.png");
        background = CCTPlugin.jeiHelper.getGuiHelper().createDrawable(location, 11, 16, width, height);
        localizedName = cctJEINames[4] != null && !Objects.equals(cctJEINames[4], "") && !Objects.equals(cctJEINames[4], " ") ? cctJEINames[4] : getFormatted("gui.jei.category.5x5");
        craftingGridHelper = CCTPlugin.jeiHelper.getGuiHelper().createCraftingGridHelper(INPUT_SLOT, OUTPUT_SLOT);
    }

    @Nonnull
    @Override
    public String getUid() {
        return CCTPlugin.JEI_CATEGORY_5X5;
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
        JEIUtils.setRecipe(recipeLayout, recipeWrapper, ingredients, craftingGridHelper, 136, 36, 5, 5, INPUT_SLOT, OUTPUT_SLOT);
    }
}

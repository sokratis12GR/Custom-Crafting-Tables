/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.jei.base;

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

import static java.lang.String.format;
import static net.thedragonteam.cct.CCTConfig.cctJEINames;
import static net.thedragonteam.cct.util.Utils.getFormatted;
import static net.thedragonteam.cct.util.Utils.setRL;

public class CategoryBase extends BlankRecipeCategory<IRecipeWrapper> {

    private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private final IDrawable background;
    private final String localizedName;
    private final ICraftingGridHelper craftingGridHelper;
    private final int xPos;
    private final int yPos;
    private final int xy;
    private final String category;

    public CategoryBase(int u, int v, int widthU, int heightV, int outputXPos, int outputYPos, int xy, String category) {
        this.xPos = outputXPos;
        this.yPos = outputYPos;
        this.xy = xy;
        this.category = category;
        ResourceLocation location = setRL(format("textures/gui/container/gui_%sx%s.png", xy, xy));
        background = CCTPlugin.jeiHelper.getGuiHelper().createDrawable(location, u, v, widthU, heightV);
        localizedName = cctJEINames[xy - 1] != null && !Objects.equals(cctJEINames[xy - 1], "") &&
                !Objects.equals(cctJEINames[xy - 1], " ") ? cctJEINames[xy - 1] : getFormatted(String.format("gui.jei.category.%sx%s", xy, xy));
        craftingGridHelper = CCTPlugin.jeiHelper.getGuiHelper().createCraftingGridHelper(INPUT_SLOT, OUTPUT_SLOT);
    }

    @Nonnull
    @Override
    public String getUid() {
        return category;
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
        JEIUtils.setRecipe(recipeLayout, recipeWrapper, ingredients, craftingGridHelper, xPos, yPos, xy, xy, INPUT_SLOT, OUTPUT_SLOT);
    }
}

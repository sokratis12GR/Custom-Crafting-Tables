/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.jei;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.Method;

import javax.annotation.Nonnull;

@Interface(iface = "mezz.jei.api.IItemBlacklist", modid = "jei", striprefs = true)
@JEIPlugin
public class JEI implements IModPlugin {

    @Method(modid = "jei")
    public void register(@Nonnull IModRegistry registry) {
    }

    @Method(modid = "jei")
    public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {
    }

    @Method(modid = "jei")
    public void registerIngredients(@Nonnull IModIngredientRegistration registry) {
    }

    @Method(modid = "jei")
    @Override
    public void registerItemSubtypes(@Nonnull ISubtypeRegistry subtypeRegistry) {
    }
}
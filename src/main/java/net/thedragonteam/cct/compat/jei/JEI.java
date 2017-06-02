/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.jei;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.Method;

@Interface(iface = "mezz.jei.api.IItemBlacklist", modid = "jei", striprefs = true)
@JEIPlugin
public class JEI implements IModPlugin {

    @Method(modid = "jei")
    public void register(IModRegistry registry) {
    }

    @Method(modid = "jei")
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
    }

    @Method(modid = "jei")
    public void registerIngredients(IModIngredientRegistration registry) {
    }

    @Method(modid = "jei")
    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
    }
}
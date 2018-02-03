/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat;

import net.thedragonteam.cct.compat.crafttweaker.CTCCTPlugin;
import net.thedragonteam.thedragonlib.util.LogHelper;

public class CompatibilityMineTweaker implements ICompatibility {

    public void loadCompatibility(ICompatibility.InitializationPhase phase) {
        if (phase == InitializationPhase.PRE_INIT) {
            try {
                CTCCTPlugin.init();
            } catch (Throwable e) {
                LogHelper.error("Custom Crafting Tables (CCT) seems to be having trouble with CraftTweaker.");
            }
        }
    }

    @Override
    public String getModid() {
        return "crafttweaker";
    }

    @Override
    public boolean enableCompat() {
        return true;
    }
}
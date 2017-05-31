/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat;

public class CompatibilityJustEnoughItems implements ICompatibility {

    @Override
    public void loadCompatibility(InitializationPhase phase) {
    }

    @Override
    public String getModid() {
        return "jei";
    }

    @Override
    public boolean enableCompat() {
        return true;
    }
}
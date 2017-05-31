/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.registry;

import net.minecraftforge.fml.common.Loader;
import net.thedragonteam.cct.compat.ICompatibility;
import net.thedragonteam.cct.compat.CompatibilityMineTweaker;
import net.thedragonteam.cct.compat.CompatibilityJustEnoughItems;

import java.util.ArrayList;

public class ModCompatibility {
    private static ArrayList<ICompatibility> compatibilities = new ArrayList<>();

    public static void registerModCompat() {
        compatibilities.add(new CompatibilityMineTweaker());
        compatibilities.add(new CompatibilityJustEnoughItems());
    }

    public static void loadCompat(ICompatibility.InitializationPhase phase) {
        for (ICompatibility compatibility : compatibilities) {
            if (Loader.isModLoaded(compatibility.getModid()) && compatibility.enableCompat()) {
                compatibility.loadCompatibility(phase);
            }
        }
    }
}
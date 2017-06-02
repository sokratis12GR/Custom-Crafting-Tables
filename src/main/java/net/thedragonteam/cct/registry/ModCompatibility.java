/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.registry;

import net.thedragonteam.cct.compat.CompatibilityJustEnoughItems;
import net.thedragonteam.cct.compat.CompatibilityMineTweaker;
import net.thedragonteam.cct.compat.ICompatibility;

import java.util.ArrayList;

import static net.minecraftforge.fml.common.Loader.isModLoaded;

public class ModCompatibility {
    private static ArrayList<ICompatibility> compatibilities = new ArrayList<>();

    public static void registerModCompat() {
        compatibilities.add(new CompatibilityMineTweaker());
        compatibilities.add(new CompatibilityJustEnoughItems());
    }

    public static void loadCompat(ICompatibility.InitializationPhase phase) {
        for (ICompatibility compatibility : compatibilities) {
            if (isModLoaded(compatibility.getModid()) && compatibility.enableCompat()) {
                compatibility.loadCompatibility(phase);
            }
        }
    }
}
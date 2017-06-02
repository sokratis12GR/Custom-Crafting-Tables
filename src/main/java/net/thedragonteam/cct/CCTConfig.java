/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct;

import net.thedragonteam.thedragonlib.config.ModConfigProperty;

import static java.util.Arrays.fill;

public class CCTConfig {


    @ModConfigProperty(category = "CCT", name = "renameCCTs", comment = "renames the CCTs | Replace lines with Empty ones if you want to override them with Resource Pack Lang Files")
    public static String[] cctNames = new String[]{
            "CCT 1x1", "CCT 2x2", "CCT 3x3", "CCT 4x4", "CCT 5x5", "CCT 6x6", "CCT 7x7", "CCT 8x8", "CCT 9x9", "CCT 10x10",
    };

    @ModConfigProperty(category = "CCT", name = "renameCCTGuiNames", comment = "renames the CCTs Gui Names | Replace lines with Empty ones if you want to override them with Resource Pack Lang Files")
    public static String[] cctGuiNames = new String[10];

    @ModConfigProperty(category = "CCT", name = "cctMaxStackSize", comment = "Sets the max stack size count for each table")
    public static int[] cctMaxStackSize = new int[10];

    @ModConfigProperty(category = "CCT", name = "renameCCTJEINames", comment = "renames the CCTs JEI Gui Names | Replace lines with Empty ones if you want to override them with Resource Pack Lang Files")
    public static String[] cctJEINames = new String[]{
            "1x1", "2x2", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10",
    };

    @ModConfigProperty(category = "CCT", name = "recolorCCTNames", comment = "recolors the CCTs")
    public static String[] recolorCCTNames = new String[10];

    @ModConfigProperty(category = "CCT Disable", name = "disableVanilla", comment = "Disable access to the Vanilla Crafting Table")
    public static boolean disableVanilla = false;

    @ModConfigProperty(category = "CCT Disable", name = "disableCCT", comment = "Disable access to the 1x1 -> 10x10 Tables")
    public static boolean[] disableCCT = new boolean[10];

    @ModConfigProperty(category = "Debug", name = "enableDebug", comment = "Enable/Disable debug mode")
    public static boolean enableDebug = false;

    static {
        fill(recolorCCTNames, "white");
        fill(cctMaxStackSize, 64);
        fill(cctGuiNames, "Crafting");
    }
}

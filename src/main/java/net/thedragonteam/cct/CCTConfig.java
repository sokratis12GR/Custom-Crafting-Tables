/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct;

import net.thedragonteam.thedragonlib.config.ModConfigProperty;

public class CCTConfig {

    @ModConfigProperty(category = "CCT", name = "renameCCTs", comment = "renames the CCTs | Replace lines with Empty ones if you want to override them with Resource Pack Lang Files")
    public static String[] cctNames = new String[]{
            "CCT 1x1", "CCT 2x2", "CCT 3x3", "CCT 4x4", "CCT 5x5", "CCT 6x6", "CCT 7x7", "CCT 8x8", "CCT 9x9", "CCT 10x10",
    };

    @ModConfigProperty(category = "CCT", name = "renameCCTGuiNames", comment = "renames the CCTs Gui Names | Replace lines with Empty ones if you want to override them with Resource Pack Lang Files")
    public static String[] cctGuiNames = new String[]{
            "Crafting", "Crafting", "Crafting", "Crafting", "Crafting", "Crafting", "Crafting", "Crafting", "Crafting", "Crafting",
    };

    @ModConfigProperty(category = "CCT", name = "renameCCTJEINames", comment = "renames the CCTs JEI Gui Names | Replace lines with Empty ones if you want to override them with Resource Pack Lang Files")
    public static String[] cctJEINames = new String[]{
            "1x1", "2x2", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10",
    };


    // Booleans to Disable access to Crafting Tables

    @ModConfigProperty(category = "CCT Disable", name = "disableVanilla", comment = "Disable access to the Vanilla Crafting Table")
    public static boolean disableVanilla = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable1x1", comment = "Disable access to the 1x1 Table")
    public static boolean disable1x1 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable2x2", comment = "Disable access to the 2x2 Table")
    public static boolean disable2x2 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable3x3", comment = "Disable access to the 3x3 Table")
    public static boolean disable3x3 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable4x4", comment = "Disable access to the 4x4 Table")
    public static boolean disable4x4 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable5x5", comment = "Disable access to the 5x5 Table")
    public static boolean disable5x5 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable6x6", comment = "Disable access to the 6x6 Table")
    public static boolean disable6x6 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable7x7", comment = "Disable access to the 7x7 Table")
    public static boolean disable7x7 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable8x8", comment = "Disable access to the 8x8 Table")
    public static boolean disable8x8 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable9x9", comment = "Disable access to the 9x9 Table")
    public static boolean disable9x9 = false;

    @ModConfigProperty(category = "CCT Disable", name = "disable10x10", comment = "Disable access to the 10x10 Table")
    public static boolean disable10x10 = false;


}

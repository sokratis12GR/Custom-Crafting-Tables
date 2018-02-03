/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.fml.common.Mod;

import static java.util.Arrays.fill;
import static net.thedragonteam.cct.CustomCraftingTables.MODID;

@Mod.EventBusSubscriber(modid = MODID)
@Config(modid = MODID, category = "custom_crafting_tables")
public class CCTConfig {

    @Comment({
        "renames the CCTs",
        "Replace lines with empty ones if you want to override them with resource pack lang files"
    })
    @Name(value = "renameCCTs")
    public static String[] cctNames = new String[]{
        "CCT 1x1", "CCT 2x2", "CCT 3x3", "CCT 4x4", "CCT 5x5", "CCT 6x6", "CCT 7x7", "CCT 8x8", "CCT 9x9", "CCT 10x10",
    };

    @Comment({
        "renames the CCTs gui names",
        "Replace lines with empty ones if you want to override them with resource pack lang files"
    })
    @Name(value = "renameCCTGuiNames")
    public static String[] cctGuiNames = new String[10];

    @Comment({"Sets the max stack size count for each table"})
    public static int[] cctMaxStackSize = new int[10];

    @Comment({
        "renames the CCTs JEI gui names",
        "Replace lines with empty ones if you want to override them with resource pack lang files"
    })
    @Name(value = "renameCCTJEINames")
    public static String[] cctJEINames = new String[]{
        "1x1", "2x2", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10",
    };

    @Comment({"recolors the CCTs"})
    public static String[] recolorCCTNames = new String[10];

    @Comment({"Disable access to the Vanilla Crafting Table"})
    public static boolean disableVanilla = false;

    @Comment({"Disable access to the 1x1 -> 10x10 Tables"})
    public static boolean[] disableCCT = new boolean[10];

    @Comment({"Enable/Disable debug mode"})
    public static boolean enableDebug = false;

    static {
        fill(recolorCCTNames, "white");
        fill(cctMaxStackSize, 64);
        fill(cctGuiNames, "Crafting");
    }
}

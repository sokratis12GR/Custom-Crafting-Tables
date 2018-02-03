/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.registry;

import net.thedragonteam.cct.blocks.BlockCCT;
import net.thedragonteam.cct.blocks.CCT;

import java.util.Arrays;

import static net.thedragonteam.cct.blocks.CCT.*;

public class ModBlocks {

    public static CCT[] benches = new CCT[]{
            CCT_1X1, CCT_2X2, CCT_3X3, CCT_4X4, CCT_5X5, CCT_6X6, CCT_7X7, CCT_8X8, CCT_9X9, CCT_10X10
    };
    public static BlockCCT[] blockCCT = new BlockCCT[10];

    public static void init() {
        Arrays.setAll(blockCCT, b -> new BlockCCT(benches[b]));
    }
}

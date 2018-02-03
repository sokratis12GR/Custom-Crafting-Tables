package net.thedragonteam.cct.events;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.thedragonteam.cct.CustomCraftingTables;
import net.thedragonteam.cct.blocks.base.BaseBlock;

import java.util.Arrays;

import static net.thedragonteam.cct.registry.ModBlocks.blockCCT;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 **/
@Mod.EventBusSubscriber(modid = CustomCraftingTables.MODID, value = Side.CLIENT)
public class ModelsEventHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        Arrays.stream(blockCCT).forEach(BaseBlock::initModel);
    }
}

package net.thedragonteam.cct.events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedragonteam.cct.CustomCraftingTables;
import net.thedragonteam.thedragonlib.util.LogHelper;

import java.util.stream.IntStream;

import static net.thedragonteam.cct.CCTConfig.*;
import static net.thedragonteam.cct.registry.ModBlocks.blockCCT;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 **/
@Mod.EventBusSubscriber(modid = CustomCraftingTables.MODID)
public class ServerEventsHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(final RightClickBlock e) {
        if (!e.getWorld().isRemote) {
            IBlockState state = e.getWorld().getBlockState(e.getPos());
            Block block = state.getBlock();
            int bound = disableCCT.length;
            IntStream.range(0, bound).filter(i -> disableCCT[i] && block == blockCCT[i]).forEach(i -> {
                e.setCanceled(true);
                if (enableDebug) {
                    LogHelper.info("Denied access to: '" + block.getRegistryName() + "'.");
                }
            });
            if (disableVanilla && block == Blocks.CRAFTING_TABLE) {
                e.setCanceled(true);
                if (enableDebug) {
                    LogHelper.info("Denied access to: '" + block.getRegistryName() + "'.");
                }
            }
        }
    }
}
package net.thedragonteam.cct.events;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedragonteam.thedragonlib.util.LogHelper;

import static net.thedragonteam.cct.CCTConfig.disableCCT;
import static net.thedragonteam.cct.CCTConfig.disableVanilla;
import static net.thedragonteam.cct.registry.ModBlocks.blockCCT;

public class ServerEventsHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(final RightClickBlock e) {
        if (!e.getWorld().isRemote) {
            IBlockState state = e.getWorld().getBlockState(e.getPos());
            Block block = state.getBlock();
            for (int i = 0; i < disableCCT.length; i++) {
                if (disableCCT[i] && block == blockCCT[i]) {
                    e.setCanceled(true);
                    LogHelper.INSTANCE.info("Denied access to: '" + block.getRegistryName() + "'.");
                }
            }
            if (disableVanilla && block == Blocks.CRAFTING_TABLE) {
                e.setCanceled(true);
                LogHelper.INSTANCE.info("Denied access to: '" + block.getRegistryName() + "'.");
            }
        }
    }
}
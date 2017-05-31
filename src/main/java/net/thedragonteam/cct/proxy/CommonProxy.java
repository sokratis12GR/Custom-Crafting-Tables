/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.proxy;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thedragonteam.cct.CCTConfig;
import net.thedragonteam.cct.registry.ModBlocks;
import net.thedragonteam.cct.registry.ModCompatibility;
import net.thedragonteam.cct.tileentity.*;
import net.thedragonteam.thedragonlib.config.ModConfigProcessor;
import net.thedragonteam.thedragonlib.util.LogHelper;
import org.apache.logging.log4j.Logger;

import static net.thedragonteam.cct.compat.ICompatibility.InitializationPhase.INIT;
import static net.thedragonteam.cct.compat.ICompatibility.InitializationPhase.POST_INIT;
import static net.thedragonteam.cct.compat.ICompatibility.InitializationPhase.PRE_INIT;

public class CommonProxy {

    public static ModConfigProcessor configProcessor = new ModConfigProcessor();
    public static Configuration configuration;

    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configProcessor.processConfig(CCTConfig.class, configuration);
        registerTileEntities();
        ModCompatibility.registerModCompat();
        ModCompatibility.loadCompat(PRE_INIT);
        LogHelper.INSTANCE.info("Finished PreInitialization");
        MinecraftForge.EVENT_BUS.register(new ServerEventsHandler(event.getModLog()));
    }

    public void init(FMLInitializationEvent event) {
        ModCompatibility.loadCompat(INIT);
        LogHelper.INSTANCE.info("Finished Initialization");
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModCompatibility.loadCompat(POST_INIT);
        LogHelper.INSTANCE.info("Finished PostInitialization");
    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntityWithAlternatives(TileEntityOneByOne.class, "OneByOne", "BenchOneByOne", "CCT_1x1", "1x1", "cct_1x1", "cct_one_by_one");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityTwoByTwo.class, "TwoByTwo", "BenchTwoByTwo", "CCT_2x2", "2x2", "cct_2x2", "cct_two_by_two");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityThreeByThree.class, "ThreeByThree", "BenchThreeByThree", "CCT_3x3", "3x3", "cct_3x3", "cct_three_by_three");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityFourByFour.class, "FourByFour", "BenchFourByFour", "CCT_4x4", "4x4", "cct_4x4", "cct_four_by_four");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityFiveByFive.class, "FiveByFive", "BenchFiveByFive", "CCT_5x5", "5x5", "cct_5x5", "cct_five_by_five");
        GameRegistry.registerTileEntityWithAlternatives(TileEntitySixBySix.class, "SixBySix", "BenchSixBySix", "CCT_6x6", "6x6", "cct_6x6", "cct_six_by_six");
        GameRegistry.registerTileEntityWithAlternatives(TileEntitySevenBySeven.class, "SevenBySeven", "BenchSevenBySeven", "CCT_7x7", "7x7", "cct_8x8", "cct_seven_by_seven");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityEightByEight.class, "EightByEight", "BenchEightByEight", "CCT_8x8", "8x8", "cct_8x8", "cct_eight_by_eight");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityNineByNine.class, "NineByNine", "BenchNineByNine", "CCT_9x9", "9x9", "cct_9x9", "cct_nine_by_nine");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityTenByTen.class, "TenByTen", "BenchTenByTen", "CCT_10x10", "10x10", "cct_10x10", "cct_ten_by_ten");
    }
    private class ServerEventsHandler {
        private Logger log;

        ServerEventsHandler(Logger log) {
            this.log = log;
        }

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void onPlayerInteract(final PlayerInteractEvent.RightClickBlock e) {
            if (e.getWorld().isRemote) {
                return; // don't care about client side
            }

            IBlockState state = e.getWorld().getBlockState(e.getPos());
            if (state != null) {
                Block block = state.getBlock();
                if (block != null) {
                    if ((CCTConfig.disable1x1 && ((block == ModBlocks.blockCCT[0]) || (block.getRegistryName().equals(ModBlocks.blockCCT[0].getRegistryName()))))
                            || (CCTConfig.disable2x2 && ((block == ModBlocks.blockCCT[1]) || (block.getRegistryName().equals(ModBlocks.blockCCT[1].getRegistryName()))))
                            || (CCTConfig.disable3x3 && ((block == ModBlocks.blockCCT[2]) || (block.getRegistryName().equals(ModBlocks.blockCCT[2].getRegistryName()))))
                            || (CCTConfig.disable4x4 && ((block == ModBlocks.blockCCT[3]) || (block.getRegistryName().equals(ModBlocks.blockCCT[3].getRegistryName()))))
                            || (CCTConfig.disable5x5 && ((block == ModBlocks.blockCCT[4]) || (block.getRegistryName().equals(ModBlocks.blockCCT[4].getRegistryName()))))
                            || (CCTConfig.disable6x6 && ((block == ModBlocks.blockCCT[5]) || (block.getRegistryName().equals(ModBlocks.blockCCT[5].getRegistryName()))))
                            || (CCTConfig.disable7x7 && ((block == ModBlocks.blockCCT[6]) || (block.getRegistryName().equals(ModBlocks.blockCCT[6].getRegistryName()))))
                            || (CCTConfig.disable8x8 && ((block == ModBlocks.blockCCT[7]) || (block.getRegistryName().equals(ModBlocks.blockCCT[7].getRegistryName()))))
                            || (CCTConfig.disable9x9 && ((block == ModBlocks.blockCCT[8]) || (block.getRegistryName().equals(ModBlocks.blockCCT[8].getRegistryName()))))
                            || (CCTConfig.disable10x10 && ((block == ModBlocks.blockCCT[9]) || (block.getRegistryName().equals(ModBlocks.blockCCT[9].getRegistryName()))))
                            || (CCTConfig.disableVanilla && ((block == Blocks.CRAFTING_TABLE) || (block.getRegistryName().equals(Blocks.CRAFTING_TABLE.getRegistryName()))))) {
                        e.setCanceled(true);
                        this.log.info("Deathly denied access to: '" + block.getRegistryName() + "'.");
                    }
                }
            }
        }
    }
}
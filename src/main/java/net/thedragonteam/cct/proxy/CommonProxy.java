/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.proxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.cct.CCTConfig;
import net.thedragonteam.cct.registry.ModBlocks;
import net.thedragonteam.cct.registry.ModCompatibility;
import net.thedragonteam.thedragonlib.config.ModConfigProcessor;
import net.thedragonteam.thedragonlib.util.LogHelper;

import static net.thedragonteam.cct.compat.ICompatibility.InitializationPhase.*;

public class CommonProxy {

    public static ModConfigProcessor configProcessor = new ModConfigProcessor();
    public static Configuration configuration;

    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configProcessor.processConfig(CCTConfig.class, configuration);
        ModCompatibility.registerModCompat();
        ModCompatibility.loadCompat(PRE_INIT);
        LogHelper.info("Finished PreInitialization");
    }

    public void init(FMLInitializationEvent event) {
        ModCompatibility.loadCompat(INIT);
        LogHelper.info("Finished Initialization");
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModCompatibility.loadCompat(POST_INIT);
        LogHelper.info("Finished PostInitialization");
    }
}
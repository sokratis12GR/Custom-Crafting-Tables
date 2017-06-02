/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.cct.client.gui.CCTTab;
import net.thedragonteam.cct.client.gui.GuiHandler;
import net.thedragonteam.cct.proxy.CommonProxy;
import net.thedragonteam.thedragonlib.util.LogHelper;

import static net.thedragonteam.cct.util.Utils.setName;


@Mod(modid = CustomCraftingTables.MODID, name = CustomCraftingTables.MODNAME, version = CustomCraftingTables.VERSION,
        guiFactory = CustomCraftingTables.GUIFACTORY, dependencies = CustomCraftingTables.DEPEND, updateJSON = CustomCraftingTables.UPDATE_JSON)
public class CustomCraftingTables {

    /**
     * Updates every time the mod updates minecraft version,
     * Updates MAJOR with 1 after each version upgrade
     */
    public static final String MCVERSION = "1.11.2";
    /**
     * Updates every MAJOR change,
     * never resets
     */
    public static final int MAJOR = 1;
    /**
     * Updates every time a new block, item or features is added or change,
     * resets on MAJOR changes
     */
    public static final int MINOR = 2;
    /**
     * Updates every time a bug is fixed or issue solved or very minor code changes,
     * resets on MINOR changes
     */
    public static final int PATCH = 0;
    /**
     * The Mod Version
     */
    public static final String VERSION = MCVERSION + "-" + MAJOR + "." + MINOR + "." + PATCH + "";
    public static final String MODID = "cct";
    public static final String MODNAME = "Custom Crafting Tables";
    public static final String LIB_VERSION = "1.11.2-3.2.2";
    public static final String DEPEND = "required-after:thedragonlib@[" + LIB_VERSION + ",);";
    public static final String CLIENT_PROXY = "net.thedragonteam.cct.proxy.ClientProxy";
    public static final String SERVER_PROXY = "net.thedragonteam.cct.proxy.ServerProxy";
    public static final String GUIFACTORY = "net.thedragonteam.cct.client.gui.ConfigGuiFactory";
    public static final String UPDATE_JSON = "http://fdn.redstone.tech/TheDragonTeam/custom-crafting-tables/update.json";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;

    public static CreativeTabs mbTab = new CCTTab(CreativeTabs.getNextID(), MODID, setName("cct"));

    @Mod.Instance(MODID)
    public static CustomCraftingTables instance;
    public static GuiHandler guiHandler = new GuiHandler();

    public CustomCraftingTables() {
        LogHelper.INSTANCE.info("Welcoming Minecraft");
    }

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void initClient(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
        proxy.init(event);
    }

    @SideOnly(Side.SERVER)
    @EventHandler
    public void initServer(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
        proxy.init(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    }
}
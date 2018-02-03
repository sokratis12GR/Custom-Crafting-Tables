package net.thedragonteam.cct.events;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedragonteam.cct.CustomCraftingTables;
import net.thedragonteam.cct.blocks.BlockCCT;
import net.thedragonteam.cct.blocks.ItemBlockCCT;
import net.thedragonteam.cct.tileentity.*;
import net.thedragonteam.cct.util.Utils;

import java.util.Arrays;

import static net.minecraftforge.common.util.EnumHelper.addRarity;
import static net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity;
import static net.thedragonteam.cct.registry.ModBlocks.blockCCT;
import static net.thedragonteam.cct.util.Utils.areNotNull;
import static net.thedragonteam.cct.util.Utils.getFormatted;
import static net.thedragonteam.cct.util.Utils.setLocation;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 **/
@Mod.EventBusSubscriber(modid = CustomCraftingTables.MODID)
public class RegistryEventHandler {

    private static void registerAllBlocks(Register<Block> event, Block[]... blocksArray) {
        Arrays.stream(blocksArray).forEachOrdered(blockList -> registerAllBlocks(event, blockList));
    }

    private static void registerAllBlocks(Register<Block> event, Block... blockList) {
        Arrays.stream(blockList).filter(Utils::isNotNull).forEachOrdered(block -> event.getRegistry().register(block));
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        registerAllBlocks(event, blockCCT);
        registerTileEntities();
    }

    public static void registerTileEntities() {
        registerTileEntity(TileEntityOneByOne.class, setLocation("one_by_one"));
        registerTileEntity(TileEntityTwoByTwo.class,  setLocation("two_by_two"));
        registerTileEntity(TileEntityThreeByThree.class,  setLocation("three_by_three"));
        registerTileEntity(TileEntityFourByFour.class, setLocation("four_by_four"));
        registerTileEntity(TileEntityFiveByFive.class, setLocation("five_by_five"));
        registerTileEntity(TileEntitySixBySix.class, setLocation("six_by_six"));
        registerTileEntity(TileEntitySevenBySeven.class, setLocation("seven_by_seven"));
        registerTileEntity(TileEntityEightByEight.class, setLocation("eight_by_eight"));
        registerTileEntity(TileEntityNineByNine.class, setLocation("nine_by_nine"));
        registerTileEntity(TileEntityTenByTen.class, setLocation("ten_by_ten"));
    }

    private static void registerItemBlock(Register<Item> event, BlockCCT... blocks) {
        for (BlockCCT block : blocks) {
            if (areNotNull(block, block.getRegistryName())) {
                ItemBlockCCT itemBlock = new ItemBlockCCT(block) {
                    @Override
                    public String getItemStackDisplayName(ItemStack stack) {
                        return getCct().getDisplayName(getFormatted(this.getUnlocalizedNameInefficiently(stack) + ".name"));
                    }

                    @Override
                    public EnumRarity getRarity(ItemStack stack) {
                        return addRarity(getCct().getName().toUpperCase(), getCct().getColor(), getCct().getDisplayName());
                    }

                    @Override
                    public int getItemStackLimit(ItemStack stack) {
                        return getCct().getStackSize();
                    }
                };
                itemBlock.setRegistryName(block.getRegistryName());
                event.getRegistry().register(itemBlock);
            }
        }
    }

    private static void registerAllItemBlocks(Register<Item> event, BlockCCT[]... blockArray) {
        Arrays.stream(blockArray).forEachOrdered(blockList -> registerItemBlock(event, blockList));
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        registerAllItemBlocks(event, blockCCT);
    }
}

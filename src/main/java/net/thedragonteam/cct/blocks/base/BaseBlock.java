/*
 * Copyright (c) TheDragonTeam 2016.
 */

package net.thedragonteam.cct.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.cct.CustomCraftingTables;
import net.thedragonteam.cct.util.IModelHelper;

import static net.thedragonteam.cct.util.Utils.setName;

public class BaseBlock extends Block implements IModelHelper {

    public BaseBlock(Material material, String name) {
        this(material, name, 0F, 0F);
    }

    public BaseBlock(Material material, String name, float resistance, float hardness) {
        this(material, name, resistance, hardness, null, 0);
    }

    public BaseBlock(Material material, String name, float resistance, float hardness, String tool, int harvestLevel) {
        this(material, name, resistance, hardness, tool, harvestLevel, 0F);
    }

    public BaseBlock(Material material, String name, float resistance, float hardness, String tool, int harvestLevel, float lightLevel) {
        this(material, name, resistance, hardness, tool, harvestLevel, lightLevel, 0);
    }

    public BaseBlock(Material material, String name, float resistance, float hardness, String tool, int harvestLevel, float lightLevel, int lightOpacity) {
        super(material);
        this.setUnlocalizedName(setName(name));
        this.setRegistryName(name);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setHarvestLevel(tool, harvestLevel);
        this.setLightLevel(lightLevel);
        this.setLightOpacity(lightOpacity);
        this.setCreativeTab(CustomCraftingTables.mbTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel() {
        initModel(this, this.getRegistryName(), 0);
    }
}

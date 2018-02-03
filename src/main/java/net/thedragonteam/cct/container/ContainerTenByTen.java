/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thedragonteam.cct.api.crafting.base.BaseCraftingManager;
import net.thedragonteam.cct.api.crafting.base.BaseSlotCrafting;
import net.thedragonteam.cct.container.base.ContainerTableBase;
import net.thedragonteam.cct.container.base.InventoryCraftingImproved;
import net.thedragonteam.cct.tileentity.TileEntityTenByTen;

import java.util.stream.IntStream;

public class ContainerTenByTen extends ContainerTableBase {

    private static final int ITEM_BOX = 18;
    private static final int RECIPE_SLOTS = 101;
    private static final int RECIPE_SIZE = 10;
    private static final int RECIPE_SIZE_TOTAL = 100;
    private static final int ROW_SLOTS = 9;
    private static final int FULL_INVENTORY_SLOTS = RECIPE_SLOTS + 36;
    private static final int MAIN_INVENTORY_SLOTS = RECIPE_SLOTS + 27;
    private static final EntityEquipmentSlot[] EQUIPMENT_SLOTS = new EntityEquipmentSlot[]{
        EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET};
    private final World world;
    /**
     * The crafting matrix inventory (10x10).
     */
    public InventoryCraftingImproved craftMatrix = new InventoryCraftingImproved(this, 10, 10);
    public IInventory craftResult = new InventoryCraftResult();

    public ContainerTenByTen(InventoryPlayer playerInventory, TileEntityTenByTen tile) {
        super(tile, RECIPE_SLOTS, MAIN_INVENTORY_SLOTS, FULL_INVENTORY_SLOTS);
        this.world = tile.getWorld();
        //1x1 Output Inventory
        this.addSlotToContainer(new BaseSlotCrafting(BaseCraftingManager.getTenByTen(), playerInventory.player, this.craftMatrix, this.craftResult, 0, 230, 134));

        //10x10 Crafting Inventory
        for (int i = 0; i < RECIPE_SIZE; ++i)
            for (int j = 0; j < RECIPE_SIZE; ++j)
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * RECIPE_SIZE, 39 + j * ITEM_BOX, 17 + i * ITEM_BOX));
        //2x2 Armor Inventory
        this.addPlayerArmorInventoryTop(playerInventory, 5, 217);
        this.addPlayerArmorInventoryBot(playerInventory, 5, 235);
        //3x9 Main Inventory
        for (int k = 0; k < 3; ++k)
            for (int i1 = 0; i1 < ROW_SLOTS; ++i1)
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 48 + i1 * ITEM_BOX, 199 + k * ITEM_BOX));

        //1x9 HotBar Inventory
        IntStream.range(0, ROW_SLOTS).mapToObj(l -> new Slot(playerInventory, l, 5, 17 + l * ITEM_BOX)).forEachOrdered(this::addSlotToContainer);

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    private void addPlayerArmorInventoryTop(InventoryPlayer inventory, int xPos, int yPos) {
        IntStream.range(0, 2).forEachOrdered(k -> {
            EntityEquipmentSlot equipmentSlot = EQUIPMENT_SLOTS[k];
            addSlotToContainer(new SlotArmor(inventory, 4 * 9 + (3 - k), xPos + k * ITEM_BOX, yPos, inventory.player, equipmentSlot));
        });
    }

    private void addPlayerArmorInventoryBot(InventoryPlayer inventory, int xPos, int yPos) {
        IntStream.range(0, 2).forEachOrdered(k -> {
            EntityEquipmentSlot equipmentSlot = EQUIPMENT_SLOTS[k + 2];
            addSlotToContainer(new SlotArmor(inventory, 4 * 9 + (3 - (k + 2)), xPos + k * ITEM_BOX, yPos, inventory.player, equipmentSlot));
        });
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.craftResult.setInventorySlotContents(0, BaseCraftingManager.getTenByTen().findMatchingRecipe(this.craftMatrix, this.world));
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        onContainerClosed(playerIn, this.world.isRemote, RECIPE_SIZE_TOTAL, this.craftMatrix);
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}
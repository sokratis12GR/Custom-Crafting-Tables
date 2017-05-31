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
import net.thedragonteam.cct.api.crafting.cct_10x10.SlotCrafting;
import net.thedragonteam.cct.api.crafting.cct_10x10.TenByTenManager;
import net.thedragonteam.cct.container.base.ContainerTableBase;
import net.thedragonteam.cct.container.base.InventoryCraftingImproved;
import net.thedragonteam.cct.tileentity.TileEntityTenByTen;

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
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 230, 134));

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
        for (int l = 0; l < ROW_SLOTS; ++l)
            this.addSlotToContainer(new Slot(playerInventory, l, 5, 17 + l * ITEM_BOX));

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    private void addPlayerArmorInventoryTop(InventoryPlayer inventory, int xPos, int yPos) {
        for (int k = 0; k < 2; ++k) {
            EntityEquipmentSlot equipmentSlot = EQUIPMENT_SLOTS[k];
            addSlotToContainer(new SlotArmor(inventory, 4 * 9 + (3 - k), xPos + k * ITEM_BOX, yPos, inventory.player, equipmentSlot));
        }
    }

    private void addPlayerArmorInventoryBot(InventoryPlayer inventory, int xPos, int yPos) {
        for (int k = 0; k < 2; ++k) {
            EntityEquipmentSlot equipmentSlot = EQUIPMENT_SLOTS[k + 2];
            addSlotToContainer(new SlotArmor(inventory, 4 * 9 + (3 - (k + 2)), xPos + k * ITEM_BOX, yPos, inventory.player, equipmentSlot));
        }
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.craftResult.setInventorySlotContents(0, TenByTenManager.getInstance().findMatchingRecipe(this.craftMatrix, this.world));
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
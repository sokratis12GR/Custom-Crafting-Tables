package net.thedragonteam.cct.container.base;

import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import java.util.ArrayList;
import java.util.List;

public class AdvancedRecipeTransferInfo<C extends Container> implements IRecipeTransferInfo<C> {
    private final Class<C> containerClass;
    private final String recipeCategoryUid;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;
    private final int additionalSlots;

    public AdvancedRecipeTransferInfo(Class<C> containerClass, String recipeCategoryUid, int recipeSlotStart, int recipeSlotCount, int inventorySlotStart, int inventorySlotCount, boolean hasAdditionalSlots, int additionalSlots) {
        this.containerClass = containerClass;
        this.recipeCategoryUid = recipeCategoryUid;
        this.recipeSlotStart = recipeSlotStart;
        this.recipeSlotCount = recipeSlotCount;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
        this.additionalSlots = hasAdditionalSlots ? additionalSlots : 0;
    }

    public AdvancedRecipeTransferInfo(Class<C> containerClass, String recipeCategoryUid, int recipeSlotStart, int recipeSlotCount, int inventorySlotStart, int inventorySlotCount) {
        this(containerClass, recipeCategoryUid, recipeSlotStart, recipeSlotCount, inventorySlotStart, inventorySlotCount, false, 0);
    }

    @Override
    public Class<C> getContainerClass() {
        return containerClass;
    }

    @Override
    public String getRecipeCategoryUid() {
        return recipeCategoryUid;
    }

    @Override
    public boolean canHandle(C container) {
        return true;
    }

    @Override
    public List<Slot> getRecipeSlots(C container) {
        ArrayList<Slot> list = new ArrayList<>();
        int bound = recipeSlotStart + recipeSlotCount;
        for (int i = recipeSlotStart; i < bound; i++) {
            Slot slot = container.getSlot(i);
            list.add(slot);
        }
        return list;
    }

    @Override
    public ArrayList<Slot> getInventorySlots(C container) {
        ArrayList<Slot> list = new ArrayList<>();
        int bound = inventorySlotStart + inventorySlotCount + additionalSlots;
        for (int i = inventorySlotStart; i < bound; i++) {
            if (i < container.inventorySlots.size()) {
                Slot slot = container.getSlot(i);
                list.add(slot);
            }
        }
        return list;
    }
}
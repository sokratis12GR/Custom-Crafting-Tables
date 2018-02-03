package net.thedragonteam.cct.api.crafting.base;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.thedragonteam.cct.api.crafting.IRecipe;
import net.thedragonteam.cct.api.crafting.utils.CraftingUtils;
import net.thedragonteam.cct.container.base.InventoryCraftingImproved;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Sokratis Fotkatzikis - TheDragonTeam
 */
public class BaseCraftingManager {

    private static final BaseCraftingManager TEN_BY_TEN = new BaseCraftingManager(10);
    private static final BaseCraftingManager NINE_BY_NINE = new BaseCraftingManager(9);
    private static final BaseCraftingManager EIGHT_BY_EIGHT = new BaseCraftingManager(8);
    private static final BaseCraftingManager SEVEN_BY_SEVEN = new BaseCraftingManager(7);
    private static final BaseCraftingManager SIX_BY_SIX = new BaseCraftingManager(6);
    private static final BaseCraftingManager FIVE_BY_FIVE = new BaseCraftingManager(5);
    private static final BaseCraftingManager FOUR_BY_FOUR = new BaseCraftingManager(4);
    private static final BaseCraftingManager THREE_BY_THREE = new BaseCraftingManager(3);
    private static final BaseCraftingManager TWO_BY_TWO = new BaseCraftingManager(2);
    private static final BaseCraftingManager ONE_BY_ONE = new BaseCraftingManager(1);

    public static BaseCraftingManager getTenByTen() {
         return TEN_BY_TEN;
    }

    public static BaseCraftingManager getNineByNine() {
        return NINE_BY_NINE;
    }

    public static BaseCraftingManager getEightByEight() {
        return EIGHT_BY_EIGHT;
    }

    public static BaseCraftingManager getSevenBySeven() {
        return SEVEN_BY_SEVEN;
    }

    public static BaseCraftingManager getSixBySix() {
        return SIX_BY_SIX;
    }

    public static BaseCraftingManager getFiveByFive() {
        return FIVE_BY_FIVE;
    }

    public static BaseCraftingManager getFourByFour() {
        return FOUR_BY_FOUR;
    }

    public static BaseCraftingManager getThreeByThree() {
        return THREE_BY_THREE;
    }

    public static BaseCraftingManager getTwoByTwo() {
        return TWO_BY_TWO;
    }

    public static BaseCraftingManager getOneByOne() {
        return ONE_BY_ONE;
    }

    private final List<IRecipe> recipes = Lists.newArrayList();
    private int xy;

    public BaseCraftingManager(int xy) {
        this.xy = xy;
        this.recipes.sort((pCompare1, pCompare2) -> Integer.compare(pCompare2.getRecipeSize(), pCompare1.getRecipeSize()));
    }

    /**
     * Adds a shaped recipe to the games recipe list.
     */
    public BaseShapedRecipe addRecipe(ItemStack stack, Object... recipeComponents) {
        StringBuilder s = new StringBuilder();
        int index = 0, width = 0, height = 0;

        if (recipeComponents[index] instanceof String[]) {
            String[] astring = (String[]) recipeComponents[index++];

            for (String s2 : astring) {
                ++height;
                width = s2.length();
                s.append(s2);
            }
        } else {
            while (recipeComponents[index] instanceof String) {
                String s1 = (String) recipeComponents[index++];
                ++height;
                width = s1.length();
                s.append(s1);
            }
        }

        Map<Character, ItemStack> map = CraftingUtils.getCharacterItemStackMap(index, recipeComponents);

        NonNullList<ItemStack> aitemstack = NonNullList.withSize(width * height, ItemStack.EMPTY);

        IntStream.range(0, width * height).forEachOrdered(l -> {
            char c0 = s.charAt(l);
            aitemstack.set(l, map.containsKey(c0) ? map.get(c0).copy() : ItemStack.EMPTY);
        });

        BaseShapedRecipe shapedrecipes = new BaseShapedRecipe(xy, width, height, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    /**
     * Adds a shapeless crafting recipe to the the game.
     */
    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents) {
        NonNullList<ItemStack> list = NonNullList.create();
        CraftingUtils.addShapelessRecipe(list, recipeComponents);
        this.recipes.add(new BaseShapelessRecipe(stack, list));
    }

    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    public void addRecipe(IRecipe recipe) {
        this.recipes.add(recipe);
    }

    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    public void addRecipes(IRecipe... recipes) {
        Arrays.stream(recipes).forEach(this::addRecipe);
    }

    /**
     * Removes an IRecipe to the list of crafting recipes.
     */
    public void removeRecipe(IRecipe recipe) {
        this.recipes.remove(recipe);
    }

    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     */
    public ItemStack findMatchingRecipe(InventoryCraftingImproved craftMatrix, World worldIn) {
        return CraftingUtils.findMatchingRecipe(recipes, craftMatrix, worldIn);
    }

    public NonNullList<ItemStack> getRemainingItems(InventoryCraftingImproved craftMatrix, World worldIn) {
        return CraftingUtils.getRemainingItems(recipes, craftMatrix, worldIn);
    }

    public List<IRecipe> getRecipeList() {
        return this.recipes;
    }
}
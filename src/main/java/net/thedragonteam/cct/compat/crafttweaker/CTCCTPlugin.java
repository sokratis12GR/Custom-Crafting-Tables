/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.cct.compat.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import net.minecraft.item.ItemStack;
import net.thedragonteam.cct.api.crafting.IRecipe;
import net.thedragonteam.cct.compat.crafttweaker.tables.*;

import java.util.ArrayList;
import java.util.List;

import static net.thedragonteam.cct.compat.crafttweaker.utils.MTUtils.toObject;

public class CTCCTPlugin {

    public static void init() {
        CraftTweakerAPI.registerClass(OneByOne.class);
        CraftTweakerAPI.registerClass(TwoByTwo.class);
        CraftTweakerAPI.registerClass(ThreeByThree.class);
        CraftTweakerAPI.registerClass(FourByFour.class);
        CraftTweakerAPI.registerClass(FiveByFive.class);
        CraftTweakerAPI.registerClass(SixBySix.class);
        CraftTweakerAPI.registerClass(SevenBySeven.class);
        CraftTweakerAPI.registerClass(EightByEight.class);
        CraftTweakerAPI.registerClass(NineByNine.class);
        CraftTweakerAPI.registerClass(TenByTen.class);
    }

    public static Object[] toTwoByTwoObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("ab");
        prep.add("cd");
        char[][] map = new char[][]{
            {'a', 'b'},
            {'c', 'd'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toThreeByThreeObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abc");
        prep.add("def");
        prep.add("ghi");
        char[][] map = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toFourByFourShapedObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcd");
        prep.add("efgh");
        prep.add("ijkl");
        prep.add("mnop");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toFiveByFiveShapedObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcde");
        prep.add("fghij");
        prep.add("klmno");
        prep.add("pqrst");
        prep.add("uvwxy");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toSixBySixShapedObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcdef");
        prep.add("ghijkl");
        prep.add("mnopqr");
        prep.add("stuvwx");
        prep.add("yzABCD");
        prep.add("EFGHIJ");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd', 'e', 'f'},
            {'g', 'h', 'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x'},
            {'y', 'z', 'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H', 'I', 'J'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toSevenBySevenObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcdefg");
        prep.add("hijklmn");
        prep.add("opqrstu");
        prep.add("vwxyzAB");
        prep.add("CDEFGHI");
        prep.add("JKLMNOP");
        prep.add("QRSTUVW");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd', 'e', 'f', 'g'},
            {'h', 'i', 'j', 'k', 'l', 'm', 'n'},
            {'o', 'p', 'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z', 'A', 'B'},
            {'C', 'D', 'E', 'F', 'G', 'H', 'I'},
            {'J', 'K', 'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U', 'V', 'W'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toEightByEightObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcdefgh");
        prep.add("ijklmnop");
        prep.add("qrstuvwx");
        prep.add("yzABCDEF");
        prep.add("GHIJKLMN");
        prep.add("OPQRSTUV");
        prep.add("WXYZ1234");
        prep.add("567890!@");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u', 'v', 'w', 'x'},
            {'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F'},
            {'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z', '1', '2', '3', '4'},
            {'5', '6', '7', '8', '9', '0', '!', '@'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toNineByNineObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcdefghi");
        prep.add("jklmnopqr");
        prep.add("stuvwxyzA");
        prep.add("BCDEFGHIJ");
        prep.add("KLMNOPQRS");
        prep.add("TUVWXYZ12");
        prep.add("34567890!");
        prep.add("@#$%^&*()");
        prep.add("-=_+`~|<>");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'},
            {'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A'},
            {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'},
            {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2'},
            {'3', '4', '5', '6', '7', '8', '9', '0', '!'},
            {'@', '#', '$', '%', '^', '&', '*', '(', ')'},
            {'-', '=', '_', '+', '`', '~', '|', '<', '>'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    public static Object[] toTenByTenObjects(IIngredient[][] ingredients) {
        if (ingredients == null) return null;
        ArrayList<Object> prep = new ArrayList<>();
        prep.add("abcdefghij");
        prep.add("klmnopqrst");
        prep.add("uvwxyzABCD");
        prep.add("EFGHIJKLMN");
        prep.add("OPQRSTUVWX");
        prep.add("YZ12345678");
        prep.add("90!@#$%^&*");
        prep.add("()-+`~|<>,");
        prep.add("./\";:\'\\[]{");
        prep.add("}?óβγδεζηθ");
        char[][] map = new char[][]{
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'},
            {'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8'},
            {'9', '0', '!', '@', '#', '$', '%', '^', '&', '*'},
            {'(', ')', '-', '+', '`', '~', '|', '<', '>', ','},
            {'.', '/', '\"', ';', ':', '\'', '\\', '[', ']', '{'},
            {'}', '?', 'ó', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ'}
        };
        toShapedObjects(ingredients, map, prep);
        return prep.toArray();
    }

    private static void toShapedObjects(IIngredient[][] ingredients, char[][] map, ArrayList<Object> prep) {
        for (int x = 0; x < ingredients.length; x++) {
            if (ingredients[x] != null) {
                for (int y = 0; y < ingredients[x].length; y++) {
                    if (ingredients[x][y] != null && x < map.length && y < map[x].length) {
                        prep.add(map[x][y]);
                        prep.add(toObject(ingredients[x][y]));
                    }
                }
            }
        }
    }

    public static void removeRecipe(List<IRecipe> recipes, ItemStack remove) {
        for (Object obj : recipes) {
            if (obj instanceof IRecipe) {
                IRecipe craft = (IRecipe) obj;
                if (craft.getRecipeOutput().isItemEqual(remove)) {
                    recipes.remove(obj);
                    break;
                }
            }
        }
    }

}
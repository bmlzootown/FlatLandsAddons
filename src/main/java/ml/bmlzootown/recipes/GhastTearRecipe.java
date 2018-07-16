package ml.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Brandon on 5/22/2016.
 */
public class GhastTearRecipe {

    public static ShapedRecipe ghastTearRecipe() {
        NamespacedKey nk = NamespacedKey.minecraft("flaGhastTear");
        ItemStack ghast = new ItemStack(Material.GHAST_TEAR);
        ShapedRecipe ghastTear = new ShapedRecipe(nk, ghast);
        ghastTear.shape("***","*!*","***");
        ghastTear.setIngredient('*', Material.IRON_INGOT);
        ghastTear.setIngredient('!', Material.GOLD_NUGGET);

        return ghastTear;
    }

}

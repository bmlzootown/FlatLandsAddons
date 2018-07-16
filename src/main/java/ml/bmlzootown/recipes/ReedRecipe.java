package ml.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Brandon on 5/22/2016.
 */
public class ReedRecipe {

    public static ShapedRecipe reedRecipe() {
        NamespacedKey nk = NamespacedKey.minecraft("flaSugarCane");
        ItemStack reed = new ItemStack(Material.SUGAR_CANE, 2);
        ShapedRecipe sugarCane = new ShapedRecipe(nk, reed);
        sugarCane.shape(" * "," ! "," # ");
        sugarCane.setIngredient('*', Material.SEEDS);
        sugarCane.setIngredient('!', Material.SAND);
        sugarCane.setIngredient('#', Material.WATER_BUCKET);

        return sugarCane;
    }

}

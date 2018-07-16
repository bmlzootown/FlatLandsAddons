package ml.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Brandon on 5/21/2016.
 */
public class BlazeRodRecipe {

    public static ShapedRecipe blazeRodRecipe() {
        NamespacedKey nk = NamespacedKey.minecraft("flaBlaze");
        ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
        ShapedRecipe blazeRod = new ShapedRecipe(nk, blaze);
        blazeRod.shape("***","*!*","***");
        blazeRod.setIngredient('*', Material.BLAZE_POWDER);
        blazeRod.setIngredient('!', Material.BONE);

        return blazeRod;
    }

}

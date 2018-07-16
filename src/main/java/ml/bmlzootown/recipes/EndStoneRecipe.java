package ml.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Brandon on 5/22/2016.
 */
public class EndStoneRecipe {

    public static ShapedRecipe endStoneRecipe() {
        NamespacedKey nk = NamespacedKey.minecraft("flaEndStone");
        ItemStack end = new ItemStack(Material.ENDER_STONE, 4);
        ShapedRecipe endstone = new ShapedRecipe(nk, end);
        endstone.shape("***","*!*","***");
        endstone.setIngredient('*', Material.STONE);
        endstone.setIngredient('!', Material.ENDER_PEARL);

        return endstone;
    }

}

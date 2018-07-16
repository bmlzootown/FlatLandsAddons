package ml.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Brandon on 5/22/2016.
 */
public class ChorusPlantRecipe {

    public static ShapedRecipe chorusPlantRecipe() {
        NamespacedKey nk = NamespacedKey.minecraft("flaChorus");
        ItemStack chorus = new ItemStack(Material.CHORUS_PLANT, 2);
        ShapedRecipe chorusPlant = new ShapedRecipe(nk, chorus);
        chorusPlant.shape("***","*!*","***");
        chorusPlant.setIngredient('*', Material.SEEDS);
        chorusPlant.setIngredient('!', Material.ENDER_STONE);

        return chorusPlant;
    }

}

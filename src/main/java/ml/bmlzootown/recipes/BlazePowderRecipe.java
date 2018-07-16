package ml.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Brandon on 5/21/2016.
 */
public class BlazePowderRecipe {

    public static FurnaceRecipe blazePowderRecipe() {
        ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
        FurnaceRecipe blazePowder = new FurnaceRecipe(blaze, Material.SULPHUR);
        return blazePowder;
    }

}

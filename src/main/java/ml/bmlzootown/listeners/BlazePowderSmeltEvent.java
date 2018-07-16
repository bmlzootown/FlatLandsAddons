package ml.bmlzootown.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Brandon on 5/21/2016.
 */
public class BlazePowderSmeltEvent implements Listener {

    @EventHandler
    public static void onSmeltEvent(FurnaceSmeltEvent event) {

        String world = event.getBlock().getWorld().getName().toLowerCase().trim();
        String flatlands = "flatlands";

        if (event.getSource().getType() == Material.SULPHUR) {
            if (event.getResult().getType() == Material.BLAZE_POWDER) {
                if (!world.equalsIgnoreCase(flatlands)) {
                    event.setResult(new ItemStack(Material.SULPHUR));
                }
            }
        }

    }
}

package ml.bmlzootown.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Brandon on 5/23/2016.
 */
public class ShapelessCraftingEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onCraft(CraftItemEvent event) {
        if (event.getView().getPlayer() instanceof Player) {
            Player p = (Player) event.getView().getPlayer();

            if (event.getInventory() instanceof CraftingInventory) {

                CraftingInventory inv = event.getInventory();

                ArrayList<Material> invItems = new ArrayList<Material>();
                for (ItemStack is : inv.getMatrix()) {
                    invItems.add(is.getType());
                }

                ArrayList<Material> items = new ArrayList<Material>();
                items.add((Material.DIRT));
                items.add((Material.SEEDS));
                items.add((Material.ROTTEN_FLESH));
                items.add((Material.IRON_INGOT));
                items.add((Material.AIR));
                items.add((Material.AIR));
                items.add((Material.AIR));
                items.add((Material.AIR));
                items.add((Material.AIR));

                Collections.sort(invItems);
                Collections.sort(items);

                if (invItems.equals(items)) {
                    String world = event.getWhoClicked().getWorld().getName().toLowerCase().trim();
                    String flatlands = "flatlands";

                    if (!world.equalsIgnoreCase(flatlands)) {
                        event.setResult(Event.Result.DENY);
                        event.setCancelled(true);
                    }
                }



            }
        }
    }

}

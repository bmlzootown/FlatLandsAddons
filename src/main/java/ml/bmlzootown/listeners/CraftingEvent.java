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

/**
 * Created by Brandon on 5/21/2016.
 */
public class CraftingEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public static void onCraft(CraftItemEvent event) {
        if (event.getView().getPlayer() instanceof Player) {
            //Player p = (Player) event.getView().getPlayer();

            if (event.getInventory() instanceof CraftingInventory) {
                CraftingInventory inv = event.getInventory();

                ArrayList<Material> invItems = new ArrayList<Material>();

                for(ItemStack is : inv.getMatrix()) {
                    if (is != null) {
                        invItems.add(is.getType());
                    }
                }

                ArrayList<Material> items = new ArrayList<Material>();
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BONE));
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BLAZE_POWDER));
                items.add((Material.BLAZE_POWDER));

                ArrayList<Material> items2 = new ArrayList<Material>();
                items2.add((Material.SEEDS));
                items2.add((Material.SEEDS));
                items2.add((Material.SEEDS));
                items2.add((Material.SEEDS));
                items2.add((Material.ENDER_STONE));
                items2.add((Material.SEEDS));
                items2.add((Material.SEEDS));
                items2.add((Material.SEEDS));
                items2.add((Material.SEEDS));

                ArrayList<Material> items3 = new ArrayList<Material>();
                items3.add((Material.STONE));
                items3.add((Material.STONE));
                items3.add((Material.STONE));
                items3.add((Material.STONE));
                items3.add((Material.ENDER_PEARL));
                items3.add((Material.STONE));
                items3.add((Material.STONE));
                items3.add((Material.STONE));
                items3.add((Material.STONE));

                ArrayList<Material> items4 = new ArrayList<Material>();
                items4.add((Material.IRON_INGOT));
                items4.add((Material.IRON_INGOT));
                items4.add((Material.IRON_INGOT));
                items4.add((Material.IRON_INGOT));
                items4.add((Material.GOLD_NUGGET));
                items4.add((Material.IRON_INGOT));
                items4.add((Material.IRON_INGOT));
                items4.add((Material.IRON_INGOT));
                items4.add((Material.IRON_INGOT));

                ArrayList<Material> items5 = new ArrayList<Material>();
                items5.add((Material.AIR));
                items5.add((Material.SEEDS));
                items5.add((Material.AIR));
                items5.add((Material.AIR));
                items5.add((Material.SAND));
                items5.add((Material.AIR));
                items5.add((Material.AIR));
                items5.add((Material.WATER_BUCKET));
                items5.add((Material.AIR));

                if (invItems.equals(items) || invItems.equals(items2) || invItems.equals(items3) || invItems.equals(items4) || invItems.equals(items5)) {
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

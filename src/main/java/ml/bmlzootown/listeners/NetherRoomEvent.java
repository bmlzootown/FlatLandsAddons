package ml.bmlzootown.listeners;

import ml.bmlzootown.FlatLandsAddons;
import ml.bmlzootown.Schematic;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 5/22/2016.
 */
public class NetherRoomEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        String world = e.getPlayer().getWorld().getName().toLowerCase().trim();
        String flatlands = "flatlands";

        if (world.equalsIgnoreCase(flatlands)) {

            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

                Block clicked = e.getClickedBlock();

                if (clicked.getType() == Material.PURPUR_BLOCK) {

                    List<Location> cobble = new ArrayList<Location>();
                    List<Location> gold = new ArrayList<Location>();

                    Location center = clicked.getLocation();
                    World w = center.getWorld();
                    double x = center.getX();
                    double y = center.getY();
                    double z = center.getZ();

                    cobble.add(new Location(w, x + 1, y + 1, z));
                    cobble.add(new Location(w, x - 1, y + 1, z));
                    cobble.add(new Location(w, x, y + 1, z + 1));
                    cobble.add(new Location(w, x, y + 1, z - 1));
                    cobble.add(new Location(w, x, y + 1, z));

                    cobble.add(new Location(w, x + 1, y - 1, z));
                    cobble.add(new Location(w, x - 1, y - 1, z));
                    cobble.add(new Location(w, x, y - 1, z + 1));
                    cobble.add(new Location(w, x, y - 1, z - 1));
                    cobble.add(new Location(w, x, y - 1, z));

                    cobble.add(new Location(w, x + 1, y, z + 1));
                    cobble.add(new Location(w, x + 1, y, z - 1));
                    cobble.add(new Location(w, x - 1, y, z + 1));
                    cobble.add(new Location(w, x - 1, y, z - 1));

                    gold.add(new Location(w, x + 1, y - 1, z + 1));
                    gold.add(new Location(w, x - 1, y - 1, z + 1));
                    gold.add(new Location(w, x + 1, y - 1, z - 1));
                    gold.add(new Location(w, x - 1, y - 1, z - 1));

                    List<String> b = new ArrayList<>();

                    for (Location c : cobble) {
                        if (c.getBlock().getType() != Material.COBBLESTONE) {
                            b.add("false");
                        }
                    }

                    for (Location g : gold) {
                        if (g.getBlock().getType() != Material.GOLD_BLOCK) {
                            b.add("false");
                        }
                    }

                    if (!b.contains("false")) {
                        for (Location c : cobble) {
                            c.getBlock().setType(Material.AIR);
                        }
                        for (Location g : gold) {
                            g.getBlock().setType(Material.AIR);
                        }
                        center.getBlock().setType(Material.AIR);

                        if (FlatLandsAddons.worldEditSupport) {
                            Location newCenter = new Location(w, x, y - 1, z);
                            Schematic.paste("nether.schematic",newCenter);
                        }
                    }


                }
            }
        }
    }

}

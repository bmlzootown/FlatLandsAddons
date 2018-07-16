package ml.bmlzootown.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Skull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 5/23/2016.
 */
public class SpawnerEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        String world = e.getPlayer().getWorld().getName().toLowerCase().trim();
        String flatlands = "flatlands";

        if (world.equalsIgnoreCase(flatlands)) {

            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = e.getClickedBlock();

                if (clicked.getType() == Material.EMERALD_BLOCK) {
                    List<Location> end = new ArrayList<Location>();
                    List<Location> diamond = new ArrayList<Location>();
                    List<Location> obsidian = new ArrayList<Location>();

                    Location center = clicked.getLocation();
                    World w = center.getWorld();
                    double x = center.getX();
                    double y = center.getY();
                    double z = center.getZ();

                    end.add(new Location(w, x + 1, y + 1, z));
                    end.add(new Location(w, x - 1, y + 1, z));
                    end.add(new Location(w, x, y + 1, z + 1));
                    end.add(new Location(w, x, y + 1, z - 1));

                    end.add(new Location(w, x + 1, y - 1, z));
                    end.add(new Location(w, x - 1, y - 1, z));
                    end.add(new Location(w, x, y - 1, z + 1));
                    end.add(new Location(w, x, y - 1, z - 1));

                    end.add(new Location(w, x + 1, y, z + 1));
                    end.add(new Location(w, x + 1, y, z - 1));
                    end.add(new Location(w, x - 1, y, z + 1));
                    end.add(new Location(w, x - 1, y, z - 1));

                    obsidian.add(new Location(w, x + 1, y - 1, z + 1));
                    obsidian.add(new Location(w, x - 1, y - 1, z + 1));
                    obsidian.add(new Location(w, x + 1, y - 1, z - 1));
                    obsidian.add(new Location(w, x - 1, y - 1, z - 1));

                    diamond.add(new Location(w, x, y + 1, z));
                    diamond.add(new Location(w, x, y - 1, z));

                    List<String> b = new ArrayList<>();

                    for (Location en : end) {
                        if (en.getBlock().getType() != Material.END_BRICKS) {
                            b.add("false");
                        }
                    }
                    for (Location o : obsidian) {
                        if (o.getBlock().getType() != Material.OBSIDIAN) {
                            b.add("false");
                        }
                    }
                    for (Location d : diamond) {
                        if (d.getBlock().getType() != Material.DIAMOND_BLOCK) {
                            b.add("false");
                        }
                    }

                    if (!b.contains("false")) {
                        for (Location en : end) {
                            en.getBlock().setType(Material.AIR);
                        }
                        for (Location o : obsidian) {
                            o.getBlock().setType(Material.AIR);
                        }
                        for (Location d : diamond) {
                            d.getBlock().setType(Material.AIR);
                        }
                        Block top = (new Location(w, x, y + 2, z)).getBlock();

                        if (top.getType() == Material.SKULL) {
                            center.getBlock().setType(Material.MOB_SPAWNER);
                            Block bl = center.getBlock();
                            BlockState bs = bl.getState();
                            CreatureSpawner sp = ((CreatureSpawner)bs);

                            Skull topB = (Skull) top.getState();
                            SkullType type = topB.getSkullType();

                            if (type == SkullType.SKELETON) {
                                sp.setSpawnedType(EntityType.SKELETON);
                                bs.update();
                            } else if (type == SkullType.ZOMBIE) {
                                sp.setSpawnedType(EntityType.ZOMBIE);
                                bs.update();
                            } else if (type == SkullType.CREEPER) {
                                sp.setSpawnedType(EntityType.CREEPER);
                                bs.update();
                            } else {
                                sp.setSpawnedType(EntityType.ZOMBIE);
                            }

                            top.setType(Material.AIR);
                        } else {
                            center.getBlock().setType(Material.MOB_SPAWNER);
                            Block bl = center.getBlock();
                            BlockState bs = bl.getState();
                            CreatureSpawner sp = ((CreatureSpawner)bs);
                            sp.setSpawnedType(EntityType.ZOMBIE);
                            bs.update();
                        }
                    }
                }
            }
        }
    }

}

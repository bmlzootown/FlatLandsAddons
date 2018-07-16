package ml.bmlzootown.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Random;

/**
 * Created by bmlzootown on 7/30/2016.
 */
public class ShearCactusEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        String world = e.getPlayer().getWorld().getName().toLowerCase().trim();
        String flatlands = "flatlands";
        if (world.equalsIgnoreCase(flatlands)) {
            Player p = e.getPlayer();
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = e.getClickedBlock();
                if (clicked.getType() == Material.CACTUS) {
                    if (p.getInventory().getItemInMainHand().getType() == Material.SHEARS) {
                        short usage = p.getInventory().getItemInMainHand().getDurability();
                        p.getInventory().getItemInMainHand().setDurability((short)(usage + 4));
                        Random rand = new Random();
                        float r = rand.nextFloat();
                        if (r <= 0.1f) {
                            clicked.setType(Material.MELON_BLOCK);
                        }
                    }
                }
            }
        }
    }
}

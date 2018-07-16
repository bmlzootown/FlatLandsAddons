package ml.bmlzootown.listeners;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

import java.util.Random;

/**
 * Created by bmlzootown on 7/30/2016.
 */
public class SpawnCactusEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        String world = e.getPlayer().getWorld().getName().toLowerCase().trim();
        String flatlands = "flatlands";
        if (world.equalsIgnoreCase(flatlands)) {
            Player p = e.getPlayer();
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = e.getClickedBlock();
                if (clicked.getType() == Material.SAND) {
                    if (clicked.getData() == (byte) 0) {
                        if (p.getInventory().getItemInMainHand().getType() == Material.INK_SACK) {
                            Dye dye = (Dye) p.getInventory().getItemInMainHand().getData();
                            if (dye.getColor().equals(DyeColor.WHITE)) {
                                Block above = e.getClickedBlock().getRelative(BlockFace.UP);
                                if (above.getType() == Material.AIR) {
                                    ItemStack hand = p.getInventory().getItemInMainHand();
                                    int amount = hand.getAmount();
                                    if (amount > 1) {
                                        hand.setAmount(amount - 1);
                                        p.getInventory().setItemInMainHand(hand);
                                    } else {
                                        p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                    }
                                    Random rand = new Random();
                                    float r = rand.nextFloat();
                                    if (r <= 0.1f) {
                                        above.setType(Material.CACTUS);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

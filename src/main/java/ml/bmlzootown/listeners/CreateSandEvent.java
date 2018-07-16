package ml.bmlzootown.listeners;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

/**
 * Created by Brandon on 5/22/2016.
 */
public class CreateSandEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {
        String world = e.getPlayer().getWorld().getName().toLowerCase().trim();
        String flatlands = "flatlands";
        if (world.equalsIgnoreCase(flatlands)) {
            Player p = e.getPlayer();
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block clicked = e.getClickedBlock();
                if (clicked.getType() == Material.DIRT) {
                    if (p.getInventory().getItemInMainHand().getType() == Material.BLAZE_POWDER) {
                        ItemStack hand = p.getInventory().getItemInMainHand();
                        int amount = hand.getAmount();
                        if (amount > 1) {
                            hand.setAmount(amount - 1);
                            p.getInventory().setItemInMainHand(hand);
                        } else {
                            p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        clicked.setType(Material.SAND);
                    }
                } else if (clicked.getType() == Material.SAND) {
                    if (clicked.getData() == (byte) 0) {
                        if (p.getInventory().getItemInMainHand().getType() == Material.INK_SACK) {
                            Dye dye = (Dye) p.getInventory().getItemInMainHand().getData();
                            if (dye.getColor().equals(DyeColor.RED)) {
                                ItemStack hand = p.getInventory().getItemInMainHand();
                                int amount = hand.getAmount();
                                if (amount > 1) {
                                    hand.setAmount(amount - 1);
                                    p.getInventory().setItemInMainHand(hand);
                                } else {
                                    p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                                }
                                clicked.setData((byte) 1);
                            }
                        } else if (p.getInventory().getItemInMainHand().getType() == Material.SULPHUR) {
                            ItemStack hand = p.getInventory().getItemInMainHand();
                            int amount = hand.getAmount();
                            if (amount > 1) {
                                hand.setAmount(amount - 1);
                                p.getInventory().setItemInMainHand(hand);
                            } else {
                                p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                            }
                            clicked.setType(Material.CLAY);
                        }
                    }
                }
            }
        }
    }

}

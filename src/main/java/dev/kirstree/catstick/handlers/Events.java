package dev.kirstree.catstick.handlers;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;


public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.getName().equals("Kirstree")) {
            player.sendMessage(ChatColor.GREEN + "Hi Boss");
        } else {
            player.sendMessage(ChatColor.RED + "How did you get here " + player.getName() + "?");
        }

        ItemStack Catstick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = Catstick.getItemMeta();
        meta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Catstick");
        meta.addEnchant(Enchantment.LUCK, 2, false);
        meta.isUnbreakable();

        Catstick.setItemMeta(meta);

        inv.setItem(4, Catstick);

        if(player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE){
            player.setAllowFlight(true);
        }
    }

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
                player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                        event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            Location loc = player.getLocation();
            Cat blackcat = (Cat) player.getWorld().spawnEntity(loc, EntityType.CAT);
            blackcat.setCatType(Cat.Type.ALL_BLACK);
            blackcat.setCustomName(ChatColor.DARK_PURPLE + "EDDIE");
            blackcat.setCustomNameVisible(true);
            blackcat.setVelocity(new Vector(3, 0, 3));

        }

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.LEFT_CLICK_AIR) || player.getInventory().getItemInMainHand().getType()
                        == Material.STICK && event.getAction().equals(Action.LEFT_CLICK_BLOCK)){


        }
    }

    @EventHandler
    public void onPlayerDoubleJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();

        if(player.getGameMode() == GameMode.SURVIVAL && event.isFlying()
                || player.getGameMode() == GameMode.ADVENTURE && event.isFlying()){

            if(player.getLocation().subtract(0 , 2, 0).getBlock().getType() != Material.AIR){

                player.setVelocity(player.getLocation().getDirection().multiply(1).setY(1));
            }

            event.setCancelled(true);
        }
    }
}

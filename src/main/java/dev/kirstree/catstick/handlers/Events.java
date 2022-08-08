package dev.kirstree.catstick.handlers;


import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();

        if(player.getName().equals("Kirstree")){
            player.sendMessage(ChatColor.GREEN  + "Hi Boss");
        }else{
            player.sendMessage(ChatColor.RED + "How did you get here " + player.getName() + "?");
        }

        ItemStack Catstick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = Catstick.getItemMeta();
        meta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Catstick");
        Catstick.setItemMeta(meta);

        inv.setItem(4, Catstick);
    }

    public void onPlayerInteraction(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
                player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                        event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            /*Cat blackCat = new Cat;
            blackCat.setCatType(Cat.Type.ALL_BLACK);*/


        }
    }
}
package dev.kirstree.catstick.handlers;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();

        ItemStack catstick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = catstick.getItemMeta();
        meta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Catstick");
        catstick.setItemMeta(meta);

        inv.setItem(4, catstick);
    }

}

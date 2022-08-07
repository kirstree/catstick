package dev.kirstree.catstick.handlers;

import dev.kirstree.catstick.CatStick;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Events implements Listener {

    /*public Events(CatStick plugin){
        Bukkit.getPluginManager().registerEvent(this, plugin);
    }*/

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = (Player)event.getPlayer();

        ItemStack catstick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = catstick.getItemMeta();
        meta.setDisplayName("&c" + "Catstick");
        catstick.setItemMeta(meta);

        inv.setItem(4, catstick);
    }
}

package dev.kirstree.catstick.handlers;


import net.md_5.bungee.api.chat.ClickEvent;
import net.minecraft.world.item.ItemCarrotStick;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();

        ItemStack Catstick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = Catstick.getItemMeta();
        meta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Catstick");
        Catstick.setItemMeta(meta);

        inv.setItem(4, Catstick);
    }

    public void onPlayerInteraction(PlayerInteractEvent event){
        Player player = (Player) event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
                player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                        event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

        }
    }
}

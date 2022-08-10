package dev.kirstree.catstick.handlers;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;


public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack Catstick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = Catstick.getItemMeta();
        meta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Catstick");
        meta.addEnchant(Enchantment.LUCK, 2, false);
        meta.isUnbreakable();

        Catstick.setItemMeta(meta);

        inv.setItem(4, Catstick);
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
            blackcat.setVelocity(new Vector(3 , 0 , 3));
            blackcat.getWorld().createExplosion(blackcat.getLocation(), 2);
            blackcat.setNoDamageTicks(0);

        }

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.LEFT_CLICK_AIR)
                || player.getInventory().getItemInMainHand().getType()
                        == Material.STICK && event.getAction().equals(Action.LEFT_CLICK_BLOCK)){


        }
    }
}

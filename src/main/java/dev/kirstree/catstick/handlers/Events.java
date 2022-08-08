package dev.kirstree.catstick.handlers;


import net.minecraft.world.level.block.Block;
import org.bukkit.*;
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

import java.awt.event.KeyEvent;
import java.nio.file.ClosedDirectoryStreamException;


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

            Bukkit.getLogger().info("Some code is working :P");

            Location loc = player.getEyeLocation();
            Cat blackcat = (Cat) player.getWorld().spawnEntity(loc, EntityType.CAT);
            blackcat.setCatType(Cat.Type.ALL_BLACK);
            blackcat.setCustomName(ChatColor.DARK_PURPLE + "EDDIE");
            blackcat.setCustomNameVisible(true);
            blackcat.setVelocity(new Vector(5, 2, 3));

        }
    }

//    public void onPlayerDoubleJump(PlayerToggleFlightEvent event){
//        Player player = (Player) event.getPlayer();
//        GameMode gameMode = player.getGameMode();
//
//        if(player.getGameMode() == GameMode.SPECTATOR && player.isFlying() ||
//                player.getGameMode() == GameMode.SURVIVAL && player.isFlying()){
//            Block b = player.getWorld().getBlockAt(player.getLocation();
//
//        }else{
//            event.isCancelled();
//        }

    }

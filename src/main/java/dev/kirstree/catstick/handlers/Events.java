package dev.kirstree.catstick.handlers;

import dev.kirstree.catstick.CatStick;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
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
        assert meta != null;
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
                event.getAction().equals(Action.LEFT_CLICK_AIR) ||
                player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                        event.getAction().equals(Action.LEFT_CLICK_AIR)) {

            Location loc = player.getLocation();
            Cat catType = (Cat) player.getWorld().spawnEntity(loc, EntityType.CAT);
            catType.setVelocity(new Vector(3 , 0 , 3));
            catType.getWorld().createExplosion(catType.getLocation(), 2);
            catType.setNoDamageTicks(0);

        }

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.RIGHT_CLICK_AIR)
                || player.getInventory().getItemInMainHand().getType()
                        == Material.STICK && event.getAction().equals(Action.RIGHT_CLICK_AIR)){

            //need to add someway to click stick to make it open GUI

        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e){

        if(e.getInventory() == (CatGUI.getCatGUI())){
            Player p = (Player) e.getWhoClicked();

            switch (e.getSlot()){

                case 21:{
                    p.closeInventory();
                    CatStick.catType.setCatType(Cat.Type.BRITISH_SHORTHAIR);
                    break;
                }

                case 22:{
                    p.closeInventory();
                    //more cat stuff
                    break;
                }

                //add rest of cases when im not feeling lazy
            }
        }
    }
}

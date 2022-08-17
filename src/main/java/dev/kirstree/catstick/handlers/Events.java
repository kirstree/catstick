package dev.kirstree.catstick.handlers;

import dev.kirstree.catstick.CatStick;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
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
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import java.util.Objects;


public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack catStick = new ItemStack(Material.STICK, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = catStick.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Catstick");
        meta.addEnchant(Enchantment.LUCK, 2, false);
        meta.isUnbreakable();

        catStick.setItemMeta(meta);

        inv.setItem(4, catStick);
    }

    //add explosion event

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.LEFT_CLICK_AIR) ||
                player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                        event.getAction().equals(Action.LEFT_CLICK_AIR)) {

            Location loc = player.getLocation();
            Cat cat = (Cat) player.getWorld().spawnEntity(loc, EntityType.CAT);
            //cat.setCatType(CatStick.catType);
            if(!CatStick.selectedTypes.containsKey(player.getUniqueId())) {
                CatStick.selectedTypes.put(player.getUniqueId(), Cat.Type.ALL_BLACK);
            }
            cat.setCatType(CatStick.selectedTypes.get(player.getUniqueId()));
            Vector direction = player.getLocation().getDirection();
            int speed = 3;
            Vector velocity = direction.normalize().multiply(speed);
            cat.setVelocity(velocity);
            startTimer(cat);

        }

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.RIGHT_CLICK_AIR)
                || player.getInventory().getItemInMainHand().getType()
                        == Material.STICK && event.getAction().equals(Action.RIGHT_CLICK_AIR)){

            CatGUI.gui(player);
        }
    }

    public void startTimer(Cat cat) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Location loc = cat.getLocation().clone();
                cat.remove();
                Objects.requireNonNull(loc.getWorld()).createExplosion(loc, 1f);
            }
        }.runTaskLater(CatStick.getInstance(), 10L);
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e){

        if(e.getInventory() == (CatGUI.getCatGUI())) {
            Player p = (Player) e.getWhoClicked();

            if(CatStick.catTypes.containsKey(e.getSlot())) {
                p.closeInventory();
                //CatStick.catType = CatStick.catTypes.get(e.getSlot()).type;
                if(CatStick.selectedTypes !=null ) {
                    if(CatStick.selectedTypes.containsKey(p.getUniqueId())){
                        CatStick.selectedTypes.remove(p.getUniqueId());
                        CatStick.selectedTypes.put(p.getUniqueId(), CatStick.catTypes.get(e.getSlot()).type);
                    }
                    else {
                        CatStick.selectedTypes.put(p.getUniqueId(), CatStick.catTypes.get(e.getSlot()).type);
                    }
                }
            }
            else {
                e.setCancelled(true);
            }

            /*switch (e.getSlot()){
                case 20:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.BRITISH_SHORTHAIR;
                    break;
                }
                case 21:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.JELLIE;
                    break;
                }
                case 22:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.ALL_BLACK;
                    break;
                }
                case 23:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.RAGDOLL;
                    break;
                }
                case 24:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.TABBY;
                    break;
                }
                case 29:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.CALICO;
                    break;
                }
                case 30:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.RED;
                    break;
                }
                case 31:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.PERSIAN;
                    break;
                }
                case 32:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.WHITE;
                    break;
                }
                case 33:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.SIAMESE;
                    break;
                }
<<<<<<< HEAD
            }*/
        } else {
            e.setCancelled(true);
=======
            }
>>>>>>> origin/main
        }
    }
}

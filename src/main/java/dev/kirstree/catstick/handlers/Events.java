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
import org.bukkit.util.Vector;


public class Events implements Listener {


    private static Inventory catGUI;


    public static Inventory getCatGUI(){
        return catGUI;
    }
    private void gui(Player p){ //moved this all into this class to see if we can run as private function obviously this is less than ideal though

        catGUI = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Pick a cat!");

        ItemStack blackCat = new ItemStack(Material.PURPLE_CONCRETE, 1);
        ItemMeta blackCatMeta = blackCat.getItemMeta();
        assert blackCatMeta != null;
        blackCatMeta.setDisplayName(ChatColor.DARK_PURPLE + "Eddie");
        blackCat.setItemMeta(blackCatMeta);

        ItemStack calicoCat = new ItemStack(Material.CYAN_CONCRETE, 1);
        ItemMeta calicoCatMeta = calicoCat.getItemMeta();
        assert calicoCatMeta != null;
        calicoCatMeta.setDisplayName(ChatColor.DARK_AQUA + "Edward");
        calicoCat.setItemMeta(calicoCatMeta);

        ItemStack tabbyCat = new ItemStack(Material.LIGHT_BLUE_CONCRETE, 1);
        ItemMeta tabbyCatMeta = tabbyCat.getItemMeta();
        assert tabbyCatMeta != null;
        tabbyCatMeta.setDisplayName(ChatColor.AQUA + "Edmundo");
        tabbyCat.setItemMeta(tabbyCatMeta);

        ItemStack jellieCat = new ItemStack(Material.MAGENTA_CONCRETE, 1);
        ItemMeta jellieCatMeta = jellieCat.getItemMeta();
        assert jellieCatMeta != null;
        jellieCatMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Eduardo");
        jellieCat.setItemMeta(jellieCatMeta);

        ItemStack siameseCat = new ItemStack(Material.LIME_CONCRETE, 1);
        ItemMeta siameseCatMeta = siameseCat.getItemMeta();
        assert siameseCatMeta != null;
        siameseCatMeta.setDisplayName(ChatColor.GREEN + "Edwin");
        siameseCat.setItemMeta(siameseCatMeta);

        ItemStack whiteCat = new ItemStack(Material.YELLOW_CONCRETE, 1);
        ItemMeta whiteCatMeta = whiteCat.getItemMeta();
        assert whiteCatMeta != null;
        whiteCatMeta.setDisplayName(ChatColor.YELLOW + "Edmund");
        whiteCat.setItemMeta(whiteCatMeta);

        ItemStack persianCat = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta persianCatMeta = persianCat.getItemMeta();
        assert persianCatMeta != null;
        persianCatMeta.setDisplayName(ChatColor.DARK_GREEN + "Edgar");
        persianCat.setItemMeta(persianCatMeta);

        ItemStack oTabbyCat = new ItemStack(Material.BLUE_CONCRETE, 1);
        ItemMeta oTabbyCatMeta = oTabbyCat.getItemMeta();
        assert oTabbyCatMeta != null;
        oTabbyCatMeta.setDisplayName(ChatColor.DARK_BLUE + "Eddison");
        oTabbyCat.setItemMeta(oTabbyCatMeta);

        ItemStack ragdollCat = new ItemStack(Material.ORANGE_CONCRETE, 1);
        ItemMeta ragdollCatMeta = ragdollCat.getItemMeta();
        assert ragdollCatMeta != null;
        ragdollCatMeta.setDisplayName(ChatColor.RED + "Edith");
        ragdollCat.setItemMeta(ragdollCatMeta);

        ItemStack bShortCat = new ItemStack(Material.BROWN_CONCRETE, 1);
        ItemMeta bShortCatMeta = bShortCat.getItemMeta();
        assert bShortCatMeta != null;
        bShortCatMeta.setDisplayName(ChatColor.GOLD + "Edwina");
        bShortCat.setItemMeta(bShortCatMeta);

        catGUI.setItem(21, bShortCat);
        catGUI.setItem(22, jellieCat);
        catGUI.setItem(23, blackCat);
        catGUI.setItem(24, ragdollCat);
        catGUI.setItem(25, tabbyCat);
        catGUI.setItem(30, calicoCat);
        catGUI.setItem(31, oTabbyCat);
        catGUI.setItem(32, persianCat);
        catGUI.setItem(33, whiteCat);
        catGUI.setItem(34, siameseCat);
    }

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

        Bukkit.getLogger().info("Catstick is being given");
    }

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.LEFT_CLICK_AIR) ||
                player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                        event.getAction().equals(Action.LEFT_CLICK_AIR)) {

            Location loc = player.getLocation();
            Cat cat = (Cat) player.getWorld().spawnEntity(loc, EntityType.CAT);
            cat.setCatType(CatStick.catType);
            Vector direction = player.getLocation().getDirection(); // should shoot cat in direction player is looking
            int speed = 3;
            Vector velocity = direction.normalize().multiply(speed);
            cat.setVelocity(velocity);
            //catType.setVelocity(new Vector(3 , 0 , 3));

            Bukkit.getLogger().info("Cat being fired");

        }

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK &&
                event.getAction().equals(Action.RIGHT_CLICK_AIR)
                || player.getInventory().getItemInMainHand().getType()
                        == Material.STICK && event.getAction().equals(Action.RIGHT_CLICK_AIR)){

            Bukkit.getLogger().info("Right Click is being clicked");

            gui(player);

            Bukkit.getLogger().info("Catstick is being given");

        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e){

        //if(e.getInventory() == (CatGUI.getCatGUI())){
        if(e.getInventory() == (catGUI)){
            Player p = (Player) e.getWhoClicked();

            switch (e.getSlot()){
                case 21:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.BRITISH_SHORTHAIR;
                    break;
                }
                case 22:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.JELLIE;
                    break;
                }
                case 23:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.ALL_BLACK;
                    break;
                }
                case 24:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.RAGDOLL;
                    break;
                }
                case 25:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.TABBY;
                    break;
                }
                case 30:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.CALICO;
                    break;
                }
                case 31:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.RED;
                    break;
                }
                case 32:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.PERSIAN;
                    break;
                }
                case 33:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.WHITE;
                    break;
                }
                case 34:{
                    p.closeInventory();
                    CatStick.catType = Cat.Type.SIAMESE;
                    break;
                }
            }
        }else {
            e.setCancelled(true);
        }
    }
}

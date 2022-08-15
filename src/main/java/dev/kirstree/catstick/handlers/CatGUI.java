package dev.kirstree.catstick.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CatGUI {

    private static Inventory catGUI;

    public static Inventory getCatGUI(){
        return catGUI;
    }

    public static void gui(Player p){

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
}

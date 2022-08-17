package dev.kirstree.catstick.handlers;

import dev.kirstree.catstick.CatStick;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CatGUI {


    private static Inventory catGUI;

    public static void initGUI() {

        CatType bshort = new CatType("Edwina",20,Cat.Type.BRITISH_SHORTHAIR, Material.BROWN_CONCRETE, ChatColor.GOLD);
        CatType jellie = new CatType("Eduardo",21,Cat.Type.JELLIE, Material.MAGENTA_CONCRETE, ChatColor.LIGHT_PURPLE);
        CatType black = new CatType("Eddie",22,Cat.Type.ALL_BLACK, Material.PURPLE_CONCRETE, ChatColor.DARK_PURPLE);
        CatType ragdoll = new CatType("Edith",23,Cat.Type.RAGDOLL, Material.ORANGE_CONCRETE, ChatColor.RED);
        CatType tabby = new CatType("Edmundo",24,Cat.Type.TABBY, Material.LIGHT_BLUE_CONCRETE, ChatColor.AQUA);
        CatType calico = new CatType("Edward",29,Cat.Type.CALICO, Material.CYAN_CONCRETE, ChatColor.DARK_AQUA);
        CatType red = new CatType("Eddison",30,Cat.Type.RED, Material.BLUE_CONCRETE, ChatColor.DARK_BLUE);
        CatType persian = new CatType("Edgar",31,Cat.Type.PERSIAN, Material.GREEN_CONCRETE, ChatColor.DARK_GREEN);
        CatType white = new CatType("Edmund",32,Cat.Type.WHITE, Material.YELLOW_CONCRETE, ChatColor.YELLOW);
        CatType siamese = new CatType("Edwin",33,Cat.Type.SIAMESE, Material.LIME_CONCRETE, ChatColor.GREEN);


    }

    public static Inventory getCatGUI(){
        return catGUI;
    }
    public static void gui(Player p){

        catGUI = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Pick a cat!");
        for(int i = 0; i < 54; i++) {
            if(CatStick.catTypes.containsKey(i)){
                catGUI.setItem(i, guiButton(CatStick.catTypes.get(i)));
            }
            else {
                catGUI.setItem(i, guiBlankButton());
            }
        }
        p.openInventory(catGUI);
    }

    private static ItemStack guiButton(CatType catType) {
        ItemStack itemstack = new ItemStack(catType.material, 1);
        ItemMeta meta = itemstack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(catType.color + catType.name);
        itemstack.setItemMeta(meta);
        return itemstack;
    }
    private static ItemStack guiBlankButton() {
        ItemStack itemstack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta meta = itemstack.getItemMeta();
        assert meta != null;
        meta.setDisplayName("");
        itemstack.setItemMeta(meta);
        return itemstack;
    }


    public static class CatType {
        public String name;
        public Cat.Type type;
        public Material material;
        public ChatColor color;
        public CatType(String name, int slotNumber, Cat.Type type, Material material, ChatColor color) {
            this.name = name;
            this.type = type;
            this.material = material;
            this.color = color;
            CatStick.catTypes.put(slotNumber,this);
        }
    }
}

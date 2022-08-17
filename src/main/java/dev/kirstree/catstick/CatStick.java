package dev.kirstree.catstick;

import dev.kirstree.catstick.handlers.CatGUI;
import dev.kirstree.catstick.handlers.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class CatStick extends JavaPlugin {

    public static Cat.Type catType;
    public static HashMap<UUID, Cat.Type> selectedTypes = new HashMap<UUID, Cat.Type>();
    public static HashMap<Integer, CatGUI.CatType> catTypes = new HashMap<Integer, CatGUI.CatType>();

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("CatStick enabling...");
        CatGUI.initGUI();
        catType = Cat.Type.ALL_BLACK;
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("CatStick shutting down...");
    }

}

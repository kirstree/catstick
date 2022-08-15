package dev.kirstree.catstick;

import dev.kirstree.catstick.handlers.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class CatStick extends JavaPlugin {

    public static Cat.Type catType; // default variable but is also wrong?

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("CatStick enabling...");
        catType = Cat.Type.ALL_BLACK;
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("CatStick shutting down...");
    }

}

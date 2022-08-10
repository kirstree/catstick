package dev.kirstree.catstick;

import dev.kirstree.catstick.handlers.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CatStick extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("CatStick enabling...");

        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("CatStick shutting down...");
    }

}

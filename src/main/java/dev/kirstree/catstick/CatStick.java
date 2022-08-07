package dev.kirstree.catstick;
import dev.kirstree.catstick.handlers.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CatStick extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getLogger().info("&a" + "CatStick Plugin Enabling...");
    }

    @Override
    public void onDisable(){
        Bukkit.getLogger().info("&c" + "CatStick Plugin Shutting down...");
    }

}

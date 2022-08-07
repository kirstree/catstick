package dev.kirstree.catstick;
import org.bukkit.plugin.java.JavaPlugin;

public class CatStick extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("&a" + "CatStick Plugin Enabling...");
    }

    @Override
    public void onDisable(){
        System.out.println("&c" + "CatStick Plugin Shutting down...");
    }

}

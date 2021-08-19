package me.evilterabite.tutorial;

import me.evilterabite.tutorial.commands.PingCommand;
import me.evilterabite.tutorial.events.SneakingListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin {

    private PluginManager pluginManager;

    @Override
    public void onEnable() {
        pluginManager = Bukkit.getPluginManager();

        //Register Commands
        getCommand("ping").setExecutor(new PingCommand());

        //Register Listener
        pluginManager.registerEvents(new SneakingListener(), this);


        System.out.println("Hello World!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

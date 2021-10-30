package me.evilterabite.tutorial;

import me.evilterabite.tutorial.commands.ConfigTestCommand;
import me.evilterabite.tutorial.commands.PingCommand;
import me.evilterabite.tutorial.commands.ReloadCommand;
import me.evilterabite.tutorial.events.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Tutorial extends JavaPlugin {

    private PluginManager pluginManager;
    private final Logger logger = Bukkit.getServer().getLogger();

    @Override
    public void onEnable() {
        //config setup
        saveDefaultConfig();

        pluginManager = Bukkit.getPluginManager();

        //Register Commands
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("tutorialreload").setExecutor(new ReloadCommand());
        getCommand("configtest").setExecutor(new ConfigTestCommand());

        //Register Listener
        pluginManager.registerEvents(new JoinEvent(), this);


        logger.log(Level.INFO, "Hello World!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

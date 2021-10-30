package me.evilterabite.tutorial.commands;

import me.evilterabite.tutorial.Tutorial;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigTestCommand implements CommandExecutor {

    private static Tutorial plugin = Tutorial.getPlugin(Tutorial.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = plugin.getConfig();
        String string = config.getString("string");
        int i = config.getInt("integer");
        double d = config.getDouble("double");
        boolean bool = config.getBoolean("boolean");

        sender.sendMessage("String: " + string);
        sender.sendMessage("Integer: " + i);
        sender.sendMessage("Double: " + d);
        sender.sendMessage("Boolean: " + bool);

        return true;
    }
}

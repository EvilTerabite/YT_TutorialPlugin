package me.evilterabite.tutorial.commands;

import me.evilterabite.tutorial.Tutorial;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private static Tutorial plugin = Tutorial.getPlugin(Tutorial.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("tutorial.admin")) {
            plugin.reloadConfig();
        }
        return true;
    }
}

package me.evilterabite.tutorial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {

            // Only runs if the sender is a Physical Player in the world
            Player player = (Player) sender;
            player.sendMessage("Player Pong!");
        } else {

            //Only runs if the sender is a console.
            sender.sendMessage("Console Pong!");
        }
        return true;
    }
}

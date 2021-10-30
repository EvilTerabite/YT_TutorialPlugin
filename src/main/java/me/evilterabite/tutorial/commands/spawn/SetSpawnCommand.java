package me.evilterabite.tutorial.commands.spawn;

import me.evilterabite.tutorial.Tutorial;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("tutorial.setspawn")) {
                Location location = player.getLocation();
                Tutorial plugin = Tutorial.getPlugin(Tutorial.class);
                FileConfiguration config = plugin.getConfig();

                config.set("spawn.x", location.getX());
                config.set("spawn.y", location.getY());
                config.set("spawn.z", location.getZ());
                config.set("spawn.yaw", location.getYaw());
                config.set("spawn.pitch", location.getPitch());
                config.set("spawn.set", true);
                config.set("spawn.world", Objects.requireNonNull(location.getWorld()).getName());

                plugin.saveConfig();
            } else {
                player.sendMessage(ChatColor.RED + "No Permission.");
            }


        } else {
            sender.sendMessage("Cannot be run from console.");
        }
        return true;
    }
}

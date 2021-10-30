package me.evilterabite.tutorial.commands.spawn;

import me.evilterabite.tutorial.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Tutorial plugin = Tutorial.getPlugin(Tutorial.class);
            FileConfiguration config = plugin.getConfig();
            boolean spawnSet = config.getBoolean("spawn.set");
            if(spawnSet) {
                double x = config.getDouble("spawn.x");
                double y = config.getDouble("spawn.y");
                double z = config.getDouble("spawn.z");
                double yaw = config.getDouble("spawn.yaw");
                double pitch = config.getDouble("spawn.pitch");
                String worldName = config.getString("spawn.world");
                assert worldName != null;
                Location spawnLocation = new Location(Bukkit.getWorld(worldName), x, y, z, (float) yaw, (float) pitch);

                player.sendMessage(ChatColor.RED + "DO NOT MOVE!" + ChatColor.YELLOW + "You will be teleported in 5 seconds.");
                double aX = player.getLocation().getX();
                double aY = player.getLocation().getY();
                double aZ = player.getLocation().getZ();

                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    if(aX == player.getLocation().getX() && aY == player.getLocation().getY() && aZ == player.getLocation().getZ()) {
                        player.teleport(spawnLocation);
                    } else {
                        player.sendMessage(ChatColor.RED + "You moved so you weren't teleported.");
                    }
                }, 20L * 5);

            } else {
                player.sendMessage(ChatColor.RED + "Spawn has not been set.");
            }

        }
        return true;
    }
}

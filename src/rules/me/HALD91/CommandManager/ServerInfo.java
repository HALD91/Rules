package rules.me.HALD91.CommandManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import rules.me.HALD91.Rules;

public class ServerInfo implements CommandExecutor{
    Rules main = JavaPlugin.getPlugin(Rules.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("serverinfo")) {
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix").toString()) + " " + ChatColor.RED + " This command can't be used in the console");
                return true;
            }
            if (sender instanceof Player) {
                Player p1 = (Player) sender;
                if (strings.length == 0) {
                    for (String messages : main.getConfig().getStringList("ServerInfo")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
                    }
                    return true;
                }
                if (strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("Help")) {
                        if (p1.hasPermission("rules.admin.Help")) {
                            p1.sendMessage(ChatColor.GRAY + "------------------------" + " " + ChatColor.GOLD + "Help" + " " + ChatColor.GRAY + "-----------------------");
                            p1.sendMessage(" ");
                            p1.sendMessage(ChatColor.GRAY + "/Info" + ChatColor.YELLOW + " " + "To get all the info about the server");
                            p1.sendMessage(ChatColor.GRAY + "/info help" + ChatColor.YELLOW + " " + "To get help on how to use this command");
                            p1.sendMessage(ChatColor.GRAY + "/Info Perms" + ChatColor.YELLOW + " " + "To get a list of the permissions for this commands");
                            p1.sendMessage(" ");
                            p1.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
                        }
                    }
                    if (strings[0].equalsIgnoreCase("Perms")) {
                        if (p1.hasPermission("info.admin.perms")) {
                            p1.sendMessage(ChatColor.GRAY + "------------------------" + " " + ChatColor.GOLD + "Perms" + " " + ChatColor.GRAY + "-----------------------");
                            p1.sendMessage(" ");
                            p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7info.admin.help" + " " + "&eGives access to /Info Help"));
                            p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7info.admin.perms" + " " + "&eGives access to /Info Perms"));
                            p1.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
                        }
                        return true;
                    }
                }
            }
        } return false;
    }
}

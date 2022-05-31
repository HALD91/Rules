package rules;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManger implements CommandExecutor {
    Main main = JavaPlugin.getPlugin(Main.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("rules")){
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage( ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix").toString()) + " " + ChatColor.RED + " This command can't be used in the console");
                return true;
            }
            if (sender instanceof Player){
                Player p1 = (Player) sender;
                if (strings.length == 0) {
                    for(String messages : main.getConfig().getStringList("Rules")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
                    }return true;
                }
            if (strings.length == 1) {
                if (p1.hasPermission("rules.admin.reload"))
                    if (strings[0].equalsIgnoreCase("Reload")) {
                        main.reloadConfig();
                        p1.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix").toString() + ChatColor.RED + " " + "Config" + " " + ChatColor.GREEN + "has been reload"));
                    }
                if (strings[0].equalsIgnoreCase("Help")) {
                    if (p1.hasPermission("rules.admin.Help")) {
                        p1.sendMessage(ChatColor.GRAY + "------------------------" + " " + ChatColor.GOLD + "Help" + " " + ChatColor.GRAY + "-----------------------");
                        p1.sendMessage(" ");
                        p1.sendMessage(ChatColor.GRAY + "/Rules" + ChatColor.YELLOW + " " + "To se all Rules");
                        p1.sendMessage(ChatColor.GRAY + "/Rules help" + ChatColor.YELLOW + " " + "To get help on how to use this plugin");
                        p1.sendMessage(ChatColor.GRAY + "/Rules SetPrefix <YourPrefix>" + " " + ChatColor.YELLOW + "To set your own prefix for this plugin");
                        p1.sendMessage(" ");
                        p1.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
                    }
                }
                if (strings[0].equalsIgnoreCase("Perms")) {
                    if (p1.hasPermission("rules.admin.perms")) {
                        p1.sendMessage(ChatColor.GRAY + "------------------------" + " " + ChatColor.GOLD + "Perms" + " " + ChatColor.GRAY + "-----------------------");
                        p1.sendMessage(" ");
                        p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7rules.admin.reload" + " " + "&eGives access to /Rules Reload"));
                        p1.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7rules.admin.Help" + " " + "&eGives access to /Rules Help"));
                        p1.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7rules.admin.perms" + " " + "&eGives access to /Rules Perms"));
                        p1.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7rules.admin.setprefix" + "&eGives access to /Rules SetPrefix <YourPrefix>"));
                        p1.sendMessage(ChatColor.GRAY + "-----------------------------------------------------");
                    }
                    return true;
                }
            }
            if (strings.length == 2){
                if (p1.hasPermission("rules.admin.setprefix"))
                    if (strings[0].equalsIgnoreCase("SetPrefix")){
                        if (!strings[1].isEmpty()){
                            main.getConfig().set("Prefix", strings[1]);
                            main.saveConfig();
                            p1.sendMessage(ChatColor.GREEN + "Your new prefix" + ChatColor.RESET + " " + ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix").toString()));
                        }
                    } return true;
            }
            }
        }return false;
    }
}

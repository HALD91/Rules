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
    String prefix = main.getConfig().getStringList("Prefix").toString();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("rules")){
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage(prefix + ChatColor.RED + "This command can't be used in the console");
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
                    if (strings[0].equalsIgnoreCase("Reload")) {
                        main.reloadConfig();
                        p1.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.GREEN + " Config" + ChatColor.YELLOW + "has been reload"));
                    }return true;
                }
            }
        }return false;
    }
}

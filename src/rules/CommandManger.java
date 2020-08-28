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
    String prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "Rules" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";


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
                    for (byte b = 0; 0 < main.getConfig().getStringList("Rules").size(); b++) {
                        sender.sendMessage(" " + main.getConfig().getStringList("Rules").get(b));
                        return true;
                    }
                }
            }
        }

        return false;


    }
}

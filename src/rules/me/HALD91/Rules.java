package rules.me.HALD91;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import rules.me.HALD91.CommandManager.CommandManger;
import rules.me.HALD91.CommandManager.ServerInfo;

import java.util.List;
import java.util.logging.Logger;

public class Rules extends JavaPlugin implements Listener {
    public FileConfiguration config = getConfig();
    public List<String> rules = config.getStringList("Rules");
    public List<String> ServerInfo = config.getStringList("ServerInfo");
    public List<String> prefix = config.getStringList("Prefix");

    @Override
    public void onEnable(){
        Logger.getLogger("starter");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("rules").setExecutor(new CommandManger());
        getCommand("serverinfo").setExecutor(new ServerInfo());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

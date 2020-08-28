package rules;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {
    public FileConfiguration config = getConfig();
    public List<String> rules = config.getStringList("Rules");

    @Override
    public void onEnable(){
        Logger.getLogger("starter");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("rules").setExecutor(new CommandManger());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

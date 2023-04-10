package hyoukaku.apocrypha;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    // ON ENABLE
    public void onEnable() {

        // Register command executor
        getCommand("initiateterminate-reload").setExecutor(new reload(this));
        // Generate config file if it doesn't exist
        saveDefaultConfig();

        // Plugin startup login
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "InitiateTerminate has been enabled!");

        // Schedule enable command to run once after delay
        int delay = getConfig().getInt("delay");
        String enableCommand = getConfig().getString("start_command");

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), enableCommand);
            }
        }.runTaskLater(this, delay * 20L);

    }
    // ON DISABLE
    public void onDisable() {

        // Read disable command from config and dispatch it
        String disableCommand = getConfig().getString("stop_command");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), disableCommand);

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "InitiateTerminate has been disabled!");
    }

}
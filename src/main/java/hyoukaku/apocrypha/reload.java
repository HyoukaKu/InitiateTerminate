package hyoukaku.apocrypha;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload implements CommandExecutor {

    private final Main plugin;

    public reload (Main plugin) {
        this.plugin = plugin;
    }

    @Override
    // The Commands
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("initiateterminate-reload")) {
            return false;
        }

        // Reload config
        plugin.reloadConfig();

        // Send confirmation message
        sender.sendMessage(ChatColor.GREEN + "InitiateTerminate config reloaded!");
        return true;
    }
}
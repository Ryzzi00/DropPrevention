package org.ryzzi00.dropPrevention;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DropPrevention extends JavaPlugin implements Listener {

    private Logic logic;
    private Lang lang;

    @Override
    public void onEnable() {
        logic = new Logic(getDataFolder());
        lang = new Lang(getDataFolder());

        Bukkit.getPluginManager().registerEvents(this, this);

        this.getCommand("drop").setTabCompleter(new TabCompliter());

        getLogger().info("Plugin enabled!");
        getLogger().info("Powered by SCH Studio");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("drop")) {
            if (args.length == 0) {
                if (logic.isDropEnabled(player.getName())) {
                    logic.setDrop(player.getName(), false);
                    player.sendMessage(lang.get("drop_off"));
                } else {
                    logic.setDrop(player.getName(), true);
                    player.sendMessage(lang.get("drop_on"));
                }
            } else if (args[0].equalsIgnoreCase("on")) {
                logic.setDrop(player.getName(), true);
                player.sendMessage(lang.get("drop_on"));
            } else if (args[0].equalsIgnoreCase("off")) {
                logic.setDrop(player.getName(), false);
                player.sendMessage(lang.get("drop_off"));
            } else if (args[0].equalsIgnoreCase("reloadLanguage")) {
                if (!player.hasPermission("drop.admin")) {
                    player.sendMessage(lang.get("no_permission"));
                    return true;
                }
                lang.reload();
                player.sendMessage("[DropPrevention] §aLanguage reloaded!");
            } else {
                player.sendMessage(lang.get("drop_usage"));
            }
            return true;
        }

        return false;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (!logic.isDropEnabled(player.getName())) {
            if (player.getInventory().firstEmpty() != -1) {
                event.setCancelled(true);
            }
        }
    }
}

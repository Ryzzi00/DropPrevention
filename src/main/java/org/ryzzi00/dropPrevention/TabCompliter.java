package org.ryzzi00.dropPrevention;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabCompliter implements TabCompleter {

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (!(sender instanceof Player)) return null;

        List<String> completions = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("drop")) {
            if (args.length == 1) {
                completions.addAll(Arrays.asList("on", "off"));
                if (sender.hasPermission("drop.admin")) {
                    completions.add("reloadLanguage");
                }
            }
        }

        String currentArg = args[0].toLowerCase();
        completions.removeIf(s -> !s.toLowerCase().startsWith(currentArg));

        return completions;
    }
}

package org.ryzzi00.dropPrevention;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Lang {

    private final File file;
    private FileConfiguration language;

    public Lang(File dataFolder) {
        this.file = new File(dataFolder, "lang.yml");

        if (!file.exists()) {
            try {
                dataFolder.mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        language = YamlConfiguration.loadConfiguration(file);
        saveDefault();
    }

    private void saveDefault() {
        if (!language.contains("drop_on")) language.set("drop_on", "[DropPrevention] §aDrop enabled");
        if (!language.contains("drop_off")) language.set("drop_off", "[DropPrevention] §cDrop disabled");
        if (!language.contains("drop_usage")) language.set("drop_usage", "[DropPrevention] §cUse /drop - to quickly toggle mode, /drop on to enable or /drop off to disable");
        if (!language.contains("no_permission")) language.set("no_permission", "[DropPrevention] §cYou don't have permission for this command");

        try {
            language.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return language.getString(key, key);
    }

    public void reload() {
        language = YamlConfiguration.loadConfiguration(file);
    }
}

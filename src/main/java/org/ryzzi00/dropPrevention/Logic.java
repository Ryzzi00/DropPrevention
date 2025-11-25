package org.ryzzi00.dropPrevention;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Logic {

    private final File file;
    private final Gson gson = new Gson();
    private Map<String, Boolean> storage = new HashMap<>();

    public Logic(File dataFolder) {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        this.file = new File(dataFolder, "storage.json");
        load();
    }

    public void setDrop(String player, boolean enabled) {
        storage.put(player, enabled);
        save();
    }

    public boolean isDropEnabled(String player) {
        return storage.getOrDefault(player, true);
    }

    private void load() {
        if (!file.exists()) return;
        try (FileReader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, Boolean>>() {}.getType();
            storage = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(storage, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

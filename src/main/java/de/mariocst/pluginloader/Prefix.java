package de.mariocst.pluginloader;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Prefix {

    public Prefix() {
        File dir = new File("./plugins/CityCraft");

        File file = new File(dir, "config.yml");

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        String prefix;
        if (config.contains("prefix")) {
            prefix = config.getString("prefix");
        }
        else {
            prefix = "§4§l[§3§lCityCraft§4§l] §r§f";
        }

        PluginLoader.setPrefix(prefix);
    }
}

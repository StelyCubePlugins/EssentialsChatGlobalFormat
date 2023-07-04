package fr.stelycube.ecgf.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class Config {

    private final String DISPLAY_NAME_PLACEHOLDER = "{DISPLAY_NAME}";
    private final String MESSAGE_PLACEHOLDER = "{MESSAGE}";
    private YamlConfiguration configuration;

    public void load(@NotNull ConfigLoader configLoader, @NotNull JavaPlugin javaPlugin, @NotNull String fileName) {
        configuration = configLoader.initFile(javaPlugin.getDataFolder(), Objects.requireNonNull(javaPlugin.getResource(fileName)), fileName);
    }

    @NotNull
    private String replaceByMinecraftFormat(@NotNull String configFormat) {
        return configFormat.replace(DISPLAY_NAME_PLACEHOLDER, "%1$s").replace(MESSAGE_PLACEHOLDER, "%2$s");
    }

    @NotNull
    public String getFallbackFormat(@NotNull Logger logger) {
        String fallbackFormat = configuration.getString("format");
        if (fallbackFormat == null) {
            logger.warning("No fallback format specified: using the minecraft default one");
            fallbackFormat = "<" + DISPLAY_NAME_PLACEHOLDER + "> {" + MESSAGE_PLACEHOLDER + "}";
        }
        return replaceByMinecraftFormat(fallbackFormat);
    }

    @NotNull
    public Map<String, String> getGroupFormats() {
        final Map<String, String> groupFormats = new HashMap<>();
        final ConfigurationSection groupSection = configuration.getConfigurationSection("group");
        if (groupSection == null) {
            return Collections.emptyMap();
        }
        for (String groupName : groupSection.getKeys(false)) {
            final String format = groupSection.getString(groupName);
            if (format == null) {
                continue;
            }
            groupFormats.put(groupName, replaceByMinecraftFormat(format));
        }
        return groupFormats;
    }

}

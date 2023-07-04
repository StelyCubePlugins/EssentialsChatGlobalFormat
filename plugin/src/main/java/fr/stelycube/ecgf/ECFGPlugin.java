package fr.stelycube.ecgf;

import fr.stelycube.ecgf.config.Config;
import fr.stelycube.ecgf.config.ConfigLoader;
import fr.stelycube.ecgf.format.FormatRegistry;
import fr.stelycube.ecgf.listener.ListenerLoader;
import fr.stelycube.ecgf.permission.MainGroupRetriever;
import fr.stelycube.ecgf.permission.MainGroupRetrieverLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ECFGPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final Logger logger = getLogger();
        final File dataFolder = getDataFolder();
        final ConfigLoader configLoader = new ConfigLoader();

        if (!configLoader.checkDataFolder(dataFolder)) {
            logger.log(Level.WARNING, "Can not write in the directory : " + dataFolder.getAbsolutePath());
            logger.log(Level.WARNING, "Disable the plugin");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        final Config config = new Config();
        config.load(configLoader, this, "config.yml");

        final FormatRegistry formatRegistry = new FormatRegistry(config.getFallbackFormat(logger), config.getGroupFormats());

        final MainGroupRetrieverLoader mainGroupRetrieverLoader = new MainGroupRetrieverLoader();
        final MainGroupRetriever mainGroupRetriever = mainGroupRetrieverLoader.load();

        final ListenerLoader listenerLoader = new ListenerLoader();
        listenerLoader.load(this, formatRegistry, mainGroupRetriever);
    }

}

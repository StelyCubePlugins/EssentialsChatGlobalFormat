package fr.stelycube.ecgf;

import fr.stelycube.ecgf.config.ConfigLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
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


    }

}

package fr.stelycube.ecgf.listener;

import fr.stelycube.ecgf.ECFGPlugin;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class ListenerLoader {

    public void load(@NotNull ECFGPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(new GlobalMessageListener(), plugin);
    }

}

package fr.stelycube.ecgf.listener;

import fr.stelycube.ecgf.ECFGPlugin;
import fr.stelycube.ecgf.format.FormatRegistry;
import fr.stelycube.ecgf.permission.MainGroupRetriever;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class ListenerLoader {

    public void load(@NotNull ECFGPlugin plugin, @NotNull FormatRegistry formatRegistry, @NotNull MainGroupRetriever mainGroupRetriever) {
        Bukkit.getPluginManager().registerEvents(new GlobalMessageListener(mainGroupRetriever, formatRegistry), plugin);
    }

}

package fr.stelycube.ecgf.permission.luckperms;

import fr.stelycube.ecgf.permission.MainGroupRetriever;
import fr.stelycube.ecgf.permission.PermissionLoader;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.Nullable;

public class LuckPermsLoader implements PermissionLoader {

    @Override
    public @Nullable MainGroupRetriever load() {
        final Plugin luckPermsPlugin = Bukkit.getPluginManager().getPlugin("LuckPerms");
        if (luckPermsPlugin == null || !luckPermsPlugin.isEnabled()) {
            return null;
        }
        final RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider == null) {
            return null;
        }
        return enable(provider);
    }

    @Nullable
    private MainGroupRetriever enable(RegisteredServiceProvider<LuckPerms> provider) {
        LuckPerms api = provider.getProvider();
        return null;
    }

}

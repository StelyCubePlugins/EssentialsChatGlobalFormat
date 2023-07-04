package fr.stelycube.ecgf.permission;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DummyMainGroupRetriever implements MainGroupRetriever {

    @Override
    public @Nullable String retrieve(@NotNull OfflinePlayer player) {
        return null;
    }

}

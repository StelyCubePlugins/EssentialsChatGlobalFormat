package fr.stelycube.ecgf.permission;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MainGroupRetriever {

    @Nullable
    String retrieve(@NotNull OfflinePlayer player);

}

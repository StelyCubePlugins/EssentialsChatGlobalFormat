package fr.stelycube.ecgf.permission;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MainGroupRetriever {

    @Nullable
    String retrieve(@NotNull Player player);

}

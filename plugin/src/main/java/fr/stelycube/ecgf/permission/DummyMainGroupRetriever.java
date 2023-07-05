package fr.stelycube.ecgf.permission;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DummyMainGroupRetriever implements MainGroupRetriever {

    @Override
    public @Nullable String retrieve(@NotNull Player player) {
        return null;
    }

}

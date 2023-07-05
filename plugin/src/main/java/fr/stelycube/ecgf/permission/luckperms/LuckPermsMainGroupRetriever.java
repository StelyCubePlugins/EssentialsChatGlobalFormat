package fr.stelycube.ecgf.permission.luckperms;

import fr.stelycube.ecgf.permission.MainGroupRetriever;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LuckPermsMainGroupRetriever implements MainGroupRetriever {

    private final LuckPerms luckPerms;

    public LuckPermsMainGroupRetriever(@NotNull LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    @Override
    public @Nullable String retrieve(@NotNull Player player) {
        final User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);
        return user.getPrimaryGroup();
    }

}

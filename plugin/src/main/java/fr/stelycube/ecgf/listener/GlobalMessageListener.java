package fr.stelycube.ecgf.listener;

import fr.stelycube.ecgf.format.FormatRegistry;
import fr.stelycube.ecgf.permission.MainGroupRetriever;
import net.essentialsx.api.v2.events.chat.GlobalChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class GlobalMessageListener implements Listener {

    private final MainGroupRetriever mainGroupRetriever;
    private final FormatRegistry formatRegistry;

    public GlobalMessageListener(@NotNull MainGroupRetriever mainGroupRetriever, @NotNull FormatRegistry formatRegistry) {
        this.mainGroupRetriever = mainGroupRetriever;
        this.formatRegistry = formatRegistry;
    }

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.NORMAL)
    private void onGlobalChat(GlobalChatEvent event) {
        final String mainGroup = mainGroupRetriever.retrieve(event.getPlayer());
        event.setFormat(formatRegistry.getFormat(mainGroup));
    }

}

package com.sizcraft.sizcraftcore.listeners;

import com.sizcraft.sizcraftcore.SizCraftCore;
import com.sizcraft.sizcraftcore.util.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChat implements Listener {

    SizCraftCore plugin;

    public OnChat(SizCraftCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void event(AsyncPlayerChatEvent e) {
        final String message = e.getMessage();
        final Player player = e.getPlayer();

        String format = plugin.getSettings().getString("chat-format")
                .replace("{DISPLAYNAME}", player.getDisplayName())
                .replace("{MESSAGE}", message);

        e.setFormat(ColorUtils.colorize(format));
    }

}

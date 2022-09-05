package com.sizcraft.sizcraftcore.listeners;

import com.sizcraft.sizcraftcore.SizCraftCore;
import com.sizcraft.sizcraftcore.util.ColorUtils;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    SizCraftCore plugin;

    public JoinListener(SizCraftCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void event(PlayerJoinEvent e) {
        e.setJoinMessage(ColorUtils.colorize(plugin.getSettings().getString("custom-join-message")));
    }

}

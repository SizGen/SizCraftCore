package com.sizcraft.sizcraftcore.listeners;

import com.sizcraft.sizcraftcore.SizCraftCore;
import com.sizcraft.sizcraftcore.util.ColorUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    SizCraftCore plugin;

    public QuitListener(SizCraftCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void event(PlayerQuitEvent e) {
        e.setQuitMessage(ColorUtils.colorize(plugin.getSettings().getString("custom-quit-message")));
    }

}

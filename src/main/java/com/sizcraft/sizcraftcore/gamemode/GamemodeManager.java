package com.sizcraft.sizcraftcore.gamemode;

import com.sizcraft.sizcraftcore.SizCraftCore;
import com.sizcraft.sizcraftcore.file.Messages;
import com.sizcraft.sizcraftcore.file.Settings;
import com.sizcraft.sizcraftcore.message.Message;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GamemodeManager {

    private final SizCraftCore plugin;
    private final Settings settings;
    private final Messages messages;

    public GamemodeManager(SizCraftCore plugin) {
        this.plugin = plugin;
        this.messages = plugin.getMessages();
        this.settings = plugin.getSettings();
    }

    public void setGamemode(Player player, String str) {
        switch(str) {
            case "0", "s", "survival" -> {
                player.setGameMode(GameMode.SURVIVAL);
                new Message(
                        settings.getString("prefix"),
                        messages.getStringList("gamemode.player"),
                        player
                ).replace(
                        "{GAMEMODE}",
                        "survival"
                ).replace(
                        "{PLAYER}",
                        player.getDisplayName()
                ).run();
            }
            case "1", "c", "creative" -> {
                player.setGameMode(GameMode.CREATIVE);
                new Message(
                        settings.getString("prefix"),
                        messages.getStringList("gamemode.player"),
                        player
                ).replace(
                        "{GAMEMODE}",
                        "creative"
                ).replace(
                        "{PLAYER}",
                        player.getDisplayName()
                ).run();
            }
            case "2", "a", "adventure" -> {
                player.setGameMode(GameMode.ADVENTURE);
                new Message(
                        settings.getString("prefix"),
                        messages.getStringList("gamemode.player"),
                        player
                ).replace(
                        "{GAMEMODE}",
                        "adventure"
                ).replace(
                        "{PLAYER}",
                        player.getDisplayName()
                ).run();
            }
            case "3", "sp", "spectator" -> {
                player.setGameMode(GameMode.SPECTATOR);
                new Message(
                        settings.getString("prefix"),
                        messages.getStringList("gamemode.player"),
                        player
                ).replace(
                        "{GAMEMODE}",
                        "spectator"
                ).replace(
                        "{PLAYER}",
                        player.getDisplayName()
                ).run();
            }
        }
    }


}

package com.sizcraft.sizcraftcore.command;

import com.sizcraft.sizcraftcore.SizCraftCore;
import com.sizcraft.sizcraftcore.gamemode.GamemodeManager;
import com.sizcraft.sizcraftcore.message.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamemodeCommand extends Command {

    private final SizCraftCore plugin;
    private final GamemodeManager gamemodeManager;

    public GamemodeCommand(SizCraftCore plugin) {
        super(
                "gamemode",
                new String[]{"gm","gmode", "gamem"},
                "Change someones game mode",
                "sizcraft.core.gamemode"
        );

        this.plugin = plugin;
        this.gamemodeManager = plugin.getGamemodeManager();
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player player) {
            String gamemode = args[0].toLowerCase();
            if(args.length == 1) {
                gamemodeManager.setGamemode(player, gamemode);
            } else if(args.length == 2) {
                Player target = plugin.getServer().getPlayer(args[1]);
                gamemodeManager.setGamemode(target, gamemode);
            } else {
                // Send the usage message
                new Message(
                        plugin.getSettings().getString("prefix"),
                        plugin.getMessages().getStringList("gamemode.usage"),
                        sender
                ).run();
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length == 1) {
            list = Arrays.asList("creative", "survival", "adventure", "spectator");
        } else if (args.length == 2) {
            List<Player> playerList = new ArrayList<>(plugin.getServer().getOnlinePlayers());
            for(Player player : playerList) {
                list.add(player.getDisplayName());
            }
        }
        return list;
    }
}

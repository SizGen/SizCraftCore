package com.sizcraft.sizcraftcore.message;

import com.sizcraft.sizcraftcore.util.ColorUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private final String prefix;
    private List<String> message;
    private final CommandSender sender;

    public Message(String prefix, List<String> message, CommandSender sender) {
        this.prefix = prefix;
        this.message = message;
        this.sender = sender;
    }

    public Message replace(String toReplace, String toReplaceWith) {
        List<String> newMessage = new ArrayList<>();
        for (String str : message) {
            str.replace(toReplace, toReplaceWith);
            newMessage.add(str);
        }
        message = newMessage;
        return this;
    }

    public Message run(){
        if(sender instanceof ConsoleCommandSender consoleCommandSender) {
            for (String str : message) {
                consoleCommandSender.sendMessage(ColorUtils.colorize(prefix + str));
            }
        } else if (sender instanceof Player player) {
            for (String str : message) {
                player.sendMessage(ColorUtils.colorize(prefix + str));
            }
        }
        return this;
    }

}

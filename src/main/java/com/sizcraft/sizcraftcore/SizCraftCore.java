package com.sizcraft.sizcraftcore;

import com.sizcraft.sizcraftcore.command.GamemodeCommand;
import com.sizcraft.sizcraftcore.file.CustomItems;
import com.sizcraft.sizcraftcore.file.Messages;
import com.sizcraft.sizcraftcore.file.Settings;
import com.sizcraft.sizcraftcore.gamemode.GamemodeManager;
import com.sizcraft.sizcraftcore.listeners.JoinListener;
import com.sizcraft.sizcraftcore.listeners.OnChat;
import com.sizcraft.sizcraftcore.listeners.QuitListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SizCraftCore extends JavaPlugin {

    // Files
    private Settings settings;
    private Messages messages;
    private CustomItems customItems;

    // Managers
    private GamemodeManager gamemodeManager;

    @Override
    public void onEnable() {

        initializeHandlers();
        loadFiles();

        registerManagers();

        registerCommands();
        registerListeners();

    }

    private void initializeHandlers() {
        settings = new Settings(this);
        messages = new Messages(this);
        customItems = new CustomItems(this);
    }

    private void loadFiles() {
        settings.load();
        messages.load();
        customItems.load();
    }

    private void registerCommands() {
        new GamemodeCommand(this);
    }

    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new JoinListener(this), this);
        pm.registerEvents(new QuitListener(this), this);
        pm.registerEvents(new OnChat(this), this);
    }

    private void registerManagers() {
        gamemodeManager = new GamemodeManager(this);
    }

    public Settings getSettings() { return settings; }
    public Messages getMessages() { return messages; }
    public CustomItems getCustomItems() { return customItems; }

    public GamemodeManager getGamemodeManager() { return gamemodeManager; }

}
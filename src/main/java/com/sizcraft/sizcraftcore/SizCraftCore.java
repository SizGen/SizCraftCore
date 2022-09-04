package com.sizcraft.sizcraftcore;

import com.sizcraft.sizcraftcore.command.TestCommand;
import com.sizcraft.sizcraftcore.file.Settings;
import com.sizcraft.sizcraftcore.item.CustomItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class SizCraftCore extends JavaPlugin {

    private Settings settings;

    @Override
    public void onEnable() {

        initializeHandlers();

        settings.load();

        new TestCommand();

        new CustomItem(this).get(settings.getConfigurationSection(""));
    }

    private void initializeHandlers() {
        settings = new Settings(this);

    }
}
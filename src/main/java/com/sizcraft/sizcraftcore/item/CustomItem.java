package com.sizcraft.sizcraftcore.item;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class CustomItem {

    private final Plugin plugin;

    public CustomItem(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack get(ConfigurationSection configurationSection) {
        return new ItemStack(Material.AIR);
    }

}

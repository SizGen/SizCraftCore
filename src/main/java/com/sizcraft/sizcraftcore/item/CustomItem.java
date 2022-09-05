package com.sizcraft.sizcraftcore.item;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CustomItem {

    private final Plugin plugin;

    public CustomItem(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack get(ConfigurationSection configurationSection) {
        ItemStack item;
        try {
            item = new ItemStack(Material.valueOf(
                    configurationSection.getString("material")),
                    configurationSection.getInt("amount"));
        } catch (Exception e) {
            return new ItemStack(Material.AIR);
        }

        ItemMeta itemMeta = item.getItemMeta();

        try {
            itemMeta.setDisplayName(configurationSection.getString("name"));
        } catch(Exception e) {

        }

        try {
            itemMeta.setLore(configurationSection.getStringList("lore"));
        } catch(Exception e) {

        }
        return item;
    }

}

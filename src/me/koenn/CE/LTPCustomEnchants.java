package me.koenn.CE;

import me.koenn.CE.commands.CommandHandler;
import me.koenn.CE.listeners.eventlisteners.DamageListener;
import me.koenn.CE.listeners.eventlisteners.DragAndDropListener;
import me.koenn.CE.listeners.eventlisteners.EnchantListener;
import me.koenn.CE.listeners.eventlisteners.EquipListener;
import me.koenn.CE.logger.Logger;
import me.koenn.CE.registry.EnchantmentRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * LostTimePark custom enchantments plugin version 2.0.
 */
public class LTPCustomEnchants extends JavaPlugin {

    public static Plugin instance;
    private static boolean debugMode;
    private static EnchantmentRegistry registry;

    /**
     * Get the enchantment registry
     *
     * @return EnchantmentRegistry instance
     */
    public static EnchantmentRegistry getEnchantmentRegistry() {
        return registry;
    }

    /**
     * See if the plugin is in debug mode
     *
     * @return boolean debugMode
     */
    public static boolean isInDebugMode() {
        return debugMode;
    }

    /**
     * Gets called when the plugin enables.
     * Handles all registering of most things, and initializes all objects.
     */
    @Override
    public void onEnable() {
        //Setup static variables.
        instance = this;
        debugMode = true;

        //Print startup messages.
        Logger.info("All credits for this plugin go to Koenn");
        if (debugMode) {
            Logger.debug("Loading plugin in debug mode!");
        }

        //Setup enchantment registry and register all enchantments.
        registry = new EnchantmentRegistry();
        EnchantmentRegistry.registerEnchantments(registry);

        //Register all listeners.
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new EnchantListener(), this);
        Bukkit.getPluginManager().registerEvents(new DragAndDropListener(), this);
        EquipListener.startEquipListener();

        //Setup commandHandler and load all commands.
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.setup();
    }

    /**
     * Gets called when the plugin disables.
     * Handles finishing things up.
     */
    @Override
    public void onDisable() {
        Logger.info("All credits for this plugin go to Koenn");
    }
}
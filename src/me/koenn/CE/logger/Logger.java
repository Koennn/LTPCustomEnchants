package me.koenn.CE.logger;

import me.koenn.CE.LTPCustomEnchants;
import org.bukkit.Bukkit;

public class Logger {

    public static void info(String message) {
        Bukkit.getLogger().info(String.format("[%s] %s", LTPCustomEnchants.instance.getName(), message));
    }

    public static void debug(String message) {
        if (LTPCustomEnchants.isInDebugMode()) {
            Bukkit.getLogger().info(String.format("[%s] [DEBUG] %s", LTPCustomEnchants.instance.getName(), message));
        }
    }
}

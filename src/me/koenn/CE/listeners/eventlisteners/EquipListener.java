package me.koenn.CE.listeners.eventlisteners;

import me.koenn.CE.LTPCustomEnchants;
import me.koenn.CE.listeners.EventManager;
import org.bukkit.Bukkit;

public class EquipListener {

    public static void startEquipListener() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(LTPCustomEnchants.instance, () -> Bukkit.getOnlinePlayers().forEach(EventManager::callArmorEquipped), 0, 2);
    }
}

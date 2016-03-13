package me.koenn.CE.listeners.damagelisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public interface DeathListener extends EnchantListener {

    void onDeath(EntityDeathEvent event, Player killer, Player victim, int level);
}

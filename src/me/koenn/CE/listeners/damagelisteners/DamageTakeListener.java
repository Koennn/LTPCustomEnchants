package me.koenn.CE.listeners.damagelisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface DamageTakeListener extends EnchantListener {

    void onDamageTake(EntityDamageByEntityEvent event, Player damager, Player victim, int level);
}

package me.koenn.CE.listeners.damagelisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface DamageDealListener extends EnchantListener {

    void onDamageDeal(EntityDamageByEntityEvent event, Player damager, Player victim, int level);
}

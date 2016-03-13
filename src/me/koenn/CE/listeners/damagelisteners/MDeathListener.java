package me.koenn.CE.listeners.damagelisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

public interface MDeathListener extends EnchantListener {

    void onDeath(EntityDeathEvent event, Player killer, LivingEntity victim, int level);
}

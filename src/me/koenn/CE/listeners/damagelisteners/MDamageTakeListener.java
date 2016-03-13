package me.koenn.CE.listeners.damagelisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface MDamageTakeListener extends EnchantListener {

    void onMDamageTake(EntityDamageByEntityEvent event, LivingEntity damager, Player victim, int level);
}

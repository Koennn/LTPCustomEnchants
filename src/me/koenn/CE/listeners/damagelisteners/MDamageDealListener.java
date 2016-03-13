package me.koenn.CE.listeners.damagelisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface MDamageDealListener extends EnchantListener {

    void onMDamageDeal(EntityDamageByEntityEvent event, Player damager, LivingEntity victim, int level);
}

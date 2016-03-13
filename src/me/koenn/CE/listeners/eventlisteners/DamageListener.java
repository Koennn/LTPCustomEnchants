package me.koenn.CE.listeners.eventlisteners;

import me.koenn.CE.listeners.EventManager;
import me.koenn.CE.logger.Logger;
import org.bukkit.GameMode;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Listener for all different damage events.
 * Calls all damage listeners for the enchantments using the EventManager
 *
 * @see EventManager
 */
public class DamageListener implements Listener {

    /**
     * Base listener for all EntityDamageByEntityEvent events.
     *
     * @param event EntityDamageByEntityEvent instance
     */
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = false)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof LivingEntity)) {
            return;
        }
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (event.isCancelled()) {
            return;
        }
        Logger.debug("Damage {");
        LivingEntity damager = (LivingEntity) event.getDamager();
        LivingEntity victim = (LivingEntity) event.getEntity();
        if (damager instanceof Player) {
            if (victim instanceof Player) {
                if (((Player) victim).getGameMode().equals(GameMode.CREATIVE)) {
                    return;
                }
                Logger.debug("  PvP;");
                EventManager.callPlayerDamageDeal((Player) damager, (Player) victim, event);
                EventManager.callPlayerMDamageDeal((Player) damager, victim, event);
                EventManager.callPlayerDamageTake((Player) damager, (Player) victim, event);
            } else {
                Logger.debug("  PvE;");
                EventManager.callPlayerMDamageDeal((Player) damager, victim, event);
            }
        } else {
            if (victim instanceof Player) {
                if (((Player) victim).getGameMode().equals(GameMode.CREATIVE)) {
                    return;
                }
                Logger.debug("  EvP;");
                EventManager.callPlayerMDamageTake(damager, (Player) victim, event);
            }
        }
        Logger.debug("}");
    }

    /**
     * Base listener for all EntityDeathEvent events.
     *
     * @param event EntityDeathEvent instance
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Logger.debug("Death {");
        Player damager = event.getEntity().getKiller();
        LivingEntity victim = event.getEntity();
        if (victim instanceof Player) {
            if (((Player) victim).getGameMode().equals(GameMode.CREATIVE)) {
                return;
            }
            Logger.debug("  PvP;");
            EventManager.callPlayerDeath(damager, (Player) victim, event);
            EventManager.callPlayerMDeath(damager, victim, event);
        } else {
            Logger.debug("  PvE;");
            EventManager.callPlayerMDeath(damager, victim, event);
        }
        Logger.debug("}");
    }
}
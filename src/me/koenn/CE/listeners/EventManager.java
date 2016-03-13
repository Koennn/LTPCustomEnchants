package me.koenn.CE.listeners;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.armorlisteners.ArmorEquippedListener;
import me.koenn.CE.listeners.damagelisteners.*;
import me.koenn.CE.logger.Logger;
import me.koenn.CE.util.EnchantUtil;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Manages all events, and calls the right EnchantListeners
 *
 * @see EnchantListener
 */
public class EventManager {

    /**
     * Event caller for OnArmorEquipped
     *
     * @param player Player
     */
    public static void callArmorEquipped(Player player) {
        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (item == null || item.getType().equals(Material.AIR) || !item.getItemMeta().hasLore()) {
                continue;
            }
            item.getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof ArmorEquippedListener).forEach(listener -> ((ArmorEquippedListener) listener).onArmorEquipped(player, level));
            });
        }
    }

    /**
     * Event caller for PlayerDeathEvent take PvE.
     *
     * @param killer LivingEntity
     * @param victim Player
     * @param event  EntityDamageByEntityEvent
     */
    public static void callPlayerMDeath(Player killer, LivingEntity victim, EntityDeathEvent event) {
        if (killer.getInventory().getItemInMainHand() != null && killer.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
            killer.getInventory().getItemInMainHand().getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof MDeathListener).forEach(listener -> ((MDeathListener) listener).onDeath(event, killer, victim, level));
            });
        }
    }

    /**
     * Event caller for PlayerDeathEvent take PvP.
     *
     * @param killer LivingEntity
     * @param victim Player
     * @param event  EntityDamageByEntityEvent
     */
    public static void callPlayerDeath(Player killer, Player victim, EntityDeathEvent event) {
        for (ItemStack item : victim.getInventory().getArmorContents()) {
            if (item == null || item.getType().equals(Material.AIR) || !item.getItemMeta().hasLore()) {
                continue;
            }
            item.getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof DeathListener).forEach(listener -> ((DeathListener) listener).onDeath(event, killer, victim, level));
            });
        }
    }

    /**
     * Event caller for EntityDamageByEntityEvent take EvP.
     *
     * @param damager LivingEntity
     * @param victim  Player
     * @param event   EntityDamageByEntityEvent
     */
    public static void callPlayerMDamageTake(LivingEntity damager, Player victim, EntityDamageByEntityEvent event) {
        for (ItemStack item : victim.getInventory().getArmorContents()) {
            if (item == null || item.getType().equals(Material.AIR) || !item.getItemMeta().hasLore()) {
                continue;
            }
            item.getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof MDamageTakeListener).forEach(listener -> ((MDamageTakeListener) listener).onMDamageTake(event, damager, victim, level));
            });
        }
    }

    /**
     * Event caller for EntityDamageByEntityEvent take PvP.
     *
     * @param damager Player
     * @param victim  Player
     * @param event   EntityDamageByEntityEvent
     */
    public static void callPlayerDamageTake(Player damager, Player victim, EntityDamageByEntityEvent event) {
        for (ItemStack item : victim.getInventory().getArmorContents()) {
            if (item == null || item.getType().equals(Material.AIR) || !item.getItemMeta().hasLore()) {
                continue;
            }
            item.getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof DamageTakeListener).forEach(listener -> ((DamageTakeListener) listener).onDamageTake(event, damager, victim, level));
            });
        }
    }

    /**
     * Event caller for EntityDamageByEntityEvent deal PvP.
     *
     * @param damager Player
     * @param victim  Player
     * @param event   EntityDamageByEntityEvent
     */
    public static void callPlayerDamageDeal(Player damager, Player victim, EntityDamageByEntityEvent event) {
        if (damager.getInventory().getItemInMainHand() != null && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
            damager.getInventory().getItemInMainHand().getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof DamageDealListener).forEach(listener -> ((DamageDealListener) listener).onDamageDeal(event, damager, victim, level));
            });
        }
    }

    /**
     * Event caller for EntityDamageByEntityEvent deal PvE.
     *
     * @param damager Player
     * @param victim  LivingEntity
     * @param event   EntityDamageByEntityEvent
     */
    public static void callPlayerMDamageDeal(Player damager, LivingEntity victim, EntityDamageByEntityEvent event) {
        Logger.debug("  Call PvE {");
        if (damager.getInventory().getItemInMainHand() != null && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
            Logger.debug("      Pt 1 works;");
            damager.getInventory().getItemInMainHand().getItemMeta().getLore().stream().filter(EnchantUtil::isCustomEnchant).forEach(enchantment -> {
                Logger.debug("      Enchantment: " + EnchantUtil.getName(enchantment) + ";");
                int level = EnchantUtil.getLevel(enchantment);
                CustomEnchantment customEnchantment = EnchantUtil.getEnchantmentByName(EnchantUtil.getName(enchantment));
                if (customEnchantment == null) {
                    return;
                }
                customEnchantment.getListeners().stream().filter(listener -> listener instanceof MDamageDealListener).forEach(listener -> ((MDamageDealListener) listener).onMDamageDeal(event, damager, victim, level));
                Logger.debug("      Handled!;");
            });
        }
        Logger.debug("  }");
    }
}

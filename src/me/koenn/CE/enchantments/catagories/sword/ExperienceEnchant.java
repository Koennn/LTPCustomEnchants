package me.koenn.CE.enchantments.catagories.sword;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.damagelisteners.MDeathListener;
import me.koenn.CE.logger.Logger;
import me.koenn.CE.references.Enchantments;
import org.bukkit.Sound;

/**
 * Poison enchantment
 *
 * @see Enchantments.Poison
 */
public class ExperienceEnchant extends CustomEnchantment {

    public ExperienceEnchant() {
        super(Enchantments.Experience.NAME, Enchantments.Experience.MAX_LEVEL, Enchantments.Experience.DESC, Enchantments.Experience.TOOL, Enchantments.Experience.TYPE);
        this.getListeners().add((MDeathListener) (event, damager, victim, level) -> {
            event.setDroppedExp(Math.round((event.getDroppedExp() / 2) * (level + 2)) + 2);
            Sound sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
            damager.playSound(damager.getLocation(), sound, 1F, 1.8F);
            Logger.debug(String.format("      Experience %s applied", level));
        });
    }
}

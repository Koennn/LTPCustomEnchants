package me.koenn.CE.enchantments.catagories.sword;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.damagelisteners.MDamageDealListener;
import me.koenn.CE.logger.Logger;
import me.koenn.CE.references.Enchantments;
import me.koenn.CE.util.Chance;
import me.koenn.CE.util.Util;
import org.bukkit.Sound;

/**
 * LightningEnchant enchantment
 *
 * @see Enchantments.Lightning
 */
public class LightningEnchant extends CustomEnchantment {

    public LightningEnchant() {
        super(Enchantments.Lightning.NAME, Enchantments.Lightning.MAX_LEVEL, Enchantments.Lightning.DESC, Enchantments.Lightning.TOOL, Enchantments.Lightning.TYPE);
        this.getListeners().add((MDamageDealListener) (event, damager, victim, level) -> {
            if (Chance.chanceOf((level * 5) + 10)) {
                Util.strikeLightning(victim, level);
                Sound sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                damager.playSound(damager.getLocation(), sound, 1F, 1.8F);
                Logger.debug("      Lightning applied");
            }
        });
    }
}

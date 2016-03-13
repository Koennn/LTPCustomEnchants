package me.koenn.CE.enchantments.catagories.sword;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.damagelisteners.MDamageDealListener;
import me.koenn.CE.logger.Logger;
import me.koenn.CE.references.Enchantments;
import me.koenn.CE.util.Chance;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Poison enchantment
 *
 * @see Enchantments.Poison
 */
public class PoisonEnchant extends CustomEnchantment {

    public PoisonEnchant() {
        super(Enchantments.Poison.NAME, Enchantments.Poison.MAX_LEVEL, Enchantments.Poison.DESC, Enchantments.Poison.TOOL, Enchantments.Poison.TYPE);
        this.getListeners().add((MDamageDealListener) (event, damager, victim, level) -> {
            if (Chance.chanceOf((level * 2) + 10)) {
                victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, (level + 1) * 50, 1));
                Sound sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                damager.playSound(damager.getLocation(), sound, 1F, 1.8F);
                Logger.debug(String.format("      Poison %s applied", level));
            }
        });
    }
}
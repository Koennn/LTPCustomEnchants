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
 * Wither enchantment
 *
 * @see Enchantments.Wither
 */
public class WitherEnchant extends CustomEnchantment {

    public WitherEnchant() {
        super(Enchantments.Wither.NAME, Enchantments.Wither.MAX_LEVEL, Enchantments.Wither.DESC, Enchantments.Wither.TOOL, Enchantments.Wither.TYPE);
        this.getListeners().add((MDamageDealListener) (event, damager, victim, level) -> {
            if (Chance.chanceOf((level * 5) + 10)) {
                victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, level * 40, 1, false));
                Sound sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                damager.playSound(damager.getLocation(), sound, 1F, 1.8F);
                Logger.debug("      Wither applied");
            }
        });
    }
}

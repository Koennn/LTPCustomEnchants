package me.koenn.CE.enchantments.catagories.sword;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.damagelisteners.MDamageDealListener;
import me.koenn.CE.references.Enchantments;
import me.koenn.CE.util.Chance;

/**
 * Vampirism enchantment
 *
 * @see Enchantments.Vampirism
 */
public class VampirismEnchant extends CustomEnchantment {

    public VampirismEnchant() {
        super(Enchantments.Vampirism.NAME, Enchantments.Vampirism.MAX_LEVEL, Enchantments.Vampirism.DESC, Enchantments.Vampirism.TOOL, Enchantments.Vampirism.TYPE);
        this.getListeners().add((MDamageDealListener) (event, damager, victim, level) -> {
            if (Chance.chanceOf((level * 4) + 10)) {
                if (damager.getHealth() + level > 20) {
                    damager.setHealth(20);
                } else {
                    damager.setHealth(damager.getHealth() + (level - 0.5));
                }
            }
        });
    }
}

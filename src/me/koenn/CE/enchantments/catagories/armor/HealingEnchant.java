package me.koenn.CE.enchantments.catagories.armor;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.armorlisteners.ArmorEquippedListener;
import me.koenn.CE.references.Enchantments;
import me.koenn.CE.util.Chance;

public class HealingEnchant extends CustomEnchantment {

    public HealingEnchant() {
        super(Enchantments.Healing.NAME, Enchantments.Healing.MAX_LEVEL, Enchantments.Healing.DESC, Enchantments.Healing.TOOL, Enchantments.Healing.TYPE);
        this.getListeners().add((ArmorEquippedListener) (player, level) -> {
            if (Chance.chanceOf(10)) {
                player.setHealth(player.getHealth() + (level / 2));
            }
        });
    }
}

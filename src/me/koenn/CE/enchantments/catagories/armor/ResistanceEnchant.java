package me.koenn.CE.enchantments.catagories.armor;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.armorlisteners.ArmorEquippedListener;
import me.koenn.CE.references.Enchantments;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ResistanceEnchant extends CustomEnchantment {

    public ResistanceEnchant() {
        super(Enchantments.Resistance.NAME, Enchantments.Resistance.MAX_LEVEL, Enchantments.Resistance.DESC, Enchantments.Resistance.TOOL, Enchantments.Resistance.TYPE);
        this.getListeners().add((ArmorEquippedListener) (player, level) -> player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, level - 1, true, false)));
    }
}

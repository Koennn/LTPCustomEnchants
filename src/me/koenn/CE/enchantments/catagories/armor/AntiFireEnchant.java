package me.koenn.CE.enchantments.catagories.armor;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.armorlisteners.ArmorEquippedListener;
import me.koenn.CE.references.Enchantments;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AntiFireEnchant extends CustomEnchantment {

    public AntiFireEnchant() {
        super(Enchantments.AntiFire.NAME, Enchantments.AntiFire.MAX_LEVEL, Enchantments.AntiFire.DESC, Enchantments.AntiFire.TOOL, Enchantments.AntiFire.TYPE);
        this.getListeners().add((ArmorEquippedListener) (player, level) -> player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0, true, false)));
    }
}

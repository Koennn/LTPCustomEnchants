package me.koenn.CE.enchantments.catagories.armor;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.armorlisteners.ArmorEquippedListener;
import me.koenn.CE.references.Enchantments;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GlowingEnchant extends CustomEnchantment {

    public GlowingEnchant() {
        super(Enchantments.Glowing.NAME, Enchantments.Glowing.MAX_LEVEL, Enchantments.Glowing.DESC, Enchantments.Glowing.TOOL, Enchantments.Glowing.TYPE);
        this.getListeners().add((ArmorEquippedListener) (player, level) -> player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 0, true, false)));
    }
}

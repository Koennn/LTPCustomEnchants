package me.koenn.CE.enchantments.catagories.armor;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.armorlisteners.ArmorEquippedListener;
import me.koenn.CE.references.Enchantments;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedEnchant extends CustomEnchantment {

    public SpeedEnchant() {
        super(Enchantments.Speed.NAME, Enchantments.Speed.MAX_LEVEL, Enchantments.Speed.DESC, Enchantments.Speed.TOOL, Enchantments.Speed.TYPE);
        this.getListeners().add((ArmorEquippedListener) (player, level) -> player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, level - 1, true, false)));
    }
}

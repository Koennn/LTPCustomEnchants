package me.koenn.CE.enchantments.catagories.axe;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.damagelisteners.MDamageDealListener;
import me.koenn.CE.logger.Logger;
import me.koenn.CE.references.Enchantments;
import me.koenn.CE.util.Chance;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IceAspectEnchant extends CustomEnchantment {

    public IceAspectEnchant() {
        super(Enchantments.IceAspect.NAME, Enchantments.IceAspect.MAX_LEVEL, Enchantments.IceAspect.DESC, Enchantments.IceAspect.TOOL, Enchantments.IceAspect.TYPE);
        this.getListeners().add((MDamageDealListener) (event, damager, victim, level) -> {
            if (Chance.chanceOf((level * 3) + 5)) {
                victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (level + 1) * 20, level - 1, false));
                Sound sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                damager.playSound(damager.getLocation(), sound, 1F, 1.8F);
                Logger.debug(String.format("      IceAspect %s applied", level));
            }
        });
    }
}

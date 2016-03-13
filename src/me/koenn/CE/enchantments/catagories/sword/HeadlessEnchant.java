package me.koenn.CE.enchantments.catagories.sword;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.listeners.damagelisteners.MDeathListener;
import me.koenn.CE.references.Enchantments;
import me.koenn.CE.util.Util;
import org.bukkit.entity.Player;

/**
 * Headless enchantment
 *
 * @see Enchantments.Headless
 */
public class HeadlessEnchant extends CustomEnchantment {

    public HeadlessEnchant() {
        super(Enchantments.Headless.NAME, Enchantments.Headless.MAX_LEVEL, Enchantments.Headless.DESC, Enchantments.Headless.TOOL, Enchantments.Headless.TYPE);
        this.getListeners().add((MDeathListener) (event, damager, victim, level) -> {
            if (!(victim instanceof Player)) {
                return;
            }
            Util.getSkull((Player) victim);
        });
    }
}

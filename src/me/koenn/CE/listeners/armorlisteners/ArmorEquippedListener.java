package me.koenn.CE.listeners.armorlisteners;

import me.koenn.CE.listeners.EnchantListener;
import org.bukkit.entity.Player;

public interface ArmorEquippedListener extends EnchantListener {

    void onArmorEquipped(Player player, int level);
}

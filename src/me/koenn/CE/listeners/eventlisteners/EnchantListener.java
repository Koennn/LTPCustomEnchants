package me.koenn.CE.listeners.eventlisteners;

import me.koenn.CE.LTPCustomEnchants;
import me.koenn.CE.effects.EnchantEffect;
import me.koenn.CE.util.BookUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Listener for enchantment event.
 */
public class EnchantListener implements Listener {

    /**
     * Listens for a player enchanting an item in the enchantment table.
     *
     * @param event EnchantItemEvent
     */
    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        ItemStack item = event.getItem();
        if (!item.getType().equals(Material.BOOK)) {
            return;
        }
        ItemStack enchantedBook = BookUtil.getBook();
        ItemMeta meta = enchantedBook.getItemMeta();
        Bukkit.getScheduler().scheduleSyncDelayedTask(LTPCustomEnchants.instance, () -> {
            item.setItemMeta(meta);
            item.setType(Material.BOOK);
        }, 1);

        EnchantEffect enchantEffect = new EnchantEffect(event.getEnchantBlock());
        enchantEffect.play();

        Sound enchantSound = Sound.ENTITY_PLAYER_LEVELUP;
        Player player = event.getEnchanter();
        player.playSound(player.getLocation(), enchantSound, 1.0F, 0.2F);
    }
}

package me.koenn.CE.listeners.eventlisteners;

import me.koenn.CE.effects.ApplyEffect;
import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.util.BookUtil;
import me.koenn.CE.util.EnchantUtil;
import me.koenn.CE.util.RomanNumeral;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Listener for DragAndDrop with books.
 */
public class DragAndDropListener implements Listener {

    /**
     * Listens for a player clicking an item on another item and enchants the item.
     *
     * @param event InventoryClickEvent
     */
    @EventHandler
    @SuppressWarnings("deprecation")
    public void onInventoryClick(InventoryClickEvent event) {
        //Check if the item is an enchantedBook.
        if ((event.getCursor() == null) || (event.getCurrentItem() == null) || (event.getCurrentItem().getType() == Material.AIR)) {
            return;
        }
        if (event.getCursor().getType() != Material.BOOK) {
            return;
        }
        if (!event.getCursor().hasItemMeta()) {
            return;
        }
        if (!event.getCursor().getItemMeta().hasLore() || !event.getCursor().getItemMeta().hasDisplayName()) {
            return;
        }

        //Get the CustomEnchantment instance.
        String enchName = BookUtil.getNameFromBook(event.getCursor().getItemMeta().getDisplayName());
        CustomEnchantment enchantment = EnchantUtil.getEnchantmentByName(enchName);
        if (enchantment == null) {
            return;
        }

        //Check if the tool already has the enchantment and if it already has the enchantment.
        if (EnchantUtil.hasEnchantment(event.getCurrentItem(), enchantment)) {
            return;
        }
        if (!BookUtil.checkTool(enchantment, event.getCurrentItem().getType())) {
            return;
        }

        //Cancel the event and initialize some variables.
        event.setCancelled(true);
        ItemStack book = event.getCursor();
        Player player = (Player) event.getWhoClicked();

        //Apply the succes and destroy rates.
        if (!EnchantUtil.applySucces(book)) {
            if (EnchantUtil.applyDestroy(book)) {
                //Remove the book from cursor, remove the tool and play the particle effect.
                event.setCurrentItem(new ItemStack(Material.AIR));
                event.setCursor(new ItemStack(Material.AIR));
                ApplyEffect effect = new ApplyEffect(player, ApplyEffect.Type.DESTROYED);
                effect.start();

                //Play the failed sound.
                Sound sound = Sound.ENTITY_GENERIC_EXPLODE;
                player.playSound(player.getLocation(), sound, 0.5F, 0.1F);
                return;
            }
            //Remove the book from cursor and play the particle effect.
            event.setCursor(new ItemStack(Material.AIR));
            ApplyEffect effect = new ApplyEffect(player, ApplyEffect.Type.FAILED);
            effect.start();

            //Play the failed sound.
            Sound sound = Sound.BLOCK_LAVA_EXTINGUISH;
            player.playSound(player.getLocation(), sound, 1F, 1.5F);
            return;
        }

        //Enchant the item.
        event.setCursor(new ItemStack(Material.AIR));
        String[] rawEnch = ChatColor.stripColor(book.getItemMeta().getDisplayName()).split(" ");
        int level = new RomanNumeral(rawEnch[(rawEnch.length - 1)]).toInt();
        event.setCurrentItem(EnchantUtil.enchantItem(enchantment, level, event.getCurrentItem()));
        ApplyEffect effect = new ApplyEffect(player, ApplyEffect.Type.SUCCEED);
        effect.start();

        //Play the succeed sound.
        Sound sound = Sound.ENTITY_PLAYER_LEVELUP;
        player.playSound(player.getLocation(), sound, 1F, 1.8F);
    }
}

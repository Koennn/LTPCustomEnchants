package me.koenn.CE.util;

import me.koenn.CE.LTPCustomEnchants;
import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.logger.Logger;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utility methods for enchantments.
 */
public class EnchantUtil {

    /**
     * Check whether a tool already has a certain enchantment.
     *
     * @param tool        Tool to check
     * @param enchantment CustomEnchantment instance
     * @return boolean hasEnchantment
     */
    public static boolean hasEnchantment(ItemStack tool, CustomEnchantment enchantment) {
        if (!tool.getItemMeta().hasLore()) {
            return false;
        }
        for (String enchant : tool.getItemMeta().getLore()) {
            String name = BookUtil.getNameFromBook(enchant);
            Logger.info("ToolEnchant: " + name);
            Logger.info("CustomEnchant: " + enchantment.getName());
            if (name.trim().equalsIgnoreCase(enchantment.getName().trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Apply the succes rate of a enchanted book.
     *
     * @param enchantedBook Enchanted book ItemStack
     * @return boolean succeed
     */
    public static boolean applySucces(ItemStack enchantedBook) {
        String rawSuccess = ChatColor.stripColor(enchantedBook.getItemMeta().getLore().get(0));
        String[] splitSuccess = rawSuccess.split(" ");
        rawSuccess = splitSuccess[0].replace("%", "");
        int success = Integer.parseInt(rawSuccess);
        return Chance.chanceOf(success);
    }

    /**
     * Apply the destroy rate of a enchanted book.
     *
     * @param enchantedBook Enchanted book ItemStack
     * @return boolean destroyed
     */
    public static boolean applyDestroy(ItemStack enchantedBook) {
        String rawDestroy = ChatColor.stripColor(enchantedBook.getItemMeta().getLore().get(0));
        String[] splitDestroy = rawDestroy.split(" ");
        rawDestroy = splitDestroy[0].replace("%", "");
        int destroy = Integer.parseInt(rawDestroy);
        return Chance.chanceOf(destroy);
    }

    /**
     * Get an enchantment from the registry using the name.
     *
     * @param name Enchantment name
     * @return CustomEnchantment instance
     */
    public static CustomEnchantment getEnchantmentByName(String name) {
        for (CustomEnchantment enchantment : LTPCustomEnchants.getEnchantmentRegistry().getRegisteredEnchantments()) {
            if (enchantment.getName().equalsIgnoreCase(name)) {
                return enchantment;
            }
        }
        return null;
    }

    /**
     * Gets the enchantment level from a loreString.
     *
     * @param loreLine One line from lore
     * @return Enchantment name
     * @throws IllegalArgumentException
     */
    public static String getName(String loreLine) throws IllegalArgumentException {
        loreLine = ChatColor.stripColor(loreLine);
        if (!loreLine.contains(" ")) {
            throw new IllegalArgumentException("String does not contain a name");
        }
        String[] split = loreLine.split(" ");
        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            nameBuilder.append(split[i]).append(" ");
        }
        return nameBuilder.toString().trim();
    }

    /**
     * Gets the enchantment level from a loreString.
     *
     * @param loreLine One line from lore
     * @return Enchantment level
     * @throws IllegalArgumentException
     */
    public static int getLevel(String loreLine) throws IllegalArgumentException {
        loreLine = ChatColor.stripColor(loreLine);
        if (!loreLine.contains(" ")) {
            throw new IllegalArgumentException("String does not contain a level");
        }
        String[] split = loreLine.split(" ");
        int level;
        try {
            level = new RomanNumeral(split[split.length - 1]).toInt();
        } catch (Exception ex) {
            throw new IllegalArgumentException("String does not contain a level");
        }
        return level;
    }

    /**
     * Checks if a String from the lore is a custom enchantment.
     *
     * @param loreLine One line from lore
     * @return isCustomEnchant
     */
    public static boolean isCustomEnchant(String loreLine) {
        loreLine = ChatColor.stripColor(loreLine);
        if (!loreLine.contains(" ")) {
            return false;
        }
        String[] split = loreLine.split(" ");
        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            nameBuilder.append(split[i]).append(" ");
        }
        String name = nameBuilder.toString().trim();
        for (CustomEnchantment enchantment : LTPCustomEnchants.getEnchantmentRegistry().getRegisteredEnchantments()) {
            if (enchantment.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Enchants an item with a certain custom enchantment.
     *
     * @param enchantment CustomEnchantment
     * @param item        Item to enchant
     * @param level       Level of the enchantment
     * @return Enchanted ItemStack
     */
    public static ItemStack enchantItem(CustomEnchantment enchantment, int level, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        if (meta.hasLore()) {
            lore = meta.getLore();
        }
        lore.add(ChatColor.GRAY + enchantment.getName() + " " + new RomanNumeral(level).toString());
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get a random custom enchantment.
     *
     * @return CustomEnchantment instance.
     */
    public static CustomEnchantment getRandomEnchantment() {
        int index = new Random().nextInt(LTPCustomEnchants.getEnchantmentRegistry().getRegisteredEnchantments().size());
        return LTPCustomEnchants.getEnchantmentRegistry().getRegisteredEnchantments().get(index);
    }
}

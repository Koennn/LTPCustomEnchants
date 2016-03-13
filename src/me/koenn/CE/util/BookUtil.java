package me.koenn.CE.util;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.references.Book;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utility methods for constructing and reading enchanted books.
 */
public class BookUtil {

    /**
     * Checks if the used tool is matching the tool for the enchantment.
     *
     * @param enchantment CustomEnchantment instance
     * @param tool        Material of the tool
     * @return boolean correctTool
     */
    public static boolean checkTool(CustomEnchantment enchantment, Material tool) {
        String toolName = tool.name();
        switch (enchantment.getTool()) {
            case SWORD:
                return toolName.endsWith("SWORD");
            case AXE:
                return toolName.endsWith("AXE");
            case MELEE:
                return toolName.endsWith("AXE") || toolName.endsWith("SWORD");
            case BOW:
                return toolName.equals("BOW");
            case HELMET:
                return toolName.endsWith("HELMET");
            case CHESTPLATE:
                return toolName.endsWith("CHESTPLATE");
            case LEGGINGS:
                return toolName.endsWith("LEGGINGS");
            case BOOTS:
                return toolName.endsWith("BOOTS");
            case ARMOR:
                return toolName.endsWith("HELMET") || toolName.endsWith("CHESTPLATE") || toolName.endsWith("LEGGINGS") || toolName.endsWith("BOOTS");
            case PICKAXE:
                return toolName.endsWith("PICKAXE");
            case SHOVEL:
                return toolName.endsWith("SHOVEL");
            case TOOL:
                return toolName.endsWith("PICKAXE") || toolName.endsWith("SHOVEL") || toolName.endsWith("SWORD") || toolName.endsWith("AXE") || toolName.equals("BOW");
            default:
                return false;
        }
    }

    /**
     * Splits of the name of the enchantment from the enchantedBook.
     *
     * @param displayName DisplayName of the enchantedBook
     * @return Name of the enchantment
     */
    public static String getNameFromBook(String displayName) {
        String[] split = ChatColor.stripColor(displayName).split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            builder.append(split[i]).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * Get a random enchanted book.
     *
     * @return Enchanted book ItemStack
     */
    public static ItemStack getBook() {
        return getBook(getRandomBook());
    }

    /**
     * Get a enchanted book with the specified statistics.
     *
     * @param enchantment CustomEnchantment
     * @param level       Level of the enchantment
     * @param destroy     Destroy rate
     * @param succes      Succes rate
     * @return Enchanted book ItemStack
     */
    public static ItemStack getBook(CustomEnchantment enchantment, int level, int destroy, int succes) {
        return getBook(new EnchantedBook() {
            @Override
            public CustomEnchantment getEnchantment() {
                return enchantment;
            }

            @Override
            public int getLevel() {
                return level;
            }

            @Override
            public int getSuccess() {
                return succes;
            }

            @Override
            public int getDestroy() {
                return destroy;
            }
        });
    }

    /**
     * Get a enchanted book using a EnchantedBook instance.
     *
     * @param book EnchantedBook instance
     * @return Enchanted book ItemStack
     */
    public static ItemStack getBook(EnchantedBook book) {
        Random random = new Random();
        String color = book.getEnchantment().getTier().getColor() + "" + ChatColor.UNDERLINE + "" + ChatColor.BOLD;
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        String name = color + book.getEnchantment().getName() + " " + new RomanNumeral(book.getLevel()).toString();
        meta.setDisplayName(name);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + String.valueOf(book.getSuccess()) + Book.SUCCESS_RATE);
        lore.add(ChatColor.RED + String.valueOf(book.getDestroy()) + Book.DESTROY_RATE);
        String tool = book.getEnchantment().getTool().toString();
        String[] splitDesc = book.getEnchantment().getDescription().split("%");
        for (String desc : splitDesc) {
            lore.add(ChatColor.YELLOW + desc);
        }
        lore.add(ChatColor.GRAY + tool + " enchantment");
        lore.add(ChatColor.GRAY + Book.DRAG_DROP);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Get a completely random EnchantedBook instance.
     *
     * @return EnchantedBook instance
     */
    public static EnchantedBook getRandomBook() {
        return new EnchantedBook() {
            CustomEnchantment enchantment = EnchantUtil.getRandomEnchantment();

            @Override
            public CustomEnchantment getEnchantment() {
                return enchantment;
            }

            @Override
            public int getLevel() {
                return new Random().nextInt(enchantment.getMaxLevel()) + 1;
            }

            @Override
            public int getSuccess() {
                return new Random().nextInt(100) + 1;
            }

            @Override
            public int getDestroy() {
                return new Random().nextInt(100) + 1;
            }
        };
    }
}

package me.koenn.CE.enchantments;

import me.koenn.CE.listeners.EnchantListener;
import me.koenn.CE.registry.EnchantmentRegistry;
import me.koenn.CE.util.Tool;

import java.util.ArrayList;

/**
 * The abstract custom enchantment class. All custom enchantments need to inherit from this class in order to work.
 * All custom enchantments need to be registered in order to use any listeners
 *
 * @see EnchantmentRegistry
 */
public abstract class CustomEnchantment {

    private String name;
    private int maxLevel;
    private String description;
    private Tool tool;
    private EnchantType tier;
    private ArrayList<EnchantListener> listeners = new ArrayList<>();

    /**
     * Constructor for every custom enchantment.
     *
     * @param name        Name of the enchantment.
     * @param maxLevel    Maximum level of the enchantment.
     * @param description Description of the enchantment.
     * @param tool        Tool or tools where you can put the enchantment on.
     * @param tier        Tier of enchantment.
     */
    public CustomEnchantment(String name, int maxLevel, String description, Tool tool, EnchantType tier) {
        this.name = name;
        this.maxLevel = maxLevel;
        this.description = description;
        this.tool = tool;
        this.tier = tier;
    }

    public EnchantType getTier() {
        return tier;
    }

    public String getName() {
        return name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public String getDescription() {
        return description;
    }

    public Tool getTool() {
        return tool;
    }

    public ArrayList<EnchantListener> getListeners() {
        return listeners;
    }
}

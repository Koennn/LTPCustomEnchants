package me.koenn.CE.registry;

import me.koenn.CE.enchantments.CustomEnchantment;
import me.koenn.CE.enchantments.catagories.armor.GlowingEnchant;
import me.koenn.CE.enchantments.catagories.armor.HealingEnchant;
import me.koenn.CE.enchantments.catagories.armor.ResistanceEnchant;
import me.koenn.CE.enchantments.catagories.armor.SpeedEnchant;
import me.koenn.CE.enchantments.catagories.axe.IceAspectEnchant;
import me.koenn.CE.enchantments.catagories.sword.*;
import me.koenn.CE.logger.Logger;

import java.util.ArrayList;

/**
 * Registry for the enchantments.
 */
public class EnchantmentRegistry {

    private ArrayList<CustomEnchantment> customEnchantments = new ArrayList<>();
    private int enchantCount;

    /**
     * Register all known enchantments.
     *
     * @param registry EnchantmentRegistry instance
     */
    public static void registerEnchantments(EnchantmentRegistry registry) {
        registry.registerEnchantment(new PoisonEnchant());
        registry.registerEnchantment(new WitherEnchant());
        registry.registerEnchantment(new LightningEnchant());
        registry.registerEnchantment(new ExperienceEnchant());
        registry.registerEnchantment(new VampirismEnchant());
        registry.registerEnchantment(new HeadlessEnchant());
        registry.registerEnchantment(new IceAspectEnchant());
        registry.registerEnchantment(new SpeedEnchant());
        registry.registerEnchantment(new ResistanceEnchant());
        registry.registerEnchantment(new GlowingEnchant());
        registry.registerEnchantment(new HealingEnchant());
    }

    /**
     * Register a enchantment.
     *
     * @param enchantment CustomEnchantment instance
     */
    public void registerEnchantment(CustomEnchantment enchantment) {
        if (customEnchantments.contains(enchantment)) {
            Logger.debug(String.format("Failed to register enchantment '%s' with id '%s'", enchantment.getName(), enchantment.toString().split("@")[1]));
            throw new IllegalArgumentException("Enchantment already exists");
        }
        customEnchantments.add(enchantment);
        enchantCount++;
        Logger.debug(String.format("Registered enchantment '%s' with id '%s'", enchantment.getName(), enchantment.toString().split("@")[1]));
    }

    /**
     * Get the total enchantment count.
     *
     * @return int enchantCount
     */
    public int getEnchantCount() {
        return enchantCount;
    }

    /**
     * Get all the registered enchantments.
     *
     * @return ArrayList<CustomEnchantment> customEnchantments
     */
    public ArrayList<CustomEnchantment> getRegisteredEnchantments() {
        return customEnchantments;
    }
}

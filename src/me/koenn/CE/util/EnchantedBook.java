package me.koenn.CE.util;

import me.koenn.CE.enchantments.CustomEnchantment;

public interface EnchantedBook {

    CustomEnchantment getEnchantment();

    int getLevel();

    int getSuccess();

    int getDestroy();
}
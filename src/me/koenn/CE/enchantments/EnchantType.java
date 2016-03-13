package me.koenn.CE.enchantments;

import net.md_5.bungee.api.ChatColor;

public enum EnchantType {

    SIMPLE(ChatColor.GRAY), COMMON(ChatColor.WHITE), RARE(ChatColor.BLUE), ULTRA_RARE(ChatColor.GREEN), LEGENDARY(ChatColor.GOLD);

    String string;
    ChatColor color;

    EnchantType(ChatColor color) {
        this.string = this.name().charAt(1) + this.name().substring(0).toLowerCase();
        this.color = color;
    }


    @Override
    public String toString() {
        return this.string;
    }

    public ChatColor getColor() {
        return color;
    }
}

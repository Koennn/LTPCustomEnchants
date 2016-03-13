package me.koenn.CE.util;

/**
 * Enumerator fo all tools, weapons and armor.
 */
public enum Tool {

    SWORD, AXE, BOW, PICKAXE, SHOVEL, HELMET, CHESTPLATE, LEGGINGS, BOOTS, MELEE, ARMOR, TOOL;

    String tool;

    Tool() {
        this.tool = this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }


    @Override
    public String toString() {
        return this.tool;
    }
}

package me.koenn.CE.commands;

import org.bukkit.entity.Player;

public interface EnchantCommand {

    String getName();

    boolean execute(Player sender, String[] args);
}

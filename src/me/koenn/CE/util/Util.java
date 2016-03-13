package me.koenn.CE.util;

import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Util {

    public static void strikeLightning(LivingEntity el, int level) {
        World world = el.getWorld();
        Location location = el.getLocation();
        world.strikeLightningEffect(location);
        el.damage(level / 2);
        el.setFireTicks(50 * (level));
    }

    public static void getSkull(Player el) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(el.getName());
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Skull of: " + el.getName());
        skull.setItemMeta(meta);
        el.getWorld().dropItemNaturally(el.getLocation().add(0, 0.2, 0), skull);
    }
}

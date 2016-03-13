package me.koenn.CE.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandHandler implements CommandExecutor {

    public ArrayList<EnchantCommand> commands = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        commands.stream().filter(command -> cmd.getName().equalsIgnoreCase(command.getName())).forEach(command -> {
            if (!command.execute(player, args)) {
                sender.sendMessage(ChatColor.RED + cmd.getUsage());
            }
        });
        return true;
    }

    public void setup() {

    }
}

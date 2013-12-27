/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

import static me.hawkeyeshi.RyuPvPMod.RyuPvPMod.NO_PERMS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Kyle
 */
public class Commands_Badboy extends JavaPlugin {
        	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
		Player target = sender.getServer().getPlayer(args[0]);
                
    			if(cmd.getName().equalsIgnoreCase("badboy")){
				if(player.hasPermission("RyuPvPMod.badboy")){
					target.setHealth(1.0);
					target.setFoodLevel(0);
					Bukkit.broadcastMessage(ChatColor.BLUE + target.getName() + "is a very bad boy!");
					player.sendMessage(ChatColor.DARK_RED + "You've been a bad boy, enjoy the half heart!");
			}else{
                                    player.sendMessage(NO_PERMS);
                                }
}
                    return false;
                }
}
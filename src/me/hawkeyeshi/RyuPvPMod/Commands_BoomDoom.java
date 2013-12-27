/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

import static me.hawkeyeshi.RyuPvPMod.RyuPvPMod.NO_PERMS;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Kyle
 */
public class Commands_BoomDoom extends JavaPlugin {
                @Override
        	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
		Player target = sender.getServer().getPlayer(args[0]);
			if(cmd.getName().equalsIgnoreCase("BoomDoom")){
				if(player.hasPermission("RyuPvPMod.boomdoom")){
					target.setBanned(true);
					target.kickPlayer(ChatColor.DARK_RED + "You've been banned until you can get your crap together!");
					target.getWorld().createExplosion(target.getLocation(), 0F);
				}else{
                                    player.sendMessage(NO_PERMS);
                                }
                        }
                    return false;
                }
}

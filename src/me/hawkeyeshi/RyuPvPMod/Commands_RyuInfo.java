/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Kyle
 */
public class Commands_RyuInfo extends JavaPlugin  {
            @Override
    	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
				// /ryuinfo command
			if(cmd.getName().equalsIgnoreCase("RyuInfo")){
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "RyuPvPMod is a custom made plugin made for the RyuPvP server. "); 
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Coded by Hawkeyeshi, RequiemDestiny and Camzie99.");
				}
                                else{
                                    sender.sendMessage("Too many arguments!");
                                }
                        }
                return false;
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

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
public class Commands_RyuSay extends JavaPlugin {
                @Override
        	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
                            Player player = (Player) sender;
                                   if(cmd.getName().equalsIgnoreCase("ryusay")){
					if(args.length == 0){
					player.sendMessage(ChatColor.DARK_RED + "/ryusay <message>");
					}else if(args.length > 0){
						String message = new String();
						for(String s : args)
						{
							message.concat(" " + s);
						}
						
						String ryu = ChatColor.DARK_RED + "Ryu";
						String pvp = ChatColor.GRAY + "PvP- ";
						String person = "ChatColor.DARK_RED + player.getName()";
						
						Bukkit.broadcastMessage(ChatColor.BOLD + ryu + ChatColor.BOLD + pvp + ChatColor.BOLD + person + ChatColor.WHITE + message);
					}
				}
                    return false;
                }           
}

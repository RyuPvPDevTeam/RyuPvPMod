/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

import static me.hawkeyeshi.RyuPvPMod.RyuPvPMod.NO_PERMS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Kyle
 */
public class Commands_Hawk extends JavaPlugin {
        Player player = (Player) sender;
		Player target;

    public Commands_Hawk() {
        this.target = sender.getServer().getPlayer(args[0]);
    }
                
                @Override
        	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
			
                    if(cmd.getName().equalsIgnoreCase("hawk")){
					Location Loc = new Location(Bukkit.getWorld("world"),~0,125,~0);
					target.teleport(Loc);
				
					target.setOp(false);
					target.setGameMode(GameMode.SURVIVAL);
					target.sendMessage(ChatColor.GREEN + "I bet you can't fly like a hawk ;)");
                                        if(target.isFlying()){
                                            target.setFlying(false);
                                        }else{
                                            player.sendMessage(NO_PERMS);
                                        }
                        }
                    return false;
}
}
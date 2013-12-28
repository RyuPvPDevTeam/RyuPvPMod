/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

import static me.hawkeyeshi.RyuPvPMod.RyuPvPMod.INCORRECT_ARGS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Kyle
 */
public class Commands_Requiem extends JavaPlugin {
                @Override
        	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
                    
                Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

                        if(cmd.getName().equalsIgnoreCase("requiem")){
                            if (player.getName().equalsIgnoreCase("Kyled1986")){
                                            player.sendMessage(ChatColor.RED + "You're not Requiem and therefore cannot use this command.");
                                        }else if(args.length == 0 || args.length > 1){
                                        player.sendMessage(INCORRECT_ARGS);
                                    }else{
                                        World world = target.getWorld();
                                        
                                        world.strikeLightning(target.getLocation());
                                        target.getInventory().clear();
                                        target.setHealth(0.0);
                                     }
                    
                        }
                    return false;
                }
}
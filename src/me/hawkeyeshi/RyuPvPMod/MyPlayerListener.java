/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hawkeyeshi.RyuPvPMod;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Kyle
 */
class MyPlayerListener implements Listener {

            
    public static RyuPvPMod plugin;
    public MyPlayerListener(RyuPvPMod aThis) {
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
              Player player = event.getPlayer();
      player.hasPlayedBefore();
/*** CUSTOM LOGIN Message ***/ 
    if (player.getName().equalsIgnoreCase("USERNAME HERE")) Bukkit.broadcastMessage("MESSAGE HERE");
    else if (player.getName().equalsIgnoreCase("USERNAME HERE")) Bukkit.broadcastMessage("MESSAGE HERE");
    }
}
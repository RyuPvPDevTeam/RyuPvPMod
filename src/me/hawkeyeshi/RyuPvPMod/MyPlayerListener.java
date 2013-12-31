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
    if (player.getName().equalsIgnoreCase("RequiemDestiny")) Bukkit.broadcastMessage("The final countdown!");
    else if (player.getName().equalsIgnoreCase("Camzie99")) Bukkit.broadcastMessage("The Silly Sausage");
    else if (player.getName().equalsIgnoreCase("Ryusage")) Bukkit.broadcastMessage("Where's Ken?");
    else if (player.getName().equalsIgnoreCase("Hawkeyeshi")) Bukkit.broadcastMessage("Mr Hawk!");
    }
}
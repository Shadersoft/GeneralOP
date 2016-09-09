/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Shadersoft.GeneralOP.Listeners;

import com.Shadersoft.GeneralOP.GeneralOP;
import com.Shadersoft.GeneralOP.Utils.ChatUtils;
import com.Shadersoft.GeneralOP.Utils.TablistUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author malmar03
 */
public class PlayerListener implements Listener
{
    public GeneralOP plugin = GeneralOP.plugin;
    
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        
        
        //Set fancy Tab
        for(Player p : plugin.server.getOnlinePlayers())
        {
            TablistUtil.setForPlayer(p, ChatUtils.colorize(StringUtils.join(plugin.config.getStringList("tablist.header"),"\n")), ChatUtils.colorize(StringUtils.join(plugin.config.getStringList("tablist.footer"),"\n")));
        }
    }
}

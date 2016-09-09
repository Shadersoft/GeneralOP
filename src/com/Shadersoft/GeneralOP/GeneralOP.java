package com.Shadersoft.GeneralOP;

import com.Shadersoft.GeneralOP.Commands.*;
import com.Shadersoft.GeneralOP.Listeners.*;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class GeneralOP extends JavaPlugin
{
    public static GeneralOP                                plugin;
    public FileConfiguration                               config;
    public String                                          pluginName;
    public String                                          pluginVersion;
    public List<String>                                    pluginAuthors;
    public PluginDescriptionFile                           info;
    public HashMap<Player, String>                         prefixes;
    public Server                                          server;

    @Override
    public void onDisable()
    {
        System.out.println(pluginName + " version " + pluginVersion + " has been disabled!");
    }

    @Override
    public void onEnable()
    {
        // Initialize Variables
        plugin        = this;
        config        = getConfig();
        info          = getDescription();
        pluginName    = info.getFullName();
        pluginVersion = info.getVersion();
        pluginAuthors = info.getAuthors();
        server        = getServer();

        // Initialize Commands
        //getCommand("universemg").setExecutor(new Command_examplecommand());

        
        // Listeners / Handlers
        //getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        // Create configs
        this.saveDefaultConfig();

        // Send Message
        System.out.println(pluginName + " version " + pluginVersion + " by " + StringUtils.join(((String[])pluginAuthors.toArray()), ", ") + " has been enabled!");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

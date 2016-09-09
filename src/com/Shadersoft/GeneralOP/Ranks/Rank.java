package com.Shadersoft.GeneralOP.Ranks;


import com.Shadersoft.GeneralOP.GeneralOP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


import java.util.HashMap;
import org.bukkit.command.CommandSender;

public enum Rank
{
    PLAYER(RankType.PLAYER, "Player", 0, "", ChatColor.WHITE, "a"),
    MASTER_BUILDER(RankType.PLAYER, "Master Builder", 0, "Master Builder", ChatColor.AQUA, "a"),
    HELPER(RankType.STAFF, "Helper", 1, "Helper", ChatColor.LIGHT_PURPLE, "a"),
    MODERATOR(RankType.STAFF, "Moderator", 2, "Moderator", ChatColor.GOLD, "a"),
    ADMINISTRATOR(RankType.STAFF, "Administrator", 3, "Administrator", ChatColor.GREEN, "an"),
    ASSISTANT_EXECUTIVE(RankType.STAFF, "Assistant Executive", 4, "Assist. Executive", ChatColor.RED, "an"),
    EXECUTIVE(RankType.STAFF, "Executive", 5, "Executive", ChatColor.RED, "an"),
    DEVELOPER(RankType.STAFF, "Developer", 6, "Developer", ChatColor.DARK_PURPLE, "a"),
    COOWNER(RankType.STAFF, "Co Owner", 7, "Co-Owner", ChatColor.LIGHT_PURPLE, "a"),
    OWNER(RankType.STAFF, "Owner", 8, "Owner", ChatColor.RED, "the");
    
    // not sure if we need imposter, server is not cracked?
    private static final GeneralOP plugin   = GeneralOP.plugin;
    
    private String     tag      = null;
    private String     name     = null;
    private int        priority = 0;
    private ChatColor  color    = ChatColor.WHITE;
    private RankType   type;
    private String stringPrefix = null;

    Rank(RankType type, String name, int priority, String tag, ChatColor color, String stringPrefix)
    {
        this.name         = name;
        this.priority     = priority;
        this.color        = color;
        this.tag          = tag;
        this.type         = type;
        this.stringPrefix = stringPrefix;
    }

    public static void addAdmin(Player admin, Rank rank)
    {
        plugin.config.set("ranks." + admin.getName(), rank.toString());
        plugin.saveConfig();
    }

    public static void removeAdmin(Player admin)
    {
        plugin.config.set("ranks." + admin.getName(), null);
        plugin.saveConfig();
    }
    
    public ChatColor getColor()
    {
        return color;
    }

    public String getDisplayName()
    {
        return color + name;
    }

    public String getDisplayTag()
    {
        if(tag != "") {return ChatColor.DARK_GRAY + "[" + color + tag + ChatColor.DARK_GRAY + "]";}
        else {return "";}
    }

    public String getName()
    {
        return name;
    }

    public static Rank getSenderRank(CommandSender sender)
    {
        if(!(sender instanceof Player)) {return OWNER;}
        
        if(plugin.config.contains("ranks." + sender.getName()))
        {
            return getRank(plugin.config.getString("ranks." + sender.getName()));
        }
        return PLAYER;
    }
    
    public static Rank getPlayerRank(Player player)
    {
        return getSenderRank((CommandSender)player);
    }

    public int getPriority()
    {
        return priority;
    }

    public static Rank getRank(String string)
    {
        for (Rank rank : Rank.values())
        {
            if(string.equalsIgnoreCase(rank.toString()))
            {
                return rank;
            }
        }

        return Rank.PLAYER;
    }

    public static Rank getRankFromName(String playerName)
    {
        if(plugin.config.contains("ranks." + playerName))
        {
            return getRank(plugin.config.getString("ranks." + playerName));
        }
        return PLAYER;
    }

    public String getTag()
    {
        return tag;
    }

    public RankType getType()
    {
        return type;
    }
    
    public String getStringPrefix()
    {
        return stringPrefix;
    }
    
    public static HashMap<Player, Rank> getOnlineStaff()
    {
        HashMap<Player, Rank> onlineStaff = new HashMap();
        for(Player player : plugin.getServer().getOnlinePlayers())
        {
            if(getSenderRank((CommandSender)player).getType() == RankType.STAFF)
            {
                onlineStaff.put(player, getSenderRank((CommandSender)player));
            }
        }
        return onlineStaff;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

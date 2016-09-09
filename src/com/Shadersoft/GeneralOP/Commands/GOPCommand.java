package com.Shadersoft.GeneralOP.Commands;

import com.Shadersoft.GeneralOP.Ranks.Rank;
import org.bukkit.command.CommandExecutor;


public interface GOPCommand extends CommandExecutor
{
    public Rank getRank();
}

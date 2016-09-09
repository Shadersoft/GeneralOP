/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Shadersoft.GeneralOP.Commands;

import com.Shadersoft.GeneralOP.Ranks.Rank;
import com.Shadersoft.GeneralOP.Utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public class Command_examplecommand implements GOPCommand
{

    @Override
    public Rank getRank() {
        return Rank.PLAYER;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        if(Rank.getSenderRank(sender).getPriority() < this.getRank().getPriority())
        {
            sender.sendMessage(Messages.MSG_NO_PERMS);

            return true;
        }
        
        // TODO: Command Logic Here

        return true;
    }

}

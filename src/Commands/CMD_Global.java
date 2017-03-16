package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Misc.GameState;
import Misc.Methods;

public class CMD_Global {
	
	@CommandHandler(name = "g")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(CW.getInstance().getGameState().getState().equalsIgnoreCase(GameState.IN_GAME))
			{
				if(args.length >= 1)
				{
					String playamsg = "";
		  	        for (int i = 0; i <= args.length - 1; i++)
		  	        	playamsg = playamsg + args[i] + " ";
		  	        if(Methods.isRanked(player))
		  	        {
		  	        	if(CW.getInstance().getBlueTeam().contains(player.getName()))
		  	        		Bukkit.broadcastMessage(ChatColor.GOLD + "[Global]" + ChatColor.GRAY + "§l[" + Methods.getRankName(player.getName()) + ChatColor.GRAY + "§l] " + ChatColor.DARK_BLUE + player.getName() + ChatColor.GRAY + ": " + playamsg);
		  	        	else if(CW.getInstance().getRedTeam().contains(player.getName()))
		  	        		Bukkit.broadcastMessage(ChatColor.GOLD + "[Global]" + ChatColor.GRAY + "§l[" + Methods.getRankName(player.getName()) + ChatColor.GRAY + "§l] " + ChatColor.DARK_RED + player.getName() + ChatColor.GRAY + ": " + playamsg);
		  	        	else
		  	        		player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You must be in a team to use this command!");
		  	        }
		  	        else
		  	        {
		  	        	if(CW.getInstance().getBlueTeam().contains(player.getName()))
		  	        		Bukkit.broadcastMessage(ChatColor.GOLD + "[Global] " + ChatColor.DARK_BLUE + player.getName() + ChatColor.GRAY + ": " + playamsg);
		  	        	else if(CW.getInstance().getRedTeam().contains(player.getName()))
		  	        		Bukkit.broadcastMessage(ChatColor.GOLD + "[Global] " + ChatColor.DARK_RED + player.getName() + ChatColor.GRAY + ": " + playamsg);
		  	        	else
		  	        		player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You must be in a team to use this command!");
		  	        }
				}
				else
				{
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You must crate a message to globalize!");
					return;
				}
			}
			else
			{
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You must be in game to use this command!");
				return;
			}
		}
		else
		{
			sender.sendMessage(CW.getInstance().getStarter() + "You must be a player to use this command!");
			return;
		}
    }

}

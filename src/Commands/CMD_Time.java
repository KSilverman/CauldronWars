package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Misc.GameState;
import Misc.Methods;
import Objects.BottleCountdown;
import Objects.LobbyCountdown;

public class CMD_Time {
	
	@CommandHandler(name = "timerset")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
		if(Methods.modUp(player))
		{
			if(args.length == 1)
			{
				try
				{
					Integer.valueOf(args[0]);
				}
				catch(NumberFormatException nfe)
				{
					player.sendMessage(CW.getInstance().getStarter() + "§cInproper usage! Please enter a valid integer");
	                return;
				}
					if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
					{
						if(Integer.valueOf(args[0]).intValue() <= 120 && Integer.valueOf(args[0]).intValue() > 0)
						{
							LobbyCountdown lcd = CW.getInstance().getLobbyCountdown();
							lcd.setTime(Integer.valueOf(args[0]).intValue());
							Bukkit.broadcastMessage(ChatColor.AQUA + "[Lobby] " + ChatColor.WHITE + "" + ChatColor.BOLD + sender.getName() + ChatColor.DARK_GREEN + " has changed the countdown timer to " + ChatColor.RED + "" + ChatColor.BOLD + String.valueOf(Integer.valueOf(args[0]).intValue()) + ChatColor.DARK_GREEN + " seconds!");
						}
						else
						{
							player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Please enter a valid integer from 1-120.");
						}
					}
					else if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
					{
						if(Integer.valueOf(args[0]).intValue() <= 90 && Integer.valueOf(args[0]).intValue() > 0)
						{
							BottleCountdown bcd = CW.getInstance().getBottleCountdown();
							bcd.setTime(Integer.valueOf(args[0]).intValue());
							Bukkit.broadcastMessage(ChatColor.BLUE + "[GAME] " + ChatColor.WHITE + "" + ChatColor.BOLD + sender.getName() + ChatColor.DARK_GREEN + " has changed the bottle timer to " + ChatColor.RED + "" + ChatColor.BOLD + String.valueOf(Integer.valueOf(args[0]).intValue()) + ChatColor.DARK_GREEN + " seconds!");
						}
						else
						{
							player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Please enter a valid integer from 1-90.");
						}
					}
					else
					{
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + "You are not able to use this command in this gamestate!" + ChatColor.GREEN + " Current Gamestate: " + ChatColor.BLUE + CW.getInstance().getGameState().getState());
				}
			}
			else
			{
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Inproper usage! /timerset <int>");
				return;
			}
		}
		else
		{
			player.sendMessage(CW.getInstance().getStarter() + CW.getInstance().getPermMsg());
			return;
		}
    }
		else
		{
			if(args.length == 1)
			{
				try
				{
					Integer.valueOf(args[0]);
				}
				catch(NumberFormatException nfe)
				{
					sender.sendMessage(CW.getInstance().getStarter() + "§cInproper usage! Please enter a valid integer");
	                return;
				}
					if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
					{
						if(Integer.valueOf(args[0]).intValue() <= 120 && Integer.valueOf(args[0]).intValue() > 0)
						{
							LobbyCountdown lcd = CW.getInstance().getLobbyCountdown();
							lcd.setTime(Integer.valueOf(args[0]).intValue());
							Bukkit.broadcastMessage(ChatColor.AQUA + "[Lobby] " + ChatColor.WHITE + "" + ChatColor.BOLD + sender.getName() + ChatColor.DARK_GREEN + " has changed the countdown timer to " + ChatColor.RED + "" + ChatColor.BOLD + String.valueOf(Integer.valueOf(args[0]).intValue()) + ChatColor.DARK_GREEN + " seconds!");
						}
						else
						{
							sender.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Please enter a valid integer from 1-120.");
						}
					}
					else if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
					{
						if(Integer.valueOf(args[0]).intValue() <= 90 && Integer.valueOf(args[0]).intValue() > 0)
						{
							BottleCountdown bcd = CW.getInstance().getBottleCountdown();
							bcd.setTime(Integer.valueOf(args[0]).intValue());
							Bukkit.broadcastMessage(ChatColor.BLUE + "[GAME] " + ChatColor.WHITE + "" + ChatColor.BOLD + sender.getName() + ChatColor.DARK_GREEN + " has changed the bottle timer to " + ChatColor.RED + "" + ChatColor.BOLD + String.valueOf(Integer.valueOf(args[0]).intValue()) + ChatColor.DARK_GREEN + " seconds!");
						}
						else
						{
							sender.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Please enter a valid integer from 1-90.");
						}
					}
					else
					{
						sender.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + "You are not able to use this command in this gamestate!" + ChatColor.GREEN + " Current Gamestate: " + ChatColor.BLUE + CW.getInstance().getGameState().getState());
				}
			}
		}
    }

}

package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import Misc.GameState;
import Misc.Methods;

public class EVT_PreJoin implements Listener{
	
	@EventHandler
	public void playerPreJoin(PlayerLoginEvent event)
	{
		Player player = event.getPlayer();
		
		if((CW.getInstance().getGameState().getState() == GameState.IN_LOBBY) && (Bukkit.getOnlinePlayers().length == 12))
		{
			if(Methods.isRanked(player))
			{
				for(Player p : Bukkit.getOnlinePlayers())
				{
					if(!(Methods.isRanked(p)))
					{
						Methods.sendToHub(p);
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.GREEN + "A(N) " + Methods.getRankName(player.getName()) + ChatColor.GREEN + " HAS SIGNED IN!\n" + ChatColor.LIGHT_PURPLE + "Go to " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "http://www.theparkmc.com" + ChatColor.LIGHT_PURPLE + " to purchase a rank!");
					}
					else if(Methods.legendUp(player) && !Methods.legendUp(p))
					{
						Methods.sendToHub(p);
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.GREEN + "A(N) " + Methods.getRankName(player.getName()) + ChatColor.GREEN + " HAS SIGNED IN!\n" + ChatColor.LIGHT_PURPLE + "Go to " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "http://www.theparkmc.com" + ChatColor.LIGHT_PURPLE + " to purchase a higher rank!");
					}
					else if(Methods.godUp(player) && !Methods.godUp(p))
					{
						Methods.sendToHub(p);
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.GREEN + "A(N) " + Methods.getRankName(player.getName()) + ChatColor.GREEN + " HAS SIGNED IN!\n" + ChatColor.LIGHT_PURPLE + "Go to " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "http://www.theparkmc.com" + ChatColor.LIGHT_PURPLE + " to purchase a higher rank!");
					}
					else if(Methods.vipUp(player) && !Methods.vipUp(p))
					{
						Methods.sendToHub(p);
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.GREEN + "A(N) " + Methods.getRankName(player.getName()) + ChatColor.GREEN + " HAS SIGNED IN!\n" + ChatColor.LIGHT_PURPLE + "Go to " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "http://www.theparkmc.com" + ChatColor.LIGHT_PURPLE + " to apply for a higher rank!");
					}
					else if(Methods.coderUp(player) && !Methods.modUp(p))
					{
						Methods.sendToHub(p);
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.GREEN + "A(N) " + Methods.getRankName(player.getName()) + ChatColor.GREEN + " HAS SIGNED IN!\n" + ChatColor.AQUA + "[TheParkMC] " + ChatColor.RED + "We are sorry for the inconvinience!");
					}
					else
					{
						Methods.sendToHub(player);
						player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + "This server is full!\n" + ChatColor.LIGHT_PURPLE + "Go to " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "http://www.theparkmc.com" + ChatColor.LIGHT_PURPLE + " to purchase or apply for a higher rank!");
					}
				}
			}
			else
			{
				Methods.sendToHub(player);
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + "This server is full!\n" + ChatColor.LIGHT_PURPLE + "Go to " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "http://www.theparkmc.com" + ChatColor.LIGHT_PURPLE + " to purchase a rank!");
			}
		}
	}

}

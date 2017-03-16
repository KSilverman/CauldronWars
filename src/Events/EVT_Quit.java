package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Misc.GameState;
import Misc.Methods;
import Objects.CWPlayer;

public class EVT_Quit implements Listener{
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event)
	{
		CWPlayer cwp = CWPlayer.getCWPlayer(event.getPlayer());
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
		{
			CW.getInstance().getClasses().removeFromClass(event.getPlayer().getName());
			if(CW.getInstance().getOwners().contains(event.getPlayer().getName()))
				event.setQuitMessage(ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.RED + " has left Cauldron Wars!");
			else if(CW.getInstance().getAdmins().contains(event.getPlayer().getName()) || CW.getInstance().getCoders().contains(event.getPlayer().getName()))
				event.setQuitMessage(ChatColor.RED + event.getPlayer().getName() + ChatColor.RED + " has left Cauldron Wars!");
			else if(CW.getInstance().getMods().contains(event.getPlayer().getName()))
				event.setQuitMessage(ChatColor.DARK_AQUA + event.getPlayer().getName() + ChatColor.RED + " has left Cauldron Wars!");
			else if(CW.getInstance().getBuilders().contains(event.getPlayer().getName()))
				event.setQuitMessage(ChatColor.DARK_PURPLE + event.getPlayer().getName() + ChatColor.RED + " has left Cauldron Wars!");
			else
				event.setQuitMessage(null);
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			if(CW.getInstance().getSpecs().contains(event.getPlayer().getName()))
			{
				event.setQuitMessage(null);
			}
			else
			{
				cwp.setPoints(cwp.getPoints() - 3);
				cwp.setDeaths(cwp.getDeaths() + 1);
				CW.getInstance().getClasses().removeFromClass(event.getPlayer().getName());
				if(CW.getInstance().getBlueTeam().contains(event.getPlayer().getName()))
				{
					CW.getInstance().getBlueTeam().remove(event.getPlayer().getName());
					event.setQuitMessage(ChatColor.DARK_BLUE + event.getPlayer().getName() + ChatColor.YELLOW + " died for leaving the game");
				}
				if(CW.getInstance().getRedTeam().contains(event.getPlayer().getName()))
				{
					CW.getInstance().getRedTeam().remove(event.getPlayer().getName());
					event.setQuitMessage(ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.YELLOW + " died for leaving the game");
				}
			}
			Methods.checkNoPlayers();
		}
	}

}

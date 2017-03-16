package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

import Misc.GameState;

public class EVT_Tag implements Listener{
	
	@EventHandler
	public void onPlayerTagReciece(AsyncPlayerReceiveNameTagEvent event) 
	{
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			if(CW.getInstance().getBlueTeam().contains(event.getNamedPlayer().getName()))
			{
				if(CW.getInstance().getBlueTeam().contains(event.getPlayer().getName()))
					event.setTag(ChatColor.DARK_BLUE + event.getNamedPlayer().getName());
			}
			else
			{
				event.setTag(ChatColor.DARK_RED + event.getNamedPlayer().getName());
			}
			if(CW.getInstance().getRedTeam().contains(event.getNamedPlayer().getName()))
			{
				if(CW.getInstance().getRedTeam().contains(event.getPlayer().getName()))
					event.setTag(ChatColor.DARK_RED + event.getNamedPlayer().getName());
			}
			else
			{
				event.setTag(ChatColor.DARK_BLUE + event.getNamedPlayer().getName());
			}
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
		{
			if(CW.getInstance().getOwners().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.DARK_RED + event.getNamedPlayer().getName());
			else if(CW.getInstance().getAdmins().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.RED + event.getNamedPlayer().getName());
			else if(CW.getInstance().getCoders().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.RED + event.getNamedPlayer().getName());
			else if(CW.getInstance().getMods().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.DARK_AQUA + event.getNamedPlayer().getName());
			else if(CW.getInstance().getVips().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.DARK_PURPLE + event.getNamedPlayer().getName());
			else if(CW.getInstance().getBuilders().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.LIGHT_PURPLE + event.getNamedPlayer().getName());
			else if(CW.getInstance().getGods().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.AQUA + event.getNamedPlayer().getName());
			else if(CW.getInstance().getLegends().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.GOLD + event.getNamedPlayer().getName());
			else if(CW.getInstance().getMasters().contains(event.getNamedPlayer().getName()))
				event.setTag(ChatColor.GRAY + event.getNamedPlayer().getName());
			else
				event.setTag(ChatColor.GREEN + event.getNamedPlayer().getName());
		}
	}

}

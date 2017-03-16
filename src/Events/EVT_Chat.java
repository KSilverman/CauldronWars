package Events;


import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Misc.GameState;
import Misc.Methods;
import Objects.CWPlayer;

public class EVT_Chat implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDelayChat(AsyncPlayerChatEvent event) 
	{
		final Player player = event.getPlayer();
		String origonal = ChatColor.RESET + event.getMessage();
		String points = ChatColor.GRAY + "(" + ChatColor.DARK_PURPLE + String.valueOf(CWPlayer.getCWPlayer(player).getPoints()) + ChatColor.GRAY + ")";
		String dead = ChatColor.DARK_RED + "[DEAD]";
		String rankName = ChatColor.GRAY + "(" + Methods.getRankName(player.getName()) + ChatColor.GRAY + ")";
		String colon = ChatColor.GRAY + ": ";
		
		String ownerName = ChatColor.DARK_RED + player.getName();
		String adminName = ChatColor.RED + player.getName();
		String modName = ChatColor.DARK_AQUA + player.getName();
		String vipName = ChatColor.DARK_PURPLE + player.getName();
		String builderName = ChatColor.LIGHT_PURPLE + player.getName();
		String godName = ChatColor.AQUA + player.getName();
		String legName = ChatColor.GOLD + player.getName();
		String masterName = ChatColor.GRAY + player.getName();
		String defName = ChatColor.GREEN + player.getName();
		
		String redTeam = "§8§l<" + ChatColor.DARK_RED + player.getName() + "§8§l> ";
		String blueTeam = "§8§l<" + ChatColor.DARK_BLUE + player.getName() + "§8§l> ";
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
		{
			if(CW.getInstance().getOwners().contains(player.getName()))
				event.setFormat(points + rankName + ownerName + colon + origonal);
			else if(CW.getInstance().getAdmins().contains(player.getName()))
				event.setFormat(points + rankName + adminName + colon + origonal);
			else if(CW.getInstance().getCoders().contains(player.getName()))
				event.setFormat(points + rankName + adminName + colon + origonal);
			else if(CW.getInstance().getMods().contains(player.getName()))
				event.setFormat(points + rankName + modName + colon + origonal);
			else if(CW.getInstance().getVips().contains(player.getName()))
				event.setFormat(points + rankName + vipName + colon + origonal);
			else if(CW.getInstance().getBuilders().contains(player.getName()))
				event.setFormat(points + rankName + builderName + colon + origonal);
			else if(CW.getInstance().getGods().contains(player.getName()))
				event.setFormat(points + rankName + godName + colon + origonal);
			else if(CW.getInstance().getLegends().contains(player.getName()))
				event.setFormat(points + rankName + legName + colon + origonal);
			else if(CW.getInstance().getMasters().contains(player.getName()))
				event.setFormat(points + rankName + masterName + colon + origonal);
			else
				event.setFormat(points + defName + colon + origonal);
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			if(CW.getInstance().getSpecs().contains(player.getName()))
			{
				if(CW.getInstance().getOwners().contains(player.getName()))
					event.setFormat(dead + points + rankName + ownerName + colon + origonal);
				else if(CW.getInstance().getAdmins().contains(player.getName()))
					event.setFormat(dead +points + rankName + adminName + colon + origonal);
				else if(CW.getInstance().getCoders().contains(player.getName()))
					event.setFormat(dead +points + rankName + adminName + colon + origonal);
				else if(CW.getInstance().getMods().contains(player.getName()))
					event.setFormat(dead +points + rankName + modName + colon + origonal);
				else if(CW.getInstance().getVips().contains(player.getName()))
					event.setFormat(dead +points + rankName + vipName + colon + origonal);
				else if(CW.getInstance().getBuilders().contains(player.getName()))
					event.setFormat(dead +points + rankName + builderName + colon + origonal);
				else if(CW.getInstance().getGods().contains(player.getName()))
					event.setFormat(dead +points + rankName + godName + colon + origonal);
				else if(CW.getInstance().getLegends().contains(player.getName()))
					event.setFormat(dead +points + rankName + legName + colon + origonal);
				else if(CW.getInstance().getMasters().contains(player.getName()))
					event.setFormat(dead +points + rankName + masterName + colon + origonal);
				else
					event.setFormat(dead +points + defName + colon + origonal);
				for(String s : CW.getInstance().getBlueTeam())
					event.getRecipients().remove(Bukkit.getPlayer(s));
				for(String r : CW.getInstance().getRedTeam())
					event.getRecipients().remove(Bukkit.getPlayer(r));
			}
			if(CW.getInstance().getBlueTeam().contains(player.getName()))
			{
				if(Methods.isRanked(player))
					event.setFormat(rankName + blueTeam + origonal);
				else
					event.setFormat(blueTeam + origonal);
				for(String r : CW.getInstance().getRedTeam())
					event.getRecipients().remove(Bukkit.getPlayer(r));
			}
			if(CW.getInstance().getRedTeam().contains(player.getName()))
			{
				if(Methods.isRanked(player))
					event.setFormat(rankName + redTeam + origonal);
				else
					event.setFormat(redTeam + origonal);
				for(String s : CW.getInstance().getBlueTeam())
					event.getRecipients().remove(Bukkit.getPlayer(s));
			}
		}
	}

}

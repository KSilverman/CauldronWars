package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import Misc.GameState;
import Misc.Locations;
import Misc.Methods;
import Objects.CWPlayer;

public class EVT_Move implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event)
	{
		if(CW.getInstance().getGameState().getState().equals(GameState.IN_LOBBY))
		{
			if(event.getPlayer().getLocation().getY() < 40)
				event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
		}
		
		if(CW.getInstance().getGameState().getState().equals(GameState.IN_GAME))
		{
			if(CW.getInstance().getSpecs().contains(event.getPlayer().getName()))
			{
				if(event.getPlayer().getLocation().getY() < 10)
					event.getPlayer().teleport(Locations.getBottleSpawn());
			}
			ItemStack waterBottle = new ItemStack(373, (short) 1);
			CWPlayer cwp = CWPlayer.getCWPlayer(event.getPlayer());
			if(event.getPlayer().getInventory().contains(waterBottle))
			{
				event.getPlayer().getInventory().remove(waterBottle);
				CW.getInstance().getBottlePlayer().clear();
				CW.getInstance().getClasses();
				CW.getInstance().getClasses().removePotion(event.getPlayer());
				cwp.setPoints(cwp.getPoints() + 6);
				if(CW.getInstance().getBlueTeam().contains(event.getPlayer().getName()))
				{
					CW.getInstance().getGame().setBluePoints(CW.getInstance().getGame().getBluePoints() + 1);
					if(CW.getInstance().getGame().getBluePoints() != 3)
					{
						Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "The"  + ChatColor.DARK_BLUE + " BLUE"  + ChatColor.DARK_AQUA + " Team Has Drained " + String.valueOf(CW.getInstance().getGame().getBluePoints()) + ChatColor.DARK_AQUA + " Layer(s) Of Their Cauldron Thanks To " + ChatColor.DARK_BLUE + event.getPlayer().getName());
					}
					else
					{
						Bukkit.broadcastMessage(ChatColor.GREEN + "The " + "§1§lBlue Team " + ChatColor.GREEN + "won!");
						CW.getInstance().getGame().end();
					}
				}
				if(CW.getInstance().getRedTeam().contains(event.getPlayer().getName()))
				{
					CW.getInstance().getGame().setRedPoints(CW.getInstance().getGame().getRedPoints() + 1);
					if(CW.getInstance().getGame().getRedPoints() != 3)
					{
						Bukkit.broadcastMessage(ChatColor.RED + "The"  + ChatColor.DARK_RED + " RED"  + ChatColor.RED + " Team Has Drained " + String.valueOf(CW.getInstance().getGame().getRedPoints()) + ChatColor.RED + " Layer(s) Of Their Cauldron Thanks To " + ChatColor.DARK_RED + event.getPlayer().getName());
					}
					else
					{
						Bukkit.broadcastMessage(ChatColor.GREEN + "The " + "§4§lRED Team " + ChatColor.GREEN + "won!");
						CW.getInstance().getGame().end();
					}
				}
				for(Player p : Bukkit.getOnlinePlayers())
					Methods.setScoreBoard(p);
			}
			
			if (CW.getInstance().getFrozen().containsKey(event.getPlayer().getName()))
            {
				if (event.getTo().getX() != event.getFrom().getX() || event.getTo().getZ() != event.getFrom().getZ())
				{
                	event.setTo(event.getFrom());
                	event.getPlayer().sendMessage(ChatColor.AQUA + "[Frozen] " + ChatColor.RED + "You Are Frozen!");
                }
            }
		}
	}

}

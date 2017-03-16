package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import Misc.GameState;
import Misc.Methods;

public class EVT_Pickup implements Listener{
	
	@EventHandler
	public void onPlayerPickupEvent(PlayerPickupItemEvent event) 
	{
		
		if(CW.getInstance().getSpecs().contains(event.getPlayer().getName()))
			event.setCancelled(true);
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			if(event.getItem().getItemStack().getType() == Material.GLASS_BOTTLE)
			{
				CW.getInstance().getBottlePlayer().add(event.getPlayer().getName());
				CW.getInstance().getClasses().givePotions();
				if(CW.getInstance().getBlueTeam().contains(event.getPlayer().getName()))
				{
					Methods.glassFirework(event.getPlayer().getLocation(), Color.BLUE);
					Bukkit.broadcastMessage(ChatColor.DARK_BLUE + event.getPlayer().getName() + ChatColor.GRAY + ChatColor.BOLD + " NOW HAS A GLASS BOTTLE!");
				}
				if(CW.getInstance().getRedTeam().contains(event.getPlayer().getName()))
				{
					Methods.glassFirework(event.getPlayer().getLocation(), Color.RED);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + event.getPlayer().getName() + ChatColor.GRAY + ChatColor.BOLD + " NOW HAS A GLASS BOTTLE!");
				}
				for(Player p : Bukkit.getOnlinePlayers())
					p.playSound(p.getLocation(), Sound.FIREWORK_TWINKLE2, 15, 1);
			}
			else
			{
				CW.getInstance().getLogger().severe(event.getPlayer().getName() + " picked up an item that was not a glass bottle! Item: " + event.getItem().getItemStack().getType().toString());
			}
		}
	}

}

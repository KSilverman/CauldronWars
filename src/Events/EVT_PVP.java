package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Misc.GameState;
import Misc.Methods;

public class EVT_PVP implements Listener{
	
	private int taskId = 0;
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
	{
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			if(!(event.getEntity() instanceof Player))
			{
				return;
			}
			final Player victim = (Player) event.getEntity();
			Player attacker = null;
			if (event.getDamager() instanceof Player)
			{
				attacker = (Player) event.getDamager();
			} 
			else if (event.getDamager() instanceof Arrow) 
			{
				Arrow arrow = (Arrow) event.getDamager();
				if (!(arrow.getShooter() instanceof Player))
				{
					return;
				}
				attacker = (Player) arrow.getShooter();
				arrow.remove();
			} 
			else if (event.getDamager() instanceof Snowball)
			{
				Snowball snowball = (Snowball) event.getDamager();
				if (!(snowball.getShooter() instanceof Player))
				{
					return;
				}
				attacker = (Player) snowball.getShooter();
				if(!(Methods.sameTeam(victim, attacker)))
				{
					if(CW.getInstance().getClasses().getYetiMembers().contains(attacker.getName()))
					{
						if(!(CW.getInstance().getFrozen().containsKey(victim.getName())))
						{
							CW.getInstance().getFrozen().put(victim.getName(), 3);
						}
						taskId = CW.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(CW.getInstance(), new Runnable()
						{

							public void run()
							{
								CW.getInstance().getFrozen().put(victim.getName(), CW.getInstance().getFrozen().get(victim.getName()) - 1);
								if(CW.getInstance().getFrozen().get(victim.getName()) == 0)
								{
									CW.getInstance().getFrozen().remove(victim.getName());
	       					  		victim.sendMessage(ChatColor.GREEN + "§lYou Are UnFrozen!");
	       					  		CW.getInstance().getServer().getScheduler().cancelTask(taskId);
	       					  		taskId = 0;
								}
							}       		   
						}, 0L, 20L);
					}
				}	
			}
			if (victim == attacker) 
			{
				return;
			}
			
			if (attacker == null)
			{
				return;
			}
			if (Methods.sameTeam(victim, attacker))
			{
				event.setCancelled(true);
			}
		}
	}		
}

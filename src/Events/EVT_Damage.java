package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import Misc.GameState;

public class EVT_Damage implements Listener{
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) 
	{		
		if(!(event.getEntity() instanceof Player))
			return;
		
		Player player = (Player) event.getEntity();
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
			event.setCancelled(true);
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
				if(CW.getInstance().getBlueTeam().contains(CW.getInstance().getGame().getThrower()) && CW.getInstance().getBlueTeam().contains(player.getName()))
				{
					event.setCancelled(true);
					CW.getInstance().getGame().setThrower(" ");
				}
				if(CW.getInstance().getRedTeam().contains(CW.getInstance().getGame().getThrower()) && CW.getInstance().getRedTeam().contains(player.getName()))
				{
					event.setCancelled(true);
					CW.getInstance().getGame().setThrower(" ");
				}
			}
		}
}

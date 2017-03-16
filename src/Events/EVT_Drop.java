package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class EVT_Drop implements Listener{
	
	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent event) 
	{
		event.setCancelled(true);
	}

}

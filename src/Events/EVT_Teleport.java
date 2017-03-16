package Events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class EVT_Teleport implements Listener{
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event)
	{
	  Player player = event.getPlayer();
	  TeleportCause cause = event.getCause();
	  Location to = event.getTo();
	 
	  if(cause == TeleportCause.ENDER_PEARL)
	  {
	    event.setCancelled(true);
	    player.teleport(to);
	  }
	}

}

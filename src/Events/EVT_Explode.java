package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EVT_Explode implements Listener{
	
	@EventHandler
    public void onEntityExplode(EntityExplodeEvent event)
	  {
		event.blockList().clear();  
	    event.getLocation().getWorld().createExplosion(event.getLocation().getX(), event.getLocation().getY(), event.getLocation().getZ(), 4, false, false);
	  }

}

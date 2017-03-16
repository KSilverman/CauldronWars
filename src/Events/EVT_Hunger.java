package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EVT_Hunger implements Listener{
	
	@EventHandler
	public void onHungerChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

}

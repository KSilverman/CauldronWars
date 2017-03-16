package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import Misc.GameState;

public class EVT_Ping implements Listener {
	
	@EventHandler
	public void onServerListPing(ServerListPingEvent event)
	{
		if(CW.getInstance().getGameState().getState().equalsIgnoreCase(GameState.IN_LOBBY))
			{
				event.setMotd("&a&lJOIN NOW");
			} 
		else if(CW.getInstance().getGameState().getState().equalsIgnoreCase(GameState.IN_GAME))
			{
				event.setMotd("&6&lIN PROGRESS");
			} 
		else
			{
				event.setMotd("&c&lRESTARTING");
			}
	}

}

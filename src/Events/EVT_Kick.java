package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import Misc.GameState;
import Misc.Methods;

public class EVT_Kick implements Listener{
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent event)
	{
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
		{
			event.setLeaveMessage(null);
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			event.setLeaveMessage(null);
			if(CW.getInstance().getBlueTeam().contains(event.getPlayer().getName()))
				CW.getInstance().getBlueTeam().remove(event.getPlayer().getName());
			if(CW.getInstance().getRedTeam().contains(event.getPlayer().getName()))
				CW.getInstance().getRedTeam().remove(event.getPlayer().getName());
			if(CW.getInstance().getSpecs().contains(event.getPlayer().getName()))
				CW.getInstance().getSpecs().remove(event.getPlayer().getName());
			Methods.checkNoPlayers();
		}
		
		
	}

}

package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import Misc.GameState;

public class EVT_Block implements Listener{
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) 
	{
		if(CW.getInstance().getSpecs().contains(event.getPlayer().getName()))
			event.setCancelled(true);
		if(CW.getInstance().getGameState().getState() != GameState.IN_GAME)
			event.setCancelled(true);
	}

}

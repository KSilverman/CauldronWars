package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import Misc.GameState;
import Misc.Locations;

public class EVT_Respawn implements Listener{
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event)
	{
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			event.getPlayer().getInventory().setArmorContents(
					new ItemStack[] { new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR) });
			CW.getInstance().getClasses().giveItem(event.getPlayer());
			CW.getInstance().getClasses().givePotions();
			if(CW.getInstance().getBlueTeam().contains(event.getPlayer().getName()))
				event.setRespawnLocation(Locations.getBlueRespawnLocation());
			if(CW.getInstance().getRedTeam().contains(event.getPlayer().getName()))
				event.setRespawnLocation(Locations.getRedRespawnLocation());
			if(CW.getInstance().getSpecs().contains(event.getPlayer().getName()))
				event.setRespawnLocation(Locations.getBottleSpawn());
		}
	}

}

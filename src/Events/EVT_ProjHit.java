package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import Misc.GameState;
import Misc.Methods;

public class EVT_ProjHit implements Listener{

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event)
	{
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
		  if(event.getEntity() instanceof Arrow)
		  {
			    Arrow arrow = (Arrow) event.getEntity();
			    arrow.remove();
		  } 
		  else if(event.getEntity() instanceof Egg)
		  {
			  Egg l = (Egg) event.getEntity();
			  Location hit = l.getLocation();
			  World world = Bukkit.getWorld("world");
			
			  double i = hit.getX();
			  double j = hit.getY();
			 
			  double k = hit.getZ();
			 
			  int r = 5;
			  int rsquared = r*r;
			  for(int x = -r; x < r; x++){
				  for(int z = -r; z < r; z++){
			          	if(x*x + z*z > rsquared)
			          		continue;
			          	Location loc = new Location(world, i+x, j + 10, k+z);
			          	TNTPrimed tnt = (TNTPrimed) world.spawnEntity(loc, EntityType.PRIMED_TNT);
			          	tnt.setFuseTicks(40);					  
			     }
			  }
		  } 
		  else if(event.getEntity() instanceof WitherSkull)
		  {
			WitherSkull l = (WitherSkull) event.getEntity();
			Location hit = l.getLocation();
			World world = Bukkit.getWorld("world");
			Methods.shootFirework(hit);
			int r = 2;
			int rsquared = r*r;
			for(int x = -r; x < r; x++){
			     for(int z = -r; z < r; z++){
			          if(x*x + z*z > rsquared)
			               continue;
			world.createExplosion(hit.getX() + x, hit.getY(), hit.getZ() + z, 4, false, false);
			     	}
				}
		  	}
		}
	}
}

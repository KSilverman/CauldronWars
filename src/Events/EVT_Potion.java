package Events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;

import Misc.Methods;

public class EVT_Potion implements Listener{
	
	@EventHandler
	public void onPotionSplash(PotionSplashEvent e) 
	{
	    boolean cancel = true;
	    for(PotionEffect effect : e.getEntity().getEffects()) {
	        if(effect.getType().getName().equalsIgnoreCase("harm") ||
	        effect.getType().getName().equalsIgnoreCase("weakness")) { 
	            cancel = false;
	        }
	    }
	    if(cancel) return;
	 
	    if(!(e.getPotion().getShooter() instanceof Player)) {
	        return;
	    }
	 
	    Player attacker = (Player) e.getPotion().getShooter();
	 
	    Player victim = null;
	    for(LivingEntity entity : e.getAffectedEntities()) {
	        if(entity instanceof Player) {
	            victim = (Player) entity;
	            if(victim == attacker) {
	                continue;
	            }
	            if(Methods.sameTeam(victim, attacker)) {
	                e.setIntensity(victim, 0);
	            }
	        }
	    }
	}

}

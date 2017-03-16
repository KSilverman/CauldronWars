package Objects;


import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Misc.Locations;

public class BottleCountdown {
 	int time;
    int id;
    int[] intervals = new int[] { 90, 60, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    
    
    
    public void startCountdown(final int seconds)
    {
        this.time = seconds;
        this.id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(CW.getInstance(), new Runnable()
        {
            
            
            @Override
            public void run()
            {
                if (time > 0)
                {
                    for (int interval : intervals)
                    {
                        if (time == interval)
                        {
                        	if(time == 90 || time == 60 || time == 10)
                        	{
                        		Bukkit.getServer().broadcastMessage(CW.getInstance().getStarter() +  "§6A glass bottle spawns in the center in " + "§4§l" + time + " §6seconds!");
                        	}
                        	
                            for (Player p : Bukkit.getServer().getOnlinePlayers())
                            {
                                p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);
                            }
                            
                        }
                    }
                    for(Player p : Bukkit.getOnlinePlayers())
                    	p.setLevel(time);
                    time--;
                }
                else
                {
                	CW.getInstance().getServer().getScheduler().runTaskLater(CW.getInstance(), new Runnable() 
                	{
        	              public void run() 
        	              {
        	                ItemStack gl = new ItemStack(Material.GLASS_BOTTLE, 1);
        	                Bukkit.getWorld("world").dropItemNaturally(Locations.getBottleSpawn(), gl);
        	              }
        	            }
        	            , 1L);
                	for (Player player : Bukkit.getOnlinePlayers())
              	      player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 15.0F, 1.0F);
                    System.out.println("BottleCountdown is finished. Starting it up again."); 
                    cancelCountdown(id);
                	CW.getInstance().getBottleCountdown().startCountdown(seconds);
                }
            }
        }, 20L, 20L);
    }
    
    
    
    public void cancelCountdown(int taskID)
    {
        Bukkit.getServer().getScheduler().cancelTask(taskID);
    }
    
    public int getTaskID()
    {
    	return id;
    }
    
    public void setTime(int x)
    {
    	this.time = x;
    }
    
    public int getTime()
    {
        return time;
    }
}

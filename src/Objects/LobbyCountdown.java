package Objects;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Misc.Locations;
import Misc.Methods;

public class LobbyCountdown {
	int time;
    int id;
    int[] intervals = new int[] { 120, 60, 30, 15, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    
    
    
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
                        	if(time == 120)
                        	{
                        		Bukkit.getServer().broadcastMessage(CW.getInstance().getStarter() +  "§bThe game starts in " + "§9§l" + time/60 + " §bminutes!");
                        	}
                        	else if(time == 60)
                        	{
                        		Bukkit.getServer().broadcastMessage(CW.getInstance().getStarter() +  "§bThe game starts in " + "§9§l" + time/60 + " §bminute!");
                        	}
                        	else
                        	{
                        		Bukkit.getServer().broadcastMessage(CW.getInstance().getStarter() +  "§bThe game starts in " + "§9§l" + time + " §bseconds!");
                        	}                       	
                            for (Player p : Bukkit.getServer().getOnlinePlayers())
                                p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 2.0F);                          
                        }
                    }
                    for(Player p : Bukkit.getOnlinePlayers())
                    {
                    	p.setLevel(time);
                    	Methods.startingBoard(p);
                    }
                    time--;
                }
                else
                {
                	if(Bukkit.getOnlinePlayers().length >= 2)
        			{
                        cancelCountdown(id);
        				CW.getInstance().getGame().start();
        				CW.getInstance().getGame().init_gamecountdown(90);
                        System.out.println("LobbyCountdown is finished. Starting up BotttleCountdown.");
        				Bukkit.broadcastMessage(ChatColor.BLACK + "§l-" + ChatColor.RED + "§lTHE GAME HAS BEGUN!" + ChatColor.BLACK + "§l-");
        				Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Stuck? Do " + ChatColor.RESET + ChatColor.UNDERLINE + "/gf");
        				Bukkit.broadcastMessage("\n" + ChatColor.GREEN + "" + ChatColor.BOLD + "A GLASS BOTTLE HAS SPAWNED IN THE CENTER! RUSH TO GET THE BOTTLE!\n");
           				for (Player player : Bukkit.getOnlinePlayers())
        					player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 15.0F, 1.0F);
           				CW.getInstance().getServer().getScheduler().runTaskLater(CW.getInstance(), new Runnable() 
                    	{
            	              public void run() 
            	              {
            	                ItemStack gl = new ItemStack(Material.GLASS_BOTTLE, 1);
            	                Bukkit.getWorld("world").dropItemNaturally(Locations.getBottleSpawn(), gl);
            	              }
            	            }
            	            , 1L);
        			}
        			else
        			{
        				cancelCountdown(id);
        				Bukkit.broadcastMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + "Not enough players! Resetting timer!");
        				CW.getInstance().getLobbyCountdown().startCountdown(seconds);
                        System.out.println("LobbyCountdown is finished, but there were not enough players, so it is starting up again.");
        			}
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

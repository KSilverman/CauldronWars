package Misc;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Locations {
	
	public static Location respawnLocationBlue;
	public static Location respawnLocationRed;
	public static Location bottleLocation;
	public static Location cauldronLocationBlue;
	public static Location cauldronLocationRed;
	
	public static void respawnPlayers()
	{
		 switch(CW.getInstance().getRandomNumber(4, 1)) 
		 {
	        case 1:
	            respawnLocationBlue = new Location(Bukkit.getWorld("world"), -2, 69, 386);
	            respawnLocationRed = new Location(Bukkit.getWorld("world"), -2, 70, 254);
	            cauldronLocationBlue = new Location(Bukkit.getWorld("world"), -3, 62, 375);
	            cauldronLocationRed = new Location(Bukkit.getWorld("world"), -3, 62, 265);
	            bottleLocation = new Location(Bukkit.getWorld("world"), -2.37, 62.5, 321.0);
	            break;
	        case 2:
	            respawnLocationBlue = new Location(Bukkit.getWorld("world"), -26, 52, -456);
	            respawnLocationRed = new Location(Bukkit.getWorld("world"), -160, 52, -456);
	            cauldronLocationBlue = new Location(Bukkit.getWorld("world"), -62, 47, -457);
	            cauldronLocationRed = new Location(Bukkit.getWorld("world"), -126, 47, -457);
	            bottleLocation = new Location(Bukkit.getWorld("world"), -93, 47, -456);
	            break;
	        case 3:
	        	respawnLocationBlue = new Location(Bukkit.getWorld("world"), -361.5, 50, -97.5);
	            respawnLocationRed = new Location(Bukkit.getWorld("world"), -361.5, 50, -271.5);
	            cauldronLocationBlue = new Location(Bukkit.getWorld("world"), -361, 44, -118);
	            cauldronLocationRed = new Location(Bukkit.getWorld("world"), -361, 44, -250);
	            bottleLocation = new Location(Bukkit.getWorld("world"), -361.5, 45, -184.5);
	            break;
	        case 4:
	            respawnLocationBlue = new Location(Bukkit.getWorld("world"), 113.5D, 71.0D, -97.5D);
	            respawnLocationRed = new Location(Bukkit.getWorld("world"), 209.5D, 71.0D, -97.5D);
	            cauldronLocationBlue = new Location(Bukkit.getWorld("world"), 119.0D, 67.0D, -97.0D);
	            cauldronLocationRed = new Location(Bukkit.getWorld("world"), 203.0D, 67.0D, -97.0D);
	            bottleLocation = new Location(Bukkit.getWorld("world"), 161.5D, 67.0D, -97.5D);
	        	break;
	    }
	 }
	 
	 	public static Location getBlueRespawnLocation()
	 	{
		    return respawnLocationBlue;
		}
		 
		public static Location getRedRespawnLocation()
		{
		    return respawnLocationRed;
		}
		
		public static Location getBlueCauldronLocation()
		{
			return cauldronLocationBlue;
		}
			 
		public static Location getRedCauldronLocation()
		{
			return cauldronLocationRed;
		}
		
		public static Location getBottleSpawn()
		{
			return bottleLocation;
		}
}

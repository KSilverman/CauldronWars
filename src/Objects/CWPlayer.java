package Objects;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CWPlayer {
	
	private String name;
	private double points;
	private double kills;
	private double deaths;
	private double captures;
	
	public CWPlayer()
	{
		
	}

    @SuppressWarnings("deprecation")
	public Player getPlayer()
    {
        return Bukkit.getServer().getPlayerExact(name);
    }   
    
    
    public static CWPlayer getCWPlayer(String name)
    {
        return CW.getInstance().getCWPlayers().get(name);
    }
      
    
    public static CWPlayer getCWPlayer(Player player)
    {
        return CW.getInstance().getCWPlayers().get(player.getName());
    }

	public double getPoints()
	{
		return points;
	}

	public void setPoints(double points)
	{
		this.points = points;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getKills()
	{
		return kills;
	}

	public void setKills(double kills) 
	{
		this.kills = kills;
	}

	public double getDeaths() 
	{
		return deaths;
	}

	public void setDeaths(double deaths) 
	{
		this.deaths = deaths;
	}

	public double getCaptures()
{
		return captures;
	}

	public void setCaptures(double captures)
	{
		this.captures = captures;
	}
	
	public void save()
	{
		try
		{
			CW.getInstance().getSQL().changePlayerStat(getPlayer(), "points", points);
			CW.getInstance().getSQL().changePlayerStat(getPlayer(), "captures", captures);
			CW.getInstance().getSQL().changePlayerStat(getPlayer(), "kills", kills);
			CW.getInstance().getSQL().changePlayerStat(getPlayer(), "deaths", deaths);
			CW.getInstance().getLogger().info("[CAULDRON WARS] Saved player data for " + name + "!");
		}
		catch(Exception e)
		{
			CW.getInstance().getLogger().info("[CAULDRON WARS] Was NOT able to save player data for " + name + "!");
			e.printStackTrace();
		}
	}

}

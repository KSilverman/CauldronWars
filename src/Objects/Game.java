package Objects;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Misc.GameState;
import Misc.Locations;
import Misc.Methods;

public class Game {
	int redpoints;
	int bluepoints;
	int redkills;
	int bluekills;
	String thrower;
	
	public Game()
	{
		redpoints = 0;
		bluepoints = 0;
		redkills = 0;
		bluekills = 0;
		thrower = "";
	}
	
	public void start()
	{
		CW.getInstance().getGameState().setInGame();
		Locations.respawnPlayers();
		for(Player p : Bukkit.getOnlinePlayers())
		{
            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.getWorld().setTime(0);
            Methods.setScoreBoard(p);
            if(!(CW.getInstance().getPlayerKillStreaks().containsKey(p.getName())))
            	CW.getInstance().getPlayerKillStreaks().put(p.getName(), 0);
		}
		CW.getInstance().getClasses().giveDefaultClasses();
		CW.getInstance().getClasses().giveItems();
		CW.getInstance().getClasses().givePotions();
		splitTeams();
	}
	
	public void end()
	{
		CW.getInstance().getGameState().setGameState(GameState.GAME_RESETING);
		Bukkit.broadcastMessage(CW.getInstance().getStarter() + "§6§lServer Restarting...");
		for(Player p : Bukkit.getOnlinePlayers())
		{
			p.teleport(p.getWorld().getSpawnLocation());
			p.setAllowFlight(false);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			p.getInventory().setArmorContents(
					new ItemStack[] { new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR) });
			p.closeInventory();
			Methods.sendToHub(p);
		}
		for(CWPlayer cp : CW.getInstance().getCWPlayers().values())
		{
			cp.save();
		}
		Methods.clearAllLists();
		CW.getInstance().getServer().shutdown();
	}
	
	@SuppressWarnings("deprecation")
	private void splitTeams()
	{
		removeExcessPlayers();
		for(Player p : Bukkit.getOnlinePlayers())
		{
			if(CW.getInstance().getPicked().contains(p.getName()))
			{
				if(CW.getInstance().getBlueTeam().contains(p.getName()))
				{
					Methods.setListName(p, ChatColor.DARK_BLUE + p.getName());
				}
				else if(CW.getInstance().getRedTeam().contains(p.getName()))
				{
					Methods.setListName(p, ChatColor.DARK_RED + p.getName());
				}
				else
				{
					p.sendMessage(ChatColor.RED + "Team Not Defined!\n" + ChatColor.DARK_GREEN + "Report The Developers About This Bug:" + ChatColor.DARK_AQUA + " @TheParkMC");
					Methods.sendToHub(p);
				}
				CW.getInstance().getPicked().remove(p.getName());
			}
			else
			{
				if(CW.getInstance().getRedTeam().size() > CW.getInstance().getBlueTeam().size())
				{
					CW.getInstance().getBlueTeam().add(p.getName());
					Methods.setListName(p, ChatColor.DARK_BLUE + p.getName());
				}
				else if(CW.getInstance().getRedTeam().size() < CW.getInstance().getBlueTeam().size())
				{
					CW.getInstance().getRedTeam().add(p.getName());
					Methods.setListName(p, ChatColor.DARK_RED + p.getName());
				}
				else
				{
					CW.getInstance().getRedTeam().add(p.getName());
					Methods.setListName(p, ChatColor.DARK_RED + p.getName());
				}
			}
			p.setGameMode(GameMode.SURVIVAL);
		}
		
		for(String s : CW.getInstance().getBlueTeam())
		{
			if ((s != null) && (Bukkit.getPlayer(s) != null))
			{
				Bukkit.getPlayer(s).sendMessage("§1§lYou Are On The BLUE Team!");
				Bukkit.getPlayer(s).teleport(Locations.respawnLocationBlue);
			}
		}
		for (String r : CW.getInstance().getRedTeam())
		{
			if ((r != null) && (Bukkit.getPlayer(r) != null))
			{
				Bukkit.getPlayer(r).sendMessage("§4§lYou Are On The RED Team!");
				Bukkit.getPlayer(r).teleport(Locations.respawnLocationRed);
			}
		}
		
		CW.getInstance().getPicked().clear();		
	}
	
	@SuppressWarnings("deprecation")
	private void removeExcessPlayers()
	{
		for(String s : CW.getInstance().getBlueTeam())
		{
			if(!(Bukkit.getPlayer(s).isOnline()))
				CW.getInstance().getBlueTeam().remove(s);
		}
		for(String r : CW.getInstance().getRedTeam())
		{
			if(!(Bukkit.getPlayer(r).isOnline()))
				CW.getInstance().getRedTeam().remove(r);
		}
	}
	
	public void init_gamecountdown(int seconds)
	{
		CW.getInstance().getBottleCountdown().startCountdown(seconds);
		if(CW.getInstance().getBottleCountdown().getTime() == 0)
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
        	CW.getInstance().getBottleCountdown().startCountdown(seconds);
		}
	}
	
	public int getRedPoints()
	{
		return redpoints;
	}
	
	public int getBluePoints()
	{
		return bluepoints;
	}
	
	public int getRedKills()
	{
		return redkills;		
	}
	
	public int getBlueKills()
	{
		return bluekills;
	}
	
	public String getThrower()
	{
		return thrower;
	}
	
	public void setRedPoints(int x)
	{
		redpoints = x;
	}
	
	public void setBluePoints(int x)
	{
		bluepoints = x;
	}
	
	public void setBlueKills(int x)
	{
		bluekills = x;
	}
	
	public void setRedKills(int x)
	{
		redkills = x;
	}
	
	public void setThrower(String player)
	{
		thrower = player;
	}

}

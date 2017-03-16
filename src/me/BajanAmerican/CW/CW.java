package me.BajanAmerican.CW;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import Commands.CMD_Global;
import Commands.CMD_Hub;
import Commands.CMD_ShowTeams;
import Commands.CMD_Stat;
import Commands.CMD_Team;
import Commands.CMD_Time;
import Commands.CMD_gf;
import Commands.SimpleCommand;
import Events.EVT_Block;
import Events.EVT_Chat;
import Events.EVT_Damage;
import Events.EVT_Death;
import Events.EVT_Drop;
import Events.EVT_Explode;
import Events.EVT_Hunger;
import Events.EVT_Interact;
import Events.EVT_InvClick;
import Events.EVT_Join;
import Events.EVT_Kick;
import Events.EVT_Move;
import Events.EVT_PVP;
import Events.EVT_Pickup;
import Events.EVT_Ping;
import Events.EVT_Potion;
import Events.EVT_PreJoin;
import Events.EVT_ProjHit;
import Events.EVT_Quit;
import Events.EVT_Respawn;
import Events.EVT_Tag;
import Events.EVT_Teleport;
import Events.EVT_Weather;
import Misc.GameState;
import Misc.Methods;
import Objects.BottleCountdown;
import Objects.CWPlayer;
import Objects.Classes;
import Objects.Game;
import Objects.LobbyCountdown;
import Objects.SQL;

public class CW extends JavaPlugin {

	private static CW instance;

	GameState gamestate;
	Game game;
	Classes classes;

	LobbyCountdown lbc;
	BottleCountdown bcd;
	
	Scoreboard scoreboard;

	SQL sql;

	List<String> owners;
	List<String> admins;
	List<String> mods;
	List<String> coders;
	List<String> builders;
	List<String> vips;
	List<String> gods;
	List<String> legends;
	List<String> masters;

	List<String> blue;
	List<String> red;
	List<String> specs;
	List<String> picked;
	List<String> hasBottle;

	Map<String, CWPlayer> cwplayers;
	Map<String, Integer> frozen;
	Map<String, Integer> cantLight;
	Map<String, Integer> playerkillstreak;

	@Override
	public void onEnable()
	{
		instance = this;
		owners = new ArrayList<String>();
		admins = new ArrayList<String>();
		mods = new ArrayList<String>();
		coders = new ArrayList<String>();
		builders = new ArrayList<String>();
		vips = new ArrayList<String>();
		gods = new ArrayList<String>();
		legends = new ArrayList<String>();
		masters = new ArrayList<String>();
		blue = new ArrayList<String>();
		red = new ArrayList<String>();
		specs = new ArrayList<String>();
		picked = new ArrayList<String>();
		hasBottle = new ArrayList<String>();
		cwplayers = new HashMap<String, CWPlayer>();
		frozen = new HashMap<String, Integer>();
		cantLight = new HashMap<String, Integer>();
		playerkillstreak = new HashMap<String, Integer>();
		gamestate = new GameState();
		game = new Game();
		sql = new SQL();
		lbc = new LobbyCountdown();
		bcd = new BottleCountdown();
		classes = new Classes();
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Methods.clearAllLists();
		Methods.doMapStuff();
		init_events();
		init_commands();
		gamestate.setInLobby();
		Bukkit.getWorld("world").setSpawnLocation(-115, 57, -101);
		init_lobbycountdown(120);
		System.out.println("ENABLED!");
	}

	@Override
	public void onDisable()
	{
		try
		{
			if(sql.getConnection() != null && !sql.getConnection().isClosed())
			{
				sql.getConnection().close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		Methods.clearAllLists();
		Methods.doMapStuff();
		System.out.println("DISABLED!");
	}

	private void init_events()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EVT_Join(), this);
		pm.registerEvents(new EVT_Ping(), this);
		pm.registerEvents(new EVT_Death(), this);
		pm.registerEvents(new EVT_Damage(), this);
		pm.registerEvents(new EVT_Explode(), this);
		pm.registerEvents(new EVT_Respawn(), this);
		pm.registerEvents(new EVT_Block(), this);
		pm.registerEvents(new EVT_Weather(), this);
		pm.registerEvents(new EVT_Hunger(), this);
		pm.registerEvents(new EVT_Teleport(), this);
		pm.registerEvents(new EVT_Potion(), this);
		pm.registerEvents(new EVT_Kick(), this);
		pm.registerEvents(new EVT_Drop(), this);
		pm.registerEvents(new EVT_ProjHit(), this);
		pm.registerEvents(new EVT_PreJoin(), this);
		pm.registerEvents(new EVT_Tag(), this);
		pm.registerEvents(new EVT_Pickup(), this);
		pm.registerEvents(new EVT_Quit(), this);
		pm.registerEvents(new EVT_PVP(), this);
		pm.registerEvents(new EVT_Interact(), this);
		pm.registerEvents(new EVT_Chat(), this);
		pm.registerEvents(new EVT_InvClick(), this);
		pm.registerEvents(new EVT_Move(), this);
	}

	private void init_commands()
	{
		SimpleCommand.registerCommands(this, new CMD_Time());
		SimpleCommand.registerCommands(this, new CMD_ShowTeams());
		SimpleCommand.registerCommands(this, new CMD_Stat());
		SimpleCommand.registerCommands(this, new CMD_Global());
		SimpleCommand.registerCommands(this, new CMD_gf());
		SimpleCommand.registerCommands(this, new CMD_Hub());
		SimpleCommand.registerCommands(this, new CMD_Team());
	}

	public void init_lobbycountdown(int seconds)
	{
		getLobbyCountdown().startCountdown(seconds);
		if(getLobbyCountdown().getTime() <= 0)
		{

			if(Bukkit.getOnlinePlayers().length >= 2)
			{
				game.start();
				for (Player player : Bukkit.getOnlinePlayers())
				{
					player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 15.0F, 1.0F);
					Bukkit.broadcastMessage(ChatColor.BLACK + "§l-" + ChatColor.RED + "§lTHE GAME HAS BEGUN!" + ChatColor.BLACK + "§l-");
					Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Stuck? Do " + ChatColor.RESET + ChatColor.UNDERLINE + "/gf");
				}
			}
			else
			{
				Bukkit.broadcastMessage(getStarter() + ChatColor.DARK_RED + "Not enough players! Resetting timer!");
				getLobbyCountdown().startCountdown(seconds);
			}
		}
	}

	public static CW getInstance()
	{
		return instance;
	}

	public String getStarter()
	{
		return ChatColor.GRAY + "[" + ChatColor.ITALIC + "CauldronWars" + ChatColor.GRAY + "] ";
	}

	public String getPermMsg()
	{
		return ChatColor.DARK_RED + "You do not have permission to execute this command.";
	}

	public Map<String, CWPlayer> getCWPlayers()
	{
		return cwplayers;
	}

	public List<String> getOwners()
	{
		return owners;
	}

	public List<String> getAdmins()
	{
		return admins;
	}

	public List<String> getMods()
	{
		return mods;
	}

	public List<String> getBuilders()
	{
		return builders;
	}

	public List<String> getCoders()
	{
		return coders;
	}

	public List<String> getVips()
	{
		return vips;
	}

	public List<String> getGods()
	{
		return gods;
	}

	public List<String> getLegends()
	{
		return legends;
	}

	public List<String> getMasters()
	{
		return masters;
	}

	public List<String> getBlueTeam()
	{
		return blue;
	}

	public List<String> getRedTeam()
	{
		return red;
	}

	public List<String> getSpecs()
	{
		return specs;
	}

	public List<String> getPicked()
	{
		return picked;
	}

	public Map<String, Integer> getPlayerKillStreaks()
	{
		return playerkillstreak;
	}

	public Map<String, Integer> getFrozen()
	{
		return frozen;
	}

	public Map<String, Integer> getCannotLight()
	{
		return cantLight;
	}

	public GameState getGameState()
	{
		return gamestate;
	}

	public Game getGame()
	{
		return game;
	}

	public LobbyCountdown getLobbyCountdown()
	{
		return lbc;
	}

	public BottleCountdown getBottleCountdown()
	{
		return bcd;
	}

	public Classes getClasses()
	{
		return classes;
	}

	public List<String> getBottlePlayer()
	{
		return hasBottle;
	}

	public Scoreboard getScoreboard()
	{
		return scoreboard;
	}

	public SQL getSQL()
	{
		return sql;
	}

	public int getRandomNumber(int Max, int Min)
	{
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}

}

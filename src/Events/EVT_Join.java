package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import Misc.GameState;
import Misc.Locations;
import Misc.Methods;
import Objects.CWPlayer;

public class EVT_Join implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bm = (BookMeta) book.getItemMeta();
		bm.setAuthor(ChatColor.GOLD + player.getName());
		bm.setTitle(ChatColor.DARK_RED + "Cauldron" + ChatColor.DARK_BLUE + " Wars" + ChatColor.BLACK + "!");
		bm.addPage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "CAULDRON WARS!\n" + ChatColor.RESET + "" + ChatColor.BLACK + "-------------------" + ChatColor.RESET + "Welcome To " + ChatColor.DARK_RED + "Cauldron " + ChatColor.DARK_BLUE + "Wars" + ChatColor.BLACK + "!\n" + ChatColor.BLACK + "-------------------", ChatColor.DARK_RED + "" + ChatColor.BOLD + "How To Play!\n" + ChatColor.RESET + "" + ChatColor.BLACK + "-------------------\n" + ChatColor.RESET + "Pick a team(/team " + ChatColor.DARK_RED + "Red" + ChatColor.BLACK + "/" + ChatColor.DARK_BLUE + "Blue" + ChatColor.BLACK + "), and then a class! You’ll spawn at your teams spawn location. When you spawn, fight for the center! Why? A" + ChatColor.GRAY + " §lGlass Bottle " + ChatColor.BLACK + "will spawn in the center every 90 Seconds. You,", "your team, and, the enemy team will fight for this" + ChatColor.GRAY + " §lGlass Bottle" + ChatColor.BLACK + ". If you control the" + ChatColor.GRAY + " §lGlass Bottle" + ChatColor.BLACK + ", you will have to run back to YOUR team's" + ChatColor.DARK_GRAY + " §lCauldron " + ChatColor.BLACK + "and DRAIN a layer of water 1 by 1 until all 3 layers are drained from your team's", ChatColor.DARK_GRAY + "§lCauldron" + ChatColor.BLACK + ". When they are: You Win!", ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Commands!\n" + ChatColor.RESET + "" + ChatColor.BLACK + "-------------------\n" + ChatColor.RESET + "/team (Team Name)-Chooses your team.\n" + "/class (Class Name)-Chooses your class.\n" + "/cinfo (Class Name)-Gives information of the selected class.\n" + "/g (Message)-Globally chat amongst both              teams.\n", "/gf - Fixes you if you’re stuck.\n" + "/censor (On/Off)-Censors swearing in chat if on.", ChatColor.GOLD + "" + ChatColor.BOLD + "Contact Info!\n" + ChatColor.BLACK + "WILL BE FILLED IN LATER!\n" + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "CREDITS!\n" + ChatColor.RESET + "" + ChatColor.GOLD + "Owner of Cauldron Wars & TheParkMC: " + ChatColor.DARK_RED + "§lxhockey" + ChatColor.DARK_RED + "(@xhockeymc)\n" + ChatColor.GOLD + "Coder of Cauldron Wars: " + ChatColor.DARK_BLUE + "§lBajanAmerican" + ChatColor.DARK_BLUE + "(@Bajan_American)\n" + ChatColor.BLACK + "\nThanks For Playing " + ChatColor.DARK_RED + "           Cauldron " + ChatColor.DARK_BLUE + "Wars" + ChatColor.BLACK + "!");
		book.setItemMeta(bm);
		
		
		if(CW.getInstance().getGameState().getState() == GameState.GAME_RESETING)
		{
			Methods.sendToHub(player);
			player.sendMessage(ChatColor.AQUA + "[TheParkMC] " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "You CANNOT Join During Cleanup!");
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
		{
			CW.getInstance().getSQL().playerGiveRanks(player);
			CW.getInstance().getSQL().playerLogin(player);
			event.setJoinMessage(null);
			CW.getInstance().getSpecs().add(player.getName());
			player.sendMessage(CW.getInstance().getStarter() + ChatColor.GOLD + "You are a spectator!");
			Methods.setListName(player, ChatColor.BLACK + player.getName());
			Methods.setScoreBoard(player);
			player.teleport(Locations.getBottleSpawn());
			player.setGameMode(GameMode.CREATIVE);
			player.setHealth(20);
			player.setFoodLevel(20);
			player.getInventory().clear();
			player.getInventory().setArmorContents(
					new ItemStack[] { new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR) });
			player.getInventory().setItem(7, CW.getInstance().getClasses().lobbyCompass);
			for(int i = 0; i < 7; i++)
				player.getInventory().setItem(i, Methods.setName(new ItemStack(Material.CAULDRON_ITEM), "CAULDRON", ChatColor.DARK_GRAY));
			for(Player p : Bukkit.getOnlinePlayers())
				p.hidePlayer(player);
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
		{
			CW.getInstance().getSQL().playerGiveRanks(player);
			CW.getInstance().getSQL().playerLogin(player);
			
			player.sendMessage(ChatColor.AQUA + "Welcome " + ChatColor.RESET + ChatColor.UNDERLINE + player.getName() + ChatColor.AQUA + " To" + ChatColor.DARK_PURPLE + " Cauldron Wars!\n\n");
			
			player.sendMessage(ChatColor.DARK_PURPLE + "\nCauldron Wars!\n" + ChatColor.BLACK + "-----------------\n" + ChatColor.GOLD + "Owned By:" + ChatColor.RESET + ChatColor.ITALIC + ChatColor.BOLD + " xhockey + BajanAmerican\n" + ChatColor.DARK_GREEN + "Developed By:" + ChatColor.WHITE + ChatColor.BOLD + " BajanAmerican\n");
			
			player.sendMessage(ChatColor.AQUA+ "\nThere Are " + ChatColor.DARK_AQUA + String.valueOf(CW.getInstance().getLobbyCountdown().getTime()) + ChatColor.AQUA + " Seconds Until The Game Starts!\n");
			
			if(CW.getInstance().getVips().contains(player.getName()))
			{
				Methods.setListName(player, ChatColor.DARK_PURPLE + player.getName());
				event.setJoinMessage("\n" + ChatColor.DARK_PURPLE + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				}
				else if(CW.getInstance().getMods().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.DARK_AQUA + player.getName());
					event.setJoinMessage("\n" + ChatColor.DARK_AQUA + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				} 
				else if(CW.getInstance().getAdmins().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.RED + player.getName());
					event.setJoinMessage("\n" + ChatColor.RED + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				}
				else if(CW.getInstance().getOwners().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.DARK_RED + player.getName());
					event.setJoinMessage("\n" + ChatColor.DARK_RED + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				} 
				else if(CW.getInstance().getBuilders().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.LIGHT_PURPLE + player.getName());
					event.setJoinMessage("\n" + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				} 
				else if(CW.getInstance().getCoders().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.RED + player.getName());
					event.setJoinMessage("\n" + ChatColor.RED + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				} 
				else if(CW.getInstance().getMasters().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.GRAY + player.getName());
					event.setJoinMessage("\n" + ChatColor.GRAY + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				}
				else if(CW.getInstance().getLegends().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.GOLD + player.getName());
					event.setJoinMessage("\n" + ChatColor.GOLD + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				} 
				else if(CW.getInstance().getGods().contains(player.getName()))
				{
					Methods.setListName(player, ChatColor.AQUA + player.getName());
					event.setJoinMessage("\n" + ChatColor.AQUA + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				} 
				else
				{
					Methods.setListName(player, ChatColor.GREEN + player.getName());
					event.setJoinMessage("\n" + ChatColor.GREEN + player.getName() + ChatColor.AQUA + " Has Joined Cauldron Wars!");
				}
			
			player.setGameMode(GameMode.SURVIVAL);
			player.teleport(Bukkit.getWorld("world").getSpawnLocation());
			player.setHealth(20);
			player.setFoodLevel(20);
			player.setLevel(CW.getInstance().getLobbyCountdown().getTime());
			player.getInventory().clear();
			player.getInventory().setArmorContents(
					new ItemStack[] { new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR),
							new ItemStack(Material.AIR) });
			player.getInventory().setItem(8, book);
			player.getInventory().setItem(7, CW.getInstance().getClasses().lobbyCompass);
			player.getInventory().setItem(1, CW.getInstance().getClasses().teams);
			player.getInventory().setItem(0, CW.getInstance().getClasses().lobbyArrow);
			if(CW.getInstance().getBlueTeam().contains(player.getName()))
			{
				player.getInventory().setHelmet(CW.getInstance().getClasses().bluePickedHats);
				player.getInventory().setItem(1, CW.getInstance().getClasses().blueDye);
			}
			if(CW.getInstance().getRedTeam().contains(player.getName()))
			{
				player.getInventory().setHelmet(CW.getInstance().getClasses().redPickedHats);
				player.getInventory().setItem(1, CW.getInstance().getClasses().redDye);
			}
		}
		
		if(!(CW.getInstance().getCWPlayers().containsKey(player.getName())))
		{
			CWPlayer cwp = new CWPlayer();
			cwp.setName(player.getName());
			cwp.setPoints(CW.getInstance().getSQL().getPlayerStat(player, "points"));
			cwp.setCaptures(CW.getInstance().getSQL().getPlayerStat(player, "captures"));
			cwp.setDeaths(CW.getInstance().getSQL().getPlayerStat(player, "deaths"));
			cwp.setKills(CW.getInstance().getSQL().getPlayerStat(player, "kills"));
			CW.getInstance().getCWPlayers().put(player.getName(), cwp);
		}
	}

}

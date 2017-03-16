package Misc;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.Random;

import me.BajanAmerican.CW.CW;
import net.minecraft.server.v1_7_R3.IInventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Methods {

	public static void sendToHub(Player p)
	{
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try
		{
			out.writeUTF("Connect");
			out.writeUTF("Hub");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		p.sendPluginMessage(CW.getInstance(), "BungeeCord", b.toByteArray());
	}

	public static void msgAdmins(String msg)
	{
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);

		try
		{
			out.writeUTF("Message");
			//out.writeUTF(p.getName());
			out.writeUTF(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//p.sendPluginMessage(CW.getInstance(), "BungeeCord", b.toByteArray());
	}

	public static void setListName(Player player, String name)
	{
		if (name.length() > 16) {
			name = name.substring(0, 16);
		}
		player.setPlayerListName(name);
	}

	public static void checkNoPlayers()
	{
		if ((CW.getInstance().getRedTeam().size() == 0) && (CW.getInstance().getBlueTeam().size() != 0)) 
		{
			Bukkit.broadcastMessage(ChatColor.GREEN + "The " + "§1§lBlue Team " + ChatColor.GREEN + "won!");
			CW.getInstance().getGame().end();
		}
		if ((CW.getInstance().getRedTeam().size() != 0) && (CW.getInstance().getBlueTeam().size() == 0))
		{
			Bukkit.broadcastMessage(ChatColor.GREEN + "The " + "§4§lRed Team " + ChatColor.GREEN + "won!");
			CW.getInstance().getGame().end();
		}
		if ((CW.getInstance().getRedTeam().size() == 0) && (CW.getInstance().getBlueTeam().size() == 0))
			CW.getInstance().getGame().end();
	}

	public static void openArrow(Player player)
	{
		Inventory inv = Bukkit.getServer().createInventory(player, 9, ChatColor.RED + "Kit Selection");
		inv.setItem(0, CW.getInstance().getClasses().archermate);
		inv.setItem(2, CW.getInstance().getClasses().bandanit);
		inv.setItem(5, CW.getInstance().getClasses().golem);
		inv.setItem(8, CW.getInstance().getClasses().mediotic);
		player.openInventory(inv);
	}

	public static void openMasterArrow(Player player)
	{
		Inventory inv = Bukkit.getServer().createInventory(player, 9, ChatColor.RED + "Kit Selection");
		inv.setItem(0, CW.getInstance().getClasses().archermate);
		inv.setItem(1, CW.getInstance().getClasses().bandanit);
		inv.setItem(2, CW.getInstance().getClasses().golem);
		inv.setItem(3, CW.getInstance().getClasses().mediotic);
		inv.setItem(5, CW.getInstance().getClasses().pyro);
		inv.setItem(6, CW.getInstance().getClasses().rabbit);
		inv.setItem(7, CW.getInstance().getClasses().chemy);
		inv.setItem(8, CW.getInstance().getClasses().jack);
		player.openInventory(inv);
	}

	public static void openLegendArrow(Player player)
	{
		Inventory inv = Bukkit.getServer().createInventory(player, 18, ChatColor.RED + "Kit Selection");
		inv.setItem(0, CW.getInstance().getClasses().archermate);
		inv.setItem(1, CW.getInstance().getClasses().bandanit);
		inv.setItem(2, CW.getInstance().getClasses().golem);
		inv.setItem(3, CW.getInstance().getClasses().mediotic);
		inv.setItem(5, CW.getInstance().getClasses().pyro);
		inv.setItem(6, CW.getInstance().getClasses().rabbit);
		inv.setItem(7, CW.getInstance().getClasses().chemy);
		inv.setItem(8, CW.getInstance().getClasses().jack);
		inv.setItem(9, CW.getInstance().getClasses().kraken);
		inv.setItem(10, CW.getInstance().getClasses().rfox);
		inv.setItem(11, CW.getInstance().getClasses().cookie);
		inv.setItem(12, CW.getInstance().getClasses().assassin);
		player.openInventory(inv);
	}

	public static void openGodArrow(Player player)
	{
		Inventory inv = Bukkit.getServer().createInventory(player, 18, ChatColor.RED + "Kit Selection");
		inv.setItem(0, CW.getInstance().getClasses().archermate);
		inv.setItem(1, CW.getInstance().getClasses().bandanit);
		inv.setItem(2, CW.getInstance().getClasses().golem);
		inv.setItem(3, CW.getInstance().getClasses().mediotic);
		inv.setItem(5, CW.getInstance().getClasses().pyro);
		inv.setItem(6, CW.getInstance().getClasses().rabbit);
		inv.setItem(7, CW.getInstance().getClasses().chemy);
		inv.setItem(8, CW.getInstance().getClasses().jack);
		inv.setItem(9, CW.getInstance().getClasses().kraken);
		inv.setItem(10,CW.getInstance().getClasses().rfox);
		inv.setItem(11, CW.getInstance().getClasses().cookie);
		inv.setItem(12, CW.getInstance().getClasses().assassin);
		inv.setItem(14, CW.getInstance().getClasses().jug);
		inv.setItem(15, CW.getInstance().getClasses().zeus);
		inv.setItem(16, CW.getInstance().getClasses().yeti);
		inv.setItem(17, CW.getInstance().getClasses().phoenix);
		player.openInventory(inv);
	}

	public static void openTag(Player player)
	{
		Inventory inv = Bukkit.getServer().createInventory(player, 9, ChatColor.AQUA + "Team Selection");
		inv.setItem(0, CW.getInstance().getClasses().blueteam);
		inv.setItem(8, CW.getInstance().getClasses().redteam);
		player.openInventory(inv);
	}

	public static boolean modUp(Player p)
	{
		if(CW.getInstance().getOwners().contains(p.getName()) || CW.getInstance().getAdmins().contains(p.getName()) || CW.getInstance().getCoders().contains(p.getName()) || CW.getInstance().getMods().contains(p.getName()))
			return true;
		else
			return false;
	}

	public static boolean vipUp(Player p)
	{
		if(CW.getInstance().getOwners().contains(p.getName()) || CW.getInstance().getAdmins().contains(p.getName()) || CW.getInstance().getCoders().contains(p.getName()) || CW.getInstance().getMods().contains(p.getName()) || CW.getInstance().getVips().contains(p.getName()) || CW.getInstance().getBuilders().contains(p.getName()))
			return true;
		else
			return false;
	}

	public static boolean coderUp(Player p)
	{
		if(CW.getInstance().getOwners().contains(p.getName()) || CW.getInstance().getAdmins().contains(p.getName()) || CW.getInstance().getCoders().contains(p.getName()))
			return true;
		else
			return false;
	}

	public static boolean godUp(Player p)
	{
		if(CW.getInstance().getOwners().contains(p.getName()) || CW.getInstance().getAdmins().contains(p.getName()) || CW.getInstance().getCoders().contains(p.getName()) || CW.getInstance().getMods().contains(p.getName()) || CW.getInstance().getVips().contains(p.getName()) || CW.getInstance().getBuilders().contains(p.getName()) || CW.getInstance().getGods().contains(p.getName()))
			return true;
		else
			return false;
	}

	public static boolean legendUp(Player p)
	{
		if(CW.getInstance().getOwners().contains(p.getName()) || CW.getInstance().getAdmins().contains(p.getName()) || CW.getInstance().getCoders().contains(p.getName()) || CW.getInstance().getMods().contains(p.getName()) || CW.getInstance().getVips().contains(p.getName()) || CW.getInstance().getBuilders().contains(p.getName()) || CW.getInstance().getGods().contains(p.getName()) || CW.getInstance().getLegends().contains(p.getName()))
			return true;
		else
			return false;
	}

	public static boolean isRanked(Player p)
	{
		if(CW.getInstance().getOwners().contains(p.getName()) || CW.getInstance().getAdmins().contains(p.getName()) || CW.getInstance().getCoders().contains(p.getName()) || CW.getInstance().getMods().contains(p.getName()) || CW.getInstance().getVips().contains(p.getName()) || CW.getInstance().getBuilders().contains(p.getName()) || CW.getInstance().getGods().contains(p.getName()) || CW.getInstance().getLegends().contains(p.getName()) || CW.getInstance().getMasters().contains(p.getName()))
			return true;
		else
			return false;
	}

	public static boolean sameTeam(Player victim, Player attacker)
	{
		if (CW.getInstance().getRedTeam().contains(victim.getName()) && CW.getInstance().getRedTeam().contains(attacker.getName())) {
			return true;
		} 
		else if (CW.getInstance().getBlueTeam().contains(victim.getName()) && CW.getInstance().getBlueTeam().contains(attacker.getName())) {
			return true;
		} 
		else if(CW.getInstance().getRedTeam().contains(victim.getName()) && CW.getInstance().getSpecs().contains(attacker.getName())){
			return true;
		} 
		else if(CW.getInstance().getBlueTeam().contains(victim.getName()) && CW.getInstance().getSpecs().contains(attacker.getName())){
			return true;
		} 
		else if(CW.getInstance().getSpecs().contains(victim.getName()) && CW.getInstance().getRedTeam().contains(attacker.getName())){
			return true;
		} 
		else if(CW.getInstance().getSpecs().contains(victim.getName()) && CW.getInstance().getBlueTeam().contains(attacker.getName())){
			return true;
		}
		else if(CW.getInstance().getSpecs().contains(victim.getName()) && CW.getInstance().getSpecs().contains(attacker.getName())){
			return true;
		}
		return false;
	}

	public static ItemStack setName(ItemStack is, String name, ChatColor colour)
	{
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(colour + name);
		is.setItemMeta(im);
		return is;
	}

	public static ItemStack setColor(ItemStack is, String Name, Color color, ChatColor colorr)
	{
		LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
		im.setColor(color);
		im.setDisplayName(colorr + Name);
		is.setItemMeta(im);
		return is;
	}

	public static void clearAllLists()
	{
		CW.getInstance().getBlueTeam().clear();
		CW.getInstance().getRedTeam().clear();
		CW.getInstance().getSpecs().clear();
		CW.getInstance().getPlayerKillStreaks().clear();
		CW.getInstance().getBottlePlayer().clear();
		CW.getInstance().getPicked().clear();
		CW.getInstance().getOwners().clear();
		CW.getInstance().getAdmins().clear();
		CW.getInstance().getCoders().clear();
		CW.getInstance().getMods().clear();
		CW.getInstance().getVips().clear();
		CW.getInstance().getBuilders().clear();
		CW.getInstance().getGods().clear();
		CW.getInstance().getLegends().clear();
		CW.getInstance().getMasters().clear();
		CW.getInstance().getCWPlayers().clear();
		CW.getInstance().getFrozen().clear();
		CW.getInstance().getCannotLight().clear();
		CW.getInstance().getClasses().getArcherMembers().clear();
		CW.getInstance().getClasses().getBanditMembers().clear();
		CW.getInstance().getClasses().getGolemMembers().clear();
		CW.getInstance().getClasses().getMedioticMembers().clear();
		CW.getInstance().getClasses().getPyroMembers().clear();
		CW.getInstance().getClasses().getRabbitMembers().clear();
		CW.getInstance().getClasses().getJackMembers().clear();
		CW.getInstance().getClasses().getChemyMembers().clear();
		CW.getInstance().getClasses().getAssassinMembers().clear();
		CW.getInstance().getClasses().getCookieMembers().clear();
		CW.getInstance().getClasses().getKrakenMembers().clear();
		CW.getInstance().getClasses().getFoxMembers().clear();
		CW.getInstance().getClasses().getJugMembers().clear();
		CW.getInstance().getClasses().getZeusMembers().clear();
		CW.getInstance().getClasses().getYetiMembers().clear();
		CW.getInstance().getClasses().getPhenioxMembers().clear();
	}

	public static String getKitName(String player)
	{
		if(CW.getInstance().getClasses().getArcherMembers().contains(player))
			return ChatColor.DARK_GRAY + "§lArcherMate";
		if(CW.getInstance().getClasses().getBanditMembers().contains(player))
			return ChatColor.DARK_GREEN + "§lBandanit";
		if(CW.getInstance().getClasses().getGolemMembers().contains(player))
			return ChatColor.DARK_PURPLE + "§lGolem";
		if(CW.getInstance().getClasses().getMedioticMembers().contains(player))
			return ChatColor.DARK_AQUA + "§lMediotic";
		if(CW.getInstance().getClasses().getPyroMembers().contains(player))
			return ChatColor.GOLD + "§lPyr0";
		if(CW.getInstance().getClasses().getRabbitMembers().contains(player))
			return ChatColor.WHITE + "§lRabbit";
		if(CW.getInstance().getClasses().getChemyMembers().contains(player))
			return ChatColor.WHITE + "§lChemy";
		if(CW.getInstance().getClasses().getJackMembers().contains(player))
			return ChatColor.DARK_RED + "§lLumberJack";
		if(CW.getInstance().getClasses().getKrakenMembers().contains(player))
			return ChatColor.DARK_BLUE + "§lKraken";
		if(CW.getInstance().getClasses().getFoxMembers().contains(player))
			return ChatColor.DARK_RED + "§lRedFox";
		if(CW.getInstance().getClasses().getCookieMembers().contains(player))
			return ChatColor.AQUA + "§lCookie";
		if(CW.getInstance().getClasses().getAssassinMembers().contains(player))
			return ChatColor.DARK_AQUA + "§lAssassin";
		if(CW.getInstance().getClasses().getJugMembers().contains(player))
			return ChatColor.GOLD + "§lJuggernaut";
		if(CW.getInstance().getClasses().getZeusMembers().contains(player))
			return ChatColor.YELLOW + "§lZeus";
		if(CW.getInstance().getClasses().getYetiMembers().contains(player))
			return ChatColor.GRAY + "§lYeti";
		if(CW.getInstance().getClasses().getPhenioxMembers().contains(player))
			return ChatColor.DARK_RED + "§lPheonix";
		return ChatColor.DARK_GRAY + "§lArcherMate";
	}

	public static String getRankName(String player)
	{
		if(CW.getInstance().getMasters().contains(player))
			return ChatColor.DARK_GRAY + "MASTER";
		if(CW.getInstance().getLegends().contains(player))
			return ChatColor.GOLD + "LEGEND";
		if(CW.getInstance().getGods().contains(player))
			return ChatColor.AQUA + "GOD";
		if(CW.getInstance().getOwners().contains(player))
			return ChatColor.DARK_RED + "OWNER";
		if(CW.getInstance().getAdmins().contains(player))
			return ChatColor.RED + "ADMIN";
		if(CW.getInstance().getMods().contains(player))
			return ChatColor.DARK_AQUA + "MOD";
		if(CW.getInstance().getVips().contains(player))
			return ChatColor.DARK_PURPLE + "VIP";
		if(CW.getInstance().getBuilders().contains(player))
			return ChatColor.LIGHT_PURPLE + "MAP MAKER";
		if(CW.getInstance().getCoders().contains(player))
			return ChatColor.RED + "CODER";
		return "NONE";
	}

	private static void unloadMap(String mapname)
	{
		if(!Bukkit.getServer().unloadWorld(Bukkit.getWorld(mapname), false))
			Bukkit.getServer().unloadWorld(Bukkit.getWorld(mapname), false);
	}

	private static void loadMap(String mapname)
	{
		World w = Bukkit.getServer().createWorld(new WorldCreator(mapname));
		w.setAutoSave(false);
	}

	private static void rollback(String mapname)
	{
		unloadMap(mapname);
		loadMap(mapname);
	}

	@SuppressWarnings("deprecation")
	public static void deletePlayerDat(String worldName)
	{
		File playerFilesDir = new File(worldName + "/playerdata");
		if(playerFilesDir.isDirectory())
		{
			String[] playerDats = playerFilesDir.list();
			for (int i = 0; i < playerDats.length; i++) 
			{
				File datFile = new File(playerFilesDir, playerDats[i]); 
				datFile.delete();
				System.out.println("[Cauldron Wars] Deleted player data file for " + CW.getInstance().getServer().getOfflinePlayer(playerDats[i]) + ".dat !");
			}
		}
	}

	public static void deleteUID(String worldName)
	{
		File worldFile = new File(worldName);
		File datFile = new File(worldFile, "uid.dat");
		datFile.delete();
	}

	public static void doMapStuff()
	{
		unloadMap("world");
		loadMap("world");
		rollback("world");
		deletePlayerDat("world");
		deletePlayerDat("map");
		deleteUID("world");
		deleteUID("map");	
	}

	@SuppressWarnings("deprecation")
	public static void setScoreBoard(Player player)
	{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("CauldronWars", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "     §nCauldron Wars" + ChatColor.RESET + "     ");
		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "BLUE POINTS"));
		Score bpoints = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "" + ChatColor.BOLD + String.valueOf(CW.getInstance().getGame().getBluePoints())));
		Score blank2 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "----------"));
		Score scoree = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_RED + "" + ChatColor.BOLD + "RED POINTS"));
		Score rpoints = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "" + ChatColor.BOLD + String.valueOf(CW.getInstance().getGame().getRedPoints())));
		Score blank3 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "----------"));
		Score blank = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "BLUE KILLS"));
		Score bkills = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + String.valueOf(CW.getInstance().getGame().getBlueKills())));
		Score blank4 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.LIGHT_PURPLE + "----------"));
		Score blankk = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_RED + "" + ChatColor.BOLD + "RED KILLS"));
		Score rkills = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + String.valueOf(CW.getInstance().getGame().getRedKills())));
		Score blank5 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA + "----------"));
		Score kit = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "" + ChatColor.BOLD + "Your Kit"));
		Score kitname = objective.getScore(Bukkit.getOfflinePlayer((getKitName(player.getName()))));
		Score blank6 = objective.getScore(Bukkit.getOfflinePlayer((ChatColor.BLACK + "----------")));
		score.setScore(15);
		bpoints.setScore(14);
		blank2.setScore(13);
		scoree.setScore(12);
		rpoints.setScore(11);
		blank3.setScore(10);
		blank.setScore(9);
		bkills.setScore(8);
		blank4.setScore(7);
		blankk.setScore(6);
		rkills.setScore(5);
		blank5.setScore(4);
		kit.setScore(3);
		kitname.setScore(2);
		blank6.setScore(1);
		player.setScoreboard(board);
	}

	@SuppressWarnings("deprecation")
	public static void startingBoard(Player player)
	{
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("CW", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(ChatColor.RED + String.valueOf(CW.getInstance().getLobbyCountdown().getTime()) + ChatColor.GOLD + "" + ChatColor.BOLD + " Seconds");
		Score blank1 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "----------"));
		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_GREEN + "" + ChatColor.UNDERLINE + "Needed:"));
		Score pNeeded = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_RED + "" + ChatColor.BOLD + String.valueOf(2)));
		Score blank2 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "----------"));
		Score players = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_AQUA + "" + ChatColor.UNDERLINE + "Online:"));
		Score playerss = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "" + ChatColor.BOLD + String.valueOf(Bukkit.getOnlinePlayers().length)));
		Score blank3 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "----------"));
		Score kit = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "Your Kit:"));
		Score kitName = objective.getScore(Bukkit.getOfflinePlayer(getKitName(player.getName())));
		Score blank4 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "----------"));
		Score website = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.BLUE + "" + ChatColor.UNDERLINE + "Stats:"));
		Score points = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "/stats"));
		Score blank5 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "----------"));
		blank1.setScore(12);
		score.setScore(11);
		pNeeded.setScore(10);
		blank2.setScore(9);
		players.setScore(8);
		playerss.setScore(7);
		blank3.setScore(6);
		kit.setScore(5);
		kitName.setScore(4);
		blank4.setScore(3);
		website.setScore(2);
		points.setScore(1);
		blank5.setScore(0);
		player.setScoreboard(board);
	}

	public static void shootFirework(Location location)
	{
		Firework fw = (Firework) Bukkit.getWorld("world").spawn(location, Firework.class);
		FireworkMeta fm = fw.getFireworkMeta();
		Random r = new Random();
		int fType = r.nextInt(5) + 1;
		Type type = null;
		switch(fType){
		default:
		case 1:
			type = Type.BALL_LARGE;
			break;
		case 2: 
			type = Type.BALL;
			break;
		case 3:
			type = Type.BURST;
			break;
		case 4:
			type = Type.CREEPER;
			break;
		case 5:
			type = Type.STAR;		
		}
		int c1i = r.nextInt(16) + 1;
		int c2i = r.nextInt(16) +1;
		Color c1 = getColor(c1i);
		Color c2 = getColor(c2i);
		FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
		fm.addEffect(effect);
		int power = r.nextInt(2) + 1;
		fm.setPower(power);
		fw.setFireworkMeta(fm);
	}

	public static void glassFirework(Location location, Color color)
	{
		Firework fw = (Firework) Bukkit.getWorld("world").spawn(location, Firework.class);
		FireworkMeta fm = fw.getFireworkMeta();
		Type type = Type.BALL_LARGE;
		FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(color).with(type).trail(true).build();
		fm.addEffect(effect);
		fm.setPower(1);
		fw.setFireworkMeta(fm);
	}

	public static Color getColor(int c){
		switch(c)
		{
		default:
		case 1:return Color.RED;
		case 2:return Color.AQUA;
		case 3:return Color.BLACK;
		case 4:return Color.BLUE;
		case 5:return Color.FUCHSIA;
		case 6:return Color.LIME;
		case 7:return Color.ORANGE;
		case 8:return Color.OLIVE;
		case 9:return Color.MAROON;
		case 10:return Color.GREEN;
		case 11:return Color.PURPLE;
		case 12:return Color.GRAY;
		case 13:return Color.SILVER;
		case 14:return Color.YELLOW;
		case 15:return Color.TEAL;
		case 16:return Color.WHITE;			
		}
	}

	public static void memoryFix()
	{
		CW.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(CW.getInstance(), new Runnable()
		{
			@SuppressWarnings("rawtypes")
			public void run()
			{
				Iterator localIterator2;
				for (Iterator<World> localIterator1 = Bukkit.getWorlds().iterator(); localIterator1.hasNext(); localIterator2.hasNext())
				{
					World world = (World)localIterator1.next();

					localIterator2 = ((CraftWorld)world).getHandle().tileEntityList.iterator(); 

					Object tileEntity = localIterator2.next();


					if ((tileEntity instanceof IInventory))
					{
						Iterator<HumanEntity> entityIterator = ((IInventory)tileEntity).getViewers().iterator();

						while (entityIterator.hasNext())
						{
							HumanEntity entity = (HumanEntity)entityIterator.next();

							if (((entity instanceof CraftPlayer)) && (!((CraftPlayer)entity).isOnline()))
							{
								entityIterator.remove();
							}
						}
					}
				}
			}
		}
		, 100L, 100L);
	}
}

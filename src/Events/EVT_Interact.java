package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Misc.GameState;
import Misc.Locations;
import Misc.Methods;
import Objects.CWPlayer;

public class EVT_Interact implements Listener{
	
	int taskID;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		final Player player = event.getPlayer();
		CWPlayer cwp = CWPlayer.getCWPlayer(player);
		try
		{
	        if ((event.getClickedBlock().getType() == Material.SIGN) ||
	                (event.getClickedBlock().getType() == Material.SIGN_POST) ||
	                (event.getClickedBlock().getType() == Material.WALL_SIGN))
	        {
	        	if(CW.getInstance().getSpecs().contains(player.getName()))
	        	{
	        		event.setCancelled(true);
	        	}
	        	Sign s = (Sign) event.getClickedBlock().getState();
	        	if (s.getLine(1).equalsIgnoreCase(ChatColor.DARK_RED + "[Class]"))
	        	{
	        		if(Methods.godUp(player))
	        			Methods.openGodArrow(player);
	        		else if(Methods.legendUp(player) && !Methods.godUp(player))
	        			Methods.openLegendArrow(player);
	        		else if(Methods.isRanked(player) && !Methods.legendUp(player))
	        			Methods.openMasterArrow(player);
	        		else
	        			Methods.openArrow(player);
	        	}
	        	else if(s.getLine(0).equalsIgnoreCase(ChatColor.DARK_RED + "[Team]"))
	        	{
	        		String playerClass = s.getLine(2);
            		if(CW.getInstance().getPicked().contains(player.getName()))
            		{
            			player.sendMessage("§8§lYou Are Already On A Team!");
            			return;
            		}
            		if(playerClass.equalsIgnoreCase("§1§lBLUE") || (playerClass.contains("§1§lBLUE")))
            		{
		            	  if((CW.getInstance().getBlueTeam().size() - 1) >= CW.getInstance().getRedTeam().size())
		            	  {
		            		  player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_GREEN + "You are not able to join the " + ChatColor.DARK_BLUE + "BLUE " + ChatColor.DARK_GREEN + "team because it would cause an inbalance of players!");
		            	  } 
		            	  else 
		            	  {
		            		  CW.getInstance().getPicked().add(player.getName());
		            		  CW.getInstance().getBlueTeam().add(player.getName());
		            		  player.sendMessage(ChatColor.GOLD + "Team " + "§1§lBLUE " +  ChatColor.GOLD + "Chosen!");
		            		  player.getInventory().setHelmet(CW.getInstance().getClasses().bluePickedHats);
		            		  player.getInventory().addItem(CW.getInstance().getClasses().blueDye);
		            		  for(String b : CW.getInstance().getBlueTeam())
		            			  Bukkit.getPlayer(b).sendMessage(ChatColor.DARK_BLUE + player.getName() + ChatColor.BLUE + " Has Joined The " + ChatColor.DARK_BLUE + "BLUE " + ChatColor.BLUE + "Team!");
		            	  }
            		}
            		else if(playerClass.equalsIgnoreCase("§4§lRED") || (playerClass.contains("§4§lRED")))
            		{
            			if((CW.getInstance().getRedTeam().size() - 1) >= CW.getInstance().getBlueTeam().size())
		            	  {
		            		  player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_GREEN + "You are not able to join the " + ChatColor.DARK_RED + "RED " + ChatColor.DARK_GREEN + "team because it would cause an inbalance of players!");
		            	  } 
		            	  else 
		            	  {
		            		  CW.getInstance().getPicked().add(player.getName());
		            		  CW.getInstance().getRedTeam().add(player.getName());
		            		  player.sendMessage(ChatColor.GOLD + "Team " + "§4§RED " +  ChatColor.GOLD + "Chosen!");
		            		  player.getInventory().setHelmet(CW.getInstance().getClasses().redPickedHats);
		            		  player.getInventory().addItem(CW.getInstance().getClasses().redDye);
		            		  for(String b : CW.getInstance().getRedTeam())
		            			  Bukkit.getPlayer(b).sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + player.getName() + ChatColor.RED + " Has Joined The " + ChatColor.DARK_RED + "BLUE " + ChatColor.RED + "Team!");
		            	  }
            		}
	        	}
	        	else if(s.getLine(1).equalsIgnoreCase("§1[Shop]"))
	        	{
	            	player.sendMessage(ChatColor.BLACK + "---" + ChatColor.GOLD + "Welcome to the TheParkMC Shop!" + ChatColor.BLACK + "---\n" + "\n" + ChatColor.BLACK + "---   " + ChatColor.DARK_AQUA + "" + ChatColor.UNDERLINE + "http://theparkmc.com/shop" + ChatColor.BLACK + "   ---\n" + "\n" + ChatColor.BLACK + "---" + ChatColor.GOLD + "Click that link to buy a rank!" + ChatColor.BLACK + "---");
	            }
	        	else if(s.getLine(1).equalsIgnoreCase(ChatColor.DARK_RED + "§lYour Stats!"))
	        	{
	        		player.sendMessage(ChatColor.GRAY + player.getName() + ":\n" + ChatColor.YELLOW + "Points: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getPoints()) + "\n" + ChatColor.RED + "Deaths: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getDeaths()) + "\n" + ChatColor.AQUA + "Kills: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getKills()) + "\n" + ChatColor.BLUE + "Captures: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getCaptures()) + "\n" + ChatColor.GOLD + "K/D: " + ChatColor.DARK_GREEN + String.valueOf(roundInt((cwp.getKills() / cwp.getDeaths()), 3)));
	            }
	        	else if(s.getLine(2).equalsIgnoreCase("Right-Click") || s.getLine(2).contains("Right-Click"))
	        	{
		            player.sendMessage(ChatColor.BLUE + "Want To Apply To Be A " + ChatColor.DARK_AQUA + "Moderator" + ChatColor.BLUE + " Or " + ChatColor.DARK_PURPLE + "VIP" + ChatColor.WHITE + ", " + ChatColor.BLUE + "Or Want To Buy A Rank?\n" + "\n" + ChatColor.BLACK + "-----> " + ChatColor.DARK_AQUA + "" + ChatColor.UNDERLINE + "http://theparkmc.com/forums" + ChatColor.BLACK + " <-----\n" + "\n" + ChatColor.BLACK + "--" + ChatColor.BLUE + "Click that link to either buy or apply for a rank!" + ChatColor.BLACK + "--");
		        }
	        }
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			if(event.getItem().getType() == Material.IRON_BARDING)
			{
				Entity e = event.getPlayer().launchProjectile(WitherSkull.class);
	        	e.setVelocity(e.getVelocity().multiply(40));
	        	CW.getInstance().getGame().setThrower(player.getName());
	        	player.getInventory().remove(CW.getInstance().getClasses().killStreak3);
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			if(event.getItem().getType() == Material.MAGMA_CREAM)
			{
				event.setCancelled(true);
				Entity e = event.getPlayer().launchProjectile(Egg.class);
	        	e.setVelocity(e.getVelocity().multiply(5));
	        	CW.getInstance().getGame().setThrower(player.getName());
	        	player.getInventory().remove(CW.getInstance().getClasses().killStreak5);
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				if(event.getClickedBlock().getType() == Material.FURNACE)
				{
	        		event.setCancelled(true);
	        		return;
	        	}
				if(CW.getInstance().getBlueTeam().contains(player.getName()) && event.getClickedBlock().getLocation().equals(Locations.getRedCauldronLocation()))
				{
					event.setCancelled(true);
        			player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_GREEN + "You are not permitted to drain the " + ChatColor.DARK_RED + "RED" + ChatColor.DARK_GREEN + " team's Cauldron!");
        			return;
				}
				if(CW.getInstance().getRedTeam().contains(player.getName()) && event.getClickedBlock().getLocation().equals(Locations.getBlueCauldronLocation()))
				{
					event.setCancelled(true);
        			player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_GREEN + "You are not permitted to drain the " + ChatColor.DARK_BLUE + "BLUE" + ChatColor.DARK_GREEN + " team's Cauldron!");
        			return;
				}
			}
		}
		catch(Exception e)
		{
			
		}
		
		if(event.getPlayer().getItemInHand().getType() == Material.COMPASS)
		{
			if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
			{
				Methods.sendToHub(player);
			}
		}
		
		if(event.getPlayer().getItemInHand().getType() == Material.STONE_AXE)
		{
			if(CW.getInstance().getClasses().getZeusMembers().contains(player.getName()))
			{
				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				{
					if(CW.getInstance().getCannotLight().containsKey(player.getName()))
						return;
					else
					{
						player.getWorld().strikeLightning(event.getPlayer().getTargetBlock(null, 200).getLocation());
						CW.getInstance().getCannotLight().put(player.getName(), 5);
						this.taskID = CW.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(CW.getInstance(), new Runnable()
						{

							public void run() 
							{
			       				CW.getInstance().getCannotLight().put(player.getName(), CW.getInstance().getCannotLight().get(player.getName()) - 1);
			       				   if(CW.getInstance().getCannotLight().get(player.getName()) == 0)
			       				   {
			       					CW.getInstance().getCannotLight().remove(player.getName());
			       					   player.sendMessage(ChatColor.YELLOW + "§lYou can strike again!");
			       					   CW.getInstance().getServer().getScheduler().cancelTask(taskID);
			       				   }
							}
							
						}, 0L, 20L);
					}
				}
			}
		}
		
		if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
		{
			if(event.getPlayer().getItemInHand() != null)
			{
				if(event.getPlayer().getItemInHand().getType() == Material.ARROW)
				{
					if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
					{
						if(Methods.godUp(player))
							Methods.openGodArrow(player);
						else if(Methods.legendUp(player) && !Methods.godUp(player))
							Methods.openLegendArrow(player);
						else if(Methods.isRanked(player) && !Methods.legendUp(player))
							Methods.openMasterArrow(player);
						else
							Methods.openArrow(player);
					}
				}
				else if(event.getPlayer().getItemInHand().getType() == Material.NAME_TAG)
				{
					if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
					{
						Methods.openTag(player);
					}
				}
			}
		}
	}
	
	private double roundInt(double num, int slot)
	{
		int factor = (int) Math.pow(10, slot + 1);
		int temp = (int) (num * (double) factor);
		int digit = temp % 10; 
		temp = temp / 10;

		if (digit >= 5)
		{
			temp++;
		}

		double answer = (double) temp / Math.pow(10, slot);
		return answer;
	}

}

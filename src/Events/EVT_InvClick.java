package Events;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import Misc.GameState;
import Misc.Methods;

public class EVT_InvClick implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInvClick(InventoryClickEvent event)
	{
		if(!(event.getWhoClicked() instanceof Player))
		{
			event.setCancelled(true);
			return;
		}
		
		Player player = (Player) event.getWhoClicked();
		
		event.setCancelled(true);
		
		if(event.getInventory().getName().equals(ChatColor.AQUA + "Team Selection"))
		{
			event.setCancelled(true);
			if(CW.getInstance().getPicked().contains(player.getName()))
			{
				player.sendMessage("§8§lYou Are Already On A Team!");
        		player.closeInventory();
        		return;
			}
			if(event.getCurrentItem().getType() == Material.LAPIS_BLOCK)
			{
				if((CW.getInstance().getBlueTeam().size() - 1) >= CW.getInstance().getRedTeam().size())
				{
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_GREEN + "You are not able to join the " + ChatColor.DARK_BLUE + "BLUE " + ChatColor.DARK_GREEN + "team because it would cause an inbalance of players!");
					player.closeInventory();
					return;
				}
				else
				{
					CW.getInstance().getPicked().add(player.getName());
					CW.getInstance().getBlueTeam().add(player.getName());
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.GOLD + "Team " + "§1§lBLUE " +  ChatColor.GOLD + "Chosen!");
					player.getInventory().setHelmet(CW.getInstance().getClasses().bluePickedHats);
					player.getInventory().setItem(1, CW.getInstance().getClasses().blueDye);
					for(String s : CW.getInstance().getBlueTeam())
						Bukkit.getPlayer(s).sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_BLUE + player.getName() + ChatColor.BLUE + " Has Joined The " + ChatColor.DARK_BLUE + "BLUE " + ChatColor.BLUE + "Team!");
					player.closeInventory();
				}
			}
			else if(event.getCurrentItem().getType() == Material.REDSTONE_BLOCK)
			{
				if((CW.getInstance().getRedTeam().size() - 1) >= CW.getInstance().getBlueTeam().size())
				{
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_GREEN + "You are not able to join the " + ChatColor.DARK_RED + "RED " + ChatColor.DARK_GREEN + "team because it would cause an inbalance of players!");
					player.closeInventory();
					return;
				}
				else
				{
					CW.getInstance().getPicked().add(player.getName());
					CW.getInstance().getRedTeam().add(player.getName());
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.GOLD + "Team " + "§4§lRED " +  ChatColor.GOLD + "Chosen!");
					player.getInventory().setHelmet(CW.getInstance().getClasses().redPickedHats);
					player.getInventory().setItem(1, CW.getInstance().getClasses().redDye);
					for(String s : CW.getInstance().getRedTeam())
						Bukkit.getPlayer(s).sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_RED + player.getName() + ChatColor.RED + " Has Joined The " + ChatColor.DARK_RED + "RED " + ChatColor.RED + "Team!");
					player.closeInventory();
				}
			}
		}
		
		if(event.getInventory().getName().equals(ChatColor.RED + "Kit Selection"))
		{
			event.setCancelled(true);
			
			CW.getInstance().getClasses().removeFromClass(player.getName());

			if(event.getCurrentItem().getType() == Material.BOW)
			{
				CW.getInstance().getClasses().getArcherMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_GRAY + "ArcherMate " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.IRON_HELMET)
			{
				CW.getInstance().getClasses().getBanditMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_GREEN + "Bandanit " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.IRON_CHESTPLATE)
			{
				CW.getInstance().getClasses().getGolemMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_PURPLE + "Golem " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.GOLD_AXE)
			{
				CW.getInstance().getClasses().getMedioticMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_AQUA + "Mediotic " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.FIRE)
			{
				CW.getInstance().getClasses().getPyroMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.GOLD + "Pyr0 " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.CARROT_ITEM)
			{
				CW.getInstance().getClasses().getRabbitMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.WHITE + "§lRabbit " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.POTION)
			{
				CW.getInstance().getClasses().getChemyMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.WHITE + "Chemy " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.DIAMOND_AXE)
			{
				CW.getInstance().getClasses().getJackMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_RED + "Lumber Jack " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.ENDER_PEARL)
			{
				CW.getInstance().getClasses().getAssassinMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_AQUA + "Assassin " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.COOKIE)
			{
				CW.getInstance().getClasses().getCookieMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.AQUA + "Cookie Monster " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.IRON_SWORD)
			{
				CW.getInstance().getClasses().getKrakenMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_BLUE + "Kraken " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.GOLD_SWORD)
			{
				CW.getInstance().getClasses().getFoxMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_RED + "Red Fox " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.STICK)
			{
				CW.getInstance().getClasses().getJugMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.GOLD + "Juggernaut " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.SNOW_BALL)
			{
				CW.getInstance().getClasses().getYetiMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.GRAY + "Yeti " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.STONE_AXE)
			{
				CW.getInstance().getClasses().getZeusMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.YELLOW + "Zeus " + ChatColor.RED + "Class!");
			}
			else if(event.getCurrentItem().getType() == Material.ARROW)
			{
				CW.getInstance().getClasses().getPhenioxMembers().add(player.getName());
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You Have Chosen The " + ChatColor.DARK_RED + "Pheonix " + ChatColor.RED + "Class!");
			}
			
			if(CW.getInstance().getGameState().getState() == GameState.IN_GAME)
			{
				player.getInventory().clear();
    			player.getInventory().setItemInHand(new ItemStack(Material.AIR));
    			player.getInventory().setArmorContents(
    					new ItemStack[] { new ItemStack(Material.AIR),
    							new ItemStack(Material.AIR),
    							new ItemStack(Material.AIR),
    							new ItemStack(Material.AIR) });
    			CW.getInstance().getClasses().giveItem(player);
    			Methods.setScoreBoard(player);
			}
			
			player.closeInventory();
		}
	}

}

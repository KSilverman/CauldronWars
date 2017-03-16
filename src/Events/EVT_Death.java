package Events;

import me.BajanAmerican.CW.CW;
import net.minecraft.server.v1_7_R3.EnumClientCommand;
import net.minecraft.server.v1_7_R3.PacketPlayInClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import Misc.Methods;
import Objects.CWPlayer;

public class EVT_Death implements Listener{
	
	@EventHandler
	public void onPlayerDeath(final PlayerDeathEvent event)
	{
		final Player victim = event.getEntity().getPlayer();
		Player attacker = victim.getKiller();
		CWPlayer cwpvictim = CWPlayer.getCWPlayer(victim);

		event.getDrops().clear();
		event.setDroppedExp(0);
		
		cwpvictim.setDeaths(cwpvictim.getDeaths() + 1);
		cwpvictim.setPoints(cwpvictim.getPoints() - 3);
		
		if(attacker instanceof Player)
		{
			attacker = (Player) victim.getKiller();
		}
		
		if(attacker != null && event.getDeathMessage().contains(attacker.getName()))
		{
			String deathmsg = event.getDeathMessage().substring(0, event.getDeathMessage().indexOf(attacker.getName()) + attacker.getName().length());
			String reason = deathmsg.substring(victim.getName().length(), deathmsg.length() - attacker.getName().length());
			CWPlayer cwpattacker = CWPlayer.getCWPlayer(victim.getKiller());
			cwpattacker.setKills(cwpattacker.getKills() + 1);
			if(Methods.isRanked(victim.getKiller()))
				cwpattacker.setPoints(cwpattacker.getPoints() + 8);
			else
				cwpattacker.setPoints(cwpattacker.getPoints() + 5);
			if(CW.getInstance().getBlueTeam().contains(victim.getName()))
			{
				event.setDeathMessage(ChatColor.DARK_BLUE + victim.getName() + ChatColor.YELLOW + reason + ChatColor.DARK_RED + attacker.getName());
				CW.getInstance().getGame().setRedKills(CW.getInstance().getGame().getRedKills() + 1);
			}
			else
			{
				event.setDeathMessage(ChatColor.DARK_RED + victim.getName() + ChatColor.YELLOW + reason + ChatColor.DARK_BLUE + attacker.getName());
				CW.getInstance().getGame().setBlueKills(CW.getInstance().getGame().getBlueKills() + 1);
			}
			CW.getInstance().getPlayerKillStreaks().put(victim.getKiller().getName(), CW.getInstance().getPlayerKillStreaks().get(victim.getKiller().getName()) + 1);
			CW.getInstance().getPlayerKillStreaks().put(victim.getName(), 0);
			if(CW.getInstance().getPlayerKillStreaks().get(victim.getKiller().getName()) == 3)
			{
				victim.getKiller().getInventory().addItem(CW.getInstance().getClasses().killStreak3);
				if(CW.getInstance().getBlueTeam().contains(victim.getKiller().getName()))
					Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + victim.getKiller().getName() + ChatColor.WHITE + "" + ChatColor.BOLD + " HAS RECIEVED A  " + ChatColor.GOLD + "" + ChatColor.BOLD + "BAZOOKA");
				else
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + victim.getKiller().getName() + ChatColor.WHITE + "" + ChatColor.BOLD + " HAS RECIEVED A  " + ChatColor.GOLD + "" + ChatColor.BOLD + "BAZOOKA");
			}
			else if(CW.getInstance().getPlayerKillStreaks().get(victim.getKiller().getName()) == 5)
			{
				victim.getKiller().getInventory().addItem(CW.getInstance().getClasses().killStreak5);
				if(CW.getInstance().getBlueTeam().contains(victim.getKiller().getName()))
					Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + victim.getKiller().getName() + ChatColor.WHITE + "" + ChatColor.BOLD + " HAS RECIEVED A  " + ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "TnT Strike");
				else
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + victim.getKiller().getName() + ChatColor.WHITE + "" + ChatColor.BOLD + " HAS RECIEVED A  " + ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "TnT Strike");
			}
		}
		else
		{
			String deathMSG = event.getDeathMessage().substring(victim.getName().length(), event.getDeathMessage().length());
			if(CW.getInstance().getBlueTeam().contains(victim.getName()))
			{
				event.setDeathMessage(ChatColor.DARK_BLUE + victim.getName() + ChatColor.YELLOW + deathMSG);
				CW.getInstance().getGame().setRedKills(CW.getInstance().getGame().getRedKills() + 1);
			}
			else
			{
				event.setDeathMessage(ChatColor.DARK_RED + victim.getName() + ChatColor.YELLOW + deathMSG);
				CW.getInstance().getGame().setBlueKills(CW.getInstance().getGame().getBlueKills() + 1);
			}
			CW.getInstance().getPlayerKillStreaks().put(victim.getName(), 0);
		}
		if(CW.getInstance().getBottlePlayer().contains(victim.getName()))
		{
			CW.getInstance().getBottlePlayer().clear();
			victim.getWorld().dropItem(victim.getLocation(), new ItemStack(Material.GLASS_BOTTLE));
			if(CW.getInstance().getBlueTeam().contains(victim.getName()))
				Bukkit.broadcastMessage(ChatColor.DARK_BLUE + victim.getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " Has DROPPED A Glass Bottle!");
			else if(CW.getInstance().getRedTeam().contains(victim.getName()))
				Bukkit.broadcastMessage(ChatColor.DARK_RED + victim.getName() + ChatColor.DARK_GRAY + ChatColor.BOLD + " Has DROPPED A Glass Bottle!");
		}
		
		if(CW.getInstance().getFrozen().containsKey(victim.getName()))
			CW.getInstance().getFrozen().remove(victim.getName());
				
		for(Player p : Bukkit.getOnlinePlayers())
			Methods.setScoreBoard(p);
			
		Methods.checkNoPlayers();
		
		CW.getInstance().getServer().getScheduler().runTaskLater(CW.getInstance(), new Runnable() 
    	{
              public void run() 
              {
          		((CraftPlayer)event.getEntity()).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
              }
            }
            , 2L);
	}

}

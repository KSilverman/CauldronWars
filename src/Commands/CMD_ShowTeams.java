package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Misc.Methods;

public class CMD_ShowTeams {

	@SuppressWarnings("deprecation")
	@CommandHandler(name = "showteams")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(Methods.modUp(player))
			{
				if(args.length == 0)
				{
					String redteam = "";
					String blueteam = "";
					for(String b : CW.getInstance().getBlueTeam())
					{
						if ((b != null) && (Bukkit.getPlayer(b) != null))
							blueteam += (b + ", ");
					}
					for(String r : CW.getInstance().getRedTeam())
					{
						if ((r != null) && (Bukkit.getPlayer(r) != null))
							redteam += (r + ", ");
					}
					player.sendMessage("§6§lTEAMS:\n" + ChatColor.DARK_BLUE + "Blue" + ChatColor.GRAY + "(" + String.valueOf(CW.getInstance().getBlueTeam().size()) + "): " + ChatColor.BLUE + blueteam + "\n" + ChatColor.DARK_RED + "Red" + ChatColor.GRAY + "(" + String.valueOf(CW.getInstance().getRedTeam().size()) + "): " + ChatColor.RED + redteam);
				}
				else
				{
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Incorrect usage! /showteams");
					return;
				}
			}
			else
			{
				player.sendMessage(CW.getInstance().getStarter() + CW.getInstance().getPermMsg());
				return;
			}
		}
		else
		{
			if(args.length == 0)
			{
				String redteam = "";
				String blueteam = "";
				for(String b : CW.getInstance().getBlueTeam())
				{
					if ((b != null) && (Bukkit.getPlayer(b) != null))
						blueteam += (b + ", ");
				}
				for(String r : CW.getInstance().getRedTeam())
				{
					if ((r != null) && (Bukkit.getPlayer(r) != null))
						redteam += (r + ", ");
				}
				sender.sendMessage("§6§lTEAMS:\n" + ChatColor.DARK_BLUE + "Blue" + ChatColor.GRAY + "(" + String.valueOf(CW.getInstance().getBlueTeam().size()) + "): " + ChatColor.BLUE + blueteam + "\n" + ChatColor.DARK_RED + "Red" + ChatColor.GRAY + "(" + String.valueOf(CW.getInstance().getRedTeam().size()) + "): " + ChatColor.RED + redteam);
			}
			else
			{
				sender.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Incorrect usage! /showteams");
				return;
			}
		}
    }
}

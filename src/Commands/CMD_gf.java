package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Misc.GameState;

public class CMD_gf {

	@CommandHandler(name = "gF")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(CW.getInstance().getGameState().getState().equalsIgnoreCase(GameState.IN_GAME))
			{
				if(args.length == 0)
				{
					player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 3, player.getLocation().getZ()));
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.BOLD + "" + ChatColor.GREEN + "You have been fixed!");
				}
				else
				{
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "Incorrect usage! /gf");
					return;
				}
			}
			else
			{
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "You must be in game to use this command!");
				return;
			}
		}
		else
		{
			sender.sendMessage(CW.getInstance().getStarter() + "You must be a player to use this command!");
			return;
		}
    }
}

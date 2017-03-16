package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Misc.Methods;

public class CMD_Hub {
	
	@CommandHandler(name = "hub")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Methods.sendToHub((Player)sender);
			sender.sendMessage(CW.getInstance().getStarter() + ChatColor.GREEN + "Teleported to hub!");
		}
		else
		{
			sender.sendMessage(CW.getInstance().getStarter() + "You must be a player to use this command!");
			return;
		}
    }

}

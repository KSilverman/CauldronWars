package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;

public class CMD_Join {
	
	@CommandHandler(name = "join")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			
		}
		else
		{
			sender.sendMessage(CW.getInstance().getStarter() + "You must be a player to use this command!");
		}
    }

}

package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Misc.GameState;

public class CMD_Team {
	
	@CommandHandler(name = "team")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(args.length == 1)
			{
				if(CW.getInstance().getGameState().getState() == GameState.IN_LOBBY)
				{
					if(!(CW.getInstance().getPicked().contains(player.getName())))
					{
						if ((args[0].equalsIgnoreCase("blue")) || (args[0].equalsIgnoreCase("b")))
						{
							
						}
						else if((args[0].equalsIgnoreCase("red")) || (args[0].equalsIgnoreCase("r")))
						{
							
						}
						else
						{
							player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_PURPLE + "/Team §4§lRED §7§l/ §1§lBLUE");
						}
					}
					else
					{
						player.sendMessage(CW.getInstance().getStarter() + "§8§lYou are already on a team!");
					}
				}
				else
				{
					player.sendMessage(CW.getInstance().getStarter() + ChatColor.RED + "This command is only avaliable in LOBBY mode!");
				}
			}
			else
			{
				player.sendMessage(CW.getInstance().getStarter() + ChatColor.DARK_PURPLE + "/Team §4§lRED §7§l/ §1§lBLUE");
			}
		}
		else
		{
			sender.sendMessage("You must be a player to use this command!");
		}
    }

}

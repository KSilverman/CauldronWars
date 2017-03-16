package Commands;

import me.BajanAmerican.CW.CW;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Commands.SimpleCommand.CommandHandler;
import Objects.CWPlayer;

public class CMD_Stat {
	
	@CommandHandler(name = "stats")
    public void onCommand(CommandSender sender, String[] args)
    {
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			CWPlayer cwp = CWPlayer.getCWPlayer(player);
			player.sendMessage(ChatColor.GRAY + player.getName() + ":\n" + ChatColor.YELLOW + "Points: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getPoints()) + "\n" + ChatColor.RED + "Deaths: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getDeaths()) + "\n" + ChatColor.AQUA + "Kills: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getKills()) + "\n" + ChatColor.BLUE + "Captures: " + ChatColor.DARK_GREEN + String.valueOf(cwp.getCaptures()) + "\n" + ChatColor.GOLD + "K/D: " + ChatColor.DARK_GREEN + String.valueOf(roundInt((cwp.getKills() / cwp.getDeaths()), 3)));
		}
		else
		{
			sender.sendMessage(CW.getInstance().getStarter() + "You must be a player to execute this command!");
		}
    }
	
	private double roundInt(double num, int slot) {
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

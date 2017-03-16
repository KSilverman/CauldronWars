package Misc;

import org.bukkit.ChatColor;

public class GameState {
	
	  public static String IN_LOBBY = "§A&lJOIN NOW";
	  public static final String IN_GAME = ChatColor.DARK_RED + "Game Is In Progress! ";
	  public static final String POST_GAME = "Game Is In POST GAME! ";
	  public static final String GAME_RESETING = ChatColor.DARK_GREEN + "Game Is Resetting! ";
	  public static final String GAME_STARTING = "Game Is STARTING! ";
	  private String gameState;


	  public void setGameState(String state)
	  {
	    this.gameState = state;
	  }

	  public String getState() 
	  {
	    return this.gameState;
	  }

	  public void setInLobby() 
	  {
	    setGameState(IN_LOBBY);
	  }
	  public void setInGame() 
	  {
	    setGameState(IN_GAME);
	  }
}

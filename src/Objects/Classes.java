package Objects;

import java.util.ArrayList;
import java.util.List;

import me.BajanAmerican.CW.CW;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import Misc.Methods;

public class Classes {
	
	   List<String> ArcherMembers;
	   List<String> BanditMembers;
	   List<String> TankMembers;
	   List<String> MedioticMembers;
	   List<String> PyroMembers;
	   List<String> KrakenMembers;
	   List<String> FoxMembers;
	   List<String> ChemyMembers;
	   List<String> RabbitMembers;
	   List<String> JackMembers;
	   List<String> AssMembers;
	   List<String> CookieMembers;
	   List<String> JugMembers;
	   List<String> PhenioxMembers;
	   List<String> ZeusMembers;
	   List<String> YetiMembers;
	   
	   public Classes()
	   {
		   ArcherMembers = new ArrayList<String>();
		   BanditMembers = new ArrayList<String>();
		   TankMembers = new ArrayList<String>();
		   MedioticMembers = new ArrayList<String>();
		   PyroMembers = new ArrayList<String>();
		   KrakenMembers = new ArrayList<String>();
		   FoxMembers = new ArrayList<String>();
		   ChemyMembers = new ArrayList<String>();
		   RabbitMembers = new ArrayList<String>();
		   JackMembers = new ArrayList<String>();
		   AssMembers = new ArrayList<String>();
		   CookieMembers = new ArrayList<String>();
		   JugMembers = new ArrayList<String>();
		   PhenioxMembers = new ArrayList<String>();
		   ZeusMembers = new ArrayList<String>();
		   YetiMembers = new ArrayList<String>();
		   Cookie.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
		   Cookie.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		   woodsword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
		   gSword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		   Tank.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		   Bandit.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		   Pyro.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		   Fox.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		   Rabbit.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
		   Jug.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
		   Jug.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		   firebow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
		   PyroLeatherBoots.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		   PyroLeatherHelm.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		   PyroLeatherChest.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		   PyroLeatherPants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1);
		   MedioticGoldenBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   MedioticGoldenHelm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   MedioticGoldenChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   MedioticGoldenPants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   KrakenLetherBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   KrakenIronHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   KrakenLetherChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   KrakenLetherPants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   rabbithelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   rabbitboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   rabbitboots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 2);
		   rabbitchest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   rabbitpants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   jackhelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   cookiehelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   cookiechest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   cookiepants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   cookieboots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   phhelm.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
		   phchest.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 2);
		   zeuschest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		   Potion p = new Potion(PotionType.INSTANT_DAMAGE);
		   p.setSplash(true);
		   p.apply(harm);
		   Potion p1 = new Potion(PotionType.WEAKNESS);
		   p1.setSplash(true);
		   p1.apply(poision);
	   }
	   
	   
	   public final ItemStack bluePickedHats = Methods.setColor(new ItemStack(Material.LEATHER_HELMET), "Blue Team", Color.BLUE, ChatColor.DARK_BLUE);
	   
	   public final ItemStack redPickedHats = Methods.setColor(new ItemStack(Material.LEATHER_HELMET), "Red Team", Color.RED, ChatColor.DARK_RED);
	   
	   @SuppressWarnings("deprecation")
	   public final ItemStack blueDye = Methods.setName(new ItemStack(351, 1, (short) 4), "Blue Team", ChatColor.DARK_BLUE);
		 
	   @SuppressWarnings("deprecation")
	   public final ItemStack redDye = Methods.setName(new ItemStack(351, 1, (short) 1), "Red Team", ChatColor.DARK_RED);
		 
	   public final ItemStack killStreak3 = Methods.setName(new ItemStack(Material.IRON_BARDING), "§lBazooka", ChatColor.GOLD);
		 
	   public final ItemStack killStreak5 = Methods.setName(new ItemStack(Material.MAGMA_CREAM), "§lTnT Strike", ChatColor.GOLD);
	   
	   public final ItemStack lobbyCompass = Methods.setName(new ItemStack(Material.COMPASS), "Return to Hub", ChatColor.BLUE);
	   
	   public final ItemStack teams = Methods.setName(new ItemStack(Material.NAME_TAG), "§lTeam Selection", ChatColor.AQUA);
	   
	   public final ItemStack lobbyArrow = Methods.setName(new ItemStack(Material.ARROW), "§lKit Selection", ChatColor.RED);
	   
		public final ItemStack blueteam = Methods.setName(new ItemStack(Material.LAPIS_BLOCK), "BLUE", ChatColor.DARK_BLUE);
		public final ItemStack redteam = Methods.setName(new ItemStack(Material.REDSTONE_BLOCK), "RED", ChatColor.DARK_RED);
	   
	   
		public final ItemStack archermate = Methods.setName(new ItemStack(Material.BOW), "ArcherMate", ChatColor.GRAY);
		public final ItemStack bandanit = Methods.setName(new ItemStack(Material.IRON_HELMET), "Bandanit", ChatColor.DARK_GREEN);
		public final ItemStack golem = Methods.setName(new ItemStack(Material.IRON_CHESTPLATE), "Golem", ChatColor.DARK_PURPLE);
		public final ItemStack mediotic = Methods.setName(new ItemStack(Material.GOLD_AXE), "Mediotic", ChatColor.DARK_AQUA);
		public final ItemStack pyro = Methods.setName(new ItemStack(Material.FIRE), "Pyro", ChatColor.GOLD);
		public final ItemStack rabbit = Methods.setName(new ItemStack(Material.CARROT_ITEM), "§lRabbit", ChatColor.WHITE);
		public final ItemStack chemy = Methods.setName(new ItemStack(Material.POTION), "Chemy", ChatColor.WHITE);
		public final ItemStack rfox = Methods.setName(new ItemStack(Material.GOLD_SWORD), "Red Fox", ChatColor.DARK_RED);
		public final ItemStack kraken = Methods.setName(new ItemStack(Material.IRON_SWORD), "§oKraken", ChatColor.DARK_BLUE);
		public final ItemStack jack = Methods.setName(new ItemStack(Material.DIAMOND_AXE), "LumberJack", ChatColor.DARK_RED);
		public final ItemStack assassin = Methods.setName(new ItemStack(Material.ENDER_PEARL), "Assassin", ChatColor.DARK_AQUA);
		public final ItemStack cookie = Methods.setName(new ItemStack(Material.COOKIE), "Cookie Monster", ChatColor.AQUA);
		public final ItemStack jug = Methods.setName(new ItemStack(Material.STICK), "Juggernaut", ChatColor.GOLD);
		public final ItemStack zeus = Methods.setName(new ItemStack(Material.STONE_AXE), "Zeus", ChatColor.YELLOW);
		public final ItemStack yeti = Methods.setName(new ItemStack(Material.SNOW_BALL), "Yeti", ChatColor.GRAY);
		public final ItemStack phoenix = Methods.setName(new ItemStack(Material.ARROW), "Phoenix", ChatColor.DARK_RED);
	   
	   //Amour
	   
			public final ItemStack ArcherChainBoots = Methods.setName(new ItemStack(Material.CHAINMAIL_BOOTS), "ArcherMate's Boots", ChatColor.DARK_GRAY);
			
			public final ItemStack ArcherChainHelm = Methods.setName(new ItemStack(Material.CHAINMAIL_HELMET), "ArcherMate's Helmet", ChatColor.DARK_GRAY);
			
			public final ItemStack ArcherChainChest = Methods.setName(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "ArcherMate's ChestPlate", ChatColor.DARK_GRAY);
			
			public final ItemStack ArcherChainPants = Methods.setName(new ItemStack(Material.CHAINMAIL_LEGGINGS), "ArcherMate's Pants", ChatColor.DARK_GRAY);
			
			//Pyro
			
			public  final ItemStack PyroLeatherBoots = Methods.setName(new ItemStack(Material.LEATHER_BOOTS), "Pyro's Boots", ChatColor.GOLD);
			
			public  final ItemStack PyroLeatherHelm = Methods.setName(new ItemStack(Material.LEATHER_HELMET), "Pyro's Helmet", ChatColor.GOLD);
			
			public  final ItemStack PyroLeatherChest = Methods.setName(new ItemStack(Material.LEATHER_CHESTPLATE), "Pyro's ChestPlate", ChatColor.GOLD);
			
			public  final ItemStack PyroLeatherPants = Methods.setName(new ItemStack(Material.LEATHER_BOOTS), "Pyro's Boots", ChatColor.GOLD);
			
			//bandanit
			
			public  final ItemStack BanDanitIronBoots = Methods.setName(new ItemStack(Material.CHAINMAIL_BOOTS), "BanDanit's Boots", ChatColor.DARK_GREEN);
			
			public  final ItemStack BanDanitIronHelm = Methods.setName(new ItemStack(Material.IRON_HELMET), "BanDanit's Helmet", ChatColor.DARK_GREEN);
			
			public  final ItemStack BanDanitIronChest = Methods.setName(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "BanDanit's ChestPlate", ChatColor.DARK_GREEN);
			
			public  final ItemStack BanDanitIronPants = Methods.setName(new ItemStack(Material.CHAINMAIL_LEGGINGS), "BanDanit's Boots", ChatColor.DARK_GREEN);
			
			//tank
			
			public  final ItemStack TankIronBoots = Methods.setName(new ItemStack(Material.CHAINMAIL_BOOTS), "Golem's Boots", ChatColor.DARK_PURPLE);
			
			public  final ItemStack TankIronHelm = Methods.setName(new ItemStack(Material.IRON_HELMET), "Golem's Helmet", ChatColor.DARK_PURPLE);
			
			public  final ItemStack TankDiamondChest = Methods.setName(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "Golem's ChestPlate", ChatColor.DARK_PURPLE);
			
			public  final ItemStack TankDiamondPants = Methods.setName(new ItemStack(Material.IRON_LEGGINGS), "Golem's Pants", ChatColor.DARK_PURPLE);
			
			//Mediotic
			
			public  final ItemStack MedioticGoldenBoots = Methods.setName(new ItemStack(Material.GOLD_BOOTS), "Mediotic's Boots", ChatColor.DARK_AQUA);
			
			public  final ItemStack MedioticGoldenHelm = Methods.setName(new ItemStack(Material.GOLD_HELMET), "Mediotic's Helmet", ChatColor.DARK_AQUA);
			
			public  final ItemStack MedioticGoldenChest = Methods.setName(new ItemStack(Material.GOLD_CHESTPLATE), "Mediotic's ChestPlate", ChatColor.DARK_AQUA);
			
			public  final ItemStack MedioticGoldenPants = Methods.setName(new ItemStack(Material.GOLD_LEGGINGS), "Mediotic's Pants", ChatColor.DARK_AQUA);
			
			//Kraken
			
			public  final ItemStack KrakenLetherBoots = Methods.setName(new ItemStack(Material.LEATHER_BOOTS), "Kraken's Boots", ChatColor.DARK_BLUE);
				
			public  final ItemStack KrakenIronHelm = Methods.setName(new ItemStack(Material.IRON_HELMET), "Kraken's Helmet", ChatColor.DARK_BLUE);
				
			public  final ItemStack KrakenLetherChest = Methods.setName(new ItemStack(Material.LEATHER_CHESTPLATE), "Kraken's ChestPlate", ChatColor.DARK_BLUE);
				
			public  final ItemStack KrakenLetherPants = Methods.setName(new ItemStack(Material.LEATHER_LEGGINGS), "Kraken's Pants", ChatColor.DARK_BLUE);
				
				//Fox
				
			public  final ItemStack FoxIronBoots = Methods.setName(new ItemStack(Material.IRON_BOOTS), "R. Fox's Boots", ChatColor.DARK_RED);
					
			public  final ItemStack FoxLetherHelm = Methods.setName(new ItemStack(Material.LEATHER_HELMET), "R. Fox's Helmet", ChatColor.DARK_RED);
					
			public  final ItemStack FoxIronChest = Methods.setName(new ItemStack(Material.IRON_CHESTPLATE), "R. Fox's ChestPlate", ChatColor.DARK_RED);
					
			public  final ItemStack FoxDiamondPants = Methods.setName(new ItemStack(Material.IRON_LEGGINGS), "R. Fox's Pants", ChatColor.DARK_RED);
					
				//Chemy
					
			public  final ItemStack ChemyLetherBoots = Methods.setName(new ItemStack(Material.LEATHER_BOOTS), "Chemy's Boots", ChatColor.WHITE);
						
			public  final ItemStack ChemyLetherHelm = Methods.setName(new ItemStack(Material.LEATHER_HELMET), "Chemy's Helmet", ChatColor.WHITE);
						
			public  final ItemStack ChemyChainChest = Methods.setName(new ItemStack(Material.CHAINMAIL_CHESTPLATE), "Chemy's ChestPlate", ChatColor.WHITE);
						
			public  final ItemStack ChemyChainPants = Methods.setName(new ItemStack(Material.CHAINMAIL_LEGGINGS), "Chemy's Pants", ChatColor.WHITE);
					
				//Rabbit
						
			public  final ItemStack rabbitchest = Methods.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), "§lRabbit's Chest", Color.WHITE, ChatColor.WHITE);
						 
			public  final ItemStack rabbithelm = Methods.setColor(new ItemStack(Material.LEATHER_HELMET), "§lRabbit's Ears", Color.WHITE, ChatColor.WHITE);
						 
			public  final ItemStack rabbitpants = Methods.setColor(new ItemStack(Material.LEATHER_LEGGINGS), "§lRabbit's Pants", Color.WHITE, ChatColor.WHITE);
						 
			public  final ItemStack rabbitboots = Methods.setColor(new ItemStack(Material.LEATHER_BOOTS), "§lRabbit's Boots", Color.WHITE, ChatColor.WHITE);
			
		     //Jack
			public  final ItemStack jackchest = Methods.setColor(new ItemStack(Material.LEATHER_CHESTPLATE), "Lumberjack’s Coat", Color.RED, ChatColor.RED);
						 
			public  final ItemStack jackhelm = Methods.setColor(new ItemStack(Material.LEATHER_HELMET), "Lumberjack’s Hat", Color.BLACK, ChatColor.RED);
						 
			public  final ItemStack jackpants = Methods.setColor(new ItemStack(Material.LEATHER_LEGGINGS), "Lumberjack’s Pants", Color.RED, ChatColor.RED);
						 
			public  final ItemStack jackboots = Methods.setName(new ItemStack(Material.IRON_BOOTS), "Lumberjack’s Boots", ChatColor.RED); 
						 				 
			//Cookie Monster
			public ItemStack cookiehelm = Methods.setColor(new ItemStack(Material.LEATHER_HELMET), "Cookie Hat", Color.AQUA, ChatColor.AQUA);
					
			public ItemStack cookiechest = Methods.setName(new ItemStack(Material.IRON_CHESTPLATE), "Cookie Chest", ChatColor.AQUA);
					
			public ItemStack cookiepants = Methods.setColor(new ItemStack(Material.LEATHER_LEGGINGS), "Cookie Pants", Color.AQUA, ChatColor.AQUA);
					
			public ItemStack cookieboots = Methods.setColor(new ItemStack(Material.LEATHER_BOOTS), "Cookie Feet", Color.AQUA, ChatColor.AQUA);
						
			//Pheonix
			public ItemStack phhelm = Methods.setName(new ItemStack(Material.GOLD_HELMET), "Phoenix Beak", ChatColor.DARK_RED);
					
			public ItemStack phchest = Methods.setName(new ItemStack(Material.IRON_CHESTPLATE), "Phoenix Chest", ChatColor.DARK_RED);
					
			public ItemStack phpants = Methods.setName(new ItemStack(Material.GOLD_LEGGINGS), "Phoenix Armor", ChatColor.DARK_RED);
					
			public ItemStack phboots = Methods.setName(new ItemStack(Material.LEATHER_BOOTS), "Phoenix Gauntlets", ChatColor.DARK_RED);
					
			//Jug
			public ItemStack jughelm = Methods.setName(new ItemStack(Material.DIAMOND_HELMET), "Juggernaut’s Helmet", ChatColor.DARK_RED);
					
			public ItemStack jugchest = Methods.setName(new ItemStack(Material.DIAMOND_CHESTPLATE), "Juggernaut’s Chestplate", ChatColor.DARK_RED);
					
			public ItemStack jugpants = Methods.setName(new ItemStack(Material.DIAMOND_LEGGINGS), "Juggernaut’s Leggings", ChatColor.DARK_RED);
					
			public ItemStack jugboots = Methods.setName(new ItemStack(Material.DIAMOND_BOOTS), "Juggernaut’s Boots", ChatColor.DARK_RED);
					
			//Zeus
			public ItemStack zeushelm = Methods.setName(new ItemStack(Material.GOLD_HELMET), "Zeus’s Helmet", ChatColor.YELLOW);
					
			public ItemStack zeuschest = Methods.setName(new ItemStack(Material.IRON_CHESTPLATE), "Zeus’s Toga", ChatColor.YELLOW);
					
			public ItemStack zeuspants = Methods.setColor(new ItemStack(Material.LEATHER_LEGGINGS), "Zeus’s Leggings", Color.YELLOW, ChatColor.YELLOW);
					
			public ItemStack zeusboots = Methods.setColor(new ItemStack(Material.LEATHER_BOOTS), "Zeus’s Boots", Color.YELLOW, ChatColor.YELLOW);
			//Yeti
			public ItemStack yetihelm = Methods.setColor(new ItemStack(Material.LEATHER_BOOTS), "Yeti's Fur Helmet", Color.WHITE, ChatColor.GRAY);
					
			public ItemStack yetichest = Methods.setName(new ItemStack(Material.IRON_CHESTPLATE), "Yeti's Furry Chestplate", ChatColor.GRAY);
					
			public ItemStack yetipants = Methods.setName(new ItemStack(Material.IRON_LEGGINGS), "Yeti's Hairy Leggings", ChatColor.GRAY);
					
			public ItemStack yetiboots = Methods.setColor(new ItemStack(Material.LEATHER_BOOTS), "Yeti's Fur Boots", Color.WHITE, ChatColor.GRAY);
			
		//Inventory
				 private final ItemStack woodsword = new ItemStack(Material.WOOD_SWORD);
			  	 public final ItemStack[] ArcherMate = { 
				      Methods.setName(new ItemStack(Material.BOW), "ArcherMate's Bow", ChatColor.DARK_GRAY), 
				      Methods.setName(new ItemStack(Material.ARROW, 41), "ArcherMate's Arrow", ChatColor.DARK_GRAY), 
				      Methods.setName(woodsword, "ArcherMate's Sword", ChatColor.DARK_GRAY),
				  };

				  public final ItemStack Bandit = Methods.setName(new ItemStack(Material.STONE_SWORD), "BanDanit's Sword", ChatColor.DARK_GREEN);

				  public  final ItemStack Tank = Methods.setName(new ItemStack(Material.STONE_SWORD), "Golem's Sword", ChatColor.DARK_PURPLE);
				  
				  private final ItemStack gSword = new ItemStack(Material.GOLD_SWORD);
				  public final ItemStack[] Mediotic = {
					  Methods.setName(gSword, "Mediotic's Sword", ChatColor.DARK_AQUA),
					  Methods.setName(new ItemStack(Material.GOLDEN_APPLE, 2), "Mediotic's Golden Apple", ChatColor.DARK_AQUA),
				  };
				  
				  public final ItemStack Pyro = Methods.setName(new ItemStack(Material.IRON_AXE), "Pyro's Axe", ChatColor.GOLD);
				  
				  public ItemStack Kraken = Methods.setName(new ItemStack(Material.IRON_SWORD), "Kraken's Sword", ChatColor.DARK_BLUE);
				  
				  public ItemStack Fox = Methods.setName(new ItemStack(Material.GOLD_SWORD), "R. Fox's Sword", ChatColor.DARK_RED);
				  
				  private final ItemStack poision = new ItemStack(Material.POTION, 10);
				  private final ItemStack harm = new ItemStack(Material.POTION, 10);
				  private final ItemStack chemyhoe = new ItemStack(Material.DIAMOND_HOE);
				  public ItemStack[] Chemy = {
					  Methods.setName(poision, "Chemy's Weakness", ChatColor.WHITE),
					  Methods.setName(harm, "Chemy's Instant Harm", ChatColor.WHITE),
					  Methods.setName(chemyhoe, "Chemy's Hoe", ChatColor.WHITE),
				  };
				  
				  public ItemStack Rabbit = Methods.setName(new ItemStack(Material.CARROT_ITEM), "§lRabbit’s Carrot", ChatColor.WHITE);
				  
				  public ItemStack Jack = Methods.setName(new ItemStack(Material.DIAMOND_AXE), "Lumberjack’s Axe", ChatColor.RED);
				 
				  public ItemStack[] Assasin = {
					  Methods.setName(new ItemStack(Material.DIAMOND_SWORD), "Dagger", ChatColor.DARK_AQUA),
					  Methods.setName(new ItemStack(Material.ENDER_PEARL), "Assassin's teleportation", ChatColor.DARK_AQUA),
				  };
				  
				  public ItemStack Cookie = Methods.setName(new ItemStack(Material.COOKIE), "§lCookie Crumbler", ChatColor.AQUA);
				  
				  private ItemStack firebow = new ItemStack(Material.BOW);
				  public ItemStack[] Pheonix = {
					  Methods.setName(firebow, "Phoenix Flamin’ Wing", ChatColor.DARK_RED),
					  Methods.setName(new ItemStack(Material.ARROW, 25), "Phoenix Feathers", ChatColor.DARK_RED),
					  Methods.setName(new ItemStack(Material.WOOD_SWORD), "Phoenix’ Claw", ChatColor.DARK_RED),
				  };
				  
				  public ItemStack Jug = Methods.setName(new ItemStack(Material.STICK), "Juggernaut’s Diffuser", ChatColor.GOLD);
				  
				  public ItemStack Zeus = Methods.setName(new ItemStack(Material.STONE_AXE), "§lZeus’ Hammer", ChatColor.YELLOW);
				  
				  public ItemStack[] Yeti = {
					  Methods.setName(new ItemStack(Material.IRON_AXE), "Yeti’s Horns", ChatColor.GRAY),
					  Methods.setName(new ItemStack(Material.SNOW_BALL, 3), "Frozen Orb", ChatColor.GRAY)
				  };
				  
		//METHODS
				  
				  @SuppressWarnings("deprecation")
				public void giveItems()
				  {
				    for (Player p : Bukkit.getOnlinePlayers())
				    {
				      p.getInventory().clear();
				    }
				    
				    for (String s : ArcherMembers){
				      if (Bukkit.getPlayer(s) != null){
				        Bukkit.getPlayer(s).getInventory().addItem(ArcherMate);
				        Bukkit.getPlayer(s).getInventory().setBoots(ArcherChainBoots);
				        Bukkit.getPlayer(s).getInventory().setHelmet(ArcherChainHelm);
				        Bukkit.getPlayer(s).getInventory().setChestplate(ArcherChainChest);
				        Bukkit.getPlayer(s).getInventory().setLeggings(ArcherChainPants);
				      }
				    }
				    
				    for (String t : BanditMembers){
				      if (Bukkit.getPlayer(t) != null){
				        Bukkit.getPlayer(t).getInventory().addItem(Bandit);
				        Bukkit.getPlayer(t).getInventory().setBoots(BanDanitIronBoots);
				        Bukkit.getPlayer(t).getInventory().setHelmet(BanDanitIronHelm);
				        Bukkit.getPlayer(t).getInventory().setChestplate(BanDanitIronChest);
				        Bukkit.getPlayer(t).getInventory().setLeggings(BanDanitIronPants);
				      }
				    }
				    
				    for (String v : MedioticMembers){
				      if (Bukkit.getPlayer(v) != null){
				        Bukkit.getPlayer(v).getInventory().addItem(Mediotic);
				        Bukkit.getPlayer(v).getInventory().setBoots(MedioticGoldenBoots);
				        Bukkit.getPlayer(v).getInventory().setHelmet(MedioticGoldenHelm);
				        Bukkit.getPlayer(v).getInventory().setChestplate(MedioticGoldenChest);
				        Bukkit.getPlayer(v).getInventory().setLeggings(MedioticGoldenPants);
				      }
				    }
				    
				    for (String x : PyroMembers){
				      if (Bukkit.getPlayer(x) != null) {
				        Bukkit.getPlayer(x).getInventory().addItem(Pyro);
				        Bukkit.getPlayer(x).getInventory()
				          .setBoots(PyroLeatherBoots);
				        Bukkit.getPlayer(x).getInventory()
				          .setHelmet(PyroLeatherHelm);
				        Bukkit.getPlayer(x)
				          .getInventory()
				          .setChestplate(PyroLeatherChest);
				        Bukkit.getPlayer(x)
				          .getInventory()
				          .setLeggings(PyroLeatherPants);
				      }
				    }
				    
				    for (String z : TankMembers){
				      if (Bukkit.getPlayer(z) != null) {
				        Bukkit.getPlayer(z).getInventory().addItem(Tank);
				        Bukkit.getPlayer(z).getInventory()
				          .setBoots(TankIronBoots);
				        Bukkit.getPlayer(z).getInventory()
				          .setHelmet(TankIronHelm);
				        Bukkit.getPlayer(z)
				          .getInventory()
				          .setChestplate(TankDiamondChest);
				        Bukkit.getPlayer(z).getInventory()
				          .setLeggings(TankDiamondPants);
				        Bukkit.getPlayer(z).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0));
				      }
				    }
				    
				    for (String q : KrakenMembers){
					      if (Bukkit.getPlayer(q) != null){
					        Bukkit.getPlayer(q).getInventory().addItem(Kraken);
					        Bukkit.getPlayer(q).getInventory().setBoots(KrakenLetherBoots);
					        Bukkit.getPlayer(q).getInventory().setHelmet(KrakenIronHelm);
					        Bukkit.getPlayer(q).getInventory().setChestplate(KrakenLetherChest);
					        Bukkit.getPlayer(q).getInventory().setLeggings(KrakenLetherPants);
					        Bukkit.getPlayer(q).addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
					      }
					    }
				    
				    for (String m : FoxMembers){
					      if (Bukkit.getPlayer(m) != null){
					        Bukkit.getPlayer(m).getInventory().addItem(Fox);
					        Bukkit.getPlayer(m).getInventory().setBoots(FoxIronBoots);
					        Bukkit.getPlayer(m).getInventory().setHelmet(FoxLetherHelm);
					        Bukkit.getPlayer(m).getInventory().setChestplate(FoxIronChest);
					        Bukkit.getPlayer(m).getInventory().setLeggings(FoxDiamondPants);
					      }
					    }
				    
				    for (String n : ChemyMembers){
					      if (Bukkit.getPlayer(n) != null){
					        Bukkit.getPlayer(n).getInventory().addItem(Chemy);
					        Bukkit.getPlayer(n).getInventory().setBoots(ChemyLetherBoots);
					        Bukkit.getPlayer(n).getInventory().setHelmet(ChemyLetherHelm);
					        Bukkit.getPlayer(n).getInventory().setChestplate(ChemyChainChest);
					        Bukkit.getPlayer(n).getInventory().setLeggings(ChemyChainPants);
					      }
					    }
				    for (String k : RabbitMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Rabbit);
					        Bukkit.getPlayer(k).getInventory().setBoots(rabbitboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(rabbithelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(rabbitchest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(rabbitpants);
					      }
					    }
				    
				    for (String k : JackMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Jack);
					        Bukkit.getPlayer(k).getInventory().setBoots(jackboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(jackhelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(jackchest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(jackpants);
					      }
					    }
				    for (String k : AssMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Assasin);
					      }
					    }
				    for (String k : CookieMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Cookie);
					        Bukkit.getPlayer(k).getInventory().setBoots(cookieboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(cookiehelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(cookiechest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(cookiepants);
					      }
					    }
				    for (String k : PhenioxMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Pheonix);
					        Bukkit.getPlayer(k).getInventory().setBoots(phboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(phhelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(phchest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(phpants);
					      }
					    }
				    for (String k : JugMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Jug);
					        Bukkit.getPlayer(k).getInventory().setBoots(jugboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(jughelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(jugchest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(jugpants);
					      }
					    }
				    for (String k : ZeusMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Zeus);
					        Bukkit.getPlayer(k).getInventory().setBoots(zeusboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(zeushelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(zeuschest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(zeuspants);
					      }
					    }
				    for (String k : YetiMembers){
					      if (Bukkit.getPlayer(k) != null){
					        Bukkit.getPlayer(k).getInventory().addItem(Yeti);
					        Bukkit.getPlayer(k).getInventory().setBoots(yetiboots);
					        Bukkit.getPlayer(k).getInventory().setHelmet(yetihelm);
					        Bukkit.getPlayer(k).getInventory().setChestplate(yetichest);
					        Bukkit.getPlayer(k).getInventory().setLeggings(yetipants);
					      }
					    }
				  }
				  
				  public void giveItem(Player player){
					  
				      if (ArcherMembers.contains(player.getName())){
				        player.getInventory().addItem(ArcherMate);
				        player.getInventory().setBoots(ArcherChainBoots);
				        player.getInventory().setHelmet(ArcherChainHelm);
				        player.getInventory().setChestplate(ArcherChainChest);
				        player.getInventory().setLeggings(ArcherChainPants);
				      }
				    
				      if (BanditMembers.contains(player.getName())){
				    	  player.getInventory().addItem(Bandit);
				    	  player.getInventory().setBoots(BanDanitIronBoots);
				    	  player.getInventory().setHelmet(BanDanitIronHelm);
				    	  player.getInventory().setChestplate(BanDanitIronChest);
				    	  player.getInventory().setLeggings(BanDanitIronPants);
				      }
				    
				      if (MedioticMembers.contains(player.getName())){
				    	  player.getInventory().addItem(Mediotic);
				    	  player.getInventory().setBoots(MedioticGoldenBoots);
				    	  player.getInventory().setHelmet(MedioticGoldenHelm);
				    	  player.getInventory().setChestplate(MedioticGoldenChest);
				    	  player.getInventory().setLeggings(MedioticGoldenPants);
				      }
				    
				      if (PyroMembers.contains(player.getName())){
				    	  player.getInventory().addItem(Pyro);
				    	  player.getInventory()
				          .setBoots(PyroLeatherBoots);
				    	  player.getInventory()
				          .setHelmet(PyroLeatherHelm);
				    	  player
				          .getInventory()
				          .setChestplate(PyroLeatherChest);
				    	  player
				          .getInventory()
				          .setLeggings(PyroLeatherPants);
				      }
				    
				    	 if (TankMembers.contains(player.getName())){
				        player.getInventory().addItem(Tank);
				        player.getInventory()
				          .setBoots(TankIronBoots);
				        player.getInventory()
				          .setHelmet(TankIronHelm);
				        player
				          .getInventory()
				          .setChestplate(TankDiamondChest);
				        player.getInventory()
				          .setLeggings(TankDiamondPants);
				      }
				    	 
				    	 if (KrakenMembers.contains(player.getName())){
						        player.getInventory().addItem(Kraken);
						        player.getInventory().setBoots(KrakenLetherBoots);
						        player.getInventory().setHelmet(KrakenIronHelm);
						        player.getInventory().setChestplate(KrakenLetherChest);
						        player.getInventory().setLeggings(KrakenLetherPants);
						      }
				    	 
				    	 if (FoxMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Fox);
				    		 player.getInventory().setBoots(FoxIronBoots);
				    		 player.getInventory().setHelmet(FoxLetherHelm);
				    		 player.getInventory().setChestplate(FoxIronChest);
				    		 player.getInventory().setLeggings(FoxDiamondPants);
						      }
				    	 
				    	 if (ChemyMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Chemy);
				    		 player.getInventory().setBoots(ChemyLetherBoots);
				    		 player.getInventory().setHelmet(ChemyLetherHelm);
				    		 player.getInventory().setChestplate(ChemyChainChest);
				    		 player.getInventory().setLeggings(ChemyChainPants);
						      }
				    	 if (RabbitMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Rabbit);
				    		 player.getInventory().setBoots(rabbitboots);
				    		 player.getInventory().setHelmet(rabbithelm);
				    		 player.getInventory().setChestplate(rabbitchest);
				    		 player.getInventory().setLeggings(rabbitpants);
						      }
				    	 if (JackMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Jack);
				    		 player.getInventory().setBoots(jackboots);
				    		 player.getInventory().setHelmet(jackhelm);
				    		 player.getInventory().setChestplate(jackchest);
				    		 player.getInventory().setLeggings(jackpants);
						      }
				    	 if (AssMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Assasin);
						      }
				    	 if (CookieMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Cookie);
				    		 player.getInventory().setBoots(cookieboots);
				    		 player.getInventory().setHelmet(cookiehelm);
				    		 player.getInventory().setChestplate(cookiechest);
				    		 player.getInventory().setLeggings(cookiepants);
						      }
				    	 if (PhenioxMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Pheonix);
				    		 player.getInventory().setBoots(phboots);
				    		 player.getInventory().setHelmet(phhelm);
				    		 player.getInventory().setChestplate(phchest);
				    		 player.getInventory().setLeggings(phpants);
						      }
				    	 if (JugMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Jug);
				    		 player.getInventory().setBoots(jugboots);
				    		 player.getInventory().setHelmet(jughelm);
				    		 player.getInventory().setChestplate(jugchest);
				    		 player.getInventory().setLeggings(jugpants);
						      }
				    	 if (ZeusMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Zeus);
				    		 player.getInventory().setBoots(zeusboots);
				    		 player.getInventory().setHelmet(zeushelm);
				    		 player.getInventory().setChestplate(zeuschest);
				    		 player.getInventory().setLeggings(zeuspants);
						      }
				    	 if (YetiMembers.contains(player.getName())){
				    		 player.getInventory().addItem(Yeti);
				    		 player.getInventory().setBoots(yetiboots);
				    		 player.getInventory().setHelmet(yetihelm);
				    		 player.getInventory().setChestplate(yetichest);
				    		 player.getInventory().setLeggings(yetipants);
						      }
		  }
			
				  		public void giveDefaultClasses() 
						{
					    for (Player player : Bukkit.getOnlinePlayers())
					      if ((!ArcherMembers.contains(player.getName())) && 
					        (!TankMembers.contains(player.getName())) && 
					        (!MedioticMembers.contains(player.getName())) && 
					        (!BanditMembers.contains(player.getName())) && 
					        (!PyroMembers.contains(player.getName())) &&
					        (!KrakenMembers.contains(player.getName())) &&
					        (!FoxMembers.contains(player.getName())) &&
					        (!ChemyMembers.contains(player.getName())) &&
					        (!RabbitMembers.contains(player.getName())) &&
					        (!JackMembers.contains(player.getName())) &&
					        (!AssMembers.contains(player.getName())) &&
					        (!CookieMembers.contains(player.getName())) &&
					        (!PhenioxMembers.contains(player.getName())) &&
					        (!JugMembers.contains(player.getName())) &&
					        (!ZeusMembers.contains(player.getName())) &&
					        (!YetiMembers.contains(player.getName()))){
					        ArcherMembers.add(player.getName());
					      }
					  }
				  		
				  	  public void removeFromClass(String player)
				  	  {
				  	    if (ArcherMembers.contains(player))
				  	      ArcherMembers.remove(player);
				  	    if (TankMembers.contains(player))
				  	      TankMembers.remove(player);
				  	    removeOnePotion(player, PotionEffectType.SLOW);
				  	    if (BanditMembers.contains(player))
				  	      BanditMembers.remove(player);
				  	    if (PyroMembers.contains(player))
				  	      PyroMembers.remove(player);
				  	    if (MedioticMembers.contains(player))
				  	      MedioticMembers.remove(player);
				  	    if (ChemyMembers.contains(player))
				  		      ChemyMembers.remove(player);
				  		if (KrakenMembers.contains(player))
				  		      KrakenMembers.remove(player);
				  		removeOnePotion(player, PotionEffectType.WATER_BREATHING);
				  		if (FoxMembers.contains(player))
				  		      FoxMembers.remove(player);
				  		if (RabbitMembers.contains(player))
				  			     RabbitMembers.remove(player);
				  				removeOnePotion(player, PotionEffectType.JUMP);
				  		if (JackMembers.contains(player))
				  			      JackMembers.remove(player);
				  		if (AssMembers.contains(player))
				  			      AssMembers.remove(player);
				  		removeOnePotion(player, PotionEffectType.INVISIBILITY);
				  		removeOnePotion(player, PotionEffectType.CONFUSION);
				  		if (CookieMembers.contains(player))
				  		    	CookieMembers.remove(player);
				  		if (PhenioxMembers.contains(player))
				  		    	PhenioxMembers.remove(player);
				  		if (JugMembers.contains(player))
				  		    	JugMembers.remove(player);
				  		if (ZeusMembers.contains(player))
				  		    	ZeusMembers.remove(player);
				  		if (YetiMembers.contains(player))
				  		    	YetiMembers.remove(player);
				  	  }
				  	  
					  @SuppressWarnings("deprecation")
					public void givePotions()
					  {						  
						    for(String p : KrakenMembers)
						    {
						    	if(Bukkit.getPlayer(p) != null)
						    	{
						    		Bukkit.getPlayer(p).addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0));
						    	}
						    }
						    
						    for(String k : RabbitMembers)
						    {
						    	if(Bukkit.getPlayer(k) != null)
						    	{
						    		Bukkit.getPlayer(k).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1));
						    	}
						    }
						    
						    for(String k : AssMembers)
						    {
						    	if(Bukkit.getPlayer(k) != null)
						    	{
						    		Bukkit.getPlayer(k).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 15, 1));
						    		Bukkit.getPlayer(k).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 15, 1));
						    	}
						    }
						    
						    for(String g : CW.getInstance().getBottlePlayer())
						    {
						    	if(Bukkit.getPlayer(g) != null)
						    	{
						    		Bukkit.getPlayer(g).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 0));
						    		Bukkit.getPlayer(g).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 0));
						    		Bukkit.getPlayer(g).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 0));
						    		Bukkit.getPlayer(g).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));	
						    		Bukkit.getPlayer(g).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
						    	}
						    }
					  }
					  	  
					  @SuppressWarnings("deprecation")
					public void removePotions()
					  {						  						  

						    for(String p : KrakenMembers){
						    	if(Bukkit.getPlayer(p) != null){
						    		Bukkit.getPlayer(p).removePotionEffect(PotionEffectType.WATER_BREATHING);
						    	}
						    }
						    
						    for(String p : RabbitMembers){
						    	if(Bukkit.getPlayer(p) != null){
						    		Bukkit.getPlayer(p).removePotionEffect(PotionEffectType.JUMP);
						    	}
						    }
					  }
					  
					  public void removePotion(Player player)
					  {
						  for (PotionEffect effect : player.getActivePotionEffects())
						        player.removePotionEffect(effect.getType());
					  }
				  	  
					  @SuppressWarnings("deprecation")
					public void removeOnePotion(String player, PotionEffectType pet){
						  for (PotionEffect effect : Bukkit.getPlayer(player).getActivePotionEffects()){
							  if(effect.getType().equals(pet)){
								  Bukkit.getPlayer(player).removePotionEffect(pet);
							  }
						  }
					  }
	   
	   //Getters
	   
	   public List<String> getArcherMembers()
	   {
		   return ArcherMembers;
	   }
	   
	   public List<String> getBanditMembers()
	   {
		   return BanditMembers;
	   }
	   
	   public List<String> getGolemMembers()
	   {
		   return TankMembers;
	   }
	   
	   public List<String> getMedioticMembers()
	   {
		   return MedioticMembers;
	   }
	   
	   public List<String> getPyroMembers()
	   {
		   return PyroMembers;
	   }
	   
	   public List<String> getKrakenMembers()
	   {
		   return KrakenMembers;
	   }
	   
	   public List<String> getFoxMembers()
	   {
		   return FoxMembers;
	   }
	   
	   public List<String> getChemyMembers()
	   {
		   return ChemyMembers;
	   }
	   
	   public List<String> getAssassinMembers()
	   {
		   return AssMembers;
	   }
	   
	   public List<String> getRabbitMembers()
	   {
		   return RabbitMembers;
	   }
	   
	   public List<String> getJackMembers()
	   {
		   return JackMembers;
	   }
	   
	   public List<String> getCookieMembers()
	   {
		   return CookieMembers;
	   }
	   
	   public List<String> getJugMembers()
	   {
		   return JugMembers;
	   }
	   
	   public List<String> getZeusMembers()
	   {
		   return ZeusMembers;
	   }
	   
	   public List<String> getYetiMembers()
	   {
		   return YetiMembers;
	   }
	   
	   public List<String> getPhenioxMembers()
	   {
		   return PhenioxMembers;
	   }
}

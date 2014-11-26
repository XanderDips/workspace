package Bukkit.littlexanman.FutureCraft;

import java.util.ArrayList;
import java.util.logging.Logger;

import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.CommandManager;
import me.littlexanman.TheInfected.SettingsManager;
import me.littlexanman.TheInfected.listeners.ArmorRemove;
import me.littlexanman.TheInfected.listeners.BlockBreak;
import me.littlexanman.TheInfected.listeners.LobbySigns;
import me.littlexanman.TheInfected.listeners.PlayerLeave;
import me.littlexanman.TheInfected.listeners.PlayerLoseHunger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{
	
	//Requests From Gunnar------
	//-Dog, 1000 coins

	//-Bodie, 10000 coins, blue collar and the name Bodie hovering over his head

	//-Cat, 1000 coins

	//-Cow, 1000 coins

	//-Mooshroom, 5000 coins

	//-snowman, 5000 coins

	//-Iron golem, 5000 coins

	//-name your pet, 500 coins

	
	public static Plugin me;
	public static ArenaManager arenaManager;
	public static FileConfiguration config;
	public static Core plugin = null;
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("FutureCraft" + "Version:" + pdfFile.getVersion() + "plugins are loaded!");
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new ArmorRemove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LobbySigns(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerLoseHunger(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EventHandlers(), this);
		SettingsManager.getInstance().setup(this);
		this.saveDefaultConfig();
		config = getConfig();
		plugin = this;
		me = this;
		getLogger().info(ChatColor.RED + "The Infected" + ChatColor.GOLD + " has been enabled!");
		ArenaManager.getInstance().setup();
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("ti").setExecutor(cm);
		MagicClock.usingClock = new ArrayList<String>();
	}
	public static void saveFile(){
		plugin.saveConfig();
	}
	
	public void onDisable(){
		this.logger.info("FutureCraft plugins are un-loaded!");
		this.saveDefaultConfig();
		getLogger().info(ChatColor.RED + "The Infected" + ChatColor.GOLD + " has been Disabled!");
		for (Arena a : ArenaManager.getInstance().getArenas()) {
			a.stop(null);
		}

	}

	//KitPvP
	
	public void onSignChange(SignChangeEvent e){
		Sign s = (Sign) e.getBlock().getState();
		if (s.getLine(0).equalsIgnoreCase("[Kit]")){
			logger.info("HelloK");
			s.setLine(0, "§4[Kit]");
			
			if (s.getLine(1).equalsIgnoreCase("Archer")){
				logger.info("HelloA");
				s.setLine(1, "§3Archer"); 
			}
			if (s.getLine(1).equalsIgnoreCase("Heavy")){
				logger.info("HelloH");
				s.setLine(1, "§6Heavy");
			}
			if (s.getLine(1).equalsIgnoreCase("Spy")){
				logger.info("HelloS");
				s.setLine(1, "§2Spy");
			}
		}
		else {
			logger.info("Not Kit");
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType() == Material.SIGN_POST
					|| e.getClickedBlock().getType() == Material.WALL_SIGN
					|| e.getClickedBlock().getType() == Material.SIGN) {
				
				Player p = e.getPlayer();
				BlockState state = e.getClickedBlock().getState();
				
				if (state instanceof Sign) {
					final Sign s = (Sign)state;
					
					if(s.getLine(0).equals("[Kit]") || s.getLine(0).equals("§4[Kit]")){
						if(s.getLine(1).equals("Archer") || s.getLine(1).equals("§3Archer")){
							PlayerInventory pi = p.getInventory();
							pi.clear();
							p.updateInventory();
							p.sendMessage(ChatColor.YELLOW + "Archer Inventory Cleared");
							
							pi.setHelmet(KitPvPIS.ArcherH);
							pi.setChestplate(KitPvPIS.ArcherC);
							pi.setLeggings(KitPvPIS.ArcherL);
							pi.setBoots(KitPvPIS.ArcherB);
							pi.addItem(KitPvPIS.ArcherS);
							pi.addItem(KitPvPIS.ArcherBo);
							pi.addItem(KitPvPIS.ArcherA);
							pi.addItem(KitPvPIS.ArcherP);
							p.updateInventory();
							p.sendMessage(ChatColor.YELLOW + "You have chosen the Archer kit");
							
							return;
						}
					
						if(s.getLine(1).equals("Heavy") || s.getLine(1).equals("§6Heavy")){
							PlayerInventory pi = p.getInventory();
							pi.clear();
							p.updateInventory();
							ItemStack HeavyH = new ItemStack(Material.IRON_HELMET, 1);
							ItemStack HeavyC = new ItemStack(Material.IRON_CHESTPLATE, 1);
							ItemStack HeavyL = new ItemStack(Material.IRON_LEGGINGS, 1);
							ItemStack HeavyB = new ItemStack(Material.IRON_BOOTS, 1);
							ItemStack HeavyS = new ItemStack(Material.STONE_SWORD, 1);
							ItemStack HeavyP = new ItemStack(Material.BAKED_POTATO, 64);
							HeavyH.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							HeavyC.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							HeavyC.addEnchantment(Enchantment.THORNS, 2);
							HeavyL.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							HeavyB.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							HeavyB.addEnchantment(Enchantment.PROTECTION_FALL, 1);
							HeavyS.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							pi.setHelmet(HeavyH);
							pi.setChestplate(HeavyC);
							pi.setLeggings(HeavyL);
							pi.setBoots(HeavyB);
							pi.addItem(HeavyS);
							pi.addItem(HeavyP);
							p.updateInventory();
							p.sendMessage(ChatColor.YELLOW + "You have chosen the Heavy kit");
							return;
			
						}	
				
						if(s.getLine(1).equals("Spy") || s.getLine(1).equals("§2Spy")){
							PlayerInventory pi = p.getInventory();
							pi.clear();
							p.updateInventory();
							ItemStack SpyH = new ItemStack(Material.LEATHER_HELMET, 1);
							ItemStack SpyC = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
							ItemStack SpyL = new ItemStack(Material.LEATHER_LEGGINGS, 1);
							ItemStack SpyB = new ItemStack(Material.LEATHER_BOOTS, 1);
							ItemStack SpyS = new ItemStack(Material.DIAMOND_SWORD, 1);
							ItemStack SpyBo = new ItemStack(Material.BOW, 1);
							ItemStack SpyA = new ItemStack(Material.ARROW, 1);
							ItemStack SpyP = new ItemStack(Material.BAKED_POTATO, 64);
							SpyH.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							SpyC.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							SpyC.addEnchantment(Enchantment.THORNS, 1);
							SpyL.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							SpyB.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							SpyB.addEnchantment(Enchantment.PROTECTION_FALL, 2);
							SpyS.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							SpyS.addEnchantment(Enchantment.KNOCKBACK, 1);
							SpyBo.addEnchantment(Enchantment.ARROW_INFINITE, 1);
							SpyBo.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
							pi.setHelmet(SpyH);
							pi.setChestplate(SpyC);
							pi.setLeggings(SpyL);
							pi.setBoots(SpyB);
							pi.addItem(SpyS);
							pi.addItem(SpyBo);
							pi.addItem(SpyA);
							pi.addItem(SpyP);
							p.updateInventory();
							p.sendMessage(ChatColor.YELLOW + "You have chosen the Spy kit");
							return;
				
						}		
					}
				}
			}
		}
	}
}

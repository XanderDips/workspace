package me.littlexanman.TheInfected;

import me.littlexanman.TheInfected.listeners.ArmorRemove;
import me.littlexanman.TheInfected.listeners.BlockBreak;
import me.littlexanman.TheInfected.listeners.LobbySigns;
import me.littlexanman.TheInfected.listeners.PlayerLeave;
import me.littlexanman.TheInfected.listeners.PlayerLoseHunger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Core extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info(ChatColor.RED + "The Infected" + ChatColor.GOLD + " has been enabled!");
		ArenaManager.getInstance().setup();
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("ti").setExecutor(cm);
		Bukkit.getServer().getPluginManager().registerEvents(new ArmorRemove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LobbySigns(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerLoseHunger(), this);
	}

	public void onDisable() {
		getLogger().info(ChatColor.RED + "The Infected" + ChatColor.GOLD + " has been Disabled!");
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("tihelp")){
				String tihelp = "tihelp " + player.getName();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), tihelp);
				player.sendMessage(ChatColor.RED + "======================The Infected======================");
				player.sendMessage(ChatColor.GREEN + "/ticreatearena" + ChatColor.RED + "  Create an Arena!");
				player.sendMessage(ChatColor.GREEN + "/tigetkitsurvivor" + ChatColor.RED + "  Become a Survivor!");
				player.sendMessage(ChatColor.GREEN + "/tigetkitinfected " + ChatColor.RED + "  Become The Infected!");
				player.sendMessage(ChatColor.GREEN + "/tileave" + ChatColor.RED + "  Leave the Arena!");
				
			} 
			if(cmd.getName().equalsIgnoreCase("tigetkitsurvivor")){
				ItemStack diamondhelm = new ItemStack(Material.DIAMOND_HELMET, 1);
				ItemStack chainchest = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				ItemStack diamondlegs = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				ItemStack diamondboots = new ItemStack(Material.DIAMOND_BOOTS, 1);
				ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD, 1);
				ItemStack bread = new ItemStack(Material.BREAD, 64);
				PlayerInventory pi = player.getInventory();
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 9));
				pi.clear();
				pi.addItem(diamondhelm);
				pi.addItem(chainchest);
				pi.addItem(diamondlegs);
				pi.addItem(diamondboots);
				pi.addItem(dsword);
				pi.addItem(bread);
				player.updateInventory();
				player.sendMessage(ChatColor.AQUA + "You are a survivor!");
				
			}
			if(cmd.getName().equalsIgnoreCase("tigetkitinfected")){
				ItemStack zombiehead = new ItemStack(Material.getMaterial(397), 1, (short) 2);
				
				ItemStack leatherchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				LeatherArmorMeta meta = (LeatherArmorMeta) leatherchest.getItemMeta();
				meta.setColor(Color.LIME);
				leatherchest.setItemMeta(meta);
				
				ItemStack leatherlegs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				LeatherArmorMeta metaL = (LeatherArmorMeta) leatherlegs.getItemMeta();
				metaL.setColor(Color.LIME);
				leatherlegs.setItemMeta(metaL);
				
				ItemStack leatherboots = new ItemStack(Material.LEATHER_BOOTS, 1);
				LeatherArmorMeta metaB = (LeatherArmorMeta) leatherboots.getItemMeta();
				metaB.setColor(Color.LIME);
				leatherboots.setItemMeta(metaB);
				
				ItemStack wsword = new ItemStack(Material.WOOD_SWORD, 1);
				ItemStack rf = new ItemStack(Material.ROTTEN_FLESH, 64);
				PlayerInventory pi = player.getInventory();
				Potion splash = new Potion(PotionType.POISON, 2);
				splash.setSplash(true);
				ItemStack potion = splash.toItemStack(0);
				ItemMeta metaP = potion.getItemMeta();
				metaP.setDisplayName(ChatColor.GREEN + "Splash Potion of Poison");
				potion.setItemMeta(metaP);
				wsword.addEnchantment(org.bukkit.enchantments.Enchantment.DAMAGE_ALL, 2);
				pi.clear();
				pi.addItem(zombiehead);
				pi.addItem(leatherchest);
				pi.addItem(leatherlegs);
				pi.addItem(leatherboots);
				pi.addItem(wsword);
				pi.addItem(rf);
				pi.addItem(potion);
				player.updateInventory();
				player.sendMessage(ChatColor.GREEN + "You have been infected!");
			}
			if(cmd.getName().equalsIgnoreCase("tileave")){
				String tileave = "spawn " + player.getName();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), tileave);
				player.sendMessage(ChatColor.RED + "You have left the game!");
				
			}
			if(cmd.getName().equalsIgnoreCase("ticreatearena")){
				player.sendMessage(ChatColor.DARK_RED + "Work in Progress!");
			}
			
			if(cmd.getName().equalsIgnoreCase("ti p1"));
				player.getLocation();
				
			
		}
		
	return false;
	}
	
}
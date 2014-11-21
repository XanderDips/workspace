package me.littlexanman.KitPvP;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.block.Sign;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(ChatColor.LIGHT_PURPLE + "KitPvP" + ChatColor.RED + "Version:" + pdfFile.getVersion() + ChatColor.RED + "§4 Has been Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable(){
		this.logger.info(ChatColor.LIGHT_PURPLE + "KitPvP" + ChatColor.RED + " Has been Disabled!");
	}
	
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
				logger.info("HellH");
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
						p.sendMessage(ChatColor.YELLOW + "Kit");
						if(s.getLine(1).equals("Archer") || s.getLine(1).equals("§3Archer")){
							p.sendMessage(ChatColor.YELLOW + "Sign says §3Archer");
							PlayerInventory pi = p.getInventory();
							pi.clear();
							p.updateInventory();
							p.sendMessage(ChatColor.YELLOW + "Archer Inventory Cleared");
							ItemStack ArcherH = new ItemStack(Material.CHAINMAIL_HELMET, 1);
							ItemStack ArcherC = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
							ItemStack ArcherL = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
							ItemStack ArcherB = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
							ItemStack ArcherS = new ItemStack(Material.WOOD_SWORD, 1);
							ItemStack ArcherBo = new ItemStack(Material.BOW, 1);
							ItemStack ArcherA = new ItemStack(Material.ARROW, 1);
							ItemStack ArcherP = new ItemStack(Material.BAKED_POTATO, 64);
							p.sendMessage(ChatColor.YELLOW + "Archer Items Created");
							ArcherH.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							ArcherC.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							ArcherC.addEnchantment(Enchantment.THORNS, 2);
							ArcherL.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
							ArcherB.addEnchantment(Enchantment.PROTECTION_FALL, 2);
							ArcherB.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
							ArcherBo.addEnchantment(Enchantment.ARROW_INFINITE, 1);
							ArcherBo.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
							ArcherS.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							ArcherS.addEnchantment(Enchantment.KNOCKBACK, 1);
							p.sendMessage(ChatColor.YELLOW + "Archer Enchantments Added");
							pi.setHelmet(ArcherH);
							pi.setChestplate(ArcherC);
							pi.setLeggings(ArcherL);
							pi.setBoots(ArcherB);
							pi.addItem(ArcherS);
							pi.addItem(ArcherBo);
							pi.addItem(ArcherA);
							pi.addItem(ArcherP);
							p.updateInventory();
							p.sendMessage(ChatColor.YELLOW + "You have chosen the Archer kit");
							
							return;
						}
					
						if(s.getLine(1).equals("Heavy") || s.getLine(1).equals("§6Heavy")){
							p.sendMessage(ChatColor.YELLOW + "Sign says §6Heavy");
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
							p.sendMessage(ChatColor.YELLOW + "Sign says §2Spy");
							PlayerInventory pi = p.getInventory();
							pi.clear();
							p.updateInventory();
							ItemStack SpyH = new ItemStack(Material.LEATHER_HELMET, 1);
							ItemStack SpyC = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
							ItemStack SpyL = new ItemStack(Material.LEATHER_LEGGINGS, 1);
							ItemStack SpyB = new ItemStack(Material.LEATHER_BOOTS, 1);
							ItemStack SpyS = new ItemStack(Material.DIAMOND_SWORD, 1);
							ItemStack SpyBo = new ItemStack(Material.BOW, 1);
							ItemStack SpyA = new ItemStack(Material.ARROW, 64);
							ItemStack SpyP = new ItemStack(Material.BAKED_POTATO, 64);
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

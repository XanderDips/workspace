package Bukkit.littlexanman.FutureCraft;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

public class EventHandlers implements Listener {
	
	boolean  Rdone = true;

	//Shops
	
	public Inventory PInv;
	public Inventory PeInv;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent pe) {
		Player p = (Player) pe.getPlayer();
		PlayerInventory pi = p.getInventory();
		p.sendMessage(ChatColor.RED + "Hello & Welcome to " + ChatColor.WHITE + "Future " + ChatColor.GRAY + "Craft!");
		p.sendMessage("§3§k66666666666666666666666666666666");
		p.sendMessage(ChatColor.RED + "§lNew " + ChatColor.GOLD + "Coin System!");
		p.sendMessage(ChatColor.RED + "§lNew " + ChatColor.GOLD + "Infected Beta Release!");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage(ChatColor.GOLD + "Owner: Gunnar");
		p.sendMessage(ChatColor.RED + "§lPerson who coded this wonderful Server:");
		p.sendMessage(ChatColor.BLUE + "§lXander");
		p.sendMessage(ChatColor.GREEN + "        §l-Gunnar");
		p.sendMessage("");
		p.sendMessage(ChatColor.GOLD + "Coins: " + Core.config.getInt(p.getName() + ".Coins", 0));
		pi.clear();
		pi.setItem(1, IS.C);
		pi.setItem(2, IS.Cl);
		pi.setItem(3, IS.P);
		pi.setItem(6, IS.B);
		if(!Core.config.contains(p.getName())){
			Core.config.set(p.getName() + ".Coins", 1000);
			Core.saveFile();
			return;
		}
		return;
	}
	

	//Pet Shop

	@EventHandler
	public void Pets(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		PeInv = Bukkit.createInventory(null, 36, ChatColor.BLACK + "Pets");
		PeInv.setItem(2, IS.Ws);
		PeInv.setItem(4, IS.Bos);
		if(p.getInventory().getItemInHand().getType() == Material.BONE){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				p.openInventory(PeInv);
			}
		}
	}

	//Particle Shop

	@EventHandler
	public void Particle(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		PInv = Bukkit.createInventory(null, 9, ChatColor.BLACK + "Particles");
		PInv.setItem(1, IS.RP);
		if(p.getInventory().getItemInHand().getType() == Material.SULPHUR){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
				p.openInventory(PInv);
			}
		}
	}
	
	
	//PetClick
	
		@EventHandler
	public void PetClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(PeInv.getName())){
			e.setCancelled(true);
		}
		
		if(e.getCurrentItem() == null){
			return;
		}
		
		if(!e.getCurrentItem().hasItemMeta()){
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Bodie!")) {
			if(MyAPI.hasEnough(p, 10000)){
				MessageManagerFC.getInstance().good(p, "You have purchased a Dog!");
				MyAPI.takeCoins(p, 10000);
				MyAPI.spawnWolf(p);
	
				
			}
			else{
				MessageManagerFC.getInstance().severe(p, "§lNot Enough Coins!");
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Dog!")) {
				if(MyAPI.hasEnough(p, 1000)){
					MessageManagerFC.getInstance().good(p, "You have purchased the legendary " + ChatColor.GOLD + "Bodie!");
					MyAPI.takeCoins(p, 1000);
					MyAPI.spawnWolf(p);
		
					
				}
				else{
					MessageManagerFC.getInstance().severe(p, "§lNot Enough Coins!");
					p.closeInventory();
				}
			}
		}
	}								
	
		//Red Dust Particle
	
	@EventHandler
	public void ParticleClick(InventoryClickEvent e) {
			Player p = (Player) e.getWhoClicked();
			
			if(e.getInventory().getName().equals(PInv.getName())){
				e.setCancelled(true);
			}
			
			if(e.getCurrentItem() == null){
				return;
			}
			
			if(!e.getCurrentItem().hasItemMeta()){
				return;
			}
			
			if(e.getCurrentItem().getType() == Material.REDSTONE) {
				if(MyAPI.hasEnough(p, 10)) {
					MessageManagerFC.getInstance().good(p, "You have equiped the Red Dust particle effect!");
					MyAPI.takeCoins(p, 10);
					ParticleEffect.RED_DUST.display(0, 0, 0, 10, 30, p.getLocation().add(0, 2, 0), 10);
					Rdone = false;
					p.closeInventory();
					while( Rdone = false ) {
						ParticleEffect.RED_DUST.display(0, 0, 0, 10, 30, p.getLocation().add(0, 2, 0), 10);
					}										
				}
				else{
					MessageManagerFC.getInstance().severe(p, "§lNot Enough Coins!");
					p.closeInventory();
					}	
			}	
				
		}								

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
			Player Dp = (Player) e.getEntity();
			PlayerInventory pi = (PlayerInventory) Dp.getPlayer();
			pi.clear();
			pi.addItem(IS.C);
			pi.addItem(IS.Cl);
	}
	
	@EventHandler
	public void onKill(PlayerDeathEvent e){
		if(e.getEntity() instanceof Player) {
			Player Dp = (Player) e.getEntity();
			if(Dp.getKiller() instanceof Player) {
				Player Kp = Dp.getKiller();
				MyAPI.giveCoins(Kp, 10);
				return;
			}
			return;
		}
		return;
	}
	
	public static void summonWolf(Player p) {
	            return; 
	}
}

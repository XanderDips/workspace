package me.littlexanman.MOTD;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent pe) {
		Player p = pe.getPlayer();
		PlayerInventory pi = p.getInventory();
		pi.clear();
		p.sendMessage(ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-");
		p.sendMessage(ChatColor.DARK_GREEN + "");
		p.sendMessage(ChatColor.DARK_GREEN + "Welcome to the " + ChatColor.DARK_BLUE + "-=[" + ChatColor.GOLD + "Crazy " + ChatColor.GRAY + "Network" + ChatColor.DARK_BLUE + "]=- " + ChatColor.DARK_GREEN + "Server!");
		p.sendMessage(ChatColor.DARK_GREEN + "");
		p.sendMessage(ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-" + ChatColor.GOLD + "-" + ChatColor.GRAY + "-");
		ItemStack SC = new ItemStack(Material.COMPASS, 1 );
		ItemStack SR = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
		pi.addItem(SC);
		pi.addItem(SR);

	}
}

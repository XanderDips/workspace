package Bukkit.littlexanman.FutureCraft;

import java.util.ArrayList;

import me.littlexanman.TheInfected.MessageManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MagicClock {
	
	public static ArrayList<String> usingClock;
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() !=  Action.RIGHT_CLICK_BLOCK) return;
		if(e.getItem().getType() != Material.WATCH) return;
		if(!e.getItem().hasItemMeta() || !e.getItem().getItemMeta().hasDisplayName() || !e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Invisible Clock!")) return;
		MessageManager.getInstance().good(p, "All Players have been shown!");
		if(usingClock.contains(p.getName())) {
			usingClock.remove(p.getName());
			for(Player p1 : Bukkit.getServer().getOnlinePlayers()) {
				if(p != e.getPlayer()) {
					p.showPlayer(p1);	
				}
			}
		}
		else {
			MessageManager.getInstance().good(p, "All Players have been hidden!");
			usingClock.add(p.getName());
			for(Player p1 : Bukkit.getServer().getOnlinePlayers()) {
				if(p1 != p) {
					p.hidePlayer(p);
					
				}
			}
		}
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		for(Player p1 : Bukkit.getServer().getOnlinePlayers()) {
			if(p1 != p) {
				if(usingClock.contains(p.getName())) {
					p1.hidePlayer(p);
				}
				else {
					p1.showPlayer(p);
				}
			}
		}
	}
}

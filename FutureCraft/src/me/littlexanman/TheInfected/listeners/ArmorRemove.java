package me.littlexanman.TheInfected.listeners;

import me.littlexanman.TheInfected.ArenaManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ArmorRemove implements Listener{

	@EventHandler
	public void onPlayerClick(InventoryClickEvent e) {
		if(!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player) e.getWhoClicked();
		if(ArenaManager.getInstance().getArena(p) != null) e.setCancelled(true);
	}
	
}

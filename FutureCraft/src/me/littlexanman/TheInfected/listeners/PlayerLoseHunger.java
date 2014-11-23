package me.littlexanman.TheInfected.listeners;

import me.littlexanman.TheInfected.ArenaManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerLoseHunger implements Listener {
	@EventHandler
	public void onPlayerLoseHunger(FoodLevelChangeEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		Player p = (Player) e.getEntity();
		if(ArenaManager.getInstance().getArena(p) != null) e.setCancelled(true);
	}

}

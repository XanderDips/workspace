package me.littlexanman.TheInfected.listeners;

import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener{
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		Arena a = ArenaManager.getInstance().getArena(e.getPlayer());
		if(a == null) return;
		a.removePlayerL(e.getPlayer());
	}

}

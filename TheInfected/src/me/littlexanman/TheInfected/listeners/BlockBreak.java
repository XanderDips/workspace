package me.littlexanman.TheInfected.listeners;

import me.littlexanman.TheInfected.ArenaManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener{

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(ArenaManager.getInstance().getArena(e.getPlayer()) != null) e.setCancelled(true);
	}
	
}

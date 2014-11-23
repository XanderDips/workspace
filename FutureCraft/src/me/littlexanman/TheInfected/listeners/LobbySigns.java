package me.littlexanman.TheInfected.listeners;

import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class LobbySigns implements Listener{

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if(e.getLines().length > 0 && !e.getLine(0).equalsIgnoreCase("[TI]")) return;
		if(e.getLines().length < 3) {
			e.getBlock().breakNaturally();
			MessageManager.getInstance().severe(e.getPlayer(), "An infected sign must have 3 or more lines!");
			return;
		}
		try{Integer.parseInt(e.getLine(2)); }
		catch(Exception ex) {
			e.getBlock().breakNaturally();
			MessageManager.getInstance().severe(e.getPlayer(), e.getLine(2) + " is not a valid Arena!");
			return;
		}
		e.setLine(0, ChatColor.RED + "[The Infected]");
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if(!(e.getClickedBlock().getType()  == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN)) return;
		Sign s= (Sign) e.getClickedBlock().getState();
		if(s.getLine(0).equalsIgnoreCase(ChatColor.RED + "[The Infected]")) {
			int id = -1;
			try{ id = Integer.parseInt(s.getLine(2)); }
			catch(Exception ex) {
				MessageManager.getInstance().severe(e.getPlayer(), s.getLine(2) + " is not a valid Arena!");
				return;
			}
			
			Arena a = ArenaManager.getInstance().getArena(id);
			
			if(a.isStarted()){
				MessageManager.getInstance().severe(e.getPlayer(), "Arena " + id +" has already started!");
			}
			e.getPlayer().performCommand("ti join" + id);
		}
	}
}

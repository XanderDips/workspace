package me.littlexanman.Sign_Warp;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Sign;

public class Signs implements Listener {
	
public static Bukkit plugin; 
	
	public final HashMap<Location, String> signs = new HashMap<Location, String>();
	
	public void BukkitListener(Bukkit instance) {
		plugin = instance;
	}

	@EventHandler
	public void onSignChanger(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("[signwarp]") && e.getLine(1).equalsIgnoreCase("MiniGame"))
			e.setLine(0, ChatColor.AQUA + "MiniGames");
			signs.put(e.getBlock().getLocation(), e.getPlayer().getName());
		e.getPlayer().sendMessage("Teloportation Sign Created!");
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(signs.containsKey(e.getBlock()) && !signs.containsValue(e.getPlayer().getName())
		|| !p.isOp());
		e.setCancelled(true);
		
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			  if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) e.getClickedBlock().getState();

			    	
			    }
			}
		}
	
	
	
}


package me.littlexanman.Paintball;


import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Paintball_Join extends JavaPlugin implements Listener{
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		if (e.getLine(0).equalsIgnoreCase("PaintBall")){
			e.setLine(0, "§1PaintBall");
			
			
		}
	}
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
			if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign s = (Sign) e.getClickedBlock().getState();
				if(s.getLine(0).equals("PaintBall")) {
					
				}
		}
		
	}

}

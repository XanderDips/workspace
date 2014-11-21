package me.littlexanman.ExplosiveArrows;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@SuppressWarnings("deprecation")

public class ExplosiveListener implements Listener{
	
	@EventHandler
	public void onHit(ProjectileHitEvent event){
		Projectile proj = event.getEntity();
		if ((proj instanceof Arrow)){
			Arrow arrow = (Arrow)proj;
			LivingEntity shooter = arrow.getShooter();
			if ((shooter instanceof Player)){
				Player player = (Player)shooter;
				
				if (Core.players.contains(player.getName())){
					
					arrow.getWorld().createExplosion(arrow.getLocation(), 4F);
					player.sendMessage(ChatColor.RED+"Sucsess!"+ChatColor.DARK_RED+"You have shot a Explosive Arrow & it has blown up!");
					
				}
				
			}
		
		}
	
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		
		Player player = event.getPlayer();
		if (Core.players.contains(player.getName())){
			Core.players.remove(player.getName());
			
		}
		
	}

}

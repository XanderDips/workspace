package Bukkit.littlexanman.FutureCraft;


import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Wolf;


public class MyAPI {
	
	
	
		//Coin System
	public static void giveCoins(Player p, int i){
		Core.config.set(p.getName() + ".Coins", Core.config.getInt(p.getName() + ".Coins", 0) + i);
		Core.saveFile();
		p.sendMessage("§6§l" + i + " Coins Recieved!" + " You now have: " + Core.config.getInt(p.getName() + ".Coins", 0));
	}
	public static void takeCoins(Player p, int i){
		Core.config.set(p.getName() + ".Coins",
		Core.config.getInt(p.getName() + ".Coins", 0) - i);
		Core.saveFile();
		p.sendMessage("§6§l" + i + " Coins Taken!" + " You now have: " + Core.config.getInt(p.getName() + ".Coins", 0));
	}

	public static boolean hasEnough(Player p, int i) {
		if(Core.config.getInt(p.getName() + ".Coins") >= i){
			return true;
		}
		else{	return false; }
		
	}
		//Wolf System
	public static void spawnWolf(Player p) {
        
		Wolf wolf = (Wolf) p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
        wolf.setCollarColor(DyeColor.RED);
        wolf.setCustomName(p.getName() + "'s Wolf");
        wolf.setCustomNameVisible(true);
        wolf.setTamed(true);
        wolf.setOwner(p);
        
	}

	public static void spawnBodie(Player p) {
        Wolf wolf = (Wolf) p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
        wolf.setCollarColor(DyeColor.BLUE);
        wolf.setCustomName(ChatColor.BLUE + "Bodie");
        wolf.setCustomNameVisible(true);
        wolf.setTamed(true);
        wolf.setOwner(p);
        
	}
	public static void spawnCat(Player p) {
		Ocelot Cat = (Ocelot) p.getWorld().spawnEntity(p.getLocation(), EntityType.OCELOT);
		Cat.setCustomName(p.getName() + "'s Cat");
		Cat.setCustomNameVisible(true);
		Cat.setTamed(true);
		Cat.setOwner(p);
        
	}

        
	
}

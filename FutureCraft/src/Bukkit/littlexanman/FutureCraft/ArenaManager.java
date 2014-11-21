package Bukkit.littlexanman.FutureCraft;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class ArenaManager {

	private ArrayList<Arena> arenas;

	public ArrayList<Arena> getArenas() {
		return arenas;
	}

	public void setArenas(ArrayList<Arena> arenas) {
		this.arenas = arenas;
	}
	
	public Arena getArena(String arenaName) {
		for(Arena arena : arenas)
			if(arena.getName().equalsIgnoreCase(arenaName))
				return arena;
			return null;
	}

	public Arena getArena(Player p) {
		for(Arena arena : arenas)
			if(arena.isPlayer(p.getName()))
				return arena;
			return null;
	}
	
	public ArenaManager(){
		this.arenas = new ArrayList<Arena>();
		loadArenas();
	}
	
	public void loadArenas(){
		if(Core.me.getConfig().get("Arenas") != null) {
			for(String arenaName : Core.me.getConfig().getConfigurationSection("Arenas").getKeys(true)){
				if(!arenaName.contains(".")) {
					arenas.add(new Arena(arenaName));
						
					
				}
			}
		}
	}
}

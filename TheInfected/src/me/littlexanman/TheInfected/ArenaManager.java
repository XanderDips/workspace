package me.littlexanman.TheInfected;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class ArenaManager {
	
	public enum Team { Survivor, Infected; }
	
	private ArenaManager() { }

	private static ArenaManager instance = new ArenaManager();
	
	public static ArenaManager getInstance() {
		return instance;
	}

	private ArrayList<Arena> arenas = new ArrayList<Arena>();
	
	public void setup() {
		// Load config.
	}

	public Arena getArena(int id) {
		for (Arena a : arenas) {
			if (a.getID() == id) return a; 
		}
		return null;
	}

	public Arena getArena(Player p) {
		for (Arena a : arenas) {
			if (a.containsPlayer(p)) return a;
		}
		return null;
	}
}
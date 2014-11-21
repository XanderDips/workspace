package me.littlexanman.TheInfected;

import java.util.HashMap;

import me.littlexanman.TheInfected.ArenaManager.Team;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Arena extends JavaPlugin implements Listener{

	private int id;
	private Location SurvivorSpawn, InfectedSpawn;
	private HashMap<String, Team> players = new HashMap<String, Team>();
	
	public Arena(int id) {
		// Setup
		
	}

	public int getID() {
		return id;
		
	}

	public Location getSpawn(Team team) {
		switch(team) {
			case Survivor: return SurvivorSpawn;
			case Infected: return InfectedSpawn;
			default: return null;
		}
	}

	public Team getTeam(Player p) {
		return players.get(p.getName());
	}

	public void addPlayer(Player p) {
		players.put(p.getName(), getTeamWithLessPlayers());	
	}

	private Team getTeamWithLessPlayers() {
		int Survivor = 0, Infected = 0;
		for(String p : players.keySet()) {
			if(players.get(p) == Team.Survivor) Survivor++;
			else Infected++;
		}
		if (Survivor > Infected) return Team.Infected;
		else return Team.Survivor;
	}
	
	public boolean containsPlayer(Player p) {
		return players.keySet().contains(p.getName());
	}
}

package Bukkit.littlexanman.FutureCraft;

import java.util.ArrayList;

import org.bukkit.Location;




public class Arena {

	private String name;
	private Location spawn;
	private ArrayList<String> players;

	
	
	
	public Arena(String name){
		this.name = name;
		this.spawn = (Location) Core.me.getConfig().get("Arenas." + name + ".Spawn");
		this.players = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	
	public Location getSpawn() {
		return spawn;
	}
	
	public void setSpawn(Location spawn) {
		this.spawn = spawn;
		Core.me.getConfig().get("Arenas." + name + ".Spawn", spawn);
		Core.me.saveConfig();
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}
	
	public void addPlayer(String p) {
		this.players.add(p);
	}
	
	public void removePlayer(String p) {
		this.players.remove(p);
	}
	
	public boolean isPlayer(String p) {
		return this.players.contains(p);
	}
	
	
	
}

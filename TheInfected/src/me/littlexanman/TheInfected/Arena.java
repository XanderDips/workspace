package me.littlexanman.TheInfected;

import java.util.ArrayList;

import me.littlexanman.TheInfected.ArenaManager.Team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
//import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;


public class Arena extends JavaPlugin implements Listener{


	private int id;
	public boolean Started = false;
	private Location SurvivorSpawn, InfectedSpawn;
	private ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	int TL = 480; 
	int SL = 0;
	int IL = 0;
	SimpleScoreboard TIsb = new SimpleScoreboard(ChatColor.LIGHT_PURPLE + "The Infected");
	
	
	
	public Arena(int id) {
		this.id = id;
		ConfigurationSection conf = SettingsManager.getInstance().get(id + "");
		
		this.SurvivorSpawn = getLocation(conf.getConfigurationSection("SurvivorSpawn"));
		this.InfectedSpawn = getLocation(conf.getConfigurationSection("InfectedSpawn"));
		
		
		TIsb.add(ChatColor.GREEN + "Time:   " + TL, 10);
		TIsb.add(" ", 9);
		TIsb.add(" ", 8);
		TIsb.add(" ", 7);
		TIsb.add(ChatColor.AQUA + "Survivors:   " + SL, 6);
		TIsb.add(" ", 5);
		TIsb.add(" ", 4);
		TIsb.add(ChatColor.RED + "Infected:   " + IL, 3);
		TIsb.add(" ", 2);
		TIsb.add(" ", 1);
		
	}
	
	private Location getLocation(ConfigurationSection path) {
		return new Location(
				Bukkit.getServer().getWorld(path.getString("world")),path.getDouble("x"),path.getDouble("y"),path.getDouble("z"));
	}

	public void timerStart(){
		TL = 480;
		while(TL > 0) {
			try {
				Thread.sleep(1000);
				TL --;
			}
			catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	public int getID() {
		return id;
		
	}
	
	public boolean isStarted() {
		return Started;
	}

	public void setStarted(boolean Started){
		this.Started = Started;
	}
	
	public Location getSpawn(Team team) {
		switch(team) {
			case Survivor: return SurvivorSpawn;
			case Infected: return InfectedSpawn;
			default: return null;
		}
	}

	public Team getTeam(Player p) {
		return getData(p).getTeam();
	}

	public void addPlayer(Player p) {
		PlayerInventory pi = (PlayerInventory) p.getInventory();
		players.add(new PlayerData(p.getName(), setTeam(), p.getInventory(), p.getLocation()));
		pi.clear();
		p.teleport(getSpawn(getData(p).getTeam()));
		if(getData(p).getTeam() == Team.Survivor) {
			p.setCustomName(ChatColor.RED + "[" + ChatColor.BLUE + "Survivor" + ChatColor.RED + "] " + p.getName());
			p.setCustomNameVisible(true);
			pi.addItem(ItemStacks.Ss);
			pi.addItem(ItemStacks.Sb);
			pi.addItem(ItemStacks.Sa);
			pi.setHelmet(ItemStacks.Sh);
			pi.setChestplate(ItemStacks.Sc);
			pi.setLeggings(ItemStacks.Sl);
			pi.setBoots(ItemStacks.Sbo);
			TIsb.send(p);
		}
		if(getData(p).getTeam() == Team.Infected) {
			p.setCustomName(ChatColor.BLUE + "[" + ChatColor.RED + "Infected" + ChatColor.BLUE + "] " + p.getName());
			p.setCustomNameVisible(true);
			pi.addItem(ItemStacks.Is);
			pi.addItem(ItemStacks.Ib);
			pi.addItem(ItemStacks.Ia);
			pi.addItem(ItemStacks.Ist);
			pi.setHelmet(ItemStacks.Ih);
			pi.setChestplate(ItemStacks.Ic);
			pi.setLeggings(ItemStacks.Il);
			pi.setBoots(ItemStacks.Ibo);
			TIsb.send(p);
		}
			
		if(players.size() >= 5) start(); 
		
	}
	
	public Team addInfected(Player p) {
		PlayerInventory pi2 = (PlayerInventory) p.getInventory();
		addInfected();
		if(getData(p).getTeam() == Team.Infected) {
			p.setCustomName(ChatColor.BLUE + "[" + ChatColor.RED + "Infected" + ChatColor.BLUE + "] " + p.getName());
			p.setCustomNameVisible(true);
			pi2.addItem(ItemStacks.Is);
			pi2.addItem(ItemStacks.Ib);
			pi2.addItem(ItemStacks.Ia);
			pi2.addItem(ItemStacks.Ist);
			pi2.setHelmet(ItemStacks.Ih);
			pi2.setChestplate(ItemStacks.Ic);
			pi2.setLeggings(ItemStacks.Il);
			pi2.setBoots(ItemStacks.Ibo);
			TIsb.send(p);
		}
		return null;
	}

	public Team addInfected() {
		return Team.Infected;
	}
	
	public Team Survivors() {
		SL++;
		return null;
	}
	public Team Infected() {
		IL++;
		return null;
	}
	
	public void removePlayerL(Player p) {
		PlayerData pd = getData(p);
		p.getInventory().addItem(pd.getInventory().getContents());
		p.getInventory().setArmorContents(pd.getInventory().getArmorContents());
		p.getInventory().clear();
		p.teleport(pd.getLocation());
		players.remove(pd);	
		p.setScoreboard(null);
		
		MessageManager.getInstance().info(p, "You have left the game!");
		msg(p + " has left the game!");
		SL = 0;
		IL = 0;
	}
	
	public void removePlayerGO(Player p) {
		PlayerData pd = getData(p);
		p.getInventory().addItem(pd.getInventory().getContents());
		p.getInventory().setArmorContents(pd.getInventory().getArmorContents());
		p.getInventory().clear();
		p.teleport(pd.getLocation());
		players.remove(pd);	
		msg("The game is over!");
		SL = 0;
		IL = 0;
		TIsb.reset();
		p.setScoreboard(null);
	}
	
	public void removePlayerS(Player p) {
		players.remove(p);
		SL--;
		p.teleport(InfectedSpawn);
		p.setBedSpawnLocation(InfectedSpawn);
		MessageManager.getInstance().info(p, "You have become an Infected!");
		msg(p + " has been infected!");
		
		

	}
	
	public void start() {
		msg("Game starting in 30 seconds!");
		try{
			msg("Good luck!");
			Thread.sleep(10000);
			msg("Gmae starting in 20 seconds!");
			Thread.sleep(10000);
			msg("Gmae starting in 10 seconds!");
			Thread.sleep(5000);
			msg("Gmae starting in 5 seconds!");
			Thread.sleep(1000);
			msg("Gmae starting in 4 seconds!");
			Thread.sleep(1000);
			msg("Gmae starting in 3 seconds!");
			Thread.sleep(1000);
			msg("Gmae starting in 2 seconds!");
			Thread.sleep(1000);
			msg("Gmae starting in 1 seconds!");
			Thread.sleep(1000);
			msg("The round has Begun!");
			Arena.this.Started = true;
			timerStart();
			TIsb.build();
		} 
		catch(Exception e) { e.printStackTrace(); }
	}
	
	public void stop(Team winner) {
		msg(winner != null ? "The " + winner.name() + " won the game!" : "The game was ended.");
		for(PlayerData pd : players) {
			@SuppressWarnings("deprecation")
			Player p = Bukkit.getServer().getPlayer(pd.getPlayerName());
			p.getInventory().clear();
			p.getInventory().addItem(pd.getInventory().getContents());
			p.getInventory().setArmorContents(pd.getInventory().getArmorContents());
			p.teleport(pd.getLocation());
			SL = 0;
			IL = 0;
			p.setBedSpawnLocation(null);
			
		}
	}
	
	private void msg(String msg) {
		for(PlayerData pd : players) {
			@SuppressWarnings("deprecation")
			Player p = Bukkit.getServer().getPlayer(pd.getPlayerName());
			MessageManager.getInstance().info(p, msg);
		}
	}
	private Team setTeam() {
		@SuppressWarnings("unused")
		int Survivor = 0, Infected = 0;
		for(@SuppressWarnings("unused") PlayerData pd : players) {
			if(Infected == 2) {
				SL++;
				Survivor++;
				return Team.Survivor;
			}
			else {
				IL++;
				Infected++;
				return Team.Infected;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private Team getTeamWithLessPlayers() {
		int Survivor = 0, Infected = 0;
		for(PlayerData pd : players) {
			if(pd.getTeam() == Team.Survivor) Survivor++;
			else Infected++;
		}
		if (Survivor > Infected) return Team.Infected;
		else return Team.Survivor;
	}
	
	public boolean containsPlayer(Player p) {
		return getData(p) != null;
	}
	private PlayerData getData(Player p) {
		for(PlayerData pd : players) {
			if(pd.getPlayerName().equalsIgnoreCase(p.getName()))return pd;
		}
		return null;
	}
	
	public void onKill(PlayerDeathEvent e) {
		if(ArenaManager.getInstance().getArena(e.getEntity()) == null) return;
		Player p = (Player) e.getEntity();
		if(getData(p).getTeam() == Team.Survivor){
			Player pk = (Player) p.getKiller();
			if(!(pk instanceof Player))return;
			if(getData(pk).getTeam() != Team.Infected)return;
			removePlayerS(p);
			
				
		}
	}
	
}


package me.littlexanman.TheInfected.cmd;


import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.ArenaManager.Team;
import me.littlexanman.TheInfected.MessageManager;
import me.littlexanman.TheInfected.SettingsManager;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class SetLocation extends SubCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		if(args.length < 2) {
			MessageManager.getInstance().severe(p, "You did not specify enough arguments!");
		}
		
		int id = 0;
		try{ id = Integer.parseInt(args[0]);}
		catch(Exception e) {
			MessageManager.getInstance().severe(p,args[0] + " is not a valid Arena!");
			return;
		}
		
		Arena a = ArenaManager.getInstance().getArena(id);
		
		if(a == null) {
			MessageManager.getInstance().severe(p, "There is no Arena with the ID" + id + "!");
			return;
		}
		
		Team team = null;
		try {team = Team.valueOf(args[1]); }
		catch(Exception e) {
			MessageManager.getInstance().severe(p, args[1] + " is not a valid team!");
			return;
		}
		
		ConfigurationSection s = SettingsManager.getInstance().createConfigurationSection(a.getID() + "." + team.toString().toLowerCase() + "spawn");
		
		s.set("world", p.getName());
		s.set("x", p.getLocation().getX());
		s.set("y", p.getLocation().getY());
		s.set("z", p.getLocation().getZ());
		
		MessageManager.getInstance().good(p, "Set " + team.toString().toLowerCase() + " spawn!");
		
	}

	@Override
	public String name() {
		return "setlocation";
	}

	@Override
	public String info() {
		return "Set a team spawn";
	}

	@Override
	public String[] aliases() {
		return new String[] {"s"};
	}

}

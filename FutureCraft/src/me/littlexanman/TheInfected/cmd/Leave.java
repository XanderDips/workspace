package me.littlexanman.TheInfected.cmd;


import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.MessageManager;

import org.bukkit.entity.Player;

public class Leave extends SubCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		if(args.length == 0) {
			MessageManager.getInstance().severe(p, "You must specify an Arena ID!");
			return;
		}
		
		Arena a = ArenaManager.getInstance().getArena(p);
		
		if(ArenaManager.getInstance().getArena(p) == null) {
			MessageManager.getInstance().severe(p, "You are not in a game!");
			return;
		}
		
		if(!(p.hasPermission("FutureCraft.Leave"))) {
			MessageManager.getInstance().severe(p, "You do not have permission to perform this command!");
			return;
		}
		
		a.removePlayerL(p);
		
	}

	@Override
	public String name() {
		return "Leave";
	}

	@Override
	public String info() {
		return "Leave an Arena.";
	}

	@Override
	public String[] aliases() {
		return new String[]{"l"};
	}

	
	
	
}

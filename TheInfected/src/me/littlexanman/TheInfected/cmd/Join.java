package me.littlexanman.TheInfected.cmd;

import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.MessageManager;

import org.bukkit.entity.Player;

public class Join extends SubCommand{
	
	public void onCommand(Player p, String[] args) {
		if(ArenaManager.getInstance().getArena(p) != null) {
			MessageManager.getInstance().severe(p, "You are already in a game!");
			return;
		}
		
		if(args.length == 0) {
			MessageManager.getInstance().severe(p, "You must specify an Arena ID!");
			return;
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
		
		if(a.isStarted()){
			MessageManager.getInstance().severe(p, "Arena " + id +" has already started!");
		}
		a.addPlayer(p);
	}

	@Override
	public String name() {
		return "join";
	}

	@Override
	public String info() {
		return "Join a game.";
	}

	@Override
	public String[] aliases() {
		return new String[] {"j"};
	}

}

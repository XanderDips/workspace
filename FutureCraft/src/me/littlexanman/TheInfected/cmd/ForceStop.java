package me.littlexanman.TheInfected.cmd;

import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.MessageManager;

import org.bukkit.entity.Player;

public class ForceStop extends SubCommand{

	@Override
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
		
		if(!a.isStarted()){
			MessageManager.getInstance().severe(p, "Arena " + id +" has not yet started!");
		}

		a.stop(null);
		MessageManager.getInstance().good(p, "Force stoped Arena " + a.getID() + "!");
		
	}

	@Override
	public String name() {
		return "forcestop";
	}

	@Override
	public String info() {
		return "Force Stop a game!";
	}

	@Override
	public String[] aliases() {
		return new String[] {"fstop", "stop"};
	}

}

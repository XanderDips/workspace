package me.littlexanman.TheInfected.cmd;

import me.littlexanman.TheInfected.Arena;
import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.MessageManager;
import me.littlexanman.TheInfected.SettingsManager;

import org.bukkit.entity.Player;

public class Delete extends SubCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		if(args.length == 0) {
			MessageManager.getInstance().severe(p, "You must specify an Arena number!");
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
			MessageManager.getInstance().severe(p, "Arena " + id +" is ingame!");
		}
		SettingsManager.getInstance().set(id + "", null);
		//TODO: Stop all games and broadcast!
		ArenaManager.getInstance().setup();
	}

	@Override
	public String name() {
		return "delete";
	}

	@Override
	public String info() {
		return "delete a game";
	}

	@Override
	public String[] aliases() {
		return new String[] {"d"};
	}

	
	
}

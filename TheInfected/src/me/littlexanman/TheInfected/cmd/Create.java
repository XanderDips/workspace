package me.littlexanman.TheInfected.cmd;

import me.littlexanman.TheInfected.ArenaManager;
import me.littlexanman.TheInfected.MessageManager;
import me.littlexanman.TheInfected.SettingsManager;

import org.bukkit.entity.Player;

public class Create extends SubCommand{

	@Override
	public void onCommand(Player p, String[] args) {		
		if(args.length == 0) {
			MessageManager.getInstance().severe(p, "You must specify an Arena ID!");
			return;
		}
		
		int id = ArenaManager.getInstance().getArenas().size() + 1;
		SettingsManager.getInstance().createConfigurationSection(id + "");
		MessageManager.getInstance().good(p, "You have created Arena " + id + "!");
	}

	@Override
	public String name() {
		return "create";
	}

	@Override
	public String info() {
		return "create a game";
	}

	@Override
	public String[] aliases() {
		return new String[] {"c"};
	}
	
	
}

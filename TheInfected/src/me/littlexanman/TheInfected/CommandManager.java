package me.littlexanman.TheInfected;

import java.util.ArrayList;

import me.littlexanman.TheInfected.cmd.SubCommand;

import org.bukkit.command.CommandExecutor;

public class CommandManager implements CommandExecutor{

	private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	
	public void setup() {
		// Add all Commands!!
	}

}

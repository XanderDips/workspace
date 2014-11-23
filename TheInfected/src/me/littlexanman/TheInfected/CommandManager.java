package me.littlexanman.TheInfected;

import java.util.ArrayList;
import java.util.Arrays;

import me.littlexanman.TheInfected.cmd.SubCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor{

	private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	
	public void setup() {
		// Add all Commands!!
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)){
			MessageManager.getInstance().severe(sender, "Only players Can play Infected!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("ti")){
			if(args.length == 0){
				for(SubCommand c : commands) {
					MessageManager.getInstance().info(p, "/infected" + c.name() + "(" + aliases(c) + ")" + " - " + c.info());
				}
				return true;
			}
			
			SubCommand target = get(args[0]); 
			
			if(target == null) {
				MessageManager.getInstance().severe(p, "/infected " + args[0] + " is not a valid subcommand!");
				return true;
			}
			
			ArrayList<String> a = new ArrayList<String>();
			a.addAll(Arrays.asList(args));
			a.remove(0);
			args = a.toArray(new String[a.size()]);
			
			try {
				target.onCommand(p, args);
			}catch(Exception e){
				MessageManager.getInstance().severe(p, "An error has occured" + e.getCause());
				e.printStackTrace();
				return true;
			}
			
		}
		return true;
	}
	
	private String aliases(SubCommand cmd) {
		
		String fin = "";
		
		for (String a : cmd.aliases()) {
			fin += a + " | ";
			
		}
	
		return fin.substring(0, fin.lastIndexOf("| "));
	
	}
	
	private SubCommand get(String name) {
		for(SubCommand cmd : commands){
			if(cmd.name().equalsIgnoreCase(name)) return cmd;
		}
		return null;
	}
	
}

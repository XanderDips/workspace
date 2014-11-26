package Bukkit.littlexanman.FutureCraft;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class MessageManagerFC {
	
	private MessageManagerFC() {}

	private static MessageManagerFC instance = new MessageManagerFC();
	
	public static MessageManagerFC getInstance() {
		return instance;
	}
	
	public String prefix  = ChatColor.BOLD + "[" + ChatColor.RED + "FC" + ChatColor.BOLD + "] ";
	
	public void info(CommandSender s, String msg){
		msg(s, ChatColor.LIGHT_PURPLE, msg);
	}
	
	public void severe(CommandSender s, String msg){
		msg(s, ChatColor.RED, msg);
	}
	
	public void good(CommandSender s, String msg){
		msg(s, ChatColor.GREEN, msg);
	}
	
	private void msg(CommandSender s, ChatColor c, String msg) {
		s.sendMessage(prefix + c + msg);
	}
	
}

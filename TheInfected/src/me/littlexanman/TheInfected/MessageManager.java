package me.littlexanman.TheInfected;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class MessageManager {
	
	private MessageManager() {}

	private static MessageManager instance = new MessageManager();
	
	public static MessageManager getInstance() {
		return instance;
	}
	
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
		s.sendMessage(ChatColor.BOLD + "[" + ChatColor.RED + "TI" + ChatColor.BOLD + "] " + c + msg);
	}
	
}

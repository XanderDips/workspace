package me.littlexanman.Paintball;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{
	public final Logger logger = Logger.getLogger("Minecraft");
	
	List<String> redTeam = new ArrayList<String>();
	List<String> blueTeam = new ArrayList<String>();
	List<String> spectate = new ArrayList<String>();
	
	@Override
	public void onEnable(){
		getConfig().createSection("red");
		getConfig().createSection("blue");
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(ChatColor.GOLD + "Paintball" + ChatColor.RED + "Version:" + pdfFile.getVersion() + ChatColor.RED + "Has been Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
		
	}
		
	@Override
	public void onDisable(){
		List<String> redMembers = getConfig().getStringList("red");
		List<String> blueMembers = getConfig().getStringList("blue");
		redMembers.clear();
		blueMembers.clear();
		saveConfig();
		this.logger.info(ChatColor.GOLD + "Paintball" + ChatColor.RED + "Has been Disabled!");
		getServer().getPluginManager().registerEvents(this, this);	
	
	}

	
	
}

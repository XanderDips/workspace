package me.littlexanman.ExplosiveArrows;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{
	
	public static List<String> players = new ArrayList<String>();
	
	@Override
	public void onEnable(){

		
		getCommand("explosivearrows").setExecutor(new ExplosiveCommand());
		getServer().getPluginManager().registerEvents(new ExplosiveListener(), this);
		
	}

	@Override
	public void onDisable(){
		
	}




}


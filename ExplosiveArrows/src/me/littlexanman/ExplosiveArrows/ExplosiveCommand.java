package me.littlexanman.ExplosiveArrows;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplosiveCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if ((sender instanceof Player)){
			Player player = (Player)sender;
			
			if (player.hasPermission("explosivearrows.toggle")){
				
				if (args.length != 1){
					
					if (Core.players.contains(player.getName())){
						Core.players.add(player.getName());
						player.sendMessage(ChatColor.GREEN+"Your arrows are now explosive!");						
					}
					else{
						Core.players.remove(player.getName());
						player.sendMessage(ChatColor.YELLOW+"your arrows are no longer explosive");
					}		
				}
				
				else{
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null){
						
						if (!Core.players.contains(target.getName())){
							Core.players.add(target.getName());
							target.sendMessage(ChatColor.GREEN+"Your arrows are now explosive!");
							player.sendMessage(ChatColor.GREEN+"You have made "+ target.getName() + "'s arrows explosive!");
						}
						else{
							Core.players.remove(target.getName());
							target.sendMessage(ChatColor.YELLOW+"your arrows are no longer explosive");
							player.sendMessage(ChatColor.YELLOW+"You have removed the explosive effect from "+ target.getName() + "'s arrows!");
						}
					
					}
					else{
						sender.sendMessage(ChatColor.AQUA+"Woh there buddy!"+ChatColor.RED+"That player does not exsist!");
					}
				}				
			}
			else{
				sender.sendMessage(ChatColor.RED+"You do not have permission to do this commamnd!");
			}
		}
		else{
			sender.sendMessage(ChatColor.RED+"You need to be a player to do this!");
			
		}
		
		return true;
	
	}

}
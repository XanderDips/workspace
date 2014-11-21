package Bukkit.littlexanman.FutureCraft;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IS {
	//Item Stacks
	
	public static  ItemStack C = new ItemStack(Material.COMPASS, 1);
	public static  ItemStack B = new ItemStack (Material.BONE, 1); {
				ItemMeta Bmeta = B.getItemMeta();
				ArrayList<String> Bm = new ArrayList<String>();
				Bmeta.setDisplayName(ChatColor.WHITE + "Pets!");
				Bm.add(ChatColor.GOLD + "§lGet your Pets!");
				Bmeta.setLore(Bm);
				B.setItemMeta(Bmeta);
		}
		
	public static ItemStack Cl = new ItemStack(Material.SULPHUR, 1); {
				ItemMeta Clmeta = Cl.getItemMeta();
				ArrayList<String> CLM = new ArrayList<String>();
				Clmeta.setDisplayName(ChatColor.GOLD + "Particles!");
				CLM.add(ChatColor.GOLD + "§lParticle Menu");
				Clmeta.setLore(CLM);
				Cl.setItemMeta(Clmeta);
			}
		
	public static ItemStack RP = new ItemStack(Material.REDSTONE, 1); {
				ItemMeta RPmeta = RP.getItemMeta();
				ArrayList<String> RPM = new ArrayList<String>();
				RPmeta.setDisplayName(ChatColor.RED + "Red Dust Particle Effect!");
				RPM.add(ChatColor.WHITE + "Price: " + ChatColor.GOLD + "10" + ChatColor.WHITE + " Gold!");
				RPM.add(ChatColor.GOLD + "§lCreates a Red Dust Particle Effect!");
				RPM.add(ChatColor.DARK_RED + "§lOnly happens once per buy, so make sure you see it!");
				RPmeta.setLore(RPM);
				RP.setItemMeta(RPmeta);
			}
		@SuppressWarnings("deprecation")
	public static ItemStack Dp = new ItemStack(Material.MONSTER_EGG, 1, EntityType.WOLF.getTypeId()); {
				ItemMeta Dpmeta = Dp.getItemMeta();
				ArrayList<String> DPM = new ArrayList<String>();
				DPM.add(ChatColor.WHITE + "Price: " + ChatColor.GOLD + "1000" + ChatColor.WHITE + " Gold!");
				Dpmeta.setDisplayName(ChatColor.RED + "Dog!");
				Dpmeta.setLore(DPM);
				Dp.setItemMeta(Dpmeta);
			}


}

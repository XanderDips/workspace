package Bukkit.littlexanman.FutureCraft;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IS {
	//Item Stacks
	
	public static  ItemStack C = new ItemStack(Material.COMPASS, 1); {
		ItemMeta Cmeta = C.getItemMeta();
		ArrayList<String> CM = new ArrayList<String>();
		Cmeta.setDisplayName(ChatColor.AQUA + "Game Selector!");
		CM.add(ChatColor.GOLD + "§lUse this to teleport games!");
		Cmeta.setLore(CM);
		C.setItemMeta(Cmeta);
	}
	
	public static ItemStack Cl = new ItemStack(Material.WATCH, 1); {
		ItemMeta Clmeta = Cl.getItemMeta();
		ArrayList<String> ClM = new ArrayList<String>();
		Clmeta.setDisplayName(ChatColor.AQUA + "Invisible Clock!");
		ClM.add(ChatColor.GOLD + "§lHide all Players!");
		Clmeta.setLore(ClM);
		Cl.setItemMeta(Clmeta);
	}
	public static  ItemStack B = new ItemStack (Material.BONE, 1); {
				ItemMeta Bmeta = B.getItemMeta();
				ArrayList<String> Bm = new ArrayList<String>();
				Bmeta.setDisplayName(ChatColor.WHITE + "Pets!");
				Bm.add(ChatColor.GOLD + "§lGet your Pets!");
				Bmeta.setLore(Bm);
				B.setItemMeta(Bmeta);
		}
		
	public static ItemStack P = new ItemStack(Material.SULPHUR, 1); {
				ItemMeta Pmeta = P.getItemMeta();
				ArrayList<String> PM = new ArrayList<String>();
				Pmeta.setDisplayName(ChatColor.GOLD + "Particles!");
				PM.add(ChatColor.GOLD + "§lParticle Menu");
				Pmeta.setLore(PM);
				P.setItemMeta(Pmeta);
			}
		
	public static ItemStack RP = new ItemStack(Material.REDSTONE, 1); {
				ItemMeta RPmeta = RP.getItemMeta();
				ArrayList<String> RPM = new ArrayList<String>();
				RPmeta.setDisplayName(ChatColor.RED + "Red Dust Particle Effect!");
				RPM.add(ChatColor.WHITE + "Price: " + ChatColor.GOLD + "15 Coins!");
				RPM.add(ChatColor.GOLD + "§lCreates a Red Dust Particle Effect!");
				RPM.add(ChatColor.DARK_RED + "§lOnly happens once per buy, so make sure you see it!");
				RPM.add(ChatColor.DARK_RED + "§lWIP");
				RPmeta.setLore(RPM);
				RP.setItemMeta(RPmeta);
			}
		@SuppressWarnings("deprecation")
	public static ItemStack Ws = new ItemStack(Material.MONSTER_EGG, 1, EntityType.WOLF.getTypeId()); {
				ItemMeta Wsmeta = Ws.getItemMeta();
				ArrayList<String> WsM = new ArrayList<String>();
				Wsmeta.setDisplayName(ChatColor.RED + "Dog!");
				WsM.add(ChatColor.WHITE + "Price: " + ChatColor.GOLD + "1000 Coins!");
				Wsmeta.setLore(WsM);
				Ws.setItemMeta(Wsmeta);
			}
		@SuppressWarnings("deprecation")
	public static ItemStack Bos = new ItemStack(Material.MONSTER_EGG, 1, EntityType.WOLF.getTypeId()); {
			ItemMeta Bospmeta = Bos.getItemMeta();
			ArrayList<String> BosM = new ArrayList<String>();
			Bospmeta.setDisplayName(ChatColor.GOLD + "Bodie!");
			BosM.add(ChatColor.WHITE + "Price: " + ChatColor.GOLD + "10000 Coins!");
			BosM.add(ChatColor.GOLD + "&l The legnedary Bodie!");
			Bospmeta.setLore(BosM);
			Bos.setItemMeta(Bospmeta);
		}


}

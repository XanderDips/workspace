package me.littlexanman.TheInfected;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class ItemStacks {

	//Survivor's Items
	public static ItemStack Ss = new ItemStack(Material.IRON_SWORD, 1); {
		Ss.addEnchantment(Enchantment.DAMAGE_ALL, 2);
		Ss.addEnchantment(Enchantment.KNOCKBACK, 1);
	}
	public static ItemStack Sb = new ItemStack(Material.BOW, 1); 
	public static ItemStack Sa = new ItemStack(Material.ARROW, 32);
	public static ItemStack Sh = new ItemStack(Material.LEATHER_HELMET, 1); 
	public static ItemStack Sc = new ItemStack(Material.LEATHER_CHESTPLATE, 1); {
		Sc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	}
	public static ItemStack Sl = new ItemStack(Material.LEATHER_LEGGINGS, 1); {
		Sl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	}
	public static ItemStack Sbo = new ItemStack(Material.LEATHER_BOOTS, 1);
	
	//Infected's Items
	public static ItemStack Is = new ItemStack(Material.DIAMOND_SWORD, 1); {
		Is.addEnchantment(Enchantment.DAMAGE_ALL, 4);
		Is.addEnchantment(Enchantment.FIRE_ASPECT, 1);
	}
	public static ItemStack Ib = new ItemStack(Material.BOW, 1); {
		Ib.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		Ib.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
	}
	public static ItemStack Ia = new ItemStack(Material.ARROW, 1);
	public static ItemStack Ih = new ItemStack(Material.SKULL, 1, (short) 1); 
	public static ItemStack Ic = new ItemStack(Material.LEATHER_CHESTPLATE, 1); {
		LeatherArmorMeta meta = (LeatherArmorMeta) Ic.getItemMeta();
		meta.setColor(Color.GREEN);
	}
	public static ItemStack Il = new ItemStack(Material.LEATHER_LEGGINGS, 1); {
		LeatherArmorMeta meta = (LeatherArmorMeta) Il.getItemMeta();
		meta.setColor(Color.GREEN);
	}
	public static ItemStack Ibo = new ItemStack(Material.LEATHER_BOOTS, 1); {
		LeatherArmorMeta meta = (LeatherArmorMeta) Ibo.getItemMeta();
		meta.setColor(Color.GREEN);
	}
	public static ItemStack Ist = new ItemStack(Material.STICK, 1); {
		Ist.addEnchantment(Enchantment.KNOCKBACK, 2);
	}
	public static Potion splash = new Potion(PotionType.POISON, 2);
	public static ItemStack potion = splash.toItemStack(0); {
		ItemMeta metaP = potion.getItemMeta();
		metaP.setDisplayName(ChatColor.GREEN + "Splash Potion of Poison");
		potion.setItemMeta(metaP);
	}
}

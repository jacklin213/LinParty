package com.gmail.jacklin213.linparty.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemNamer {

	private ItemStack item;
	private ItemMeta meta;
	
	public ItemNamer(Material material, String name) {
		this(material, name, 1);
	}
	
	public ItemNamer(Material material, String name, int size) {
		item = new ItemStack(material, size);
		meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
	}
	
	public ItemStack getStack() {
		return item;
	}
}

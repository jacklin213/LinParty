package com.gmail.jacklin213.linparty.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head {
	
	private ItemStack head;
	
	@SuppressWarnings("deprecation")
	public Head(Player player) {
		head = new ItemStack(397, 1, (short)3);
		SkullMeta data = (SkullMeta) head.getItemMeta();
		data.setOwner(player.getName());
		data.setDisplayName(player.getName());
		head.setItemMeta(data);
	}

	public ItemStack getHead() {
		return head;
	}
}

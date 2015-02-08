package com.gmail.jacklin213.linparty;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.gmail.jacklin213.linparty.utils.GUI;
import com.gmail.jacklin213.linparty.utils.GUI.GUIType;
import com.gmail.jacklin213.linparty.utils.Head;

public class LPListener implements Listener {
	
//	private LinParty plugin;
	
	public LPListener() {
//		plugin = LinParty.instance;
	}
	
	//Invntory interact event doesnt work
	@EventHandler
	public void onInvInteract(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inv = event.getInventory();
		if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
		LinParty.log.info(event.getCurrentItem().getItemMeta().getDisplayName());
		if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("create party")) {
			LinParty.log.info("Triggered");
			GUI gui = new GUI(player, GUIType.LEADER);
			gui.getWindow().addItem(new Head(player).getHead());
			player.openInventory(gui.getWindow());
		}
		if (inv.getTitle().contains("Party")) {
			event.setCancelled(true);
		}
	}
	
}

package com.gmail.jacklin213.linparty;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.gmail.jacklin213.linparty.utils.GUI;
import com.gmail.jacklin213.linparty.utils.ItemNamer;
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
		player.sendMessage("Slot number: " + event.getSlot());
		if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
		LinParty.log.info(event.getCurrentItem().getItemMeta().getDisplayName());
		if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("create party")) {
			//Created Party
			LinParty.log.info("Triggered");
			GUI gui = new GUI(player, GUIType.LEADER);
			gui.getWindow().addItem(new Head(player).getHead());
			player.openInventory(gui.getWindow());
//			for (int i = 0; i < party.getMembers().size(); i++) {
//			int slot = -1;
//			switch (i) {
//				case 0:
//					slot = 0;
//					break;
//				case 1:
//					slot = 9;
//					break;
//				case 2:
//					slot = 18;
//					break;
//				case 3:
//					slot = 27;
//					break;
//				case 4:
//					slot = 36;
//					break;
//				case 5:
//					slot = 45;
//					break;
//				}
//				Head head = new Head(Bukkit.getPlayer(party.getMembers().get(i)));
//				menu.getWindow().setItem(slot, head.getHead());
//			}
			gui.getWindow().setItem(27, new ItemNamer(Material.BOOK_AND_QUILL, "Invite Players").getStack());
			gui.getWindow().setItem(28, new ItemNamer(Material.IRON_BOOTS, "Kick Players").getStack());
			gui.getWindow().setItem(29, new ItemNamer(Material.IRON_SWORD, "Friendly Fire").getStack());
		}
		if (inv.getTitle().contains("Party")) {
			event.setCancelled(true);
		}
	}
	
}

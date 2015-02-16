package com.gmail.jacklin213.linparty;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.jacklin213.linparty.utils.GUI;
import com.gmail.jacklin213.linparty.utils.GUI.GUIType;
import com.gmail.jacklin213.linparty.utils.Head;
import com.gmail.jacklin213.linparty.utils.ItemNamer;
import com.gmail.jacklin213.linparty.utils.Party;

public class LPCommand implements CommandExecutor {

	private LinParty plugin;
	
	public LPCommand(LinParty instance) {
//		plugin = LinParty.instance;
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
//		if (commandLabel.equalsIgnoreCase("linparty")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					if (!plugin.partyManager.contains(player)) {
						LinParty.log.info("Player does not have party");
						GUI menu = new GUI(player, GUIType.CREATE);
						menu.getWindow().addItem(new ItemNamer(Material.BOOK_AND_QUILL, "Create Party").getStack());
						player.openInventory(menu.getWindow());
						return true;
					}
					LinParty.log.info("Player has party party");
					Party party = plugin.partyManager.getParty(player);
					GUI menu = new GUI(player, GUIType.MAIN);
					for (UUID uuid : party.getMembers()) {
						Head head = new Head(Bukkit.getPlayer(uuid));
						menu.getWindow().addItem(head.getHead());
					}
					return true;
				}
				if (args.length == 1) {
					
				} else {
					return false;
				}
			} else {
				sender.sendMessage("Player only Command!");
				return true;
			}
//		}
		return false;
	}

	
}

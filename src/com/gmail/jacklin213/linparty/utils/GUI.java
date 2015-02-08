package com.gmail.jacklin213.linparty.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUI {

	private Player player;
	private UUID UUID;
	private Inventory window;
	private String title;
	private GUIType type;
	private int size;

	public GUI(Player player, GUIType type) {
		this.player = player;
		this.UUID = player.getUniqueId();
		this.type = type;
		switch (type) {
		case MAIN:
			title = "Party Overview";
			size = 36;
			break;
		case INVITE:
			title = "Party Invite";
			size = 64;
			break;
		case KICK:
			title = "Party Kick";
			size = 9;
			break;
		case PROMOTE:
			title = "Party Promote";
			size = 9;
			break;
		case LEADER:
			title = "Party Overview (Leader)";
			size = 36;
			break;
		case CREATE:
			title = "Party Create";
			size = 9;
			break;
		}
		this.window = Bukkit.createInventory(player, size, title);
	}
	
	public Player getPlayer() {
		return player;
	}

	public UUID getUUID() {
		return UUID;
	}

	public Inventory getWindow() {
		return window;
	}

	public String getTitle() {
		return title;
	}

	public GUIType getType() {
		return type;
	}

	public enum GUIType {
		CREATE, MAIN, INVITE, KICK, PROMOTE,
		/*
		 * MAIN but with leader permissions
		 */
		LEADER;
	}
}

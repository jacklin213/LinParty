package com.gmail.jacklin213.linparty;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.gmail.jacklin213.linparty.utils.Party;

public class PartyManager {
	
	private HashMap<UUID, Party> parties;
	
	public PartyManager() {
		parties = new HashMap<UUID, Party>();
		load();
	}
	
	public Party getParty(Player player) {
		if (contains(player)) {
			if (isLeader(player)) return parties.get(player.getUniqueId());
			if (isMember(player)) {
				for (Party party : parties.values()) {
					if (party.containsPlayer(player)){
						return party;
					}
				}
			}
		}
		return null;
	}
	
	public boolean contains(Player player) {
		if (parties.isEmpty()) return false;
		for (UUID uuid : parties.keySet()) {
			if (uuid == player.getUniqueId()) return true;
		}
		for (Party party : parties.values()) {
			if (party.containsPlayer(player)) return true;
		}
		return false;
	}
	
	public boolean isLeader(Player player) {
		for (UUID uuid : parties.keySet()) {
			if (uuid == player.getUniqueId()) return true;
		}
		return false;
	}
	
	public boolean isMember(Player player) {
		for (Party party : parties.values()) {
			if (party.containsPlayer(player)) return true;
		}
		return false;
	}
	
	//Database stuff
	private void load() {
		
	}
	
	public void save() {
		
	}
}

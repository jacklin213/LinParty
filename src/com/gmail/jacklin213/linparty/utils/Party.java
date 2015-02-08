package com.gmail.jacklin213.linparty.utils;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Party {

	private UUID leader;
	private ArrayList<UUID> members;
	
	public Party(Player leader) {
		this.leader = leader.getUniqueId();
		this.members = new ArrayList<UUID>(6);
		members.add(this.leader);
	}
	
	public void addMember(Player member) {
		if (members.size() == 6) {
			getLeader().sendMessage(
				ChatColor.RED + "Your party is already full, unable to add: " +
				ChatColor.GOLD + member.getName()
			);
			return;
		}
		members.add(member.getUniqueId());
	}
	
	public void removeMember(Player member) {
		if (!members.contains(member.getUniqueId())) {
			getLeader().sendMessage(ChatColor.RED + "This player isn't in your party");
		}
		members.remove(member.getUniqueId());
		getLeader().sendMessage("You have removed " + member.getName());
		for (UUID uuid : members) {
			getMember(uuid).sendMessage(ChatColor.YELLOW + member.getName() + " has been removed from party.");
		}
	}
	
	public boolean containsPlayer(Player player) {
		if (members.contains(player.getUniqueId())) {
			return true;
		}
		return false;
	}
	
	public Player getMember(Player member) {
		if (members.contains(member.getUniqueId())) {
			return member;
		}
		return null;
	}
	
	public Player getMember(UUID member) {
		return getMember(Bukkit.getPlayer(member));
	}
	
	public ArrayList<UUID> getMembers() {
		return members;
	}
	
	public Player getLeader() {
		return Bukkit.getPlayer(leader);
	}
}

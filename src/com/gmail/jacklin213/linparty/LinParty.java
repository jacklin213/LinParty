package com.gmail.jacklin213.linparty;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class LinParty extends JavaPlugin {

	public static LinParty instance;
	public static Logger log;
	
	public PartyManager partyManager;
	public LPListener listener = new LPListener();
	private LPCommand command = new LPCommand(this);
	
	@Override
	public void onEnable() {
		log = getLogger();
		instance = this;
		
		getServer().getPluginManager().registerEvents(listener, this);
		partyManager = new PartyManager();
		
		getCommand("linparty").setExecutor(command);
	}
	
}

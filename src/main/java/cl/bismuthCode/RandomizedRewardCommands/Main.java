package cl.bismuthCode.RandomizedRewardCommands;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public CommandStorage getStorage() {
		return this.storage;
	}

	private CommandStorage storage;

	public void onEnable() {
		this.storage = new CommandStorage(this);
		getCommand("RandomizedRewardCommands").setExecutor(new SimpleCommand(this));
	}
}

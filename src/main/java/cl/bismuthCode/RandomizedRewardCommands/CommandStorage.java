package cl.bismuthCode.RandomizedRewardCommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import cl.bismuthCode.RandomizedRewardCommands.domain.Reward;
import cl.bismuthCode.RandomizedRewardCommands.domain.RewardCommands;

public class CommandStorage {
	private Main m;
	//private HashMap<String, ArrayList<List<String>>> cmds;
	private HashMap<String, RewardCommands> cmds;
	

	public CommandStorage(Main m) {
		this.cmds = new HashMap<>();
		this.m = m;
		this.m.getConfig().options().copyDefaults(true);
		m.saveConfig();
		reload();
	}

	public void reload() {
		this.m.reloadConfig();
		FileConfiguration config = this.m.getConfig();
		this.cmds.clear();
		ConfigurationSection root = config.getConfigurationSection("commands");
		for (String key : root.getKeys(false)) {
			ConfigurationSection rcmds = root.getConfigurationSection(key);
			RewardCommands rewardcmd = new RewardCommands();
			rewardcmd.setCommand(key.toLowerCase());
			rewardcmd.setType(rcmds.getInt("type"));
			ConfigurationSection rootRewards = rcmds.getConfigurationSection("rewards");
			List<Reward> rewards = new ArrayList<>(); 
			for (String rewardKey : rootRewards.getKeys(false)) {
				Reward reward = new Reward();
				reward.setName(rewardKey);
				ConfigurationSection rewardConf = rootRewards.getConfigurationSection(rewardKey);
				reward.setChance(rewardConf.getDouble("chance"));
				reward.setRewardCmds(rewardConf.getStringList("commands"));
				reward.setDescription(rewardConf.getString("description"));
				rewards.add(reward);
			}
			rewardcmd.setRewards(rewards);
			cmds.put(rewardcmd.getCommand(), rewardcmd);
		}
	}

	public HashMap<String, RewardCommands> getCommands() {
		return this.cmds;
	}

	public RewardCommands getCommand(String key) {
		return this.cmds.get(key);
	}
}

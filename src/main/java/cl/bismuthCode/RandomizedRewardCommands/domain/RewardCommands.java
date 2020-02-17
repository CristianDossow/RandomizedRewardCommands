package cl.bismuthCode.RandomizedRewardCommands.domain;

import java.util.List;

public class RewardCommands {
	
	String command;
	List<Reward> rewards;
	
	public RewardCommands() {
		super();
	}
	public RewardCommands(String command, List<Reward> rewards) {
		super();
		this.command = command;
		this.rewards = rewards;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public List<Reward> getRewards() {
		return rewards;
	}
	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

}

package cl.bismuthCode.RandomizedRewardCommands.domain;

import java.util.List;

public class RewardCommands {
	
	String command;
	CommandType type;
	List<Reward> rewards;
	
	public RewardCommands() {
		super();
		type = CommandType.TRY_ALL;
	}

	public RewardCommands(String command, CommandType type, List<Reward> rewards) {
		super();
		this.command = command;
		this.type = type;
		this.rewards = rewards;
	}

	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public CommandType getType() {
		return type;
	}
	public void setType(CommandType type) {
		this.type = type;
	}
	public void setType(int type) {
		this.type = CommandType.valueOf(type);
	}
	public List<Reward> getRewards() {
		return rewards;
	}
	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

}

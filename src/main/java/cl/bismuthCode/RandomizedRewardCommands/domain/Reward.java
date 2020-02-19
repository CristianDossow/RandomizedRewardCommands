package cl.bismuthCode.RandomizedRewardCommands.domain;

import java.util.ArrayList;
import java.util.List;

public class Reward {
	
	String name;
	double chance;
	String description;
	List<String> rewardCmds;
	
	public Reward() {
		super();
		name = "";
		chance = 0;
		description = "";
		rewardCmds = new ArrayList<>();
	}

	public Reward(String name, double chance, String description, List<String> rewardCmds) {
		super();
		this.name = name;
		this.chance = chance;
		this.description = description;
		this.rewardCmds = rewardCmds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getChance() {
		return chance;
	}

	public void setChance(double chance) {
		this.chance = chance;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getRewardCmds() {
		return rewardCmds;
	}

	public void setRewardCmds(List<String> rewardCmds) {
		this.rewardCmds = rewardCmds;
	}

}

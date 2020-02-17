package cl.bismuthCode.RandomizedRewardCommands.domain;

import java.util.ArrayList;
import java.util.List;

public class Reward {
	
	String name;
	double chance;
	List<String> rewardCmds;
	
	public Reward() {
		super();
		name = "";
		chance = 0;
		rewardCmds = new ArrayList<>();
	}

	public Reward(String name, double chance, List<String> rewardCmds) {
		super();
		this.name = name;
		this.chance = chance;
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

	public List<String> getRewardCmds() {
		return rewardCmds;
	}

	public void setRewardCmds(List<String> rewardCmds) {
		this.rewardCmds = rewardCmds;
	}

}

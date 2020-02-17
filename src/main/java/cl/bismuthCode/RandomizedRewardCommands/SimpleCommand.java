package cl.bismuthCode.RandomizedRewardCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cl.bismuthCode.RandomizedRewardCommands.domain.Reward;
import cl.bismuthCode.RandomizedRewardCommands.domain.RewardCommands;

public class SimpleCommand implements CommandExecutor {
	private Main context;
	Random rand;

	public SimpleCommand(Main m) {
		this.context = m;
		rand = new Random();
	}
	
	public boolean onCommand(CommandSender snd, Command command, String label, String[] args) {
		
		String subCmd = args[0].toLowerCase();
		if (!snd.hasPermission("rrc.admin")) {
			return true;
		}
		if (args.length == 0) {
			sendPluginInfo(snd);
			return true;
		}
		
		if(subCmd.equals("execute")) {
			if (args.length < 3) {
				sendMessage(snd, "&7/rcmd execute <Key> <Player>");
				return true;
			}
			//cmds = this.m.getStorage().getCommands(args[1].toLowerCase());
			RewardCommands rewardCmd = this.context.getStorage().getCommand(args[1].toLowerCase());
			if (rewardCmd == null) {
				sendMessage(snd, "Key Not found. &c" + args[1]);
				return true;
			}
			Player p = Bukkit.getPlayer(args[2]);
			if (p == null) {
				sendMessage(snd, "Player not found. &c" + args[2]);
				return true;
			}
			for (Reward reward : rewardCmd.getRewards()) {
				double rvalue = 100D * rand.nextDouble();
				if(reward.getChance()>rvalue) {
					sendMessage(snd, "&7Reward executed: "+reward.getName());
					for(String cmd : reward.getRewardCmds()){
						String tempCmd = cmd.replaceAll("%p", p.getName());
						Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),tempCmd);
						if(snd instanceof Player) {
							sendMessage(snd, "&7 - Command executed: "+tempCmd);
						}
					}
				}
				
			}
			return true;
		} else if(subCmd.equals("reload")) {
			this.context.getStorage().reload();
			sendMessage(snd, "&aSuccessfully reloaded.");
			return true;
		} else if(subCmd.equals("list")) {
			
			List<RewardCommands> rewardCmds = new ArrayList<>(this.context.getStorage().getCommands().values());
			sendMessage(snd, "&b&l--- List of Reward Commands ---");
			for(RewardCommands rewardCommand : rewardCmds) {
				sendMessage(snd, "&b&l> &7" + rewardCommand.getCommand());
			}
			sendMessage(snd, "&b&l--- End of List ---");
			return true;
		} else if(subCmd.equals("listrewards")) {
			if (args.length < 2) {
				sendMessage(snd, "&7/rrc listRewards (Key)");
				return true;
			}
			RewardCommands rewardCmd = this.context.getStorage().getCommand(args[1].toLowerCase());
			if(rewardCmd == null) {
				sendMessage(snd, "Key Not found. &c" + args[1]);
				return true;
			} else {
				sendMessage(snd, "&7&lCommand Key: " + args[1]);
				for(Reward reward : rewardCmd.getRewards()) {
					sendMessage(snd, "&b&l> &7Reward: "+reward.getName()+" (Chance: "+reward.getChance()+"% )");
					sendMessage(snd, "&b&l> &7Commands:");
					for(String cmd : reward.getRewardCmds()) {
						sendMessage(snd, "&b&l> - "+cmd);
					}
				}
			}
			return true;
		} else {
			sendPluginInfo(snd);
			return true;
		}
	}
	
	private void sendPluginInfo(CommandSender snd) {
		sendMessage(snd, "&5&lRandomizedReward&7&lCommands");
		sendMessage(snd, "&7/rrc execute <Key> <Player>");
		sendMessage(snd, "&7/rrc list");
		sendMessage(snd, "&7/rrc listRewards <Key>");
		sendMessage(snd, "&7/rrc reload");
	}

	private void sendMessage(CommandSender snd, String msg) {
		snd.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
}

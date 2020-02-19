package cl.bismuthCode.RandomizedRewardCommands.domain;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
	TRY_ALL(0), CHOOSE_ONE(1);
	
    private int value;
    private static Map<Object, Object> map = new HashMap<>();

    private CommandType(int value) {
        this.value = value;
    }

    static {
        for (CommandType type : CommandType.values()) {
            map.put(type.value, type);
        }
    }

    public static CommandType valueOf(int type) {
        return (CommandType) map.get(type);
    }

    public int getValue() {
        return value;
    }
}

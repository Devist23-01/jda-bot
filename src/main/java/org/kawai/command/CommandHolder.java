package org.kawai.command;

import org.kawai.config.Commandable;

import java.util.HashMap;
import java.util.Map;

public class CommandHolder {
    private static CommandHolder INSTANCE = null;
    private Map<CommandType, Commandable> commandableMap = new HashMap<>();

    private CommandHolder() {
    }

    public static CommandHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandHolder();
        }
        return INSTANCE;
    }

    public Map<CommandType, Commandable> getCommandableMap() {
        return commandableMap;
    }

}

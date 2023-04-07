package org.kawai.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CommandType {
    REACTION(""),
    RPS("도박", "ㄷㅂ", "ㄷ", "rps"),
    IMAGE("코코미", "행크TS", "이로TS");
    // 이 상수들은 CommandSet Array

    //    set == collection
    private final Set<String> CommandSet = new HashSet<>();

    //    enum은 Runtime에서 실행함
    CommandType(String... CommandSet) {
        this.CommandSet.addAll(Arrays.asList(CommandSet));
    }

    public static CommandType from(String command) {
        CommandType[] values = CommandType.values();
        for (CommandType value : values) {
            Set<String> CommandSet = value.getCommandSet();
            for (String realCommand : CommandSet) {
                if (realCommand.equals(command)) {
                    return value;
                }
            }
        }
        return REACTION;
    }

    public Set<String> getCommandSet() {
        return CommandSet;
    }
}
